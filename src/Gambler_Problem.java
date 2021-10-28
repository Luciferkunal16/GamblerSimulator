package LogicalPrograms;

public class Gambler_Problem {
	public static final int INITIAL_STAKE = 100;
	public static final double STAKE_BET = 100;
	public static int stake = 0;
	public static final int NUMBER_OF_PLAYS = 20;
	public static int monthlyWins = 0, monthlyLosses = 0;
	static int maxWinDay, maxLossDay;
	public static double totalStake = 0, maximumWin = 0, maximumLoss = 0;

	/* Win or Loose By random Function */
	public static boolean winOrLose() {
		boolean isWinner = false;
		if ((int) Math.floor(Math.random() * 10) % 2 == 1) {
			monthlyWins++;
			stake++;
			isWinner = true;
			

		} else {
			monthlyLosses++;
			stake--;
		}
		return isWinner;
	}
	

	/* If stake is less than 50% stop playing */

public static boolean gamblerDecision() {
		
		boolean resign = false;
		if (stake >= INITIAL_STAKE + (INITIAL_STAKE * 0.5) || stake <= INITIAL_STAKE / 2) {
			resign = true;
		}		
		return resign;
	}

/* Calculate Stake Method*/
public static void calculateStake() {
	totalStake = totalStake+stake;
}

public static boolean calculateMaximumWin() {
	
	if(totalStake > maximumWin) {
		maximumWin = totalStake;
		return true;
	}
	return false;
}
//Loss Method
public static boolean calculateMaximumLoss(){
	if(totalStake < INITIAL_STAKE) {
		double loss = INITIAL_STAKE - totalStake;
		if(loss> maximumLoss) {
			maximumLoss = loss;
			return true;
		}
	}
	return false;
			
}
// MAIN METHOD
	public static void main(String[] args) {
		boolean resign = false;
		boolean betWin = false;
		System.out.println("Welcome To Gambler Simulation");
		double balance = 0;
		
		for (int numberOfDays = 0; numberOfDays <= NUMBER_OF_PLAYS; numberOfDays++) {
			int stake = (int) INITIAL_STAKE;
			while(resign == false){
				betWin = winOrLose();
				if(gamblerDecision() == true) {
					calculateStake();
						
					break;
				}
				
			}
			if(calculateMaximumWin()) {
				maxWinDay = numberOfDays;						
			}
			if(calculateMaximumLoss()) {
				maxLossDay = numberOfDays;
			}
		}
			
		

		System.out.println("Total amount : " + totalStake);

		double amountLostOrWon = (INITIAL_STAKE * NUMBER_OF_PLAYS) - totalStake;
		System.out.println("Amount Won(-ve) or Lost(+ve) = " + amountLostOrWon);
		System.out.println("Number of Days Lost : " + monthlyLosses);
		System.out.println("Number of Days Won : " + monthlyWins);
		System.out.println("Maximum Amount Won: " + maximumWin);
		System.out.println("Maximum Amount Won On Day " + maxWinDay);
		System.out.println("Maximum Amount Loss: " + maximumLoss);
		System.out.println("Maximum Amount Loss On Day " + maxLossDay);

	}
}
