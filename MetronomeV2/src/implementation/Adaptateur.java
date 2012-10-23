package implementation;

import interfaces.IMateriel;
import interfaces.InterfaceIhm;

public class Adaptateur implements InterfaceIhm {
	private IMateriel materiel;
	
	public Adaptateur(){
		materiel = new SimulateurMateriel();
		
	}

	@Override
	public void flasherL1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flasherL2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setControleur(Controleur c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTempo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setEtatMarche(boolean etatMarche) {
		// TODO Auto-generated method stub
		
	}
	
}
