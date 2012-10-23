/**
 * 
 */
package interfaces;

/**
 * @author 29006342
 * 
 */
public interface IHorloge {
	// Appel périodique de l’opération execute() de cmd,
	// toutes les périodeEnSecondes secondes,
	// avec une précision d’une milliseconde.
	 
	void activerPeriodiquement(ICommande cmd, float periodeEnSecondes);

	// Appel de l’opération execute() de cmd,
	// après un délai de délaiEnSecondes secondes,
	// avec une précision d’une milliseconde.
	void activerApresDelai(ICommande cmd, float delaiEnSecondes);

	void desactiver(ICommande cmd);

}
