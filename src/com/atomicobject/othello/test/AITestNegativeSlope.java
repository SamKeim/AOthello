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
 * AI Test Negative Slope
 * Tests for cases along a diagonal with a negative slope
 * Numbers on the board outside of range (0 < n < 2) denote the move taken during the test.
 * Represented by (row * 10 + column), ie. Move at [7, 7] = Move 77
 * This provides a visual marker for where the test move will occur without needing to count rows/columns.
 */

public class AITestNegativeSlope {
	@Test
	public void testSouthEastValid() {
		// Check validateMove() method for south-east direction with a valid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 12, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 2, 1, 0, 0},
				                   {0, 0, 0, 2, 2, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 1, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// Check valid move
		assertEquals(3, ai.validateMove(state, new int[] {1, 2})); // Move 12
	}
	@Test
	public void testNorthWestValid() {
		// Check validateMove() method for north-west direction with a valid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 1, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 1, 0, 0},
				                   {0, 0, 1, 2, 2, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 66, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// Check valid move
		assertEquals(3, ai.validateMove(state, new int[] {6, 6})); // Move 66
	}
	@Test
	public void testSouthEastInvalid() {
		// Check validateMove() method for south-east direction with an invalid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 12, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 2, 1, 0, 0},
				                   {0, 0, 0, 2, 2, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 77}});
		// Check edge case
		assertEquals(0, ai.validateMove(state, new int[] {7, 7})); // Move 77
		// Check invalid move
		assertEquals(0, ai.validateMove(state, new int[] {1, 2})); // Move 12
	}
	@Test
	public void testNorthWestInvalid() {
		// Check validateMove() method for north-west direction with an invalid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{00, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 1, 0, 0},
				                   {0, 0, 1, 2, 2, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 66, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// Check edge case
		assertEquals(0, ai.validateMove(state, new int[] {0,0})); // Move 00
		// Check invalid move
		assertEquals(0, ai.validateMove(state, new int[] {6, 6})); // Move 66
	}
	
	@Test
	public void testBidirectionalSlopeValid() {
		// Check validateMove() method for south-east and north-west direction with a valid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 1, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 2, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 1, 0, 0},
				                   {1, 2, 2, 0, 44, 2, 2, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 2, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 1}});
		// Check valid move
		assertEquals(4, ai.validateMove(state, new int[] {4, 4})); // Move 44
	}
}
