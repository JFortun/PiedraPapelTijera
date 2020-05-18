package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

public class Juego extends Frame implements WindowListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	// Las coordenadas del cuadrado
	int posX, posY;
	// Las coordenadas del lugar donde pulse
	int pulX, pulY;
	// Las vidas
	int vidas;
	int puntos = 0;
	Random rnd = new Random();
	public Juego()
	{
		vidas = 3;
		// Obtener los valores iniciales del cuadrado
		obtenerPosicion();
		setTitle("Moviendo...");
		addWindowListener(this);
		addMouseListener(this);
		setSize(400,400);
		setVisible(true);
		setLocationRelativeTo(null);

	}
	public void obtenerPosicion()
	{
		// Obtenemos los valores teniendo en cuenta los límites del escenario
		posX=rnd.nextInt(380);
		posY=rnd.nextInt(380);
	}
	public void paint(Graphics g)
	{
		Font font = new Font("Arial", Font.BOLD, 14);
		Color color = new Color(234,23,43);

		// Se dibuja "Hola, mundo!" a partir de la posición 30,60
		g.setFont(font);
		g.setColor(color);
		g.drawString("Puntuación: " + puntos, 30, 60);

		g.drawRect(posX, posY, 20, 20);
	}
	public void windowActivated(WindowEvent we) {}
	public void windowClosed(WindowEvent we) {}
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent we) {}
	public void windowDeiconified(WindowEvent we) {}
	public void windowIconified(WindowEvent we) {}
	public void windowOpened(WindowEvent we) {}
	public static void main(String[] args) 
	{
		new Juego();
	}
	public void mouseClicked(MouseEvent me)
	{
		// Obtenemos las coordenadas del lugar donde se ha pulsado con el ratón
		pulX = me.getX();
		pulY = me.getY();
		// Comprobamos si las coordenadas del ratón están entre las del cuadrado
		if((posX<=pulX)&&(pulX<=posX+20)&&(posY<=pulY)&&(pulY<=posY+20))
		{
			System.out.println("Acertaste");
			// Obtenemos una nueva posición del cuadrado
			obtenerPosicion();
			// Y lo dibujamos
			repaint();
			puntos ++;
		}
		else
		{
			vidas--;
			if(vidas==0)
			{
				System.out.println("Has acabado todas las vidas. FIN!");
				// Deshabilitamos el MouseListener pues se ha acabado el juego
				this.removeMouseListener(this);
			}


			else
			{
				System.out.println("Has perdido una vida. Te quedan "+vidas+ " vidas.");
			}
		}
	}

	public void mouseEntered(MouseEvent me) {}
	public void mouseExited(MouseEvent me) {}
	public void mousePressed(MouseEvent me) {}
	public void mouseReleased(MouseEvent me) {}
}