package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import modelo.Tipo;
import pruebasui.MercadoSoldadosPrueba;
import vistaConversores.Generador;

import javax.swing.JTextField;


public class MercadoTipo extends JPanel {
	public static JComboBox <Tipo>comboBox;
	private ArrayList<Tipo> tipos;
	private JTextField textFieldId;
	 MercadoSoldadosPrueba mercadoSoldadosPrueba=MercadoSoldadosPrueba.getMercadoSoldadosPrueba();

	/**
	 * Create the panel.
	 */
	public MercadoTipo(ArrayList<Tipo> tipos) {
		setLayout(null);
		this.tipos=tipos;
		JLabel lblNewLabel = new JLabel("elegir Tipo:");
		lblNewLabel.setBounds(34, 89, 69, 14);
		add(lblNewLabel);
		 tipos=mercadoSoldadosPrueba.getTipos();
		comboBox = new JComboBox<Tipo>();
		comboBox.setModel(new DefaultComboBoxModel<Tipo>());
		comboBox.setBounds(133, 86, 248, 20);
		for (int i = 0; i < tipos.size(); i++) {
			comboBox.addItem(tipos.get(i));
		}
		
		add(comboBox);
		
		JLabel lblId = new JLabel("    Id");
		lblId.setBounds(34, 49, 46, 14);
		add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(132, 46, 86, 20);
		add(textFieldId);
		textFieldId.setColumns(10);

	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public ArrayList<Tipo> getTipos() {
		return tipos;
	}

	public JTextField getTextFieldId() {
		return textFieldId;
	}
	
}
