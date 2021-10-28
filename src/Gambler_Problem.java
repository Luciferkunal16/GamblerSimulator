package LogicalPrograms;

public class Gambler_Problem {
	public static final double INITIAL_STAKE = 100;
	public static final double STAKE_BET = 100;
	public static  int stake=0;
	public static final int NUMBER_OF_PLAYS =20;
	/* Win or Loose By random Function*/
	public static boolean winOrLose() {

		if ((int)Math.floor(Math.random()*10)%2 == 1) {
			return true;
		} else {
			return false;
		}
	}
	/* If stake is less than 50% stop playing*/

	public static void gamblerDecision() {
		boolean resign = false;
		
		while(resign == false) {
			
			if (winOrLose()) {
				stake ++;
			} else {
				stake --;
			}
			if (stake >= INITIAL_STAKE + (INITIAL_STAKE * 0.5) || stake <= INITIAL_STAKE / 2) {
				resign = true;
			} 
			
		}
	}

	
	public static void main(String[] args) {
		System.out.println("Welcome To Gambler Simulation");
	
		double balance = 0;
		
		for(int numberOfDays = 0; numberOfDays<= NUMBER_OF_PLAYS ; numberOfDays++) {
			int stake = 100;
			gamblerDecision();
			balance = balance+stake; 			
		}
			System.out.println("Total amount : " + balance);
	}
	
}

