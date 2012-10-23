package implementation;

import java.awt.BorderLayout;
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

import commande.CmdDec;
import commande.CmdInc;
import commande.CmdStart;
import commande.CmdStop;

import interfaces.IAfficheur;

public class Afficheur extends JPanel implements IAfficheur {
	private static final long serialVersionUID = 1L;

	private JLabel tempoLabel;
	private JRadioButton[] led;

	public Afficheur() {
		
		led = new JRadioButton[2];
		led[0] = new JRadioButton("LED1");
		led[1] = new JRadioButton("LED2");
		tempoLabel = new JLabel();
		
		this.add(led[0]);
		this.add(led[1]);
		this.add(tempoLabel);
	}

	@Override
	public void allumerLED(int numLED) {
		led[numLED].setSelected(true);
	}

	@Override
	public void eteindreLED(int numLED) {
		led[numLED].setSelected(false);
	}

	@Override
	public void afficherTempo(int valeurTempo) {
		tempoLabel.setText(Integer.toString(valeurTempo));
	}

}
