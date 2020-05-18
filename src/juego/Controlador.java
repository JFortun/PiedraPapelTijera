package juego;

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

	Controlador()
	{
		//Establecer la distribución del Frame
		Vista.menu.setLayout(new FlowLayout());
		//Establecer el título de la aplicación
		Vista.menu.setTitle("Piedra, Papel o Tijeras");
		//Establecer el tamaño del Frame
		Vista.menu.setSize(500,500);
		Vista.menu.setResizable(false);
		// Centra la ventana en la pantalla
		Vista.menu.setLocationRelativeTo(null);
		//Añadir los botones antes creados
		Vista.menu.add(Vista.btnJugar);
		Vista.btnJugar.setPreferredSize((new Dimension(128, 64)));
		Vista.menu.add(Vista.btnTOP);
		Vista.btnTOP.setPreferredSize((new Dimension(128, 64)));
		Vista.menu.add(Vista.btnAyuda);
		Vista.btnAyuda.setPreferredSize((new Dimension(128, 64)));
		//Añadir los Listeners
		Vista.menu.addWindowListener(this);
		Vista.btnJugar.addActionListener(this);
		Vista.btnTOP.addActionListener(this);
		Vista.btnAyuda.addActionListener(this);
		Vista.menu.setVisible(true);
	}

	// Declaro los eventos que suceden en el login
	public void actionPerformed(ActionEvent evento)
	{
		// Alta de productos
		if(evento.getSource().equals(Vista.btnJugar)) 
		{
			new Juego();
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