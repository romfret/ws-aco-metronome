package implementation;

import interfaces.IClavier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToggleButton;

public class Clavier implements IClavier {

	private JToggleButton startBtn, stopBtn, incBtn, decBtn;
	private JToggleButton[] buttons; 
	
	
	public Clavier() {
		buttons = new JToggleButton[4];
		buttons[0] = startBtn;
		buttons[1] = stopBtn;
		buttons[2] = incBtn;
		buttons[3] = decBtn;
		
		//Bouton 0
		startBtn = new JToggleButton("Start");
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//cmdStart.execute();
			}
		});

		//Bouton 1
		stopBtn = new JToggleButton("Stop");
		stopBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//cmdStop.execute();
			}
		});

		//Bouton 2
		incBtn = new JToggleButton("Inc");
		incBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//cmdInc.execute();
			}
		});

		//Bouton 
		decBtn = new JToggleButton("Dec");
		decBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//cmdDec.execute();
			}
		});
	}

	@Override
	public boolean touchePressée(int i) {
		return buttons[i].isSelected();
	}

}
