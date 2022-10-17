package com.atomicobject.othello;

import java.util.Arrays;
import java.util.ListIterator;

/**
 * Othello AI
 * 
 * @author Sam Keim
 * Atomic Object Assessment
 * October 2022
 * v2.0
 */

// Pojo for calculating the best move to take
// Evaluated by the number of pieces that would be turned if the move were to occur
class BestMove {
	int piecesTurned = 0;
	int[] move = new int[2];
}

public class AI {
	
	ListIterator<int[]> moveList;
	
	public AI() {
		// empty for testing
	}

	public AI(int[][] moves) {
		super();
		moveList = Arrays.asList(moves).listIterator();
		// Keeps compiler happy without altering Main.java
	}

	/**
	 * Computes the next move for the AI to take
	 * 
	 * @param state
	 * @return int[2] Move in [r, c] form
	 */
	public int[] computeMove(GameState state) {
		// Retained in case the Canned Move Method is used for testing on AO side
		if(moveList != null) {
			return moveList.next();
		}
		
		// Setup variables
		int[] move = new int[2]; // potential move
		int[][] board = state.getBoard();
		int piecesToTurn; // pieces that would be turned if the move were to occur
		BestMove bestMove = new BestMove(); // Current best move (most number of opponent pieces to be flipped) updated
											// over loop iterations

		// For each space on board, check if move is valid
		for (int r = 0; r < board.length; r++) {
			move[0] = r;

			for (int c = 0; c < board[0].length; c++) {
				move[1] = c;
				// check if square has a piece, if so, move on
				if (board[r][c] != 0) {
					continue;
				}

				// check if move is valid
				piecesToTurn = validateMove(state, move);
				// If placing a piece in this square would flip over opponent pieces (n > 0), it is a valid move
				if (piecesToTurn > 0) {
					// If valid and greater than previous bestMove, update as new bestMove
					if (piecesToTurn > bestMove.piecesTurned) {
						bestMove.move = Arrays.copyOf(move, 2);
						bestMove.piecesTurned = piecesToTurn;
					}
				}
			}
		}
		return bestMove.move;
	}

	/**
	 * Returns number of opponent tokens that would be flipped if move occurs.
	 * If return is 0, no opponent tokens would be flipped, move is invalid.
	 * 
	 * @param state GameState object
	 * @param move  int[] potential move (square is empty as verified in calling
	 *              method).
	 * @return sum Number of opponent tokens that would be flipped if move occurs.
	 *         Return n > 0 - Move is valid.
	 *         Return n - n opponent pieces that would be flipped if move occurred.
	 */
	public int validateMove(GameState state, int[] move) {
		// Setup variables
		int sum = 0;
		// Check across planes
		sum += checkHorizontal(state, move);
		sum += checkVertical(state, move);
		sum += checkNegativeSlope(state, move);
		sum += checkPositiveSlope(state, move);
		return sum;
	}

	/**
	 * Checks if a move is valid across a row.
	 * 
	 * @param state Current GameState
	 * @param move  Potential move to be taken
	 * @return Number of opponent pieces that would be flipped if the move occurred.
	 *         Return n < 0 | Move is Valid.
	 *         Return n | n opponent pieces that would be flipped if move occurred.
	 */
	private int checkHorizontal(GameState state, int[] move) {
		// Setup variables
		int sum = 0;
		int squareToCheck;
		int opCounter = 0; // Opponent Piece Counter, discarded if the move is invalid in this direction
		int rm = move[0]; // row corresponding to the potential move
		int cm = move[1]; // column corresponding to the potential move
		int boardWidth = state.getBoard()[0].length;
		int c; // variable used in loop, corresponds to the square to check
				// (values: opponent piece, empty, player piece)

		// check east
		for (c = cm + 1; c < boardWidth; c++) {
			squareToCheck = state.getBoard()[rm][c];
			if (squareToCheck == 0) { // If empty square, exit
				break;
			} else if (squareToCheck == state.getPlayer()) {
				// If this square contains my piece, I am flanking the opponent pieces (counted by opCounter)
				// Add opCounter to sum
				// Value will be 0 if no opponent pieces were encountered
				sum += opCounter;
				break;
			} else { // Square contains opponent piece, count it
				opCounter++;
			}
		}
		
		// check west
		opCounter = 0; // empty the variable counting opponent pieces
		for (c = cm - 1; c >= 0; c--) {
			squareToCheck = state.getBoard()[rm][c];
			if (squareToCheck == 0) { // If empty square, exit
				break;
			} else if (squareToCheck == state.getPlayer()) {
				// If this square contains my piece, I am flanking the opponent pieces (counted by opCounter)
				// Add opCounter to sum
				// Value will be 0 if no opponent pieces were encountered
				sum += opCounter;
				break;
			} else { // Square contains opponent piece, count it
				opCounter++;
			}
		}
		return sum;
	}

	/**
	 * Checks if a move is valid in a column
	 * 
	 * @param state Current GameState
	 * @param move  Potential move to be taken
	 * @return Number of opponent pieces that would be flipped if the move occurred
	 *         Return n < 0 | Move is Valid.
	 *         Return n | n opponent pieces that would be flipped if move occurred.
	 */
	private int checkVertical(GameState state, int[] move) {
		// Setup variables
		int sum = 0;
		int squareToCheck;
		int opCounter = 0; // Opponent Piece Counter, discarded if the move is invalid in this direction
		int rm = move[0]; // row corresponding to the potential move
		int cm = move[1]; // column corresponding to the potential move
		int boardHeight = state.getBoard().length;
		int r;  // variables used in loop, corresponds to the square to test
				//(values: opponent piece, empty, player piece)

		// check north
		for (r = rm - 1; r >= 0; r--) {
			squareToCheck = state.getBoard()[r][cm];
			if (squareToCheck == 0) { // If empty square, exit
				break;
			} else if (squareToCheck == state.getPlayer()) {
				// If this square contains my piece, I am flanking the opponent pieces (counted by opCounter)
				// Add opCounter to sum
				// Value will be 0 if no opponent pieces were encountered
				sum += opCounter;
				break;
			} else { // Square contains opponent piece, count it
				opCounter++;
			}
		}
		// check south
		opCounter = 0; // Clear variable
		for (r = rm + 1; r < boardHeight; r++) {
			squareToCheck = state.getBoard()[r][move[1]];
			if (squareToCheck == 0) { // If empty square, exit
				break;
			} else if (squareToCheck == state.getPlayer()) {
				// If this square contains my piece, I am flanking the opponent pieces (counted by opCounter)
				// Add opCounter to sum
				// Value will be 0 if no opponent pieces were encountered
				sum += opCounter;
				break;
			} else { // Square contains opponent piece, count it
				opCounter++;
			}
		}
		return sum;
	}

	/**
	 * Checks if a move is valid in a diagonal line with a negative slope
	 * 
	 * @param state Current GameState
	 * @param move  Potential move to be taken
	 * @return Number of opponent pieces that would be flipped if the move occurred
	 *         Return < 0 | Move is Valid Return n | n opponent pieces that would be
	 *         flipped if move occurred
	 */
	private int checkNegativeSlope(GameState state, int[] move) {
		// setup variables
		int sum = 0;
		int squareToCheck;
		int opCounter = 0; // Opponent Piece Counter, discarded if the move is invalid in this direction
		int rm = move[0]; // row corresponding to the potential move
		int cm = move[1]; // column corresponding to the potential move
		int boardHeight = state.getBoard().length;
		int boardWidth = state.getBoard()[0].length;
		int r, c; 	// variables used in loop, corresponds to the square to test
					// (values: opponent piece, empty, player piece)

		// check south-east
		for (r = rm + 1, c = cm + 1; r < boardHeight && c < boardWidth; r++, c++) {
			squareToCheck = state.getBoard()[r][c];
			if (squareToCheck == 0) { // If empty square, exit
				break;
			} else if (squareToCheck == state.getPlayer()) {
				// If this square contains my piece, I am flanking the opponent pieces (counted by opCounter)
				// Add opCounter to sum
				// Value will be 0 if no opponent pieces were encountered
				sum += opCounter;
				break;
			} else { // Square contains opponent piece, count it
				opCounter++;
			}
		}

		// check north-west
		opCounter = 0; // Clear variable
		for (r = rm - 1, c = cm - 1; r >= 0 && c >= 0; r--, c--) {
			squareToCheck = state.getBoard()[r][c];
			if (squareToCheck == 0) { // If empty square, exit
				break;
			} else if (squareToCheck == state.getPlayer()) {
				// If this square contains my piece, I am flanking the opponent pieces (counted by opCounter)
				// Add opCounter to sum
				// Value will be 0 if no opponent pieces were encountered
				sum += opCounter;
				break;
			} else { // Square contains opponent piece, count it
				opCounter++;
			}
		}
		return sum;
	}

	/**
	 * Checks if a move is valid in a diagonal line with a positive slope
	 * 
	 * @param state Current GameState
	 * @param move  Potential move to be taken
	 * @return Number of opponent pieces that would be flipped if the move occurred
	 *         Return < 0 | Move is Valid
	 *         Return n | n opponent pieces that would be flipped if move occurred
	 */
	private int checkPositiveSlope(GameState state, int[] move) {
		// setup variables
		int sum = 0;
		int squareToCheck;
		int opCounter = 0; // Opponent Piece Counter, discarded if the move is invalid in this direction
		int rm = move[0]; // row corresponding to the potential move
		int cm = move[1]; // column corresponding to the potential move
		int boardHeight = state.getBoard().length;
		int boardWidth = state.getBoard()[0].length;
		int r, c; 	// variables used in loop, corresponds to the square to test
					// (values: opponent piece, empty, player piece)

		// check north-east
		for (r = rm - 1, c = cm + 1; r >= 0 && c < boardWidth; r--, c++) {
			squareToCheck = state.getBoard()[r][c];
			if (squareToCheck == 0) { // If empty square, exit
				break;
			} else if (squareToCheck == state.getPlayer()) {
				// If this square contains my piece, I am flanking the opponent pieces (counted by opCounter)
				// Add opCounter to sum
				// Value will be 0 if no opponent pieces were encountered
				sum += opCounter;
				break;
			} else { // Square contains opponent piece, count it
				opCounter++;
			}
		}

		// check south-west
		opCounter = 0; // Clear variable
		for (r = rm + 1, c = cm - 1; r < boardHeight && c >= 0; r++, c--) {
			squareToCheck = state.getBoard()[r][c];
			if (squareToCheck == 0) { // If empty square, exit
				break;
			} else if (squareToCheck == state.getPlayer()) {
				// If this square contains my piece, I am flanking the opponent pieces (counted by opCounter)
				// Add opCounter to sum
				// Value will be 0 if no opponent pieces were encountered
				sum += opCounter;
				break;
			} else { // Square contains opponent piece, count it
				opCounter++;
			}
		}
		return sum;
	}

}