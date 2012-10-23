package implementation;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import interfaces.IAfficheur;
import interfaces.IClavier;
import interfaces.IEmetteurSonore;
import interfaces.IHorloge;
import interfaces.IMateriel;
import interfaces.IMolette;

public class SimulateurMateriel extends JFrame implements IMateriel {

	static IHorloge horloge;
	static IClavier clavier;
	static IMolette molette;
	static IEmetteurSonore emetteurSonore;
	static IAfficheur afficheur;
	
	
	
	public SimulateurMateriel() {
		super("Metronome V2");

		horloge = new HorlogeImpl();
		clavier = new Clavier();
		molette = new Molette();
		emetteurSonore = new EmetteurSonore();
		afficheur = new Afficheur();

		this.add((Component) molette);
		this.add((Component) afficheur);
		this.add((Component) clavier);

		// affichage effectif
		setVisible(true);
		
		// positionnement
		setLocation(100, 100);
		setSize(400, 100);

		JPanel panelHaut = new JPanel();
		panelHaut.setLayout(new GridLayout());
		

		panelHaut.add(molette);
		panelHaut.add(afficheur);
		panelHaut.add(led1);
		panelHaut.add(led2);

		JPanel panelBas = new JPanel();
		panelBas.setLayout(new GridLayout());

		

		panelBas.add(startBtn);
		panelBas.add(stopBtn);

		panelBas.add(decBtn);

		panelBas.add(incBtn);

		this.setLayout(new BorderLayout());
		getContentPane().add(BorderLayout.NORTH, panelHaut);
		getContentPane().add(BorderLayout.SOUTH, panelBas);
		// ajustement de la taille au contenu
		pack();
	}

	@Override
	public IHorloge getHorloge() {
		// TODO Auto-generated method stub
		return horloge;
	}

	@Override
	public IClavier getClavier() {
		// TODO Auto-generated method stub
		return clavier;
	}

	@Override
	public IMolette getMolette() {
		// TODO Auto-generated method stub
		return molette;
	}

	@Override
	public IEmetteurSonore getEmetteurSonore() {
		// TODO Auto-generated method stub
		return emetteurSonore;
	}

	@Override
	public IAfficheur getAfficheur() {
		// TODO Auto-generated method stub
		return afficheur;
	}

}
