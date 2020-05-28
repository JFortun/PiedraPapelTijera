package juego;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import javax.swing.JFrame;

public class Puntuacion extends JFrame implements ActionListener, WindowListener
{
	private static final long serialVersionUID = 1L;
	Color color = new Color(204, 230, 255);

	
	public static void altaUsuario(String nombreUsuario)
	{
		
	}
	
	Puntuacion()
	{
		Vista.clasificacion.setLayout(new FlowLayout());
		Vista.clasificacion.setTitle("Clasificación");
		Vista.clasificacion.setResizable(false);
		Vista.taClasificacion.setEditable(false);
		Vista.clasificacion.setSize(300, 500);
		Vista.clasificacion.setResizable(false);
		Vista.clasificacion.add(Vista.lblclasificacion);
		Vista.clasificacion.add(Vista.taClasificacion);
		Vista.clasificacion.add(Vista.btnClasificacionVolver);
		Vista.btnClasificacionVolver.addActionListener(this);
		Vista.clasificacion.addWindowListener(this);
		Vista.clasificacion.setLocationRelativeTo(null);
		Vista.clasificacion.setVisible(true);
		Vista.clasificacion.getContentPane().setBackground(color);

		try	//Sentencia para recopilar los datos e introducirlos en el text area
		{
			Modelo.ConexionBD();
			Modelo.sentencia = "SELECT * FROM usuarios";
			Modelo.rs = Modelo.statement.executeQuery(Modelo.sentencia);
			Vista.taClasificacion.setText("");
			while(Modelo.rs.next())
			{
				if(Vista.taClasificacion.getText().length()==0)
				{
					Vista.taClasificacion.setText(Modelo.rs.getString("nombreUsuario")+
							" --- "+Modelo.rs.getInt("puntuacionUsuario"));
				}
				else
				{
					Vista.taClasificacion.setText(Vista.taClasificacion.getText() + "\n" +
							Modelo.rs.getString("nombreUsuario")+
							" --- "+Modelo.rs.getInt("puntuacionUsuario"));
				}
			}
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
	}

	public void actionPerformed(ActionEvent evento) 
	{
		// Botón volver de Jugador
		if(evento.getSource().equals(Vista.btnClasificacionVolver)) 
		{
			Vista.clasificacion.setVisible(false);
			Vista.menu.setVisible(true);
		}
	}
	
	public void windowClosing(WindowEvent arg0)
	{
		if(Vista.clasificacion.isActive())
		{
			Vista.clasificacion.setVisible(false);
			Vista.menu.setVisible(true);
		}
	}
	
	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}