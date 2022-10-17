package com.atomicobject.othello.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.atomicobject.othello.AI;
import com.atomicobject.othello.GameState;

/**
 * Othello AI
 * @author Sam Keim
 * Atomic Object Assessment
 * October 2022
 * v2.0
 * 
 * AI Test All Directions
 * Numbers on the board outside of range (0 < n < 2) denote the move taken during the test.
 * Represented by (row * 10 + column), ie. Move at [7, 7] = Move 77
 * This provides a visual marker for where the test move will occur without needing to count rows/columns.
 */
public class AITestAllDirections {
	@Test
	public void testEightDirectionValid() {
		// Check validateMove() method for all directions
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 1, 0, 1, 0, 1},
				                   {0, 0, 0, 0, 2, 2, 2, 0},
				                   {0, 0, 1, 2, 2, 25, 2, 1},
				                   {0, 0, 0, 2, 2, 2, 2, 0},
				                   {0, 0, 0, 2, 2, 2, 0, 1},
				                   {0, 0, 1, 0, 0, 2, 1, 0},
				                   {0, 0, 0, 0, 0, 1, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// check valid move
		assertEquals(12, ai.validateMove(state, new int[] {2, 5})); // Move 25
	}
}
