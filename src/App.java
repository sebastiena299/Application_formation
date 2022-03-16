import java.util.Scanner;

public class App {
	
	// Instance of Scanner
	public static Scanner sc = new Scanner(System.in);
	
	// Initialisation variables
	private static int choice;
	private static final String COLOR = "\u001B[36m";
	private static final String RESET = "\u001B[0m";
	
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
				Cart.displayCart();
				break;
			case 5:
				// Commander le contenu du panier
				break;
			case 6:
				// Changer la colorisation
				break;
			case 7:
				// Quitter le programme
				System.exit(0);
				sc.close();
				break;
			default:
				System.exit(0);
				break;
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
		System.out.println(" [7] - Quitter l'application");
		
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
		Cart.addTrainingToCart(Training.returnTrainingByIndex(indexTraining));
	}
	
	/**
	 * Menu pour gérer la suppression d'une formation au panier
	 */
	public static void menuRemoveTrainingToCart() {
		System.out.print(COLOR + "\n Saisir la formation à supprimer dans le panier : " + RESET);
		while(!sc.hasNextInt()) sc.next();
		int indexTraining = sc.nextInt();
		Cart.removeTrainingToCart(indexTraining);
	}

	/**
	 * Application globale
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Initialise le tableau de formation avec des données aléatoires
		Training.addRandomDataToTrainings();
		
		// Message d'accueil
		System.out.println(COLOR + "\n Bonjour est bienvenue dans mon application FullTrainings" + RESET);
		System.out.println(COLOR + " Nous allons vous proposer une liste de formation actullement disponible" + RESET);
		
		while(choice != 7) {
			menu();
		}
		
	}

}
