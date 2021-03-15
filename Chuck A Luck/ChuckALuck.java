import java.util.Scanner;

public class ChuckALuck {

	static float amountToBet = 0;

	public static void main(String[] args) {
		boolean exit1 = false;
		boolean exit2 = false;
		boolean winTripleBet = false;
		boolean winFieldBet = false;
		boolean winHighBet = false;
		boolean winLowBet = false;
		boolean didABet = false;
		boolean validBetInput = false;
		float wallet = 0;
		int dice = 0;
		int summation = 0;
		Wallet playerWallet = new Wallet();
		String typeOfBet = "";
		System.out.println("How much do you want in your wallet? (cannot be less than or equal to zero)");
		Scanner walletScanner = new Scanner(System.in);
		if (walletScanner.hasNextFloat()) {
			wallet = walletScanner.nextFloat();

		}
		playerWallet.addToWallet(wallet);

		while (!exit1) {


			while(!validBetInput) {
				System.out.println("We offer four bets, triple, field, high, and low.");
				System.out.println("What type of bet do you want to do? (or press quit)");
				Scanner betScanner = new Scanner(System.in);
				typeOfBet = betScanner.next();

				if (typeOfBet.equalsIgnoreCase("quit")) {
					validBetInput = true;
					exit1 = true;
					exit2 = true;
					System.out.println("Thank you for playing!");
					System.out.println("Your wallet has €" + playerWallet.getWallet() + " in it.");
					System.out.println("Your wallet had €" + wallet + " in it at the start.");
					if (wallet > playerWallet.getWallet()) {
						System.out.println("You have lost €" + (wallet - playerWallet.getWallet()) + " euros during your time playing.");
					}
					else
					{
						System.out.println("You have gained €" + (wallet - playerWallet.getWallet()) + " euros.");
					}
					betScanner.close();
				}
				else if (playerWallet.getWallet() <= 0) {
					validBetInput = true;
					exit1 = true;
					exit2 = true;
					System.out.println("You have €0 or less in your wallet. The game has ended.");
					System.out.println("Your wallet has €" + playerWallet.getWallet() + " in it.");
					System.out.println("Your wallet had €" + wallet + " in it at the start.");
					if (wallet > playerWallet.getWallet()) {
						System.out.println("You have lost €" + (wallet - playerWallet.getWallet()) + " euros.");
					}
					else
					{
						System.out.println("You have gained €" + (wallet - playerWallet.getWallet()) + " euros.");
					}
					betScanner.close();
				}

				else if  (!exit2) {
					resolveBet(typeOfBet, wallet, playerWallet, dice, summation, winTripleBet, winFieldBet, winHighBet, winLowBet, didABet);
				}

				if (winTripleBet == true && typeOfBet.equalsIgnoreCase("Triple")) {
					System.out.println("You won the bet!");
					playerWallet.addToWallet(amountToBet * 30);
					didABet = false;
				}
				else if (winFieldBet == true && typeOfBet.equalsIgnoreCase("Field")) {
					System.out.println("You won the bet!");
					playerWallet.addToWallet(amountToBet);
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				}
				else if (winHighBet == true && typeOfBet.equalsIgnoreCase("High")) {
					System.out.println("You won the bet!");
					playerWallet.addToWallet(amountToBet);
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				}
				else if (winLowBet == true && typeOfBet.equalsIgnoreCase("Low")) {
					System.out.println("You won the bet!");
					playerWallet.addToWallet(amountToBet);
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				}
				else if (winTripleBet == false && typeOfBet.equalsIgnoreCase("Triple")) {
					System.out.println("You lost the bet!");
					playerWallet.removeFromWallet(amountToBet);
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				}
				else if (winFieldBet == false && typeOfBet.equalsIgnoreCase("Field")) {
					System.out.println("You lost the bet!");
					playerWallet.removeFromWallet(amountToBet);
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				}
				else if (winLowBet == false && typeOfBet.equalsIgnoreCase("Low")) {
					System.out.println("You lost the bet!");
					playerWallet.removeFromWallet(amountToBet);
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				}
				else if (winHighBet == false && typeOfBet.equalsIgnoreCase("High")) {
					System.out.println("You lost the bet!");
					playerWallet.removeFromWallet(amountToBet);
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				}

				if (playerWallet.getWallet() <= 0) {
					validBetInput = true;
					exit1 = true;
					exit2 = true;
					System.out.println("You have €0 or less in your wallet. The game has ended.");
					System.out.println("Your wallet has €" + playerWallet.getWallet() + " in it.");
					System.out.println("Your wallet had €" + wallet + " in it at the start.");
					if (wallet > playerWallet.getWallet()) {
						System.out.println("You have lost €" + (wallet - playerWallet.getWallet()) + " euros.");
					}
					else
					{
						System.out.println("You have gained €" + (wallet - playerWallet.getWallet()) + " euros.");
					}
					betScanner.close();
				}
			}
		}
		walletScanner.close();
	}

	public static void resolveBet(String typeOfBet, float wallet, Wallet playerWallet, int dice, int summation, boolean winTripleBet, boolean winFieldBet, boolean winHighBet, boolean winLowBet, boolean didABet) {
		winTripleBet = false;
		winFieldBet = false;
		winHighBet = false;
		winLowBet = false;
		boolean isFloat = false;
		amountToBet = 0;

		System.out.println("Your wallet has €" + playerWallet.getWallet() + " in it.");

		while (!isFloat) {
			System.out.println("How much would you like to bet?");
			Scanner amountOfBetScanner = new Scanner(System.in);

			if (amountOfBetScanner.hasNextFloat()) {
				amountToBet = amountOfBetScanner.nextFloat();
				isFloat = true;
			}
			else {
				isFloat = false;
			}
			amountOfBetScanner.close();
		}

		if (amountToBet <= playerWallet.getWallet()) {
			dice dice1 = new dice(dice);
			dice dice2 = new dice(dice);
			dice dice3 = new dice(dice);
			dice1.rollDice();
			dice2.rollDice();
			dice3.rollDice();
			summation = dice1.getDice() + dice2.getDice() + dice3.getDice();
			System.out.println("Dice 1 is : " + dice1.getDice());
			System.out.println("Dice 2 is : " + dice2.getDice());
			System.out.println("Dice 3 is : " + dice3.getDice());
			if (typeOfBet.equalsIgnoreCase("Triple")) {
				winTripleBet = Triple(dice1, dice2, dice3, winTripleBet, didABet);
			}

			else if (typeOfBet.equalsIgnoreCase("Field")) {
				winFieldBet = Field(dice1, dice2, dice3, winFieldBet, didABet, summation);
			}
			else if (typeOfBet.equalsIgnoreCase("High")) {
				winHighBet = High(dice1, dice2, dice3, winHighBet, didABet, summation);
			}
			if (typeOfBet.equalsIgnoreCase("Low")) {
				winLowBet = Low(dice1, dice2, dice3, winLowBet, didABet, summation);
			}
		}
		else
		{
			System.out.println("Sorry,  you don't have enough money.");
		}
	}

	public static boolean Triple(dice dice1, dice dice2, dice dice3, boolean winTripleBet, boolean didABet) {
		if (dice1.getDice() == dice2.getDice() && dice2.getDice() == dice3.getDice()) {
			if (dice1.getDice() != 1 && dice2.getDice() != 1 && dice3.getDice() != 1) {
				if (dice1.getDice() != 6 && dice2.getDice() != 6 && dice3.getDice() != 6) {
					winTripleBet = true;
				}
			}
		}
		else
		{
			winTripleBet = false;
		}
		didABet = true;
		return winTripleBet;
	}

	public static boolean Field(dice dice1, dice dice2, dice dice3, boolean winFieldBet, boolean didABet, int summation) {
		dice1.getDice();
		dice2.getDice();
		dice3.getDice();
		if ((summation) < 8) {
			winFieldBet = true;

		}
		else if ((summation) > 12) {
			winFieldBet = true;

		}
		else
		{
			winFieldBet = false;
		}
		didABet = true;
		return winFieldBet;
	}

	public static boolean High(dice dice1, dice dice2, dice dice3, boolean winHighBet, boolean didABet, int summation) {
		dice1.getDice();
		dice2.getDice();
		dice3.getDice();
		if ((summation) > 10) {
			if (dice1.getDice() != dice2.getDice() && dice2.getDice() != dice3.getDice()) {
				winHighBet = true;

			}
		}

		else
		{
			winHighBet = false;
		}
		didABet = true;
		return winHighBet;
	}

	public static boolean Low(dice dice1, dice dice2, dice dice3, boolean winLowBet, boolean didABet, int summation) {

		if ((summation) < 11) {
			if ((dice1.getDice() != dice2.getDice()) && (dice2.getDice() != dice3.getDice())) {
				winLowBet = true;
			}
		}
		else
		{
			winLowBet = false;
		}
		didABet = true;
		return winLowBet;

	}
}
