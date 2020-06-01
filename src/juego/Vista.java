package juego;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Vista extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	// Creo los frames
	static JFrame menu = new JFrame("Menú");
	static JFrame clasificacion = new JFrame("Clasificación");
	static Frame informacion = new Frame("Información");

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
	static JDialog nombreJugador = new JDialog(menu,"Jugador", true);
	static JLabel lblNombreJugador = new JLabel("Jugador:");
	static JButton btnNombreJugadorAceptar = new JButton("Aceptar");
	static JButton btnNombreJugadorVolver = new JButton("Volver");
	static TextField txtJugador = new TextField(20);

	
	// Creo los elementos de la ventana información
	static Label lblJugador = new Label("NOMBRE JUGADOR: ");
	static Label lblOpcionElegida = new Label("OPCIÓN ELEGIDA: ");
	static Label lblPuntuacion = new Label("PUNTUACIÓN: ");

	static TextField txtNombreJugador = new TextField(20);
	static TextField txtOpcionElegida = new TextField(20);
	static TextField txtPuntuacion = new TextField(20);
	
	// Creo los elementos de la ventana de la clasificación
	static JLabel lblclasificacion = new JLabel("Ésta es la clasificación de jugadores");
	static TextArea taClasificacion = new TextArea(25,30);
	static JButton btnClasificacionVolver = new JButton("Volver");
}