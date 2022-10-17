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
 * AI Test Horizontal
 * Numbers on the board outside of range (0 < n < 2) denote the move taken during the test.
 * Represented by (row * 10 + column), ie. Move at [7, 7] = Move 77
 * This provides a visual marker for where the test move will occur without needing to count rows/columns.
 */
public class AITestHorizontal {
	@Test
	public void testEastValid() {
		// Check validateMove() method for east direction with a valid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 1, 0, 0},
				                   {0, 0, 42, 2, 2, 1, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// Check valid move
		assertEquals(2, ai.validateMove(state, new int[] {4, 2})); // Move 42
	}
	@Test
	public void testWestValid() {
		// Check validateMove() method for west direction with a valid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 1, 0, 0},
				                   {0, 0, 1, 2, 2, 45, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// Check valid move
		assertEquals(2, ai.validateMove(state, new int[] {4, 5})); // Move 45
	}
	@Test
	public void testEastInvalid() {
		// Check validateMove() method for east direction with invalid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 1, 0, 0},
				                   {0, 0, 42, 2, 2, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 77}});
		// Check edge case
		assertEquals(0, ai.validateMove(state, new int[] {7, 7})); // Move 77
		// Check invalid move
		assertEquals(0, ai.validateMove(state, new int[] {4,2})); // Move 42
	}
	@Test
	public void testWestInvalid() {
		// Check validateMove() method for west direction with invalid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{00, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 1, 0, 0},
				                   {0, 0, 0, 2, 2, 45, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// Check edge case
		assertEquals(0, ai.validateMove(state, new int[] {0, 0})); // Move 00
		// Check invalid move
		assertEquals(0, ai.validateMove(state, new int[] {4, 5})); // Move 45
	}
	@Test
	public void testEastWestValid() {
		// Check validateMove() method for east and west direction with a valid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 1, 0, 0},
				                   {1, 2, 2, 43, 2, 2, 2, 1},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// Check valid move
		assertEquals(5, ai.validateMove(state, new int[] {4, 3})); // Move 43
	}
}
