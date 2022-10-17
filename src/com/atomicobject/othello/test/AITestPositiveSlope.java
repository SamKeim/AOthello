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
 * AI Test Positive Slope
 * Tests for cases along a diagonal with a negative slope
 * Numbers on the board outside of range (0 < n < 2) denote the move taken during the test.
 * Represented by (row * 10 + column), ie. Move at [7, 7] = Move 77
 * This provides a visual marker for where the test move will occur without needing to count rows/columns.
 */
public class AITestPositiveSlope {
	@Test
	public void testNorthEastValid() {
		// Check validateMove() method for south-east direction with valid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 1, 0, 0},
				                   {0, 0, 0, 2, 2, 1, 0, 0},
				                   {0, 0, 0, 2, 2, 2, 0, 0},
				                   {0, 0, 52, 0, 0, 2, 1, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// Check valid move
		assertEquals(2, ai.validateMove(state, new int[] {5, 2})); // Move 52
	}
	@Test
	public void testSouthWestValid() {
		// Check validateMove() method for south-west direction with valid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 16, 0},
				                   {0, 0, 1, 2, 0, 2, 0, 0},
				                   {0, 0, 0, 2, 2, 1, 0, 0},
				                   {0, 0, 1, 2, 2, 0, 0, 0},
				                   {0, 0, 1, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// Check valid move
		assertEquals(3, ai.validateMove(state, new int[] {1, 6})); // Move 16
	}
	@Test
	public void testNorthEastInvalid() {
		// Check validateMove() method for north-east direction with invalid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 07},
				                   {0, 0, 0, 0, 0, 0, 1, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 2, 1, 0, 0},
				                   {0, 0, 0, 2, 2, 2, 0, 0},
				                   {0, 0, 52, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// Check edge case
		assertEquals(0, ai.validateMove(state, new int[] {0, 7})); // Move 07
		// Check invalid move
		assertEquals(0, ai.validateMove(state, new int[] {5, 2})); // Move 52
	}
	@Test
	public void testSouthWestInvalid() {
		// Check validateMove() method for south-west direction with invalid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 25, 0, 0},
				                   {0, 0, 0, 2, 2, 1, 0, 0},
				                   {0, 0, 1, 2, 2, 0, 0, 0},
				                   {0, 0, 2, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {70, 0, 0, 0, 0, 0, 0, 0}});
		// Check edge case
		assertEquals(0, ai.validateMove(state, new int[] {7, 0})); // Move 70
		// Check invalid move
		assertEquals(0, ai.validateMove(state, new int[] {2, 5})); // Move 25
	}
	
	@Test
	public void testBidirectionalSlopeValid() {
		// Check validateMove() method for north-east and south-west direction
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 1, 0, 0, 0, 0, 0, 1},
				                   {0, 0, 2, 2, 0, 0, 2, 0},
				                   {0, 0, 0, 0, 1, 2, 0, 0},
				                   {1, 2, 2, 0, 44, 2, 2, 0},
				                   {0, 0, 0, 2, 0, 2, 0, 0},
				                   {0, 0, 2, 0, 0, 0, 2, 0},
				                   {0, 1, 0, 0, 0, 0, 0, 0}});
		// Check valid move
		assertEquals(4, ai.validateMove(state, new int[] {4, 4})); // Move 44
	}
}
