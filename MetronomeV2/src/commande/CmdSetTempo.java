package commande;

import implementation.Ihm;
import interfaces.ICommande;
import interfaces.IMoteur;
import interfaces.IControleur;

public class CmdSetTempo implements ICommande  {

	private IControleur controleur;
	private Ihm ihm;
	
	public CmdSetTempo(IControleur controleur, Ihm ihm){
		this.controleur = controleur;
	}
	
	@Override
	public void execute() {
		controleur.updateMolette(ihm.getTempo());
	}

}
