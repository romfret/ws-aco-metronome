package commande;

import implementation.Controleur;
import interfaces.ICommande;
import interfaces.IControleur;

public class CmdDec implements ICommande {

	private IControleur controleur;
	
	public CmdDec(IControleur controleur2){
		controleur = controleur2;
	}
	
	@Override
	public void execute() {
		controleur.dec();
	}

}
