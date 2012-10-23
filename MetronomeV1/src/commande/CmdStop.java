package commande;

import implementation.Controleur;
import interfaces.ICommande;
import interfaces.IControleur;

public class CmdStop implements ICommande {

	private IControleur controleur;
	
	public CmdStop(IControleur controleur){
		this.controleur = controleur;
	}
	
	@Override
	public void execute() {
		controleur.stop();
	}

}
