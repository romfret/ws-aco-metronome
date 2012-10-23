/**
 * 
 */
package interfaces;

/**
 * @author 29006342
 *
 */
public interface IAfficheur {
	
	//Controle des LEDs
	public void allumerLED (int numLED);
	public void eteindreLED(int numLED);
	
	//Affiche un entier sur l'afficheur externe du metronome
	public void afficherTempo(int valeurTempo);
}
