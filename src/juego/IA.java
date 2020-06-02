package juego;

import java.util.Random;

public class IA {

	static String numeroAleatorio() 
	{
		String resultado = "";
		Random rnd = new Random();
		int x = rnd.nextInt(3);
		if(x == 0)
		{
			resultado = "PIEDRA";
		}
		else if(x == 1)
		{
			resultado = "PAPEL";
		}
		else if(x == 2)
		{
			resultado = "TIJERA";
		}
		return resultado;

		//NumeroAleatorio() saca un número aleatorio del 0 al 2
	}
}