package id.ststech.javabasic.bombermanapp;

public class BomberManUtil {

	/**
	 * Execute action
	 * 
	 * @param action     either bomb, fire, boot, kick, throw, poision
	 * @param players    array players played
	 * @param playerName player name action
	 * @param options    options for specified action
	 */
	public static void executeAction(String action, BomberMan2 player, String options) {

		BomberMan2 playerFound = player;

		switch (action) {
		case "bomb":
			switch (options) {
			case "+":
				playerFound.setBomb(playerFound.getBomb() + 1);
				break;
			case "-":
				playerFound.setBomb(playerFound.getBomb() - 1);
				break;
			case "reset":
				playerFound.setBomb(1);
				break;

			}
			break;
		case "fire":
			switch (options) {
			case "+":
				playerFound.setFire(playerFound.getFire() + 1);
				break;
			case "-":
				playerFound.setFire(playerFound.getFire() - 1);
				break;
			case "reset":
				playerFound.setFire(1);
				break;

			}
			break;
		case "boot":
			switch (options) {
			case "+":
				playerFound.setBoot(playerFound.getBoot() + 1);
				break;
			case "-":
				playerFound.setBoot(playerFound.getBoot() - 1);
				break;
			case "reset":
				playerFound.setBoot(1);
				break;

			}
			break;
		case "kick":
			switch (options) {
			case "+":
				playerFound.setCanKick(true);
				break;
			case "-":
				playerFound.setCanKick(false);
				break;

			}
			break;
		case "throw":
			switch (options) {
			case "+":
				playerFound.setCanThrow(true);
				break;
			case "-":
				playerFound.setCanThrow(false);
				break;

			}
			break;
		case "poison":
			switch (options) {
			case "+":
				playerFound.setPoisoned(true);
				break;
			case "-":
				playerFound.setPoisoned(false);
				break;

			}
		}
	}
	
	/**
	 * Validate command given
	 * @param command command for bomb, fire, boot, kick, throw, poison
	 * @return true if valid
	 */
	public static boolean validateCommand(String command) {
		String[] tokens = command.split(" ");
		if (tokens.length >= 1) {
			switch (tokens[0]) {
			case ActionConstants.BOMB:
			case ActionConstants.FIRE:
			case ActionConstants.BOOT:
			case ActionConstants.KICK:
			case ActionConstants.THROW:
			case ActionConstants.POISON:
				// Make sure minimal 3 tokens
				if (tokens.length != 3) {
					return false;
				}

				// Validate 3nd token must +/-
				switch (tokens[0]) {
				case ActionConstants.BOMB:
				case ActionConstants.FIRE:
				case ActionConstants.BOOT:
					switch (tokens[2]) {
					case "+":
					case "-":
					case "reset":
						return true;
					default:
						return false;
					}
				case ActionConstants.KICK:
				case ActionConstants.THROW:
				case ActionConstants.POISON:
					switch (tokens[2]) {
					case "+":
					case "-":
						return true;
					default:
						return false;
					}
				}

			default:
				return false;
			}
		}
		return true;
	}

	/***
	 * Display player status
	 * 
	 * @param player specify player
	 */
	public static void displayStatus(BomberMan2 player) {
		System.out.println();
		System.out.println("Player Status - name: " + player.getName());
		System.out.println("bomb=" + player.getBomb());
		System.out.println("fire=" + player.getFire());
		System.out.println("boot=" + player.getBoot());
		System.out.println("kick=" + player.isCanKick());
		System.out.println("throw=" + player.isCanThrow());
		System.out.println("poison=" + player.isPoisoned());
		System.out.println();
	}

	/**
	 * FInd player based on player name
	 * 
	 * @param players    array player to search in
	 * @param playerName player name to search
	 * @return bomberman object
	 */
	public static BomberMan2 findPlayerByName(BomberMan2[] players, String playerName) {

		// If array is null, no need to continue search
		if (players == null) {
			return null;
		}

		for (BomberMan2 item : players) {
			if (item.getName().equals(playerName)) {
				// Found the player
				return item;
			}
		}

		// Cannot find the specified playerName, return null
		return null;
	}
	
	
	
	public class ActionConstants {
		
		public final static String BOMB = "bomb";
		public final static String FIRE = "fire";
		public final static String BOOT = "boot";
		public final static String KICK = "kick";
		public final static String THROW = "throw";
		public final static String POISON = "poison";
	}
	
}
