package pruebasui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Batallon;
import modelo.Tipo;
import vista.MercadoSoldadoDialog;
import vista.MercadoSoldados;
import vista.MercadoTipo;
import vista.MercadoTipoDialog;
import vistaConversores.Generador;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MercadoSoldadosPrueba extends JFrame {

	private JPanel contentPane;
	//MercadoSoldadoDialog mercadoSoldadoPruebaDialog;
	MercadoTipoDialog mercadoTipoDialog;
	private JTextArea textAreaInformativo;
	private ArrayList <Tipo>tipos;
	private MercadoTipo mercadoTipo;
	private Batallon batallon;
	private MercadoSoldados mercadoSoldados;
	private MercadoSoldadoDialog mercadoSoldadoDialog;
	public static MercadoSoldadosPrueba mercadoSoldadosPrueba = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mercadoSoldadosPrueba = new MercadoSoldadosPrueba();
					mercadoSoldadosPrueba.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static MercadoSoldadosPrueba getMercadoSoldadosPrueba() {
		if (mercadoSoldadosPrueba == null) {
			new MercadoSoldadosPrueba();
		}
		return mercadoSoldadosPrueba;
	}

	/**
	 * Create the frame.
	 */
	private MercadoSoldadosPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 479);
		JButton btnDialogo = new JButton("crear Batallon");
		btnDialogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 mercadoTipo=new MercadoTipo(Generador.getTipos());
					mercadoTipoDialog=new MercadoTipoDialog(mercadoTipo);
					mercadoTipoDialog.setVisible(true);
					mercadoTipoDialog.getOkButton().addActionListener(new ActionListener() {	
						@Override
						public void actionPerformed(ActionEvent e) {
								//	Tipo tipo = (Tipo) MercadoTipo.comboBox.getSelectedItem();
							Tipo tipo=(Tipo)mercadoTipo.getComboBox().getSelectedItem();
									int id=Integer.parseInt(getTextFieldId().getText());
									batallon=new Batallon(id, tipo);
									//mercadoSoldados = new MercadoSoldados(id,tipo,batallon);
									mercadoTipoDialog.dispose();
									mercadoSoldados=new MercadoSoldados(batallon);
									mercadoSoldadoDialog = new MercadoSoldadoDialog(mercadoSoldados);
									mercadoSoldadoDialog.setVisible(true);
									
									mercadoSoldadoDialog.getOkButton().addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											// TODO Auto-generated method stub
										//	listaEjercito = mercadoSoldados.getListaEjercito();								
											//if (mercadoSoldadoDialog.compruebaMax()) {
										
//												pobladorController=new PobladorController(batallon);
//												pobladorController.poblarBatallon(mercadoSoldados.getListaEjercito());
//												System.out.println(batallon.getTipo());
//												for (EspecificacionSoldadosInfo especificacion : mercadoSoldados.getListaEjercito()) {
//													System.out.println(" especialidad:" + especificacion.getEspecialidad()  + " cantidad " + especificacion.getCantidad());
//													
//												}
//										}
//											mercadoSoldadoDialog.dispose();
											
										}
								
									});
					}
				
			});
				}
			});
					
				
			getContentPane().add(btnDialogo, BorderLayout.NORTH);
			
			textAreaInformativo = new JTextArea();
			getContentPane().add(textAreaInformativo, BorderLayout.CENTER);
			
		}

	
	
	public JTextField getTextFieldId() {
		return mercadoTipo.getTextFieldId();
	}
	

public ArrayList <Tipo> getTipos(){
	return tipos;
}


	public JTextArea getTextAreaInformativo() {
		return textAreaInformativo;
	}
}
