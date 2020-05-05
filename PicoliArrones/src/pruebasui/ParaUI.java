package pruebasui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.IniciadorController;
import controlador.Juego;
import modelo.Batallon;
import modelo.Coordenada;
import modelo.Dimension;
import modelo.Ejercito;
import modelo.Tablero;
import modelo.Tipo;
import utiles.Utiles;
import vista.Advertencia;
import vista.MercadoSoldadoDialog;
import vista.MercadoSoldados;
import vista.MercadoTipo;
import vista.MercadoTipoDialog;
import vistaConversores.Generador;
import vistaInfo.EspecificacionSoldadosInfo;
import vistaInfo.MiListener;

public class ParaUI extends UserInterface {

	IniciadorController iniciadorController;
	Dimension dimension = new Dimension(6, 12);
	Juego juego = new Juego(dimension);
	private MercadoSoldados mercadoSoldados;
	private MercadoTipoDialog mercadoTipoDialog;
	private MercadoTipo mercadoTipo;
	private MercadoSoldadoDialog mercadoSoldadoDialog;
	private Batallon batallon;
	private Ejercito ejercito;

	public ParaUI() {
		super();
		iniciadorController = new IniciadorController(juego);
		this.getBordeArmada().cargarEjercito(Generador.getNuevoEjercitoInfo(juego.getEjercitoActual()));
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
						// batallon=new Batallon(id, tipo);
						batallon = juego.getEjercitoActual().getBatallonActual();
						batallon.setId(id);
						// iniciadorController=new IniciadorController();
						// mercadoSoldados = new MercadoSoldados(id,tipo,batallon);
						mercadoTipoDialog.dispose();
						mercadoSoldados = new MercadoSoldados(batallon);
						mercadoSoldadoDialog = new MercadoSoldadoDialog(mercadoSoldados);
						mercadoSoldadoDialog.setVisible(true);
						iniciadorController.poblarBatallon(getListaEjercito());

						getOkButtonSoldadoDialog().addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								if (mercadoSoldadoDialog.compruebaMax()) {

									iniciadorController.poblarBatallon(getListaEjercito());
									// pobladorController.agregarAlEjercito(batallon);
									getBordeArmada().update(Generador.getEjercitoInfo(juego.getEjercitoActual()));

								}
								// bordeArmada.update(Generador.getEjercitoInfo(ejercito));

								mercadoSoldadoDialog.dispose();
							}

						});
					}
				});

			}

		});
		this.getTableroUI().setMouseAdapter(mouseAdapter);
		this.getTableroUI().actualizarTablero(Generador.getTableroUIIinfo(juego));
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
			getTableroUI().actualizarTablero(Generador.getTableroUIIinfo(iniciadorController.getJuego()));

		}
	};


	private int getId() {
		// TODO Auto-generated method stub
		return Integer.parseInt(getTextFieldId().getText());
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
}
