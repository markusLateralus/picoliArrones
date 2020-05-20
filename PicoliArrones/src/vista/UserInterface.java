package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controller;
import vista.TableroUI;
import vistaInfo.TableroUIInfo;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private TableroUI tableroUI;
	private BordeArmada bordeArmada;

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		 bordeArmada=new BordeArmada();
		contentPane.add(bordeArmada, BorderLayout.WEST);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	
		
		
		
	}

	public TableroUI getTableroUI() {
		return tableroUI;
	}

	public BordeArmada getBordeArmada() {
		return bordeArmada;
	}

	public JButton getBtnPoblar() {
		return bordeArmada.getBtnPoblar();
	}
	
	public void crearTablero(Controller controller) {
		TableroUIInfo tableroUIinfo=new TableroUIInfo(controller.getJuego());
	   // Dimension dimension=new Dimension(6,12);	
	    tableroUI=new TableroUI(controller.getAncho(), controller.getAlto());
			contentPane.add(tableroUI, BorderLayout.CENTER);
	}

}
