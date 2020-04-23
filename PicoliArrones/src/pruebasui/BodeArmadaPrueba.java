package pruebasui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.PobladorController;
import modelo.Batallon;
import modelo.Ejercito;
import modelo.Especialidad;
import modelo.Soldado;
import modelo.Tipo;
import vista.BordeArmada;
import vista.EspecialidadSoldado;
import vista.MercadoSoldadoDialog;
import vista.MercadoSoldados;
import vista.MercadoTipo;
import vista.MercadoTipoDialog;
import vistaConversores.Generador;
import vistaInfo.EjercitoInfo;
import vistaInfo.EspecificacionSoldadosInfo;
import vistaInfo.MercadoSoldadosInfo;


public class BodeArmadaPrueba extends JFrame {

	private JPanel contentPane;
	private Ejercito ejercito;
	private MercadoSoldadoDialog mercadoSoldadoDialog;
	PobladorController pobladorController;
	private MercadoSoldados mercadoSoldados;
	private MercadoTipoDialog mercadoTipoDialog;
	private MercadoTipo mercadoTipo;
private Batallon batallon;
EjercitoInfo ejercitoInfo;
BordeArmada bordeArmada;
LinkedList <Ejercito> ejercitos=new LinkedList<Ejercito>();
private LinkedList <Batallon> batallones=new LinkedList<Batallon>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BodeArmadaPrueba frame = new BodeArmadaPrueba();
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
	public BodeArmadaPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		ejercito = new Ejercito(5);
		ejercitos.add(ejercito);
	     bordeArmada = new BordeArmada();
		contentPane.add(bordeArmada, BorderLayout.WEST);	
		bordeArmada.cargarEjercito(Generador.getNuevoEjercitoInfo(ejercito));
		getBtnPoblar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 mercadoTipo=new MercadoTipo(Generador.getTipos());
					mercadoTipoDialog=new MercadoTipoDialog(mercadoTipo);
					mercadoTipoDialog.setVisible(true);
					mercadoTipoDialog.getOkButton().addActionListener(new ActionListener() {	
				
						@Override
						public void actionPerformed(ActionEvent e) {
								//	Tipo tipo = (Tipo) MercadoTipo.comboBox.getSelectedItem();
									Tipo tipo=getTipo();
									int id=getId();
									//batallon=new Batallon(id, tipo);
							batallon=ejercito.getBatallon(tipo);
							batallon.setId(id);
									pobladorController=new PobladorController(batallon, ejercito);
									//mercadoSoldados = new MercadoSoldados(id,tipo,batallon);
									mercadoTipoDialog.dispose();
									mercadoSoldados=new MercadoSoldados(batallon);
									mercadoSoldadoDialog = new MercadoSoldadoDialog(mercadoSoldados);
									mercadoSoldadoDialog.setVisible(true);	
									pobladorController.poblarBatallon(getListaEjercito());
//									ArrayList<Especialidad> tiposDeEspecialidades=Generador.getEspecialidad(batallon.getTipo());
//									
//									for (int i=0; i<tiposDeEspecialidades.size(); i++) {
//										batallon.alistarSoldado(new Soldado(tiposDeEspecialidades.get(i)));
//									}
									//batallones.add(batallon);
									mercadoSoldadoDialog.getOkButton().addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											// TODO Auto-generated method stub					
											if (mercadoSoldadoDialog.compruebaMax()) {													
						
											 pobladorController.poblarBatallon(getListaEjercito());
											//	pobladorController.agregarAlEjercito(batallon);
												//  bordeArmada.update(Generador.getEjercitoInfo(ejercito));
										
											for (int i=0; i<pobladorController.getBatallones().size(); i++) {					
											
													System.out.println("cantidad " + pobladorController.getBatallones().get(i).getCantidadSoldados() +
															" tipo " +  pobladorController.getBatallones().get(i).getTipo());

														/*
														 * -------------------------
															cantidad 4 tipo INFANTERIA
															cantidad 2 tipo CABALLERIA
															cantidad 2 tipo ARQUERIA
															-------------------------
														 * 
														 * */
												}
											
											System.out.println("-------------------------");
											

										}
											bordeArmada.update(Generador.getEjercitoInfo(ejercito));
											System.out.println(ejercito.getTipoBatallon());
											mercadoSoldadoDialog.dispose();
								
										
										}
								
									});
					}

					
				
			});
				}
			});
			
//				mercadoSoldadoDialog = new MercadoSoldadoDialog(
//						Generador.getMercadoSoldadoInfo(ejercito.getBatallonActual()));
//				mercadoSoldadoDialog.setVisible(true);
//				pobladorController=new PobladorController(ejercito.getBatallonActual());
//				mercadoSoldadoDialog.getBtnOk().addActionListener(new ActionListener() {
//
//					@Override
//					public void actionPerformed(ActionEvent e) {
////						MercadoSoldadoDialog dialogo=(MercadoSoldadoDialog)e.getSource();
//						if (mercadoSoldado.compruebaMax()) {
//							// aqui es donde hay que conectar con el modelo de datos
//							pobladorController.poblarBatallon(mercadoSoldado.getListaEjercito());
//						}
//						dispose();
//					}
//				});
	
		
	}
	
	
	public LinkedList<EspecificacionSoldadosInfo> getListaEjercito() {
		return mercadoSoldados.getListaEjercito();
	}

	public EjercitoInfo getEjercitoInfo() {
		return bordeArmada.getEjercitoInfo();
	}

	private int getId() {
		return Integer.parseInt(getTextFieldId().getText());
		
	}
	public JTextField getTextFieldId() {
		return mercadoTipo.getTextFieldId();
	}

	private JButton getBtnPoblar() {
		return bordeArmada.getBtnPoblar();
	}

	public JComboBox<Tipo> getComboBox() {
		return mercadoTipo.getComboBox();
	}

	public Tipo getTipo() {
		return mercadoTipo.getTipo();
	}
	
	

}
