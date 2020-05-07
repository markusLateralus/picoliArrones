package vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vistaInfo.FichaCastilloInfo;

public class FichaCastillo extends Ficha {

	/**
	 * Create the panel.
	 */
	public FichaCastillo(FichaCastilloInfo fichaCastilloInfo) {
		super(fichaCastilloInfo);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblCastlloEjercito = new JLabel("Castillo Ejercito");
		lblCastlloEjercito.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCastlloEjercito.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCastlloEjercito, BorderLayout.CENTER);
		
		JLabel lblIdEjercito = new JLabel(String.valueOf(fichaCastilloInfo.getIdEjercito()));
		lblIdEjercito.setFont(new Font("Tahoma", Font.PLAIN, 33));
		add(lblIdEjercito, BorderLayout.EAST);
	}
}
