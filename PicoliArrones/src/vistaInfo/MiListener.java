package vistaInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.MercadoTipo;
import vista.MercadoTipoDialog;
import vistaConversores.Generador;

public class MiListener implements ActionListener {

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton boton=(JButton) e.getSource();
		if(boton.getText().equalsIgnoreCase("Poblar")) {
			MercadoTipo mercadoTipo=new MercadoTipo(Generador.getTipos());
			MercadoTipoDialog	mercadoTipoDialog=new MercadoTipoDialog(mercadoTipo);
				mercadoTipoDialog.setVisible(true);
		}
		
	}

}
