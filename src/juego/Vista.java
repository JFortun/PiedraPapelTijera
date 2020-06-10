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
	static JButton btnMenuJugar = new JButton("JUGAR");
	static JButton btnMenuTOP = new JButton("CLASIFICACI�N");
	static JButton btnMenuAyuda = new JButton("AYUDA");
	
	// Creo los elementos de la ventana del juego
	static Button btnPiedra = new Button("PIEDRA");
	static Button btnPapel = new Button("PAPEL");
	static Button btnTijera = new Button("TIJERA");
	static Button btnJugar = new Button("JUGAR");
	static Button btnRetirarse = new Button("RETIRARSE");
	static Label lblContrincante = new Label("CONTRINCANTE");
	static Label lblUsuario = new Label("USUARIO");
	static Label lblEleccionContrincanteEnunciado = new Label("TU CONTRINCANTE HA ELEGIDO");
	static Label lblEleccionContrincante = new Label("ELEMENTO");
	static Label lblVersus = new Label("VS");
	static Label lblResultado = new Label("RESULTADO");
	static TextField txtNombreJugadorJuego = new TextField(20);



	// Creo los elementos de la ventana jugador
	static JDialog nombreJugador = new JDialog(menu,"Jugador", true);
	static JLabel lblNombreJugador = new JLabel("Jugador:");
	static JButton btnNombreJugadorAceptar = new JButton("Aceptar");
	static JButton btnNombreJugadorVolver = new JButton("Volver");

	
	// Creo los elementos de la ventana informaci�n
	static Label lblJugador = new Label("NOMBRE JUGADOR: ");
	static Label lblOpcionElegida = new Label("OPCI�N ELEGIDA: ");
	static Label lblPuntuacion = new Label("PUNTUACI�N: ");
	static Label lblRonda = new Label("RONDA: ");
	static TextField txtNombreJugador = new TextField(20);
	static TextField txtOpcionElegida = new TextField(20);
	static TextField txtPuntuacion = new TextField(20);
	static TextField txtRonda = new TextField(20);
	
	// Creo los elementos de la ventana de la clasificaci�n
	static JLabel lblclasificacion = new JLabel("�sta es la clasificaci�n de jugadores");
	static TextArea taClasificacion = new TextArea(25,30);
	static JButton btnClasificacionVolver = new JButton("Volver");
}