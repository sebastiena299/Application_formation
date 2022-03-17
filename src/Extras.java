public class Extras {
	
	public static void showLogoTraining() {
		System.out.println( App.COLOR + ""
				+ "                           .-~~~~~~~~~-._       _.-~~~~~~~~~-.\r\n"
				+ "                       __.'              ~.   .~              `.__\r\n"
				+ "                     .'//                  \\./                  \\\\`.\r\n"
				+ "                   .'//                     |                     \\\\`.\r\n"
				+ "                 .'// .-~\"\"\"\"\"\"\"~~~~-._     |     _,-~~~~\"\"\"\"\"\"\"~-. \\\\`.\r\n"
				+ "               .'//.-\"                 `-.  |  .-'                 \"-.\\\\`.\r\n"
				+ "             .'//______.============-..   \\ | /   ..-============.______\\\\`.\r\n"
				+ "           .'______________________________\\|/______________________________`.\r\n"
				+ "" + App.RESET);
	}
	
	public static void showLogoTransport() {
		System.out.println(App.COLOR + ""
				+ "                             _______________________________________________________\r\n"
				+ "                             |                                                      |\r\n"
				+ "                        /    |                                                      |\r\n"
				+ "                       /---, |                                                      |\r\n"
				+ "                  -----# ==| |                                                      |\r\n"
				+ "                  | :) # ==| |                                                      |\r\n"
				+ "             -----'----#   | |______________________________________________________|\r\n"
				+ "             |)___()  '#   |______====____   \\___________________________________|\r\n"
				+ "            [_/,-,\\\"--\"------ //,-,  ,-,\\\\\\   |/             //,-,  ,-,  ,-,\\\\ __#\r\n"
				+ "              ( 0 )|===******||( 0 )( 0 )||-  o              '( 0 )( 0 )( 0 )||\r\n"
				+ "           ----'-'--------------'-'--'-'-----------------------'-'--'-'--'-'--------------" + App.RESET);
	}
	
	public static void changeColorInterface(int colorChoice) {
		switch (colorChoice) {
		case 1:
			// Rouge
			App.COLOR = "\u001B[31m";
			break;
		case 2:
			// Vert
			App.COLOR = "\u001B[32m";
			break;
		case 3:
			// Bleu
			App.COLOR = "\u001B[34m";
			break;
		case 4:
			// Jaune
			App.COLOR = "\u001B[33m";
			break;
		case 5:
			// Violet
			App.COLOR = "\u001B[35m";
		case 6:
			// Cyan
			App.COLOR = "\u001B[36m";
		default:
			System.out.println("\n" + App.ERROR + " ⛔" + App.RESET + " Désolé aucune couleur ne correspond à votre choix");
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
