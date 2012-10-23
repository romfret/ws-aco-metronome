/**
 * 
 */
package interfaces;

/**
 * @author 29006342
 * 
 */
public interface IHorloge {
	// Appel p�riodique de l�op�ration execute() de cmd,
	// toutes les p�riodeEnSecondes secondes,
	// avec une pr�cision d�une milliseconde.
	 
	void activerPeriodiquement(ICommande cmd, float periodeEnSecondes);

	// Appel de l�op�ration execute() de cmd,
	// apr�s un d�lai de d�laiEnSecondes secondes,
	// avec une pr�cision d�une milliseconde.
	void activerApresDelai(ICommande cmd, float delaiEnSecondes);

	void desactiver(ICommande cmd);

}
