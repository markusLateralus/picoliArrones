package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
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
	MouseAdapter mouseAdapter = new MouseAdapter() {
		Coordenada coordenadaOrigen;
		//Coordenada coordenadaDestino;
		
	
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			JPanel panel = (JPanel) e.getSource();
			panel.setBackground(Color.YELLOW);
			Coordenada  coordenada = Utiles.getCoordenada(panel.getName());
	//		coordenadaOrigen = Utiles.getCoordenada(panel.getName());
			if (!controller.localizar(coordenada)) {
				new Advertencia(controller.getError());
			}
			else {
				getBordeArmada().getBtnPoblar().setEnabled(true);
				getBordeArmada()
						.update(Generador.getEjercitoInfo(controller.getEjercitoActual()));
				getBordeArmada().setVisible(controller.isLocalizarEstado());
			}
			getTableroUI().actualizarTablero(getTableroUIInfo(controller.getJuego()));
			
		}


	};
	MouseAdapter mouseAdapter2 = new MouseAdapter() {
	       private  int X, Y;
		@Override
		public void mouseDragged(MouseEvent e) {	
	
			JPanel panel = (JPanel) e.getSource();
			Coordenada	coordenadaDestino = Utiles.getCoordenada(panel.getName());

	        int x = e.getX() + X;
	        int xMax = getBordeArmada().getWidth() - panel.getWidth();
	        x = Math.min(x, xMax);
	        x = Math.max(x, 0);

	        int y = e.getY() + Y;
	        int yMax = getBordeArmada().getHeight() - panel.getHeight();
	        y = Math.min(y, yMax);
	        y = Math.max(y, 0);

	        panel.setLocation(x, y);
		}	
		@Override
		public void mousePressed(MouseEvent e){
			JPanel panel = (JPanel) e.getSource();
			Coordenada	coordenadaOrigen = Utiles.getCoordenada(panel.getName());
			  Component c =  panel.findComponentAt(e.getX(), e.getY());
	        Point parentLocation = c.getParent().getLocation();
	        X= parentLocation.x - e.getX();
	        Y = parentLocation.y - e.getY();
	        panel = (JPanel)c;
	        panel.setLocation(e.getX() + X, e.getY() + Y);

	        getBordeArmada().add(panel, JLayeredPane.DRAG_LAYER);
	        getBordeArmada().setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
	System.out.println("PRESIONADO");
			//controller.getJuego().setCasillaMarcada(coordenadaOrigen);
		}

		@Override
		 public void mouseReleased(MouseEvent e)
		    {
			JPanel panel = (JPanel) e.getSource();
			getBordeArmada().setCursor(null);

		        if (panel == null) return;

		        //  Make sure the chess piece is no longer painted on the layered pane

		        panel.setVisible(false);
		        getBordeArmada().remove(panel);
		        panel.setVisible(true);

		        //  The drop location should be within the bounds of the chess board

		        int xMax = getBordeArmada().getWidth() - panel.getWidth();
		        int x = Math.min(e.getX(), xMax);
		        x = Math.max(x, 0);

		        int yMax = getBordeArmada().getHeight() - panel.getHeight();
		        int y = Math.min(e.getY(), yMax);
		        y = Math.max(y, 0);

		        Component c =  panel.findComponentAt(x, y);

		        if (c instanceof JPanel)
		        {
		            Container parent = c.getParent();
		            parent.remove(0);
		            parent.add( panel );
		            parent.validate();
		        }
		        else
		        {
		            Container parent = (Container)c;
		            parent.add( panel );
		            parent.validate();
		        }
		    }
	};

//	MouseMotionAdapter mouseMotion=new MouseMotionAdapter() {
//		Coordenada coordenada;
//		Coordenada coordenadaArrastrar;
//		@Override
//		public void mouseDragged(MouseEvent e) {
//			JPanel panel = (JPanel) e.getSource();
//			coordenadaArrastrar = Utiles.getCoordenada(panel.getName());
//			//System.out.println("arrastro");
//	//	controller.getJuego().poner( coordenada);
//		}
//		
//		@Override
//		public void mouseMoved(MouseEvent e) {
//			JPanel panel = (JPanel) e.getSource();
//			coordenada = Utiles.getCoordenada(panel.getName());
//			//controller.getJuego().poner( coordenadaArrastrar);
//		}
//
//	};
	
	
	public ParaUI() {
		super();
		controller = new Controller(ancho, alto);
		crearTablero(controller);
		getTableroUI().setMouseAdapter(mouseAdapter);
		getTableroUI().setMouseAdapter2(mouseAdapter2);
		getTableroUI().actualizarTablero(getTableroUIInfo(controller.getJuego()));
		getBordeArmada().cargarEjercito(Generador.getEjercitoInfo(controller.getJuego().getEjercitoActual()));
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



	private JButton getBotonPoblar() {
		return this.getBordeArmada().getBtnPoblar();
	}

	private JButton getOkButton() {
		return this.mercadoTipoDialog.getOkButton();
	}

	public Tipo getTipos() {
		return mercadoTipo.getTipo();
	}


	private JButton getOkButtonSoldadoDialog() {
		return mercadoSoldadoDialog.getOkButton();
	}

	public TableroUIInfo getTableroUIInfo(Juego juego) {
		return new TableroUIInfo(juego);
	}

}
