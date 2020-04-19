package ensayos;

import javax.swing.JPanel;

import modelo.Batallon;
import vista.EspecialidadSoldado;
import vistaConversores.Generador;
import vistaInfo.MercadoSoldadosInfo;
import ensayos.MercadoSoldados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;

public class MercadoSoldados extends JPanel {
	private JLabel lblBatallonId;
	private ArrayList<EspecialidadSoldado> especialidades;
	private JLabel lblTipoSoldado;
	private JLabel lblSoldadosMaximos;
	private JLabel lblCantidadTotal;
	
	
	private FocusAdapter miFocus=new FocusAdapter() {	//CREAR UN EVENTO Y LO PASAMOS POR PARAMETRO A OTROS PANELES
	public void focusLost(FocusEvent e) {
		lblCantidadTotal.setText(String.valueOf(sumaSoldados()));
	}
	
	};
	private JButton botonOk;
	
	/**
	 * Create the panel.
	 */
	public MercadoSoldados(MercadoSoldadosInfo info) {
		setLayout(null);
		//especialidad uno
		especialidades=Generador.getEspecialidadesEnsayo(info.getTipo(),miFocus);
		JLabel lblBatallonNumero = new JLabel("batallon numero");
		int height2 = 14;
		lblBatallonNumero.setBounds(52, 53, 103, 14);
		add(lblBatallonNumero);
		
		lblBatallonId = new JLabel(String.valueOf(info.getId()));
		lblBatallonId.setBounds(150, 53, 46, height2);
		add(lblBatallonId);
		
		JLabel lblMaxSoldados = new JLabel("maximo Soldados");
		lblMaxSoldados.setBounds(206, 53, 108, 14);
		add(lblMaxSoldados);
		
		lblSoldadosMaximos = new JLabel(String.valueOf(info.getMaximoSoldados()));
		lblSoldadosMaximos.setBounds(312, 53, 46, height2);
		add(lblSoldadosMaximos);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(55, 95, 46, height2);
		add(lblTipo);
		
		lblTipoSoldado = new JLabel(String.valueOf(info.getTipo()));
		lblTipoSoldado.setBounds(121, 95, 89, 14);
		add(lblTipoSoldado);
		
		int y=120;
		for (EspecialidadSoldado elemento : especialidades) {
			elemento.setBounds(55, y, 260, height2);
			add(elemento);
			y+=height2 + 5;
					
		}
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(52, 222, 46, height2);
		add(lblTotal);
		
		lblCantidadTotal = new JLabel(String.valueOf(sumaSoldados()));
		lblCantidadTotal.setBounds(150, 222, 46, height2);
		add(lblCantidadTotal);
		
		botonOk = new JButton("ok");
		botonOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		botonOk.setBounds(289, 247, 89, 23);
		add(botonOk);

	}


	private int sumaSoldados() {
		int total=0;
		for (EspecialidadSoldado especialidadSoldados : especialidades) {
			int cantidad=Integer.parseInt(especialidadSoldados.getTxtCantidad().getText());
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
	public JLabel getLblCantidadTotal() {
		return this.lblCantidadTotal;
	}
}
