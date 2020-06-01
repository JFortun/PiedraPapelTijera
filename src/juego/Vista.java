package juego;

import java.awt.Button;
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
	static JFrame menu = new JFrame("Menú");
	static JFrame clasificacion = new JFrame("Clasificación");

	// Creo los elementos de la ventana del menú
	static JButton btnMenuJugar = new JButton("Jugar");
	static JButton btnMenuTOP = new JButton("TOP Jugadores");
	static JButton btnMenuAyuda = new JButton("Ayuda");
	
	// Creo los elementos de la ventana del juego
	static Button btnPiedra = new Button("Piedra");
	static Button btnPapel = new Button("Papel");
	static Button btnTijera = new Button("Tijera");
	static Button btnJugar = new Button("Jugar");

	// Creo los elementos de la ventana jugador
	static JDialog jugador = new JDialog(menu,"Jugador", true);
	static JLabel lblJugador = new JLabel("Jugador:");
	static JTextField txtJugador = new JTextField(20); 
	static JButton btnJugadorAceptar = new JButton("Aceptar");
	static JButton btnJugadorVolver = new JButton("Volver");
	
	// Creo los elementos de la ventana de la clasificación
	static JLabel lblclasificacion = new JLabel("Ésta es la clasificación de jugadores");
	static TextArea taClasificacion = new TextArea(25,30);
	static JButton btnClasificacionVolver = new JButton("Volver");
}