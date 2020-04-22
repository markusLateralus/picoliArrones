package vista;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Batallon;
import vistaConversores.Generador;
import vistaInfo.EspecificacionSoldadosInfo;





public class MercadoSoldados extends JPanel {

	private JLabel lblBatallonId;
	private JLabel lblMaxSoldados;
	private ArrayList<EspecialidadSoldado> especialidades;
	private JLabel lblTipoSoldado;
	private JLabel lblTotal;

	private Batallon batallon;
	private LinkedList <Batallon> batallones=new LinkedList<Batallon>();
	//private 	LinkedList<EspecificacionSoldadosInfo> especificacionesSoldadosInfo;
	
	public LinkedList<Batallon> getBatallones() {
		return batallones;
	}

	public void setBatallones(LinkedList<Batallon> batallones) {
		this.batallones = batallones;
	}

	public Batallon getBatallon() {
		return batallon;
	}

	private FocusAdapter miFocusAdapter=new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				super.focusLost(e);
				lblTotal.setText(String.valueOf(sumaSoldados()));
			}
		};
	
	/**
	 * Create the panel.
	 * tipo = (Tipo) MercadoTipo.comboBox.getSelectedItem();
	 */
		
		//Tipo tipo = (Tipo) MercadoTipo.comboBox.getSelectedItem();
	public MercadoSoldados(Batallon batallon) {
		
		setLayout(null);
		 this.batallon=batallon;
		//Batallon batallon=new Batallon(id, tipo);
		
		especialidades = Generador.getEspecialidades(batallon.getTipo(),miFocusAdapter);
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
		
		String tipoString=batallon.getTipo().toString();
		lblTipoSoldado = new JLabel(tipoString);
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
		

		lblTotal.setBounds(245, 390, 156, height2);
		add(lblTotal);
		batallones.add(batallon);
	}
	public LinkedList<EspecificacionSoldadosInfo> getListaEjercito() {
		LinkedList<EspecificacionSoldadosInfo> response=new LinkedList<EspecificacionSoldadosInfo>();
		for (EspecialidadSoldado especialidad : especialidades) {
			response.add(new EspecificacionSoldadosInfo(especialidad.getLblEspecialidad().getText().toString(),
			Integer.valueOf(especialidad.getTxtCantidad().getText().toString())));
		}
		return response;
	}
	public  int sumaSoldados() {
		int total = 0;
		for (EspecialidadSoldado especialidadSoldadosEnsayo : especialidades) {
			String text = especialidadSoldadosEnsayo.getTxtCantidad().getText();
			int cantidad = Integer.valueOf(text);
			total += cantidad;
		}
		return total;
	}
	public JLabel getLblTotal() {
		return lblTotal;
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


	public boolean compruebaMax() {
		return sumaSoldados()==Integer.parseInt(lblMaxSoldados.getText());
	}
}
