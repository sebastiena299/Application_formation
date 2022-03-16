import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Training {
	
	// Initialisation des variables
	private static int numberOfTrainings = 8;
	private static HashMap<Integer, ArrayList<String>> trainings = new HashMap<Integer, ArrayList<String>>();
	
	/**
	 * Génère des données de formation aléatoires
	 * @return Retourne un tableau avec des données aléatoires
	 */
	public static ArrayList<String> generateRandomData() {
		Random randomNumber = new Random();
		ArrayList<String> array = new ArrayList<String>();
		String[] courses = {"Java", "Angular", "React", "NextJS", "NodeJS", "Spring"};
		String[] numberOfDays = {"20", "25", "45", "120", "15", "35", "160", "145"};
		String[] description = {"Programmation Orientée Objet", "Base", "Pogrammation avancée", "Pattern Design", "Exceptions"};
		String[] price = {"1200", "3500", "4500", "2700", "1800", "5600", "2200"};
		
		array.add(courses[randomNumber.nextInt(courses.length)]);
		array.add(numberOfDays[randomNumber.nextInt(numberOfDays.length)]);
		array.add(description[randomNumber.nextInt(description.length)]);
		array.add(price[randomNumber.nextInt(price.length)]);
		
		return array;
	}
	
	/**
	 * Remplissage des formations avec des données aléatoires
	 */
	public static void addRandomDataToTrainings() {
		for(int i = 0; i < numberOfTrainings; i++) {
			trainings.put(i + 1, generateRandomData());
		}
	}
	
	/**
	 * Affiche la liste des formations sous forme de tableau
	 */
	public static void displayAllTrainings() {
		System.out.println();
		String placement = " | %-5s | %-15s | %-10s | %-35s | %-10s |\n";
		System.out.printf(placement, "▀▀▀▀▀", "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀", "▀▀▀▀▀▀▀▀▀▀", "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀", "▀▀▀▀▀▀▀▀▀▀");
		System.out.printf(placement, "ID", "COURS", "NB/JOURS", "DESCRIPTION", "PRIX");
		System.out.printf(placement, "-----", "---------------", "----------", "-----------------------------------", "----------");
		trainings.entrySet().stream()
			.forEach(e -> System.out.printf(placement, e.getKey(), e.getValue().get(0), e.getValue().get(1), e.getValue().get(2), e.getValue().get(3).concat("€")));
		System.out.printf(placement, "▄▄▄▄▄", "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄", "▄▄▄▄▄▄▄▄▄▄", "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄", "▄▄▄▄▄▄▄▄▄▄");
	}
	
	/**
	 * Retourne la taille du tableau trainings en entier
	 * @return int -> Taille du tableau
	 */
	public static int sizeOfTrainings() {
		return trainings.size();
	}
	
	/**
	 * Retourne la formation selon l'index
	 * @param Index de la formation
	 * @return Retourne le tableau contenant la formation à l'index en question
	 */
	public static ArrayList<String> returnTrainingByIndex(int index) {
		return trainings.get(index);
	}

	public static void main(String[] args) {
	

	}

}
