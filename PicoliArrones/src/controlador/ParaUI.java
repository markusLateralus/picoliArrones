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

import modelo.Tipo;
import utiles.Utiles;
import vista.Advertencia;
import vista.MercadoSoldadoDialog;
import vista.MercadoSoldados;
import vista.MercadoTipo;
import vista.MercadoTipoDialog;
import vista.UserInterface;
import vistaConversores.Generador;
import vistaInfo.EspecificacionSoldadosInfo;

import vistaInfo.TableroUIInfo;

public class ParaUI extends UserInterface {

	private Controller controller;
	private MercadoTipoDialog mercadoTipoDialog;
	private MercadoSoldadoDialog mercadoSoldadoDialog;
	private MercadoTipo mercadoTipo;
	private int ancho = 12, alto = 6;

	public ParaUI() {
		super();
		controller = new Controller(ancho, alto);
		this.crearTablero(controller);
		this.getTableroUI().setMouseAdapter(mouseAdapter);
		this.getTableroUI().actualizarTablero(getTableroUIInfo(controller.getJuego()));
		this.getBordeArmada().cargarEjercito(Generador.getEjercitoInfo(controller.getJuego().getEjercitoActual()));
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
						// int id = getId();
						// Batallon batallon=new Batallon(id, tipo);
						// batallon = juego.getEjercitoActual().getBatallonActual();
						// batallon.setId(id);
						mercadoTipoDialog.dispose();
						MercadoSoldados mercadoSoldados = new MercadoSoldados(
								Generador.getBatallonInfo(controller.getBatallonActual()));
						MercadoSoldadoDialog mercadoSoldadoDialog = new MercadoSoldadoDialog(mercadoSoldados);
						mercadoSoldadoDialog.setVisible(true);
						getOkButtonSoldadoDialog().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								if (mercadoSoldadoDialog.compruebaMax()) {
									controller.poblarBatallon(mercadoSoldadoDialog.getListaEjercito());
									// pobladorController.agregarAlEjercito(batallon);
									getBordeArmada().getBtnPoblar().setEnabled(false);

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

			if (!controller.localizar(coordenada)) {

				new Advertencia(controller.getError());
			} else {

				getBordeArmada().getBtnPoblar().setEnabled(true);
				getBordeArmada().update(Generador.getEjercitoInfo(controller.getEjercitoActual()));
				getBordeArmada().setVisible(controller.isLocalizarEstado());

			}
			getTableroUI().actualizarTablero(getTableroUIInfo(controller.getJuego()));
		}

	};

	private JButton getBotonPoblar() {
		return this.getBordeArmada().getBtnPoblar();
	}

	private JButton getOkButton() {
		return this.mercadoTipoDialog.getOkButton();
	}

	public Tipo getTipos() {
		return mercadoTipo.getTipo();
	}

//
//	public JTextField getTextFieldId() {
//		return mercadoTipo.getTextFieldId();
//	}
//
//	public LinkedList<EspecificacionSoldadosInfo> getListaEjercito() {
//		return mercadoSoldados.getListaEjercito();
//	}
//
	private JButton getOkButtonSoldadoDialog() {
		return mercadoSoldadoDialog.getOkButton();
	}

	public TableroUIInfo getTableroUIInfo(Juego juego) {
		return new TableroUIInfo(juego);
	}

}
