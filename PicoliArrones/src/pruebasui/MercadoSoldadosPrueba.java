package pruebasui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import modelo.Batallon;
import modelo.Tipo;
import vista.MercadoSoldadoDialog;
import vista.MercadoTipo;
import vista.MercadoTipoDialog;
import vistaInfo.MercadoSoldadosInfo;
import javax.swing.JTextArea;


public class MercadoSoldadosPrueba extends JFrame {

	private JPanel contentPane;
	//MercadoSoldadoDialog mercadoSoldadoPruebaDialog;
	MercadoTipoDialog mercadoTipoDialog;
	private JTextArea textAreaInformativo;
	

 
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
	public static MercadoSoldadosPrueba mercadoSoldadosPrueba = null;



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
				ArrayList <Tipo>listaTipos=new ArrayList <Tipo>();
				listaTipos.add(Tipo.ARQUERIA);
				listaTipos.add(Tipo.CABALLERIA);
				listaTipos.add(Tipo.INFANTERIA);
				mercadoTipoDialog=new MercadoTipoDialog(listaTipos);
				mercadoTipoDialog.setVisible(true);
			}
		});
		getContentPane().add(btnDialogo, BorderLayout.NORTH);
		
		textAreaInformativo = new JTextArea();
		getContentPane().add(textAreaInformativo, BorderLayout.CENTER);
	}

	
	



	public JTextArea getTextAreaInformativo() {
		return textAreaInformativo;
	}
}
