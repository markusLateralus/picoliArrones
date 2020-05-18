package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


import modelo.Coordenada;
import modelo.Dimension;

import modelo.Tipo;
import pruebasui.UserInterface;
import utiles.Utiles;
import vista.Advertencia;
import vista.MercadoSoldadoDialog;
import vista.MercadoSoldados;
import vista.MercadoTipo;
import vista.MercadoTipoDialog;
import vistaConversores.Generador;
import vistaInfo.EspecificacionSoldadosInfo;

import vistaInfo.TableroUIInfo;

public class ParaUI extends UserInterface {

	private IniciadorController iniciadorController;
	private MercadoSoldados mercadoSoldados;
	private MercadoTipoDialog mercadoTipoDialog;
	private MercadoTipo mercadoTipo;
	private MercadoSoldadoDialog mercadoSoldadoDialog;
	private Dimension dimension=new Dimension(6,12);

	public ParaUI() {
		super();
		iniciadorController = new IniciadorController(dimension);
		this.crearTablero(iniciadorController);
		this.getTableroUI().setMouseAdapter(mouseAdapter);
		this.getTableroUI().actualizarTablero(getTableroUIInfo(iniciadorController.getJuego()));
	
		this.getBordeArmada().cargarEjercito(Generador.getNuevoEjercitoInfo(iniciadorController.getJuego().getEjercitoActual()));
		getBtnPoblar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mercadoTipo = new MercadoTipo(Generador.getTipos());
				mercadoTipoDialog = new MercadoTipoDialog(mercadoTipo);
				mercadoTipoDialog.setVisible(true);

				getOkButton().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Tipo tipo = getTipos();
						int id = getId();
					//Batallon batallon=new Batallon(id, tipo);
						//batallon = juego.getEjercitoActual().getBatallonActual();
						//batallon.setId(id);
						mercadoTipoDialog.dispose();
						mercadoSoldados = new MercadoSoldados(iniciadorController.getJuego().getBatallonActual());
						mercadoSoldadoDialog = new MercadoSoldadoDialog(mercadoSoldados);
						mercadoSoldadoDialog.setVisible(true);
						//iniciadorController.poblarBatallon(getListaEjercito());

						getOkButtonSoldadoDialog().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								if (mercadoSoldadoDialog.compruebaMax()) {
									iniciadorController.poblarBatallon(getListaEjercito());
									// pobladorController.agregarAlEjercito(batallon);
									getBordeArmada().getBtnPoblar().setEnabled(false);
									getBordeArmada().update(Generador.getEjercitoInfo(iniciadorController.getJuego().getEjercitoActual()));

								}
								// bordeArmada.update(Generador.getEjercitoInfo(ejercito));

								mercadoSoldadoDialog.dispose();
							}

						});
					}
				});

			}

		});
	
	}

	MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			JPanel panel = (JPanel) e.getSource();
			panel.setBackground(Color.YELLOW);
			Coordenada coordenada = Utiles.getCoordenada(panel.getName());
			if (!iniciadorController.localizar(coordenada)) {
				new Advertencia(iniciadorController.getError());
			}
			getTableroUI().actualizarTablero(getTableroUIInfo(iniciadorController.getJuego()));
			if(iniciadorController.isLocalizarEstado()) {
				getBordeArmada().getBtnPoblar().setEnabled(true);
				getBordeArmada().update(Generador.getEjercitoInfo(iniciadorController.getJuego().getEjercitoActual()));
			}else {
				getBordeArmada().setVisible(false);
			}
	
		}
	
	};


	private int getId() {
		// TODO Auto-generated method stub
		return Integer.parseInt(getTextFieldId().getText().toString());
	}

	private JButton getBotonPoblar() {
		return this.getBordeArmada().getBtnPoblar();
	}

	private JButton getOkButton() {
		return this.mercadoTipoDialog.getOkButton();
	}

	public Tipo getTipos() {
		return mercadoTipo.getTipo();
	}

	public JTextField getTextFieldId() {
		return mercadoTipo.getTextFieldId();
	}

	public LinkedList<EspecificacionSoldadosInfo> getListaEjercito() {
		return mercadoSoldados.getListaEjercito();
	}

	private JButton getOkButtonSoldadoDialog() {
		return mercadoSoldadoDialog.getOkButton();
	}
	public TableroUIInfo getTableroUIInfo(Juego juego) {
		return new TableroUIInfo(juego);
	}
	
}
