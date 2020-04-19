package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Batallon;
import modelo.Tipo;
import vistaInfo.MercadoSoldadosInfo;


public class MercadoTipoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private MercadoTipo mercadoTipo;
MercadoSoldados mercadoSoldados;
MercadoSoldadoDialog mercadoSoldadoDialog;
	/**
	 * Create the dialog.
	 */
	public MercadoTipoDialog(ArrayList<Tipo> lista) {
		setBounds(100, 100, 450, 300);
	
		mercadoTipo=new MercadoTipo(lista);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(mercadoTipo, BorderLayout.CENTER);
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Tipo tipo=(Tipo) mercadoTipo.getComboBox().getSelectedItem();
						//MercadoSoldadosInfo info=new MercadoSoldadosInfo(new Batallon(1,(Tipo)tipo,10));
						mercadoSoldados=new MercadoSoldados(tipo);
						dispose();
						mercadoSoldadoDialog=new MercadoSoldadoDialog();
						mercadoSoldadoDialog.setVisible(true);
						//mercadoSoldados.setVisible(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
