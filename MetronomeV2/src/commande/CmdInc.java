package commande;

import implementation.Controleur;
import interfaces.ICommande;
import interfaces.IControleur;

public class CmdInc implements ICommande {

	private IControleur controleur;
	
	public CmdInc(IControleur controleur2){
		controleur = controleur2;
	}
	
	@Override
	public void execute() {
		controleur.inc();
	}

}
