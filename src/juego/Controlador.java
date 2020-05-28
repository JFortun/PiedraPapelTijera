package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class Controlador extends JFrame implements ActionListener, WindowListener
{
	private static final long serialVersionUID = 1L;
	Color color = new Color(204, 230, 255);
	
	Controlador()
	{
		Vista.menu.setLayout(new FlowLayout());
		Vista.menu.setTitle("Piedra, Papel o Tijeras");
		Vista.menu.setSize(500,300);
		Vista.menu.setResizable(false);
		Vista.menu.setLocationRelativeTo(null);
		Vista.menu.add(Vista.btnJugar);
		Vista.btnJugar.setPreferredSize((new Dimension(128, 64)));
		Vista.menu.add(Vista.btnTOP);
		Vista.btnTOP.setPreferredSize((new Dimension(128, 64)));
		Vista.menu.add(Vista.btnAyuda);
		Vista.btnAyuda.setPreferredSize((new Dimension(128, 64)));
		Vista.menu.addWindowListener(this);
		Vista.btnJugar.addActionListener(this);
		Vista.btnTOP.addActionListener(this);
		Vista.btnAyuda.addActionListener(this);
		Vista.menu.setVisible(true);
		Vista.menu.getContentPane().setBackground(color);

	}

	// Declaro los eventos que suceden en el login
	public void actionPerformed(ActionEvent evento)
	{
		// Juego
		if(evento.getSource().equals(Vista.btnJugar)) 
		{
			Vista.txtJugador.setText("");
			Vista.jugador.setLayout(new FlowLayout());
			Vista.jugador.setSize(315, 100);
			Vista.jugador.setResizable(false);
			Vista.jugador.addWindowListener(this);
			Vista.btnJugadorAceptar.addActionListener(this);
			Vista.btnJugadorVolver.addActionListener(this);
			Vista.jugador.add(Vista.lblJugador);
			Vista.jugador.add(Vista.txtJugador);;
			Vista.jugador.add(Vista.btnJugadorAceptar);
			Vista.jugador.add(Vista.btnJugadorVolver);
			Vista.jugador.setLocationRelativeTo(null);
			Vista.jugador.setVisible(true);
			Vista.jugador.getContentPane().setBackground(color);
		}
		// Clasificacion de jugadores
		else if(evento.getSource().equals(Vista.btnTOP)) 
		{
			new Puntuacion();
			Vista.menu.setVisible(false);

		}
		// Botón aceptar de Jugador
		else if(evento.getSource().equals(Vista.btnJugadorAceptar)) 
		{
			new Juego();
			Vista.jugador.setVisible(false);
			Vista.menu.setVisible(false);
		}
		// Botón volver de Jugador
		else if(evento.getSource().equals(Vista.btnJugadorVolver)) 
		{
			Vista.jugador.setVisible(false);
			Vista.menu.setVisible(true);
		}
	}

	public void windowClosing(WindowEvent arg0)
	{
		System.exit(0);
	}

	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}