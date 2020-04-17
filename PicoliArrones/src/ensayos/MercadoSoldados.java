package ensayos;

import javax.swing.JPanel;

import modelo.Batallon;
import vistaConversores.Generador;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;

public class MercadoSoldados extends JPanel {
	private JLabel lblBatallonId;
	private ArrayList<EspecialidadSoldados> especialidades;
	private JLabel lblTipoSoldado;
	private JLabel lblSoldadosMaximos;
	
	
	/**
	 * Create the panel.
	 */
	public MercadoSoldados(Batallon batallon) {
		setLayout(null);
		//especialidad uno
		especialidades=Generador.getEspecialidadesEnsayo(batallon.getTipo());
		JLabel lblBatallonNumero = new JLabel("batallon numero");
		int height2 = 14;
		lblBatallonNumero.setBounds(52, 53, 103, 14);
		add(lblBatallonNumero);
		
		lblBatallonId = new JLabel(String.valueOf(batallon.getId()));
		lblBatallonId.setBounds(150, 53, 46, height2);
		add(lblBatallonId);
		
		JLabel lblMaxSoldados = new JLabel("maximo Soldados");
		lblMaxSoldados.setBounds(206, 53, 108, 14);
		add(lblMaxSoldados);
		
		lblSoldadosMaximos = new JLabel(String.valueOf(batallon.getMaximoSoldados()));
		lblSoldadosMaximos.setBounds(312, 53, 46, height2);
		add(lblSoldadosMaximos);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(55, 95, 46, height2);
		add(lblTipo);
		
		lblTipoSoldado = new JLabel(String.valueOf(batallon.getTipo()));
		lblTipoSoldado.setBounds(121, 95, 89, 14);
		add(lblTipoSoldado);
		
		int y=151;
		for (EspecialidadSoldados elemento : especialidades) {
			elemento.setBounds(55, y, 255, height2);
			add(elemento);
			y+=height2 + 5;
					
		}
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(52, 222, 46, height2);
		add(lblTotal);
		
		JLabel lblCantidadTotal = new JLabel(String.valueOf(sumaSoldados()));
		lblCantidadTotal.setBounds(150, 222, 46, height2);
		add(lblCantidadTotal);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.setBounds(289, 247, 89, 23);
		add(btnNewButton);

	}


	private int sumaSoldados() {
		int total=0;
		for (EspecialidadSoldados especialidadSoldados : especialidades) {
			int cantidad=Integer.parseInt(especialidadSoldados.getTextFieldCantidad().getText());
			total+=cantidad;
		}
		return total;
	}


	public JLabel getLblBatallonId() {
		return lblBatallonId;
	}


	public void setLblBatallonId(JLabel lblBatallonId) {
		this.lblBatallonId = lblBatallonId;
	}


	public JLabel getLblTipoSoldado() {
		return lblTipoSoldado;
	}


	public void setLblTipoSoldado(JLabel lblTipoSoldado) {
		this.lblTipoSoldado = lblTipoSoldado;
	}


	public JLabel getLblSoldadosMaximos() {
		return lblSoldadosMaximos;
	}


	public void setLblSoldadosMaximos(JLabel lblSoldadosMaximos) {
		this.lblSoldadosMaximos = lblSoldadosMaximos;
	}
}
