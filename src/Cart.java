import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
	
	public static HashMap<Integer, ArrayList<String>> cart = new HashMap<Integer, ArrayList<String>>();
	
	/**
	 * Affiche la liste des formations dans le panier
	 */
	public static void displayCart() {
		System.out.println();
		String placement = "| %-5s | %-15s | %-10s | %-35s | %-10s |\n";
		System.out.printf(placement, "▀▀▀▀▀", "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀", "▀▀▀▀▀▀▀▀▀▀", "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀", "▀▀▀▀▀▀▀▀▀▀");
		System.out.printf(placement, "ID", "COURS", "NB/JOURS", "DESCRIPTION", "PRIX");
		System.out.printf(placement, "-----", "---------------", "----------", "-----------------------------------", "----------");
		cart.entrySet().stream()
			.forEach(e -> System.out.printf(placement, e.getKey(), e.getValue().get(0), e.getValue().get(1), e.getValue().get(2), e.getValue().get(3).concat("€")));
		System.out.printf(placement, "▄▄▄▄▄", "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄", "▄▄▄▄▄▄▄▄▄▄", "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄", "▄▄▄▄▄▄▄▄▄▄");
	}

	public static void main(String[] args) {
		
		

	}

}
