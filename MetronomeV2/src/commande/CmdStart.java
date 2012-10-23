package commande;

import implementation.Controleur;
import interfaces.ICommande;
import interfaces.IControleur;

public class CmdStart implements ICommande {

	private IControleur controleur;
	
	public CmdStart(IControleur controleur2){
		controleur = controleur2;
	}
	
	@Override
	public void execute() {
		controleur.start();
	}

}
