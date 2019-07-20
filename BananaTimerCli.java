import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

class BananaTimerCli {
					
	public static void main(String[] args) {
		
		// initialize program parameters with their default values
		int sessionLength = 25;
		int numOfSessions = 4;
		int shortBreak = 5;
		int longBreak = 30;

		// test for user input errors - none of the program parameters, if given, should be 0 or less than 0
		assert args.length <= 4; // only for testing, in use: extra arguments are ignored.
		for (int i = 0; i < args.length; i++) {
			if (Integer.parseInt(args[i]) <= 0) {
				throw new java.lang.IllegalArgumentException("Illegal argument(s). The program parameters should be greater than 0. Try again.");
			}
		}

		// change program parameters based on command-line arguments as necessary
		for (int i = 0; i < args.length; i++) {

			int parameter = Integer.parseInt(args[i]);

			if (i == 0) sessionLength = parameter;
			else if (i == 1) numOfSessions = parameter;
			else if (i == 2) shortBreak = parameter;
			else if (i == 3) longBreak = parameter;
		}

		// small exception that should not pass
		if (numOfSessions <= 1) {
			throw new java.lang.IllegalArgumentException("Illegal argument for the number of sessions. Please select a value greater than 1.");
		}

		// main program starts here
		while (true) {
			for (int i = 1; i <= numOfSessions; i++) {
				System.out.println("");
				System.out.println("SESSION IN PROGRESS(" + i + "/" + numOfSessions + ")");
				System.out.println("-------------------------");
				setTimer(sessionLength);
				playAlarm();
				System.out.println("");
				System.out.println("SESSION COMPLETE. CONGRATULATIONS!");
				if (i < numOfSessions) {
					System.out.println("");					
					System.out.println("SHORT BREAK");
					System.out.println("-----------");
					setTimer(shortBreak);
					playAlarm();
					System.out.println("");
					System.out.println("BREAK TIME OVER. GET BACK TO WORK!");
				}
				else {
					System.out.println("");
					System.out.println("LONG BREAK");
					System.out.println("----------");
					setTimer(longBreak);
					playAlarm();
					System.out.println("");
					System.out.println("BREAK TIME OVER. GET BACK TO WORK!");
				}
			}
		}
	}

	private static void setTimer(int timeInMin) {
		long startTime = System.currentTimeMillis();

		while (true) {

			long elapsedTime = System.currentTimeMillis() - startTime;
			long elapsedSeconds = elapsedTime / 1000;
			
			int MinutesDisplay = timeInMin - (int) (elapsedSeconds / 60) - 1;
			int SecondsDisplay = 60 - (int) (elapsedSeconds % 60);

			// code for fixing small bug where second is displayed as 60 incorrectly
			if (SecondsDisplay == 60) {
				SecondsDisplay = 0;
				MinutesDisplay++;
			}

			if (MinutesDisplay < 0) break;
			else {
				System.out.print(String.format("%02d", MinutesDisplay) + ":" + String.format("%02d", SecondsDisplay) + "\r");
			}

			// pause the program/delay for 1s since we're updating only by seconds
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void playAlarm() {
		try {
        	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("alarm.wav").getAbsoluteFile());
        	Clip clip = AudioSystem.getClip();
        	clip.open(audioInputStream);
        	clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
    	}

	}
}