package juego;

import java.awt.Color;
import java.awt.Frame;

public class Informacion extends Frame
{
	private static final long serialVersionUID = 1L;

	Color colorFondo = new Color(204,229,255);

	Informacion()
	{
		Vista.informacion.setLayout(null);
		Vista.informacion.setSize(400, 300);
		Vista.informacion.setResizable(false);
		
		Vista.informacion.add(Vista.lblJugador);
		Vista.lblJugador.setBounds(30,50,120,25);
		Vista.informacion.add(Vista.lblOpcionElegida);
		Vista.lblOpcionElegida.setBounds(30,120,120,25);
		Vista.informacion.add(Vista.lblPuntuacion);
		Vista.lblPuntuacion.setBounds(30,190,120,25);
		
		Vista.informacion.add(Vista.txtNombreJugador);
		Vista.txtNombreJugador.setBounds(180,50,200,25);
		Vista.txtNombreJugador.setEditable(false);
		Vista.informacion.add(Vista.txtOpcionElegida);
		Vista.txtOpcionElegida.setBounds(180,120,200,25);
		Vista.txtOpcionElegida.setEditable(false);
		Vista.informacion.add(Vista.txtPuntuacion);
		Vista.txtPuntuacion.setBounds(180,190,200,25);
		Vista.txtPuntuacion.setEditable(false);
		Vista.txtPuntuacion.setText("0");
		
		Vista.informacion.setLocation(100,200);
		Vista.informacion.setVisible(true);
		Vista.informacion.setBackground(colorFondo);
	}
}