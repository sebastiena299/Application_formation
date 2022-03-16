

public class App {

	public static void main(String[] args) {
		
		System.out.println(Training.TEXT_CYAN + "\nBonjour est bienvenue dans mon application FullTrainings" + Training.TEXT_RESET);
		System.out.println(Training.TEXT_CYAN + "Nous allons vous proposer une liste de formation actullement disponible" + Training.TEXT_RESET);
		
		Training.addRandomDataToTrainings();
		Training.displayAllTrainings();

	}

}
