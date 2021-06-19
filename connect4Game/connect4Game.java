/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment:My class does create references.

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: I have defined all 7 methods within the interface

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: My class also implements the connect4grid interface perfectly

ConnectPlayer abstract classcompur (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment: my class provides multiple non-abstract and abstract methods

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: my class properly extends the ConnectPlayer class and overrides the abstract method and human player functionality

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment: My class also extends the ConnectPlayer class properly while overriding the abstract method.

Total Marks out of 100: 100

 */
package connect4Game;
import java.util.Scanner;

public class connect4Game {
	public ConnectPlayer firstPlayer;
	public ConnectPlayer secondPlayer;
	public Connect4Grid grid; // an interface called grid

	connect4Game(String playerTwo)
	{
		//DEFAULTS :
		grid = new Connect4Grid2DArray(); //make a new grid.
		this.firstPlayer = new C4HumanPlayer(); //make a new human player as default.

		//CONDITINALS :
		if(playerTwo.equalsIgnoreCase("human")) {
			this.secondPlayer = new C4HumanPlayer(); //make a new human player
		}

		else if(playerTwo.equalsIgnoreCase("Computer")) {
			this.secondPlayer = new C4RandomAIPlayer(); //make a new computer player
		}

		else if(playerTwo.equalsIgnoreCase("Random Player AI")) {
			this.secondPlayer = new C4RandomAIPlayer(); //make a new computer player

		}
		else {
			System.out.println("INVALID INPUT, TRY AGAIN.");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Do you want to play with another human or a computer (Random Player AI) ;");
		String input = scanner.nextLine();

		connect4Game newGame = new connect4Game(input); //make a new game

		newGame.grid.emptyGrid(); //empty the grid first.

		newGame.firstPlayer.setPlayer(1); //set the first player by passing 1 into the function setPlayer

		newGame.secondPlayer.setPlayer(2); //set the second player by passing 2 into the function setPlayer

		newGame.firstPlayer.setPlayerPiece(); // set the first player's piece

		newGame.secondPlayer.setPlayerPiece(); // set the second player's piece

		ConnectPlayer currentPlayer = newGame.firstPlayer; //make the first player start the game
		System.out.println(newGame.grid.toString()); //print out the output for the user

		while(!newGame.grid.isGridFull() && !newGame.grid.didLastPieceConnect4()) 
		{
			String output = "";
			if (currentPlayer.equals(newGame.firstPlayer)) {
				output = "Player One's Turn ; ";
			}
			else {
				output = "Player Two's Turn ; ";
			}
			System.out.println(output + "\n-------------");

			if(currentPlayer.equals(newGame.firstPlayer))
			{
				newGame.firstPlayer.makeMove(newGame.grid, newGame.firstPlayer); //the player can make a move
				currentPlayer = newGame.secondPlayer; //move onto the next player
			}
			else 
			{
				newGame.secondPlayer.makeMove(newGame.grid, newGame.secondPlayer); //the player can make a move
				currentPlayer = newGame.firstPlayer; //move back onto the first player
			}
			System.out.println(newGame.grid.toString()); //print out the grid and output again.
			if(newGame.grid.didLastPieceConnect4()) //if either of the users won.
			{
				//appropriate outputs for each scenario
				//NOTE: The outputs are reversed because after each move the current player automatically
				//      changes so we use the alternate for each scenario for it to work.
				if (currentPlayer.equals(newGame.firstPlayer))
				{
					System.out.println("Congratulations to the second player (human/AI) for winning!");
				}
				else {
					System.out.println("Congratulations to the first player for winning!");
				}
			} else if(newGame.grid.isGridFull()) {
				System.out.println("Tie");
			}
		}
		
		scanner.close();

	}
}