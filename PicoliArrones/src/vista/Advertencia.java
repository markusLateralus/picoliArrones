package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Advertencia extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public Advertencia(String mensaje) {
		setBounds(100, 100, 906, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			JLabel label = new JLabel(" ");
			contentPanel.add(label);
		}
		{
			JLabel lblAdvertenciavv = new JLabel("Advertencia");
			lblAdvertenciavv.setForeground(Color.RED);
			lblAdvertenciavv.setFont(new Font("Tahoma", Font.BOLD, 26));
			contentPanel.add(lblAdvertenciavv);
		}
		{
			JLabel lblAdvertencia = new JLabel(mensaje);
			lblAdvertencia.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contentPanel.add(lblAdvertencia);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
		}
		setVisible(true);
	}

}
