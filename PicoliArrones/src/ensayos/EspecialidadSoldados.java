package ensayos;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JTextField;

import modelo.Especialidad;

public class EspecialidadSoldados extends JPanel {
	private JTextField textFieldCantidad;
	private JLabel lblEspecialidadSoldado;

	/**
	 * Create the panel.
	 */
	public EspecialidadSoldados(Especialidad especialidad) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel lblEspecialidad = new JLabel("Especialidad           ");
		lblEspecialidad.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(lblEspecialidad);
		
		lblEspecialidadSoldado = new JLabel(String.valueOf(especialidad));
		add(lblEspecialidadSoldado);
		
		JLabel lblCantidad = new JLabel("        Cantidad");
		lblCantidad.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setText("0");
		add(textFieldCantidad);
		textFieldCantidad.setColumns(10);

	}

	public JTextField getTextFieldCantidad() {
		return textFieldCantidad;
	}

	public JLabel getLblEspecialidadSoldado() {
		return lblEspecialidadSoldado;
	}

}
