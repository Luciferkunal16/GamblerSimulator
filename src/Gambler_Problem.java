package LogicalPrograms;

public class Gambler_Problem {
	public static final double INITIAL_STAKE = 100;
	public static final double STAKE_BET = 100;
	public static  int stake=0;
	/* Win or Loose By random Function*/
	public static void winOrLose() {
		
		if(Math.random()<0.5) {
			stake++;
			System.out.println("Win");;
		}
		else {
			stake --;
			System.out.println("Lose");
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome To Gambler Simulation");
		winOrLose();
	
	}

}
