package commande;

import interfaces.ICommande;
import interfaces.IMoteur;
import interfaces.IControleur;

public class CmdTick implements ICommande {

	private IMoteur moteur;
	
	public CmdTick(IMoteur moteur){
		this.moteur = moteur;
	}
	
	@Override
	public void execute() {
		moteur.tick();
	}

}
