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
				throw new java.lang.IllegalArgumentException("Illegal arguments. The program parameters should be greater than 0. Try again.");
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

		


	}
}