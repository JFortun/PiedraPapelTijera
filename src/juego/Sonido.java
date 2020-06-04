
package juego;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sonido {
	Clip clip;
	String ruta="/sonidos/";
	Sonido(String archivo){
		try 
		{
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta+archivo+".wav")));
			clip.start();

		} 

		catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}