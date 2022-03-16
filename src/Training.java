import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Training {
	
	// Initialisation des couleurs
	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_BLACK = "\u001B[30m";
	public static final String TEXT_RED = "\u001B[31m";
	public static final String TEXT_GREEN = "\u001B[32m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_BLUE = "\u001B[34m";
	public static final String TEXT_PURPLE = "\u001B[35m";
	public static final String TEXT_CYAN = "\u001B[36m";
	public static final String TEXT_WHITE = "\u001B[37m";
	
	// Initialisation des variables
	private static int numberOfTrainings = 8;
	private static HashMap<Integer, ArrayList<String>> trainings = new HashMap<Integer, ArrayList<String>>();
	
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
	
	public static void addRandomDataToTrainings() {
		for(int i = 0; i < numberOfTrainings; i++) {
			trainings.put(i + 1, generateRandomData());
		}
	}
	
	public static void displayAllCourses() {
		System.out.println();
		String placement = "| %-5s | %-15s | %-10s | %-35s | %-10s |\n";
		System.out.printf(placement, "▀▀▀▀▀", "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀", "▀▀▀▀▀▀▀▀▀▀", "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀", "▀▀▀▀▀▀▀▀▀▀");
		System.out.printf(placement, "ID", "COURS", "NB/JOURS", "DESCRIPTION", "PRIX");
		System.out.printf(placement, "-----", "---------------", "----------", "-----------------------------------", "----------");
		trainings.entrySet().stream()
			.forEach(e -> System.out.printf(placement, e.getKey(), e.getValue().get(0), e.getValue().get(1), e.getValue().get(2), e.getValue().get(3).concat("€")));
		System.out.printf(placement, "▄▄▄▄▄", "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄", "▄▄▄▄▄▄▄▄▄▄", "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄", "▄▄▄▄▄▄▄▄▄▄");
		
	}

	public static void main(String[] args) {
	

	}

}
