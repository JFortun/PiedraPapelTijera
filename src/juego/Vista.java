package juego;

import java.awt.Frame;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Vista extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	// Creo los frames
	static JFrame menu = new JFrame("Men�");
	static Frame juego = new Frame("Juego");
	static JFrame jlasificacion = new JFrame("Clasificaci�n");

	// Creo los elementos de la ventana del men�
	static JButton btnJugar = new JButton("Jugar");
	static JButton btnTOP = new JButton("TOP Jugadores");
	static JButton btnAyuda = new JButton("Ayuda");
	
	// Creo los elementos de la ventana de login
	static JDialog jugador = new JDialog(menu,"Jugador", true);
	static JLabel lblJugador = new JLabel("Jugador:");
	static JTextField txtJugador = new JTextField(20); 
	static JButton btnJugadorAceptar = new JButton("Aceptar");
	static JButton btnJugadorVolver = new JButton("Volver");
	
	// Creo los elementos de la ventana de la clasificaci�n
	static JFrame clasificacion = new JFrame("Clasificaci�n");
	static JLabel lblclasificacion = new JLabel("�sta es la clasificaci�n de jugadores");
	static TextArea taClasificacion = new TextArea(25,30);
	static JButton btnClasificacionVolver = new JButton("Volver");
}