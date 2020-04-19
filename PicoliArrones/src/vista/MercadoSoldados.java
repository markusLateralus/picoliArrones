package vista;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Batallon;
import modelo.Tipo;
import vistaConversores.Generador;
import vistaInfo.EspecificacionSoldadosInfo;
import vistaInfo.MercadoSoldadosInfo;




public class MercadoSoldados extends JPanel {

	private JLabel lblBatallonId;
	private JLabel lblMaxSoldados;
	private ArrayList<EspecialidadSoldado> especialidades;
	private JLabel lblTipoSoldado;
	private JLabel lblTotal;
	private MercadoTipo mercadoTipo;
	
	private FocusAdapter miFocusAdapter=new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				super.focusLost(e);
				lblTotal.setText(String.valueOf(sumaSoldados()));
			}
		};
	
	/**
	 * Create the panel.
	 */
	public MercadoSoldados( Tipo tipoSoldadosInfo) {
		setLayout(null);
		Batallon batallon=new Batallon(1, tipoSoldadosInfo);
		especialidades = Generador.getEspecialidadesEnsayo(tipoSoldadosInfo,miFocusAdapter);

		JLabel lblBatallonNumero = new JLabel("Batallon numero ");
		int height2 = 16;
		lblBatallonNumero.setBounds(62, 51, 165, height2);
		add(lblBatallonNumero);

		lblBatallonId = new JLabel(String.valueOf(batallon.getId()));
		lblBatallonId.setBounds(256, 51, 56, height2);
		add(lblBatallonId);

		JLabel lblMax = new JLabel("max.");
		lblMax.setBounds(395, 51, 56, height2);
		add(lblMax);

		lblMaxSoldados = new JLabel(String.valueOf(batallon.getMaximoSoldados()));
		lblMaxSoldados.setBounds(482, 51, 56, height2);
		add(lblMaxSoldados);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(62, 135, 56, height2);
		add(lblTipo);
		
		String tipo=mercadoTipo.comboBox.getSelectedItem().toString();
		lblTipoSoldado = new JLabel(tipo);
		lblTipoSoldado.setBounds(171, 135, 106, height2);
		add(lblTipoSoldado);
		int y = 223;
		for (EspecialidadSoldado especialidadSoldados : especialidades) {
			especialidadSoldados.setBounds(75, y, 556, height2);
			add(especialidadSoldados);
			y += height2 + 5;
		}
		JLabel lblTotalf = new JLabel("Total");
		lblTotalf.setBounds(62, 390, 56, height2);
		add(lblTotalf);

		lblTotal = new JLabel(String.valueOf(sumaSoldados()));
		lblTotal.setBounds(245, 390, 56, height2);
		add(lblTotal);

	}

	private int sumaSoldados() {
		int total = 0;
		for (EspecialidadSoldado especialidadSoldadosEnsayo : especialidades) {
			String text = especialidadSoldadosEnsayo.getTxtCantidad().getText();
			int cantidad = Integer.valueOf(text);
			total += cantidad;
		}
		return total;
	}

	public JLabel getLblBatallonId() {
		return lblBatallonId;
	}

	public JLabel getLblMaxSoldados() {
		return lblMaxSoldados;
	}

	public JLabel getLblTipoSoldado() {
		return lblTipoSoldado;
	}

	public LinkedList<EspecificacionSoldadosInfo> getListaEjercito() {
		LinkedList<EspecificacionSoldadosInfo> response=new LinkedList<EspecificacionSoldadosInfo>();
		for (EspecialidadSoldado especialidad : especialidades) {
			response.add(new EspecificacionSoldadosInfo(especialidad.getLblEspecialidad().getText().toString(),
			Integer.valueOf(especialidad.getTxtCantidad().getText().toString())));
		}
		return response;
	}
}
