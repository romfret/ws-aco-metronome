package implementation;

import interfaces.ICommande;
import interfaces.IHorloge;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class HorlogeImpl implements IHorloge {
	private Timer timer;
	private TimerTask timerTask;
	
	public HorlogeImpl() {
		timer = new Timer();
	}

	class RemindTask extends TimerTask {
		final ICommande cmd;

		public RemindTask(final ICommande cmd) {
			this.cmd = cmd;
		}

		public void run() {
			System.out.println("Time's up!");
			cmd.execute();
		}
	}

	@Override
	public void activerPeriodiquement(final ICommande cmd,
			final float periodeEnSecondes) {
		System.out.println("activerPeriodiquement");
		// timer.ca
		timerTask = new RemindTask(cmd);
		timer.schedule(timerTask, 0,
				(long) (periodeEnSecondes * 1000));

	}

	@Override
	public void activerApresDelai(ICommande cmd, float delaiEnSecondes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void desactiver(ICommande cmd) {
		System.out.println("desactiver horloge");
		timerTask.cancel();
	}

}
