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
	Juego juego = new Juego();

	Controlador()
	{
		Vista.menu.setLayout(new FlowLayout());
		Vista.menu.setTitle("Piedra, Papel o Tijeras");
		Vista.menu.setSize(500,180);
		Vista.menu.setResizable(false);
		Vista.menu.setLocationRelativeTo(null);
		Vista.menu.add(Vista.btnMenuJugar);
		Vista.btnMenuJugar.setPreferredSize((new Dimension(128, 64)));
		Vista.menu.add(Vista.btnMenuTOP);
		Vista.btnMenuTOP.setPreferredSize((new Dimension(128, 64)));
		Vista.menu.add(Vista.btnMenuAyuda);
		Vista.btnMenuAyuda.setPreferredSize((new Dimension(128, 64)));
		Vista.menu.addWindowListener(this);
		Vista.btnMenuJugar.addActionListener(this);
		Vista.btnMenuTOP.addActionListener(this);
		Vista.btnMenuAyuda.addActionListener(this);
		Vista.menu.setVisible(true);
		Vista.menu.getContentPane().setBackground(color);
	}

	// Declaro los eventos que suceden en jugador
	public void actionPerformed(ActionEvent evento)
	{
		// Juego
		if(evento.getSource().equals(Vista.btnMenuJugar)) 
		{
			new Sonido("jugar");
			Vista.txtNombreJugador.setText("");
			Vista.nombreJugador.getContentPane().setBackground(color);
			Vista.nombreJugador.setLayout(new FlowLayout());
			Vista.nombreJugador.setSize(315, 100);
			Vista.nombreJugador.setResizable(false);
			Vista.nombreJugador.addWindowListener(this);
			Vista.btnNombreJugadorAceptar.addActionListener(this);
			Vista.btnNombreJugadorVolver.addActionListener(this);
			Vista.nombreJugador.add(Vista.lblNombreJugador);
			Vista.nombreJugador.add(Vista.txtNombreJugador);
			Vista.nombreJugador.add(Vista.btnNombreJugadorAceptar);
			Vista.nombreJugador.add(Vista.btnNombreJugadorVolver);
			Vista.nombreJugador.setLocationRelativeTo(null);
			Vista.nombreJugador.setVisible(true);
		}
		// Clasificacion de jugadores
		else if(evento.getSource().equals(Vista.btnMenuTOP)) 
		{
			new Sonido("boton");
			new Clasificacion();
			Vista.menu.setVisible(false);

		}
		// Botón aceptar de Jugador
		else if(evento.getSource().equals(Vista.btnNombreJugadorAceptar)) 
		{
			new Sonido("boton");
			if(!Vista.txtNombreJugador.getText().equals(""))
			{
				juego.setVisible(true);
				new Informacion();
				Vista.nombreJugador.setVisible(false);
				Vista.menu.setVisible(false);
			}
		}
		// Botón volver de Jugador
		else if(evento.getSource().equals(Vista.btnNombreJugadorVolver)) 
		{
			new Sonido("boton");
			Vista.nombreJugador.setVisible(false);
			Vista.menu.setVisible(true);
		}
		// Botón Ayuda
		else if(evento.getSource().equals(Vista.btnMenuAyuda)) 
		{
			new Sonido("boton");
			new Ayuda();
		}
	}

	public void windowClosing(WindowEvent arg0)
	{
		if(Vista.nombreJugador.isActive())
		{
			Vista.nombreJugador.setVisible(false);
			Vista.menu.setVisible(true);
		}
		else
		{
			System.exit(0);
		}
	}

	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}