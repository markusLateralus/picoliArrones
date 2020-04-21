package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Batallon;
import modelo.Tipo;
import pruebasui.MercadoSoldadosPrueba;
import vistaInfo.EspecificacionSoldadosInfo;

public class MercadoSoldadoDialog extends JDialog {

	private JPanel contentPanel = new JPanel();
	private MercadoSoldados mercadoSoldados;
	LinkedList<EspecificacionSoldadosInfo> listaEjercito;
	MercadoTipo mercadoTipo;
	Tipo tipo = (Tipo) MercadoTipo.comboBox.getSelectedItem();
	static MercadoSoldadosPrueba mercadoSoldadosPrueba = MercadoSoldadosPrueba.getMercadoSoldadosPrueba();

	private LinkedList<Batallon> batallones;
	private JButton okButton;

	public MercadoSoldadoDialog(MercadoTipo mercadoTipo) {
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 500);

		int id = Integer.parseInt(mercadoTipo.getTextFieldId().getText());
		mercadoSoldados = new MercadoSoldados(id, tipo);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mercadoSoldados, BorderLayout.CENTER);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				okButton = new JButton("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (compruebaMax()) {

							listaEjercito = mercadoSoldados.getListaEjercito();
							batallones = mercadoSoldados.getBatallones();
							dispose();
							JTextArea area = mercadoSoldadosPrueba.getTextAreaInformativo();
							int contador = 0;
							for (int i = 0; i < listaEjercito.size(); i++) {
								if (contador < batallones.size()) {
									area.append(batallones.get(i).getTipo().toString() + ": ");
									contador++;
								}

								area.append("especialidad elegida " + listaEjercito.get(i).getEspecialidad()
										+ " cantidad total:" + listaEjercito.get(i).getCantidad() + "\n");
							}
						}
					}
				});
			}

		}
	}

	public JTextField getTextFieldId() {
		return mercadoTipo.getTextFieldId();
	}

	public JTextArea getTextAreaInformativo() {
		return mercadoSoldadosPrueba.getTextAreaInformativo();
	}

	public boolean compruebaMax() {
		return mercadoSoldados.compruebaMax();
	}

	public LinkedList<EspecificacionSoldadosInfo> getListaEjercito() {
		return mercadoSoldados.getListaEjercito();
	}

}
