package interfaces;

import implementation.Controleur;

/**
 * 
 */

/**
 * @author 29006342
 *
 */
public interface IMoteur {
	public void start();
	public void stop();
	public void incMesure();
	public void decMesure();
	public float getTempo();
	public void setTempo(float tempo);
	public float getMesure();
	public void setMesure(float mesure);
	
	public void setCmdMarquerTemps(ICommande c);
	public ICommande getCmdMarquerTemps(ICommande c);
	public void setCmdMarquerMesure(ICommande c);
	public ICommande getCmdMarquerMesure();
	
	public boolean getEtatMarche();
	public void setEtatMarche(boolean etatMarche);
	public void tick();
	
	
}
