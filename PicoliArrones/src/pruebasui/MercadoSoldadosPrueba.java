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
import vista.MercadoTipoDialog;
import vistaConversores.Generador;

import javax.swing.JTextArea;


public class MercadoSoldadosPrueba extends JFrame {

	private JPanel contentPane;
	//MercadoSoldadoDialog mercadoSoldadoPruebaDialog;
	MercadoTipoDialog mercadoTipoDialog;
	private JTextArea textAreaInformativo;
	private ArrayList <Tipo>tipos;
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
	//		tipos=new ArrayList<Tipo>(Arrays.asList(Tipo.values()));
//			tipos=new ArrayList <Tipo>();
//				tipos.add(Tipo.ARQUERIA);
//				tipos.add(Tipo.CABALLERIA);
//				tipos.add(Tipo.INFANTERIA);
			tipos=Generador.getTipos();
				mercadoTipoDialog=new MercadoTipoDialog(tipos);
				mercadoTipoDialog.setVisible(true);
			}
		});
		getContentPane().add(btnDialogo, BorderLayout.NORTH);
		
		textAreaInformativo = new JTextArea();
		getContentPane().add(textAreaInformativo, BorderLayout.CENTER);
		
	}

	
	
	

public ArrayList <Tipo> getTipos(){
	return tipos;
}


	public JTextArea getTextAreaInformativo() {
		return textAreaInformativo;
	}
}
