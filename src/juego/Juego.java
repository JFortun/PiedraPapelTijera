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
import java.sql.SQLException;

public class Juego extends Frame implements ActionListener, WindowListener
{
	private static final long serialVersionUID = 1L;

	Font fuenteTitulo = new Font("Time News Roman", Font.BOLD, 35);
	Font fuenteTexto = new Font("Time News Roman", Font.BOLD, 25);
	Font fuenteNombres = new Font("Time News Roman", Font.BOLD, 15);
	Font fuenteResultado = new Font("Time News Roman", Font.BOLD, 20);
	Font fuenteVersus = new Font("Time News Roman", Font.BOLD, 50);

	int puntuacion;
	int ronda;
	boolean jugando = false;

	// Se crea un color tipo RGB
	Color azulMarino = new Color(0,128,255);
	Color azul = new Color(153,204,255);
	Color celeste = new Color(204,229,255);
	Color rojo = new Color(255,51,51);
	// Declarar el objeto Image
	Image piedra;
	Image papel;
	Image tijera;

	// Declarar el objeto Toolkit  para manejo de imágenes
	Toolkit herramienta;

	Juego()
	{
		setLayout(null);
		setSize(600,800);
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(celeste);
		addWindowListener(this);

		Vista.btnPiedra.addActionListener(this);
		Vista.btnPapel.addActionListener(this);
		Vista.btnTijera.addActionListener(this);
		Vista.btnJugar.addActionListener(this);
		Vista.btnRetirarse.addActionListener(this);

		add(Vista.btnPiedra);
		Vista.btnPiedra.setBounds(25,715,60,50);
		Vista.btnPiedra.setBackground(azul);
		add(Vista.btnPapel);
		Vista.btnPapel.setBounds(215,715,60,50);
		Vista.btnPapel.setBackground(azul);
		add(Vista.btnTijera);
		Vista.btnTijera.setBounds(405,715,60,50);
		Vista.btnTijera.setBackground(azul);
		add(Vista.btnJugar);
		Vista.btnJugar.setBounds(25,570,550,50);
		Vista.btnJugar.setBackground(azul);
		//Vista.btnJugar.setEnabled(false);
		add(Vista.btnRetirarse);
		Vista.btnRetirarse.setBounds(25,625,550,50);
		Vista.btnRetirarse.setBackground(azul);
		
		Vista.lblResultado.setForeground(rojo);
		Vista.lblResultado.setFont(fuenteResultado);

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
		g.setFont(fuenteTitulo);
		g.setColor(azulMarino);
		g.drawString("PIEDRA PAPEL O TIJERAS", 85, 80);

		g.fillRect(20, 680, 185, 108);
		g.fillRect(210, 680, 185, 108);
		g.fillRect(400, 680, 185, 108);

		// Dibujar la imagen
		g.drawImage(piedra,100,685,this);
		g.drawImage(papel,290,685,this);
		g.drawImage(tijera,480,685,this);

		if(Vista.lblEleccionContrincante.getText().equals("PIEDRA"))
		{
			g.drawImage(piedra,250,220,this);
			g.drawImage(piedra,370,360,this);
		}
		else if(Vista.lblEleccionContrincante.getText().equals("PAPEL"))
		{
			g.drawImage(papel,250,220,this);
			g.drawImage(papel,370,360,this);

		}
		else if(Vista.lblEleccionContrincante.getText().equals("TIJERA"))
		{
			g.drawImage(tijera,250,220,this);
			g.drawImage(tijera,370,360,this);

		}
		if(jugando && Vista.txtOpcionElegida.getText().equals("PIEDRA"))
		{
			g.drawImage(piedra,125,360,this);
		}
		else if(jugando && Vista.txtOpcionElegida.getText().equals("PAPEL"))
		{
			g.drawImage(papel,125,360,this);
		}
		else if(jugando && Vista.txtOpcionElegida.getText().equals("TIJERA"))
		{
			g.drawImage(tijera,125,360,this);
		}

	}

	public void actionPerformed(ActionEvent evento) 
	{
		if(evento.getSource().equals(Vista.btnPiedra)) 
		{
			new Sonido("boton");
			Vista.txtOpcionElegida.setText("PIEDRA");
			Vista.btnJugar.setEnabled(true);
		}
		else if(evento.getSource().equals(Vista.btnPapel)) 
		{
			new Sonido("boton");
			Vista.txtOpcionElegida.setText("PAPEL");
			Vista.btnJugar.setEnabled(true);
		}
		else if(evento.getSource().equals(Vista.btnTijera)) 
		{
			new Sonido("boton");
			Vista.txtOpcionElegida.setText("TIJERA");
			Vista.btnJugar.setEnabled(true);
		}
		else if(evento.getSource().equals(Vista.btnJugar)) 
		{
			jugando = true;
			Vista.lblContrincante.setFont(fuenteNombres);
			add(Vista.lblContrincante);
			Vista.lblContrincante.setBounds(358,460,130,30);
			Vista.lblUsuario.setFont(fuenteNombres);
			add(Vista.lblUsuario);
			Vista.lblUsuario.setBounds(130,460,130,30);
			Vista.lblUsuario.setText(Vista.txtNombreJugador.getText());
			Vista.lblEleccionContrincanteEnunciado.setFont(fuenteTexto);
			add(Vista.lblEleccionContrincanteEnunciado);
			Vista.lblEleccionContrincanteEnunciado.setBounds(100,130,450,30);
			Vista.lblEleccionContrincante.setFont(fuenteTexto);
			add(Vista.lblEleccionContrincante);
			Vista.lblEleccionContrincante.setBounds(250,170,100,30);
			Vista.lblEleccionContrincante.setText(IA.numeroAleatorio());
			Vista.lblVersus.setFont(fuenteTexto);
			add(Vista.lblVersus);
			Vista.lblVersus.setBounds(265,390,70,50);
			Vista.lblVersus.setFont(fuenteVersus);
			Vista.lblVersus.setForeground(rojo);

			ronda = Integer.parseInt(Vista.txtRonda.getText());
			ronda = ronda + 1;
			new Sonido("ronda");
			Vista.txtRonda.setText(Integer.toString(ronda));

			// EVALUACIÓN DE LAS POSIBLES OPCIONES

			if (Vista.lblEleccionContrincante.getText().equals(Vista.txtOpcionElegida.getText()))
			{
				Vista.lblResultado.setFont(fuenteTexto);
				add(Vista.lblResultado);
				Vista.lblResultado.setText("EMPATE");
				Vista.lblResultado.setBounds(250,530,200,30);
				new Sonido("empatar");
			}
			else if (Vista.lblEleccionContrincante.getText().equals("PIEDRA") && Vista.txtOpcionElegida.getText().equals("PAPEL"))
			{
				Vista.lblResultado.setFont(fuenteTexto);
				add(Vista.lblResultado);
				Vista.lblResultado.setText("¡HAS GANADO!");
				Vista.lblResultado.setBounds(205,530,200,30);
				new Sonido("ganar");
				puntuacion = Integer.parseInt(Vista.txtPuntuacion.getText());
				puntuacion = puntuacion + 1;
				Vista.txtPuntuacion.setText(Integer.toString(puntuacion));
			}
			else if (Vista.lblEleccionContrincante.getText().equals("PAPEL") && Vista.txtOpcionElegida.getText().equals("PIEDRA"))
			{
				Vista.lblResultado.setFont(fuenteTexto);
				add(Vista.lblResultado);
				Vista.lblResultado.setText("¡HAS PERDIDO!");
				Vista.lblResultado.setBounds(205,530,200,30);
				new Sonido("perder");
				puntuacion = Integer.parseInt(Vista.txtPuntuacion.getText());
				puntuacion = puntuacion - 1;
				Vista.txtPuntuacion.setText(Integer.toString(puntuacion));
			}
			else if (Vista.lblEleccionContrincante.getText().equals("PIEDRA") && Vista.txtOpcionElegida.getText().equals("TIJERA"))
			{
				Vista.lblResultado.setFont(fuenteTexto);
				add(Vista.lblResultado);
				Vista.lblResultado.setText("¡HAS PERDIDO!");
				Vista.lblResultado.setBounds(205,530,200,30);
				new Sonido("perder");
				puntuacion = Integer.parseInt(Vista.txtPuntuacion.getText());
				puntuacion = puntuacion - 1;
				Vista.txtPuntuacion.setText(Integer.toString(puntuacion));;
			}
			else if (Vista.lblEleccionContrincante.getText().equals("TIJERA") && Vista.txtOpcionElegida.getText().equals("PIEDRA"))
			{
				Vista.lblResultado.setFont(fuenteTexto);
				add(Vista.lblResultado);
				Vista.lblResultado.setText("¡HAS GANADO!");
				Vista.lblResultado.setBounds(205,530,200,30);
				new Sonido("ganar");
				puntuacion = Integer.parseInt(Vista.txtPuntuacion.getText());
				puntuacion = puntuacion + 1;
				Vista.txtPuntuacion.setText(Integer.toString(puntuacion));
			}
			else if (Vista.lblEleccionContrincante.getText().equals("TIJERA") && Vista.txtOpcionElegida.getText().equals("PAPEL"))
			{
				Vista.lblResultado.setFont(fuenteTexto);
				add(Vista.lblResultado);
				Vista.lblResultado.setText("¡HAS PERDIDO!");
				Vista.lblResultado.setBounds(205,530,200,30);
				new Sonido("perder");
				puntuacion = Integer.parseInt(Vista.txtPuntuacion.getText());
				puntuacion = puntuacion - 1;
				Vista.txtPuntuacion.setText(Integer.toString(puntuacion));
			}
			else if (Vista.lblEleccionContrincante.getText().equals("PAPEL") && Vista.txtOpcionElegida.getText().equals("TIJERA"))
			{
				Vista.lblResultado.setFont(fuenteTexto);
				add(Vista.lblResultado);
				Vista.lblResultado.setText("¡HAS GANADO!");
				Vista.lblResultado.setBounds(205,530,200,30);
				new Sonido("ganar");
				puntuacion = Integer.parseInt(Vista.txtPuntuacion.getText());
				puntuacion = puntuacion + 1;
				Vista.txtPuntuacion.setText(Integer.toString(puntuacion));
			}
		}
		else if(evento.getSource().equals(Vista.btnRetirarse)) 
		{	
			new Sonido("retirarse");
			
			try
			{
				Modelo.ConexionBD();
				Modelo.sentencia = "INSERT INTO usuarios (nombreUsuario,puntuacionUsuario) VALUES ('"+Vista.txtNombreJugador.getText()+"',"+puntuacion+")";
				Modelo.statement.executeUpdate(Modelo.sentencia);
			}

			catch (SQLException sqle)
			{
				System.out.println("Error 2-"+sqle.getMessage());
			}

			finally
			{
				try
				{
					if(Modelo.connection!=null)
					{
						Modelo.connection.close();
					}
				}
				catch (SQLException e)
				{
					System.out.println("Error 3-"+e.getMessage());
				}
			}

			jugando = false;

			if(isActive())
			{
				setVisible(false);
				Vista.informacion.setVisible(false);
				Vista.menu.setVisible(true);
			}
		}

		repaint();
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
}