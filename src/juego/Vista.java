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
	static JFrame menu = new JFrame("Men�");
	static JFrame clasificacion = new JFrame("Clasificaci�n");
	static Frame informacion = new Frame("Informaci�n");

	// Creo los elementos de la ventana del men�
	static JButton btnMenuJugar = new JButton("Jugar");
	static JButton btnMenuTOP = new JButton("TOP Jugadores");
	static JButton btnMenuAyuda = new JButton("Ayuda");
	
	// Creo los elementos de la ventana del juego
	static Button btnPiedra = new Button("PIEDRA");
	static Button btnPapel = new Button("PAPEL");
	static Button btnTijera = new Button("TIJERA");
	static Button btnJugar = new Button("JUGAR");
	static Label lblEleccionContrincanteEnunciado = new Label("TU CONTRINCANTE HA ELEGIDO");
	static Label lblEleccionContrincante = new Label("ELEMENTO");
	static Label lblResultado = new Label("RESULTADO");


	// Creo los elementos de la ventana jugador
	static JDialog nombreJugador = new JDialog(menu,"Jugador", true);
	static JLabel lblNombreJugador = new JLabel("Jugador:");
	static JButton btnNombreJugadorAceptar = new JButton("Aceptar");
	static JButton btnNombreJugadorVolver = new JButton("Volver");

	
	// Creo los elementos de la ventana informaci�n
	static Label lblJugador = new Label("NOMBRE JUGADOR: ");
	static Label lblOpcionElegida = new Label("OPCI�N ELEGIDA: ");
	static Label lblPuntuacion = new Label("PUNTUACI�N: ");

	static TextField txtNombreJugador = new TextField(20);
	static TextField txtOpcionElegida = new TextField(20);
	static TextField txtPuntuacion = new TextField(20);
	
	// Creo los elementos de la ventana de la clasificaci�n
	static JLabel lblclasificacion = new JLabel("�sta es la clasificaci�n de jugadores");
	static TextArea taClasificacion = new TextArea(25,30);
	static JButton btnClasificacionVolver = new JButton("Volver");
}