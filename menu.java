import java.util.*;
public class menu {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int points = 0;
		int play_again = 0;
		int role = -1;
		int choice = -1;
		
		while(play_again != 2) {
			System.out.println("Would you like to play as the King or the Fool");
			System.out.println("King(1):Fool(2)");
			role = scan.nextInt();
			
			if(role == 1) { //playing as the king
				String[] hand = {"King", "Citizen", "Citizen", "Citizen", "Citizen"};
				
				boolean fool = false;
				
				for(int j = 0; j < 4; j++) {
					System.out.println("Your cards");
					System.out.println("----------");
					
					for(int i = 0; i < hand.length; i++) {
						if(!hand[i].equals("")) {
							System.out.print(hand[i] + "(" + i + "):");
						}
					}
					System.out.println("");
					
					choice = scan.nextInt();
					String played = hand[choice];
					hand[choice] = "";
					
					System.out.println("You picked " + played);
					
					String opp = "";
					int random_int = (int)Math.floor(Math.random() * (1));
					if(random_int == 0) {
						if(fool) {
							opp = "Citizen";
						}else {
							opp = "Fool";
						}
					}else {
						opp = "Citizen";
					}
					
					System.out.println("Opponent played " + opp);
					
					if(played.equals("King") && opp.equals("Fool")) {
						System.out.println("You lose 3 points");
						points -= 3;
						j = 5;
					}else if(played.equals("Citizen") && opp.equals("Fool")) {
						System.out.println("You win 1 point");
						points += 1;
						j = 5;
					}
				}
			}else {
				String[] hand = {"Fool", "Citizen", "Citizen", "Citizen", "Citizen"};
				
				boolean king = false;
			
				for(int j = 0; j < 4; j++) {
					System.out.println("Your cards");
					System.out.println("----------");
					
					for(int i = 0; i < hand.length; i++) {
						if(!hand[i].equals("")) {
							System.out.print(hand[i] + "(" + i + "):");
						}
					}
					System.out.println("");
					
					choice = scan.nextInt();
					String played = hand[choice];
					hand[choice] = "";
					
					System.out.println("You picked " + played);
					
					String opp = "";
					int random_int = (int)Math.floor(Math.random() * (1));
					if(random_int == 0) {
						if(king) {
							opp = "Citizen";
						}else {
							opp = "King";
							king = true;
						}
					}else {
						opp = "Citizen";
					}
					
					System.out.println("Opponent played " + opp);
					
					if(played.equals("Fool") && opp.equals("King")) {
						System.out.println("You win 3 points");
						points += 3;
						j = 5;
					}else if(played.equals("Fool") && opp.equals("Citizen")) {
						System.out.println("You lose 1 point");
						points -= 1;
						j = 5;
					}
				}
			}
			
			System.out.println("Points: " + points);
			System.out.println("Would you like to play again?");
			System.out.println("Yes(1):No(2)");
			play_again = scan.nextInt();
		}
		
		scan.close();
	}
}
