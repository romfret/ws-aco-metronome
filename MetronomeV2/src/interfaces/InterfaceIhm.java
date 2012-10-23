package interfaces;

import implementation.Controleur;

public interface InterfaceIhm {
	public void flasherL1() ;
	public void flasherL2();
	
	public void setControleur(Controleur c);
	public int getTempo();

	public void setEtatMarche(boolean etatMarche) ;
}
