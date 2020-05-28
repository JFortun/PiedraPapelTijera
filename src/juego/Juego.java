package juego;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Juego extends Frame implements ActionListener, WindowListener
{
	private static final long serialVersionUID = 1L;

	Juego()
	{
		Vista.juego.setLayout(new FlowLayout());
		Vista.juego.setTitle("Piedra, Papel o Tijeras");
		Vista.juego.setSize(600,800);
		Vista.juego.setResizable(false);
		Vista.juego.setLocationRelativeTo(null);
		Vista.juego.addWindowListener(this);
		Vista.juego.setVisible(true);

	}
	
	public void windowClosing(WindowEvent e) 
	{
		if(Vista.juego.isActive())
		{
			Vista.juego.setVisible(false);
			Vista.menu.setVisible(true);
		}
	}
	
	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void actionPerformed(ActionEvent e) {}
}