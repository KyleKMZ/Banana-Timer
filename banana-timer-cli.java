class BananaTimerCli {
					
	public static void main(String[] args) {
		
		// initialize program parameters with their default values
		int sessionLength = 25;
		int numOfSessions = 4;
		int shortBreak = 5;
		int longBreak = 30;

		// test for user input errors - none of the program parameters, if given, should be 0 or less than 0
		assert args.length <= 4; // only for testing, in use: extra arguments will be ignored.
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
				System.out.println("SESSION IN PROGRESS(" + i + "/" + numOfSessions + ")");
				System.out.println("-------------------------");
				setTimer(sessionLength);
				// play a sound
				if (i < numOfSessions) {
					System.out.println("SHORT BREAK");
					System.out.println("-----------");
					setTimer(shortBreak);
					// play a sound
				}
				else {
					System.out.println("LONG BREAK");
					System.out.println("----------");
					setTimer(longBreak);
					// play a sound
				}
			}
		}
	}

	public static void setTimer(int timeInMin) {
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
				System.out.println(String.format("%02d", MinutesDisplay) + ":" + String.format("%02d", SecondsDisplay));
			}

			// pause the program and delay since we're updating only by seconds
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}