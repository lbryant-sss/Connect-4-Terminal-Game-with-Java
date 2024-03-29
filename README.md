Connect 4 game with AI Using Java Report and Documentation
Connect Four is a classic two-player game where the players take turns dropping colored discs into a vertical grid. The objective is to connect four of one's own discs vertically,
horizontally, or diagonally before the opponent does.
Implementation
This implementation of the Connect Four game is written in Java and provides two game modes
Two-Player Mode: Two human players take turns playing against each other.
Single-Player Mode: One human player plays against a computer AI.
Structure
The code is organized into a single Java class named Main. 
•	Main Method: The entry point of the program where the game mode is selected.
•	Game Modes
i.	playTwoPlayerGame: Implements the two-player mode where two human players take turns.
ii.	playSinglePlayerGame: Implements the single-player mode where one human player plays against the computer AI.
•	Board Representation: The game board is represented using a two-dimensional character array.Each cell of the array represents a position on the game board,
with the characters 'R', 'Y', or '-' (empty) indicating the presence of a red disc, yellow disc, or an empty cell respectively.


Functions
i.	initializeBoard(): Initializes the game board with empty cells.

ii.	printBoard(): Prints the current state of the game board.

iii.	isValidMove(col): Checks if a move (dropping a disc into a column) is valid.

iv.	dropPiece(player, col): Drops a player's disc into the specified column.

v.	checkWin(player): Checks if the specified player has won the game.

vi.	isBoardFull(): Checks if the game board is full and no more moves can be made.

vii.	getAIMove(): Generates a move for the computer AI in single-player mode. (Currently a placeholder for a basic AI strategy.)

•	The implementation uses a basic two-dimensional array board[][] to model the state of the Connect Four board. This array represents the grid where the game is played,
with each cell storing the symbol of the player who occupies it or the EMPTY symbol if the cell is unoccupied

Upon running the program, the user is prompted to select the game mode.
In two-player mode, players take turns entering the column number to drop their discs until one player wins or the game ends in a draw.
In single-player mode, the player competes against the computer AI, with the same objective of connecting four discs.
.
