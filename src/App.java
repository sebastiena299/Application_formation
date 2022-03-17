import java.util.Scanner;

public class App {
	
	// Instance of Scanner
	public static Scanner sc = new Scanner(System.in);
	
	// Initialisation variables
	private static int choice;
	public static String COLOR = "\u001B[36m";
	public static final String ERROR = "\u001B[31m";
	public static final String RESET = "\u001B[0m";
	
	/**
	 * Dirige l'utilisateur selon son choix
	 * @param choice -> choix de l'utilistateur sous forme d'un nombre entier
	 */
	public static void menuChoice(int choice) {
		switch(choice) {
			case 1:
				// Afficher la liste des formations
				Training.displayAllTrainings();
				break;
			case 2:
				// Ajouter une formation a son panier
				menuAddTrainingToCart();
				break;
			case 3:
				// Supprimer une formation a son panier
				menuRemoveTrainingToCart();
				break;
			case 4:
				// Afficher son panier
				menuDisplayCart();
				break;
			case 5:
				// Commander le contenu du panier
				menuOrderDescription();
				break;
			case 6:
				// Changer la colorisation
				menuChangeColorInterface();
				break;
			case 7:
				// Afficher formation à venir
				Training.displayUpcomingTrainings();
				break;
			case 8:
				// Quitter le programme
				System.out.println("\n" + ERROR + " 🚀 " + RESET + "Merci de votre visite !");
				System.exit(0);
				sc.close();
				break;
			default:
				System.out.println("\n" + ERROR + " 🚀 " + RESET + "Merci de votre visite !");
				System.exit(0);
				sc.close();
				break;
		}
	}
	
	/**
	 * Efface la console en sautant un nombre de ligne défini
	 * @param number -> Nombre de ligne à sauter
	 */
	public static void clearConsole(int number) {
		for(int i = 0; i < number; i++) {
			System.out.println(System.lineSeparator());
		}
	}
	
	/**
	 * Affiche le menu principale avec les différents choix possibles
	 */
	public static void menu() {
		System.out.println("\n [1] - Afficher la liste des formations");
		System.out.println(" [2] - Ajouter une formation à son panier");
		System.out.println(" [3] - Supprimer une formation de son panier");
		System.out.println(" [4] - Afficher le panier");
		System.out.println(" [5] - Passer la commande");
		System.out.println(" [6] - Changer la couleur de l'interface");
		System.out.println(" [7] - Afficher les formations à venir");
		System.out.println(" [8] - Quitter l'application");
		
		System.out.print(COLOR + "\n Saisir le choix du menu : " + RESET);
		while(!sc.hasNextInt()) sc.next();
		choice = sc.nextInt();
		menuChoice(choice);
	}
	
	/**
	 * Menu pour gérer l'ajout d'une formation au panier
	 */
	public static void menuAddTrainingToCart() {
		System.out.print(COLOR + "\n Saisir la formation à ajouter dans le panier : " + RESET);
		while(!sc.hasNextInt()) sc.next();
		int indexTraining = sc.nextInt();
		if(Training.trainings.containsKey(indexTraining)) {
			if(Cart.cart.containsKey(indexTraining)) {
				int quantity = Integer.parseInt(Cart.cart.get(indexTraining).get(4));
				Cart.cart.get(indexTraining).set(4, Integer.toString(++quantity));
			} else {
				Cart.addTrainingToCart(indexTraining, Training.trainings.get(indexTraining));
			}
		} else {
			System.out.println("\n" + ERROR + " ⛔" + RESET + " Désolé aucune formation ne correspond à votre choix");
		}
	}
	
	/**
	 * Menu pour gérer la suppression d'une formation au panier
	 */
	public static void menuRemoveTrainingToCart() {
		if(Cart.sizeOfCart() <= 0) {
			System.out.println("\n" + ERROR + " ⛔" + RESET + " Désolé vous n'avez aucune formation dans votre panier");
		} else {
			System.out.print(COLOR + "\n Saisir la formation à supprimer dans le panier : " + RESET);
			while(!sc.hasNextInt()) sc.next();
			int indexTraining = sc.nextInt();
			if(Cart.cart.containsKey(indexTraining)) {
				if(Integer.parseInt(Cart.cart.get(indexTraining).get(4)) > 1) {
					int quantity = Integer.parseInt(Cart.cart.get(indexTraining).get(4));
					--quantity;
					Cart.cart.get(indexTraining).set(4, Integer.toString(quantity));
				} else {
					Cart.removeTrainingToCart(indexTraining);
				}
			} else {
				System.out.println("\n" + ERROR + " ⛔" + RESET + " Désolé aucune formation ne correspond à votre choix");
			}
		}
	}
	
	/**
	 * Affiche les formations dans le panier, sauf si celui ci n'en contient aucune
	 */
	public static void menuDisplayCart() {
		if(Cart.sizeOfCart() <= 0) {
			System.out.println("\n" + ERROR + " ⛔" + RESET + " Désolé vous n'avez aucune formation dans votre panier");
		} else {
			Cart.displayCart();
		}
	}
	
	/**
	 * Affiche les détails de la commande, et demande à l'utilisateur si il veux finaliser sa commande
	 */
	public static void menuOrderDescription() {
		if(Cart.sizeOfCart() <= 0) {
			System.out.println("\n" + ERROR + " ⛔" + RESET + " Désolé vous n'avez aucune formation dans votre panier");
		} else {
			clearConsole(100);
			Extras.showLogoTraining();
			Cart.orderDescription();
			System.out.print("\n" + COLOR + " Voulez-vous valider votre commande [Oui/Non] ? " + RESET);
			String validation = sc.next();
			if(validation.equalsIgnoreCase("oui")) {
				System.out.println("\n" + COLOR + " 🏷" + RESET + " Votre commande a été valider");
				System.out.println("\n" + COLOR + " 🏷" + RESET + " Votre panier a été remis à zéro");
				System.out.println();
				Cart.cleanCartAfterOrder();
				Extras.showLogoTransport();
			} else {
				System.out.println("\n" + ERROR + " ⛔" + RESET + " Votre commande a été annuler avec succès");
				Cart.cleanCartAfterOrder();
			}
		}
	}
	
	/**
	 * Menu pour changer la couleur de l'interface
	 */
	public static void menuChangeColorInterface() {
		System.out.println("\n [1] - Rouge");
		System.out.println(" [2] - Vert");
		System.out.println(" [3] - Bleu");
		System.out.println(" [4] - Jaune");
		System.out.println(" [5] - Violet");
		System.out.println(" [6] - Cyan");
		System.out.print(COLOR + "\n Saisir le choix de la couleur : " + RESET);
		while(!sc.hasNextInt()) sc.next();
		int colorChoice = sc.nextInt();
		Extras.changeColorInterface(colorChoice);
	}

	/**
	 * Application globale
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Initialise le tableau de formation avec des données aléatoires
		Training.addRandomDataToTrainings();
		Training.addRandomDataToUpcomingTrainings();
		
		// Message d'accueil
		System.out.println(COLOR + "\n Bonjour est bienvenue dans mon application FullTrainings" + RESET);
		System.out.println(COLOR + " Nous allons vous proposer une liste de formation actullement disponible" + RESET);
		
		while(choice != 8) {
			menu();
		}
		
	}

}
