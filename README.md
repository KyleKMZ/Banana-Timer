# Banana-Timer

## What is this?
A fun little project to program a Pomodoro timer app. There is a simple command line version for minimalistic, barebones use as well as a GUI version. It is written in Java, using JavaFX for the GUI.

To learn more about the Pomodoro time management technique, visit here: https://en.wikipedia.org/wiki/Pomodoro_Technique

## Command-Line Version
To run the program with default settings(Session length: 25min, Number of sessions: 4, Short break: 5min, Long break: 30min), simply run the program like this:

	java banana-timer-cli

Command-line arguments can be given in this order to personalize usage: 
1. Session length
2. Number of sessions
3. Short break
4. Long break

Below are a few example usages.

### Example 1

	java banana-timer-cli 50 3

* 3 sessions of 50 min each
* Short break(default): 5 min
* Long break(default): 30 min

### Example 2

	java banana-timer-cli 40 3 10

* 3 sessions of 40 min each
* Short break: 10 min
* Long break(Default): 30 min

### Example 3

	java banana-timer-cli 30 4 7 20

* 4 sessions of 30 min each
* Short break: 7 min
* Long break: 20 min

## GUI Version
