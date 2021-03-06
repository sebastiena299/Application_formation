import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
	
	// Initialisation des variables
	public static HashMap<Integer, ArrayList<String>> cart = new HashMap<Integer, ArrayList<String>>();
	private static int nbrOfTrainings;
	private static int sum;
	
	/**
	 * Affiche la liste des formations dans le panier
	 */
	public static void displayCart() {
		System.out.println();
		String placement = " | %-5s | %-15s | %-10s | %-35s | %-10s | %-10s |\n";
		System.out.printf(placement, App.COLOR +  "▀▀▀▀▀" + App.RESET, App.COLOR +  "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀" + App.RESET, App.COLOR + "▀▀▀▀▀▀▀▀▀▀" + App.RESET, App.COLOR + "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀" + App.RESET, App.COLOR +  "▀▀▀▀▀▀▀▀▀▀" + App.RESET, App.COLOR +  "▀▀▀▀▀▀▀▀▀▀" + App.RESET);
		System.out.printf(placement, "ID", "COURS", "NB/JOURS", "DESCRIPTION", "PRIX", "QUANTITE");
		System.out.printf(placement, "-----", "---------------", "----------", "-----------------------------------", "----------",  "----------");
		cart.entrySet().stream()
			.forEach(e -> System.out.printf(placement, e.getKey(), e.getValue().get(0), e.getValue().get(1), e.getValue().get(2), e.getValue().get(3).concat("€"), e.getValue().get(4)));
		System.out.printf(placement, App.COLOR + "▄▄▄▄▄" + App.RESET, App.COLOR +  "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄" + App.RESET, App.COLOR + "▄▄▄▄▄▄▄▄▄▄" + App.RESET, App.COLOR + "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄" + App.RESET, App.COLOR + "▄▄▄▄▄▄▄▄▄▄" + App.RESET, App.COLOR + "▄▄▄▄▄▄▄▄▄▄" + App.RESET);
	}
	
	/**
	 * Rajoute une formation au panier
	 * @param training -> un tableau comportant la formation à ajouter
	 */
	public static void addTrainingToCart(int index, ArrayList<String> training) {
		cart.put(index , training);
		cart.get(index).add("1");
	}
	
	/**
	 * Supprime une formation au panier
	 * @param index de la formation à supprimer
	 */
	public static void removeTrainingToCart(int index) {
		cart.remove(index);
	}
	
	/**
	 * Vérifie que l'index de la formation est bien dans le tableau
	 * @param indexOfTraining -> Index de la formation
	 * @return boolean
	 */
	public static boolean checkIndexForCart(int indexOfTraining) {
		if(cart.containsKey(indexOfTraining)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retourne le montant total du panier
	 * @param cart
	 * @return
	 */
	public static int TotalAmount(HashMap<Integer, ArrayList<String>> cart) {
		sum = 0;
		cart.entrySet().stream().forEach(e -> sum += Integer.parseInt(e.getValue().get(3)) * Integer.parseInt(e.getValue().get(4)));
		return sum;
	}
	
	/**
	 * Affiche la description du panier
	 */
	public static void orderDescription() {
		System.out.println("\n" + App.COLOR + " 🎁" + App.RESET + " Votre commande : ");
		System.out.println();
		String placement = " | %-5s | %-15s | %-10s | %-35s | %-10s | %-10s |\n";
		System.out.printf(placement, App.COLOR +  "▀▀▀▀▀" + App.RESET, App.COLOR +  "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀" + App.RESET, App.COLOR + "▀▀▀▀▀▀▀▀▀▀" + App.RESET, App.COLOR + "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀" + App.RESET, App.COLOR +  "▀▀▀▀▀▀▀▀▀▀" + App.RESET, App.COLOR +  "▀▀▀▀▀▀▀▀▀▀" + App.RESET);
		System.out.printf(placement, "ID", "COURS", "NB/JOURS", "DESCRIPTION", "PRIX", "QUANTITE");
		System.out.printf(placement, "-----", "---------------", "----------", "-----------------------------------", "----------",  "----------");
		cart.entrySet().stream()
			.forEach(e -> System.out.printf(placement, e.getKey(), e.getValue().get(0), e.getValue().get(1), e.getValue().get(2), e.getValue().get(3).concat("€"), e.getValue().get(4)));
		System.out.printf(placement, App.COLOR + "▄▄▄▄▄" + App.RESET, App.COLOR +  "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄" + App.RESET, App.COLOR + "▄▄▄▄▄▄▄▄▄▄" + App.RESET, App.COLOR + "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄" + App.RESET, App.COLOR + "▄▄▄▄▄▄▄▄▄▄" + App.RESET, App.COLOR + "▄▄▄▄▄▄▄▄▄▄" + App.RESET);
		System.out.println();
		System.out.println(" Nombres d'articles : " + returnNumberOfTrainingsInCart());
		System.out.println(" Montant total de la commande : " + TotalAmount(cart) + "€");
	}
	
	/**
	 * Retourne la taille du tableau cart en entier
	 * @return int -> Taille du tableau
	 */
	public static int sizeOfCart() {
		return cart.size();
	}
	
	/**
	 * Retourne le nombre de formation dans la panier pour la commande
	 * @return
	 */
	public static int returnNumberOfTrainingsInCart() {
		cart.entrySet().stream()
			.forEach(e -> nbrOfTrainings += Integer.parseInt(e.getValue().get(4)));
		return nbrOfTrainings;
	}
	
	/**
	 * Vide le panier (une fois la commande finie)
	 */
	public static void cleanCartAfterOrder() {
		sum = 0;
		cart.entrySet().stream()
			.forEach(e -> e.getValue().set(4, "1"));
		cart.clear();
	}
	
	

	public static void main(String[] args) {
		
		

	}

}
