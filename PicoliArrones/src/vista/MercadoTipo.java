package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import modelo.Tipo;


public class MercadoTipo extends JPanel {
	public static JComboBox <Tipo>comboBox;
	private ArrayList<Tipo> tipoSoldadosInfo;

	/**
	 * Create the panel.
	 */
	public MercadoTipo(ArrayList <Tipo> tipoSoldadosInfo) {
		setLayout(null);
		this.tipoSoldadosInfo=tipoSoldadosInfo;
		JLabel lblNewLabel = new JLabel("elegir Tipo:");
		lblNewLabel.setBounds(34, 89, 69, 14);
		add(lblNewLabel);
		
		comboBox = new JComboBox<Tipo>();
		comboBox.setModel(new DefaultComboBoxModel<Tipo>());
		comboBox.setBounds(133, 86, 248, 20);
		for (int i = 0; i < tipoSoldadosInfo.size(); i++) {
			comboBox.addItem(tipoSoldadosInfo.get(i));
		}
		
		add(comboBox);

	}

	public JComboBox getComboBox() {
		return comboBox;
	}
	
	
}
