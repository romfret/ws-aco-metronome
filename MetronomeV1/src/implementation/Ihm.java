package implementation;
import interfaces.IControleur;
import interfaces.InterfaceIhm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import commande.CmdDec;
import commande.CmdInc;
import commande.CmdStart;
import commande.CmdStop;

public class Ihm extends JFrame implements InterfaceIhm{

	private JLabel afficheur;
	private JRadioButton led1;
	private JRadioButton led2;
	private JButton startBtn;
	private JButton stopBtn ;
	private IControleur controleur;
	private CmdStart cmdStart;
	private CmdStop cmdStop;
	private CmdDec cmdDec;
	private CmdInc cmdInc;
	private int tempo;
	
	
	public Ihm(Controleur controleur2) {
		super("Metronome V1");
		
		this.controleur = controleur2;

		cmdStart = new CmdStart(controleur);
		cmdStop = new CmdStop(controleur);
		cmdDec = new CmdDec(controleur);
		cmdInc = new CmdInc(controleur);
		
		

		// ajustement de la taille au contenu
		pack();
		// affichage effectif
		setVisible(true);
		// positionnement
		setLocation(100, 100);
		setSize(400, 100);

		JPanel panelHaut = new JPanel();
		panelHaut.setLayout(new GridLayout());
		JSlider molette = new JSlider(0, 200);
		molette.setValue(120);		
		tempo = 120;
		
		molette.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				System.out.println("statechanged");
				tempo = ((JSlider)arg0.getSource()).getValue();
				System.out.println("tempo="+tempo);
				afficheur.setText(Integer.toString(tempo));
				controleur.updateMolette(tempo);
			}
		});
		
		afficheur = new JLabel("120");
		led1 = new JRadioButton("LED 1");
		led2 = new JRadioButton("LED 2");

		panelHaut.add(molette);
		panelHaut.add(afficheur);
		panelHaut.add(led1);
		panelHaut.add(led2);

		JPanel panelBas = new JPanel();
		panelBas.setLayout(new GridLayout());
		
		startBtn = new JButton("Start");
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cmdStart.execute();
			}
		});
		
		
		stopBtn = new JButton("Stop");
		stopBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cmdStop.execute();
			}
		});
		
		
		JButton incBtn = new JButton("Inc");
		incBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cmdInc.execute();
			}
		});
		
		
		JButton decBtn = new JButton("Dec");
		decBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cmdDec.execute();
			}
		});
		
		
		panelBas.add(startBtn);
		panelBas.add(stopBtn);
		
		panelBas.add(decBtn);
		
		
		panelBas.add(incBtn);

		this.setLayout(new BorderLayout());
		getContentPane().add(BorderLayout.NORTH, panelHaut);
		getContentPane().add(BorderLayout.SOUTH, panelBas);
		pack();
	}
	
	public void flasherL1() {
		if(led1.isSelected()){
			led1.setSelected(false);
		} else 
			led1.setSelected(true);
		
	}
	public void flasherL2(){
		
		led2.setSelected(true);
		
		
		try { Thread.sleep(100); } catch (InterruptedException e) {}
		
		led2.setSelected(false);
	}
	
	public void setControleur(Controleur c){
		controleur = c;
	}

	public int getTempo(){
		return tempo;
	}

	public void setEtatMarche(boolean etatMarche) {
		stopBtn.setEnabled(etatMarche);
		startBtn.setEnabled(!etatMarche);
	}
}
