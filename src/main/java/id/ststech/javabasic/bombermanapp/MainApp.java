/**
 * 
 */
package id.ststech.javabasic.bombermanapp;

import java.util.Scanner;

/**
 * @author Ali Irawan
 *
 */
public class MainApp {

	static Scanner scanner;
	static {
		scanner = new Scanner(System.in);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BomberMan2[] players = null;
		int playerCount = 0;

		// Ask user how many players between 1 to 4
		do {
			System.out.print("How many players (1-4) ? ");
			playerCount = scanner.nextInt();
			scanner.nextLine();

		} while (playerCount < 1 || playerCount > 4);

		// Create an array of players based on input
		players = new BomberMan2[playerCount];

		// Initialize
		MainApp.initialize(players);

		// Play game
		MainApp.playGame(players);

		// Close the System.in when end of program only
		scanner.close();
	}

	/**
	 * Initialize game
	 * 
	 * @param players
	 */
	private static void initialize(BomberMan2[] players) {
		// Initialize here...
		// Loop for players.length

		for (int i = 0; i < players.length; i++) {

			String inputName = "";

			// Asking the player name
			System.out.println("Player #" + (i + 1));
			System.out.print("Please input name (all will be lowercased): ");

			inputName = scanner.nextLine();

			// Create the instance using name given
			players[i] = new BomberMan2(inputName);
		}
	}

	/**
	 * The main game logic
	 * 
	 * @param players
	 */
	private static void playGame(BomberMan2[] players) {
		// Play the game here...

		// players have been initialized before
		printLine();
		System.out.println("Player Count: " + players.length);
		printLine();

		String command = "";

		System.out.println();

		// Do loop, until user type exit
		do {
			System.out.print("Command (type ? for help, or exit): ");
			command = scanner.nextLine();

			switch (command) {
			case "?":
				commandHelp();
				break;
			case "?bomb":
				commandHelpBomb();
				break;
			case "?fire":
				commandHelpFire();
				break;
			case "?boot":
				commandHelpBoot();
				break;
			case "?kick":
				commandHelpKick();
				break;
			case "?throw":
				commandHelpThrow();
				break;
			case "?poison":
				commandHelpPoison();
				break;
			default:

				// Handles others command
				boolean commandValid = BomberManUtil.validateCommand(command);

				if (commandValid) {
					String[] tokens = command.split(" "); // pecah command berdasarkan tanda spasi " "

					String action = tokens[0];
					String playerName = tokens[1];
					String options = tokens[2];
					BomberMan2 selectedPlayer = BomberManUtil.findPlayerByName(players, playerName);
					BomberManUtil.executeAction(action, selectedPlayer, options);
					BomberManUtil.displayStatus(selectedPlayer);
				}

				else {
					System.out.println("Command not recognized. Type ? for more commands");
				}
				break;
			}
		} while (!"exit".equals(command));
		System.out.println("Bye...");
	}

	private static void commandHelpPoison() {
		printLine();
		System.out.println("Command: poison");
		System.out.println("Format: poison player_name [+/-]");
		System.out.println("Examples: ");
		System.out.println("poison john + => means set poisoned true to player john");
		System.out.println("poison john - => means set poisoned false to player john");
		System.out.println();
	}

	private static void commandHelpThrow() {
		printLine();
		System.out.println("Command: throw");
		System.out.println("Format: throw player_name [+/-]");
		System.out.println("Examples: ");
		System.out.println("throw john + => means set can throw true to player john");
		System.out.println("throw john - => means set can throw false to player john");
		System.out.println();
	}

	private static void commandHelpKick() {
		printLine();
		System.out.println("Command: kick");
		System.out.println("Format: kick player_name [+/-]");
		System.out.println("Examples: ");
		System.out.println("kick john + => means set can kick true to player john");
		System.out.println("kick john - => means set can kick false to player john");
		System.out.println();
	}

	private static void commandHelpBoot() {
		printLine();
		System.out.println("Command: boot");
		System.out.println("Format: boot player_name [+/-/reset]");
		System.out.println("Examples: ");
		System.out.println("boot john + => means add 1 boot to player john");
		System.out.println("boot john - => means subtract 1 boot to player john");
		System.out.println("boot john reset => means reset boot to 1 to player john");
		System.out.println();
		System.out.println("Note: max boot is 15");
	}

	private static void commandHelpFire() {
		printLine();
		System.out.println("Command: fire");
		System.out.println("Format: fire player_name [+/-/reset]");
		System.out.println("Examples: ");
		System.out.println("fire john + => means add 1 fire to player john");
		System.out.println("fire john - => means subtract 1 fire to player john");
		System.out.println("fire john reset => means reset fire to 1 to player john");
		System.out.println();
		System.out.println("Note: max fire is 15");
	}

	private static void commandHelpBomb() {
		printLine();
		System.out.println("Command: bomb");
		System.out.println("Format: bomb player_name [+/-/reset]");
		System.out.println("Examples: ");
		System.out.println("bomb john + => means add 1 bomb to player john");
		System.out.println("bomb john - => means subtract 1 bomb to player john");
		System.out.println("bomb john reset => means reset bomb to 1 to player john");
		System.out.println();
		System.out.println("Note: max bomb is 15");
	}

	/**
	 * Print line
	 */
	private static void printLine() {
		for (int i = 0; i < 50; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	/**
	 * Command ?
	 */
	private static void commandHelp() {
		printLine();
		System.out.println("Command Format: [action] [player_name] [arguments]");
		System.out.println("action:");
		System.out.println("bomb\t- type \"?bomb\" for more detail");
		System.out.println("fire\t- type \"?fire\" for more detail");
		System.out.println("boot\t- type \"?boot\" for more detail");
		System.out.println("kick\t- type \"?kick\" for more detail");
		System.out.println("throw\t- type \"?throw\" for more detail");
		System.out.println("poison\t- type \"?poison\" for more detail");
		System.out.println();
	}
}
