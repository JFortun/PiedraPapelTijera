package juego;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo {

	// Conexión a la base de datos
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/juego?useSSL=false";
	static String usuario = "root";
	static String clave = "root";
	public static String sentencia = "";
	public static Connection connection = null;
	public static Statement statement = null;
	static ResultSet rs = null;

	public static void ConexionBD() {
		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD
			connection = DriverManager.getConnection(url, usuario, clave);
			//Crear una sentencia
			statement = connection.createStatement();

		}

		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1-"+cnfe.getMessage());
		}

		catch (SQLException sqle)
		{
			System.out.println("Error 2-"+sqle.getMessage());
		}

		finally{}
	}

}

/*	Código SQL para crear la base de datos
create database juego charset utf8mb4 collate utf8mb4_spanish2_ci;
use juego;
create table usuarios (
idUsuario int auto_increment,
nombreUsuario varchar(45),
puntuacionUsuario int,
primary key(idUsuario)
);
 */