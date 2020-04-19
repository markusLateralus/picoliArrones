package vista;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class CampoBatalla extends JPanel {

	/**
	 * Create the panel.
	 * @param columnas 
	 * @param filas 
	 */
	public CampoBatalla() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		int columnas=11;
		int filas=6;
		setLayout(new GridLayout(filas, columnas, 0, 0));
		
		for (int i= 0; filas < filas; i++) {
			for (int j= 0; columnas < columnas; j++) {
				JButton boton = new JButton();
				add(boton);
			}
		}
	}

}
