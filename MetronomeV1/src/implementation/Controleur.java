package implementation;

import java.util.Observable;

import interfaces.*;

public class Controleur implements IControleur{

	private Ihm ihm;
	private IMoteur moteur;
	
	
	
	//private ICommande cmdMarquerMesure;
	
	public Controleur(){
		ihm = new Ihm(this);
		moteur = new MoteurImpl(this);

		ICommande cmdMarquerTemps = new CmdMarquerTemps(this);
		ICommande cmdMarquerMesure = new CmdMarquerMesure(this);
		//cmdMarquerMesure = new CmdMarquerMesure(this);
		moteur.setCmdMarquerTemps(cmdMarquerTemps);
		moteur.setCmdMarquerMesure(cmdMarquerMesure);
		//moteur.setCmdMarquerTemps(cmdMarquerMesure);
		
		
		
	}
	

	public void marquerTemps() {
		ihm.flasherL1();
	}
	
	
	public void marquerMesure() {
		ihm.flasherL2();
	}
	
	
	//public void setTempo
	
	public void start() {
		if(!moteur.getEtatMarche()){
			//moteur.setTempo(ihm.getTempo());
			moteur.start();
		}
	}

	public void stop() {
		if(moteur.getEtatMarche()){
			
			moteur.stop();
		}
	}
	
	
	public void update() {
		System.out.println("update");
		//moteur.setTempo(ihm.getTempo());
		ihm.setEtatMarche(moteur.getEtatMarche());
		
//		if(moteur.getEtatMarche())
//			moteur.stop();
//		moteur.start();
		//moteur.getMesure();
		//moteur.getTempo();
	}


	public void setIhm(Ihm ihm2) {
		ihm = ihm2;		
	}


	public void setMoteur(IMoteur moteur2) {
		moteur = moteur2;
	}


	public void updateMolette(float tempo) {
		System.out.println("updateMolette");
		moteur.setTempo(tempo);
	}


	@Override
	public void inc() {
		moteur.incMesure();
	}


	@Override
	public void dec() {
		moteur.decMesure();
	}
	
}






class CmdMarquerMesure implements ICommande {
	
	private Controleur controleur;
	
	public CmdMarquerMesure(Controleur c){
		controleur = c;
	}
	
	@Override
	public void execute() {
		controleur.marquerMesure();
	}

}

class CmdMarquerTemps implements ICommande {
	
	private Controleur controleur;
	
	public CmdMarquerTemps(Controleur c){
		controleur = c;
	}
	
	@Override
	public void execute() {
		controleur.marquerTemps();
	}

}

