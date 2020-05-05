package pruebasui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
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
import vista.BordeArmada;
import vista.MercadoSoldados;
import vista.MercadoTipo;
import vista.MercadoTipoDialog;
import vista.TableroUI;
import vistaConversores.Generador;
import vistaInfo.EjercitoInfo;
import vistaInfo.TableroUIInfo;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private TableroUI tableroUI;
	private BordeArmada bordeArmada;
	private TableroUIInfo tableroUIInfo;

	private Ejercito ejercito;
	LinkedList <Ejercito> ejercitos=new LinkedList<Ejercito>();


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public UserInterface() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	Dimension dimension=new Dimension(6,12);
	 bordeArmada=new BordeArmada(new EjercitoInfo(1,1,Tipo.ARQUERIA,2,2,2));
		tableroUI=new TableroUI(dimension);
		contentPane.add(tableroUI, BorderLayout.CENTER);
	
		contentPane.add(bordeArmada, BorderLayout.WEST);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	
		
		
		
	}

	public TableroUI getTableroUI() {
		return tableroUI;
	}

	public BordeArmada getBordeArmada() {
		return bordeArmada;
	}

	public JButton getBtnPoblar() {
		return bordeArmada.getBtnPoblar();
	}
	

}
