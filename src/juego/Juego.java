package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Juego extends Frame implements ActionListener, WindowListener
{
	private static final long serialVersionUID = 1L;
		
	// Se crea un color tipo RGB
	Color colorTitulo = new Color(0,128,255);
	Color colorBoton = new Color(153,204,255);
	Color colorFondo = new Color(204,229,255);
	// Declarar el objeto Image
	Image piedra;
	Image papel;
	Image tijera;

	// Declarar el objeto Toolkit  para manejo de imágenes
	Toolkit herramienta;

	Juego()
	{
		setLayout(null);
		setTitle("Piedra, Papel o Tijeras");
		setSize(600,800);
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(colorFondo);
		addWindowListener(this);
		
		Vista.btnPiedra.addActionListener(this);
		Vista.btnPapel.addActionListener(this);
		Vista.btnTijera.addActionListener(this);
		Vista.btnJugar.addActionListener(this);
		
		add(Vista.btnPiedra);
		Vista.btnPiedra.setBounds(25,715,60,50);
		Vista.btnPiedra.setBackground(colorBoton);
		add(Vista.btnPapel);
		Vista.btnPapel.setBounds(215,715,60,50);
		Vista.btnPapel.setBackground(colorBoton);
		add(Vista.btnTijera);
		Vista.btnTijera.setBounds(405,715,60,50);
		Vista.btnTijera.setBackground(colorBoton);
		add(Vista.btnJugar);
		Vista.btnJugar.setBounds(425,580,80,50);
		Vista.btnJugar.setBackground(colorBoton);

		// Establecer el método de trabajo con imágenes
		herramienta = getToolkit();
		// Especificar la ruta de la imagen
		// Si ponemos ruta OJO con los \\
		piedra = herramienta.getImage("Piedra.jpeg");
		papel = herramienta.getImage("Papel.jpeg");
		tijera = herramienta.getImage("Tijera.jpeg");
		
	}
	public void paint(Graphics g)
	{
		// Creamos la fuente
		Font font = new Font("Time News Roman", Font.BOLD, 35);
		g.setFont(font);
		g.setColor(colorTitulo);
		g.drawString("PIEDRA PAPEL O TIJERAS", 85, 80);
		
		g.fillRect(20, 680, 185, 108);
		g.fillRect(210, 680, 185, 108);
		g.fillRect(400, 680, 185, 108);
		
		// Dibujar la imagen
		g.drawImage(piedra,100,685,this);
		g.drawImage(papel,290,685,this);
		g.drawImage(tijera,480,685,this);
		
	}
	
	public void windowClosing(WindowEvent e)
	{
		if(isActive())
		{
			setVisible(false);
			Vista.informacion.setVisible(false);
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