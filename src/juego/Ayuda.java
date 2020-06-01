package juego;

import java.io.IOException;

public class Ayuda 
{
	{
		try 
		{
			Runtime.getRuntime().exec("hh.exe ayuda.chm");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}