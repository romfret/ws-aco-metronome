package implementation;

import interfaces.ICommande;
import interfaces.IHorloge;
import interfaces.IMoteur;

import commande.CmdTick;

public class MoteurImpl implements IMoteur {

	private IHorloge horloge;
	private Controleur controleur;
	private ICommande cmdMarquerTemps;
	private ICommande cmdMarquerMesure;
	private ICommande cmdTick;
	private ICommande cmdInc;
	private ICommande cmdDec;
	
	private float tempo;
	private float mesure;
	private boolean etatMarche;
	
	private int nbTemps;
	private int ndDeTpsPourMesure;
	
	
	public MoteurImpl(Controleur controleur2){
		ndDeTpsPourMesure = 4;
		cmdTick = new CmdTick(this);
		nbTemps = 0;
		controleur = controleur2;
		horloge = new HorlogeImpl();
		tempo = 120;
		//horloge.activerPeriodiquement(cmd, periodeEnSecondes);
	}
	
	
	@Override
	public void start() {
		etatMarche = true;
		float periodeEnSecondes = 60/tempo;
		System.out.println("[MoteurImpl.start()] periodes en secondes = "+periodeEnSecondes);
		horloge.activerPeriodiquement(cmdTick, periodeEnSecondes);
		controleur.update();
	}

	@Override
	public void stop() {
		etatMarche = false;
		System.out.println("stop");
		horloge.desactiver(cmdTick);
		controleur.update();
	}

	@Override
	public void incMesure() {
		if(ndDeTpsPourMesure < 8){
			ndDeTpsPourMesure++;
		}
	}

	@Override
	public void decMesure() {
		if(ndDeTpsPourMesure > 4){
			ndDeTpsPourMesure--;
		}
	}

	@Override
	public float getTempo() {
		return tempo;
	}

	@Override
	public void setTempo(float tempo) {
		System.out.println("[MoteurImpl.setTempo()] = " + tempo);
		this.tempo = tempo;
		if(etatMarche == true) {
			stop();
			start();
		}
		controleur.update();
	}

	@Override
	public void setCmdMarquerTemps(ICommande c) {
		cmdMarquerTemps = c;
	}

	@Override
	public ICommande getCmdMarquerTemps(ICommande c) {
		return cmdMarquerTemps;
	}

	@Override
	public void setCmdMarquerMesure(ICommande c) {
		cmdMarquerMesure = c;
	}

	@Override
	public ICommande getCmdMarquerMesure() {
		return cmdMarquerMesure;
		
	}

	@Override
	public float getMesure() {
		return mesure;
	}

	@Override
	public void setMesure(float mesure) {
		this.mesure = mesure;
		//controleur.update();
	}

	@Override
	public boolean getEtatMarche() {
		return etatMarche;
	}

	@Override
	public void setEtatMarche(boolean etatMarche) {
		this.start();
		controleur.update();
	}

	public void tick(){
		
		
		nbTemps++;
		cmdMarquerTemps.execute();
		if(nbTemps%ndDeTpsPourMesure == 0){
			System.out.println("mesure=" + ndDeTpsPourMesure);
			cmdMarquerMesure.execute();
		}
	}
}
