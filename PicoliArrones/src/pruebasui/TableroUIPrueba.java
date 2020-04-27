package pruebasui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Juego;
import modelo.Batallon;
import modelo.Coordenada;
import modelo.Dimension;
import modelo.Ejercito;
import modelo.Tablero;
import modelo.Tipo;
import vista.TableroUI;
import vistaInfo.TableroUIInfo;

public class TableroUIPrueba extends JFrame {

	private JPanel contentPane;
	private TableroUI tableroUI;
	private Ejercito ejercito;
	private Batallon batallon;
	private Juego juego;
	private ArrayList <Batallon> batallones;
	private ArrayList<Coordenada> coordenadas=new ArrayList<Coordenada>();
	String nombre;
	Coordenada coordenada;

	TableroUIInfo tableroUIInfo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableroUIPrueba frame = new TableroUIPrueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TableroUIPrueba() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		MouseAdapter mouseAdapter = new MouseAdapter() {
		

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				JPanel panel = (JPanel) e.getSource();
				//panel.setBackground(Color.YELLOW);
				coordenada=tableroUI.obtenCoordenada(panel.getName());
				System.out.println(coordenada.getX() + " "+ coordenada.getY());
				
				if(juego.getEjercito1().getBatallones().size()>0) {
					colocarEjercito1(coordenada,tableroUI);
				}
				else if(juego.getEjercito2().getBatallones().size()>0) {
					colocarEjercito2(coordenada,tableroUI);
				}			
				

			}
		};

	
		 juego=new Juego();
		 tableroUIInfo=new TableroUIInfo(juego.getTablero());
		tableroUI=new TableroUI(mouseAdapter, tableroUIInfo,juego);
	
	  //  juego.colocarBatallon(1,coordenada);
		contentPane.add(tableroUI, BorderLayout.CENTER);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	private void colocarEjercito1(Coordenada coordenada,TableroUI tableroUI) {
		
		juego.colocarBatallon( juego.getEjercito1(),coordenada);
		tableroUIInfo.getFichas(tableroUI.getFichas(),juego);
		tableroUI.actualizarTablero(tableroUIInfo);
	}
	private void colocarEjercito2(Coordenada coordenada,TableroUI tableroUI) {
		ejercito=juego.getEjercito2();
		juego.colocarBatallon( juego.getEjercito2(),coordenada);
		tableroUIInfo.getFichas(tableroUI.getFichas(),juego);
		tableroUI.actualizarTablero(tableroUIInfo);
	}
}
