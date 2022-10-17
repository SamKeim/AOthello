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
 * AI Test Vertical
 * Numbers on the board outside of range (0 < n < 2) denote the move taken during the test.
 * Represented by (row * 10 + column), ie. Move at [7, 7] = Move 77
 * This provides a visual marker for where the test move will occur without needing to count rows/columns.
 */
public class AITestVertical {
	@Test
	public void testNorthValid() {
		// Check validateMove() method for north direction with a valid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{00, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 1, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 2, 0, 0},
				                   {0, 0, 0, 2, 2, 1, 0, 0},
				                   {0, 0, 0, 53, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// Check valid move
		assertEquals(3, ai.validateMove(state, new int[] {5,3})); // Move 53
	}
	@Test
	public void testSouthValid() {
		// Check validateMove() method for south direction with a valid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 13, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 1, 0, 0},
				                   {0, 0, 1, 2, 2, 0, 0, 0},
				                   {0, 0, 0, 1, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// check valid move
		assertEquals(3, ai.validateMove(state, new int[] {1, 3})); // Move 13
	}
	@Test
	public void testNorthInvalid() {
		// Check validateMove() method for north direction with invalid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{00, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 1, 0, 0},
				                   {0, 0, 0, 2, 2, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 65, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		// check edge case
		assertEquals(0, ai.validateMove(state, new int[] {0,0})); // Move 00
		// check invalid move
		assertEquals(0, ai.validateMove(state, new int[] {6, 5})); // Move 65
	}
	@Test
	public void testSouthInvalid() {
		// Check validateMove() method for south direction with invalid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 1, 0, 0},
				                   {0, 0, 0, 2, 2, 45, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 77}});
		// check edge case
		assertEquals(0, ai.validateMove(state, new int[] {7, 7})); // Move 77
		// check valid move
		assertEquals(0, ai.validateMove(state, new int[] {4, 5})); // Move 45
	}
	@Test
	public void testNorthSouthValid() {
		// Check validateMove() method for north and south directions with a valid move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 0, 1, 0, 0, 0},
				                   {0, 0, 0, 0, 2, 0, 0, 0},
				                   {0, 0, 0, 2, 2, 0, 0, 0},
				                   {0, 0, 0, 2, 34, 1, 0, 0},
				                   {1, 2, 2, 0, 2, 2, 2, 1},
				                   {0, 0, 0, 0, 2, 2, 0, 0},
				                   {0, 0, 0, 0, 1, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		assertEquals(4, ai.validateMove(state, new int[] {3, 4})); // Move 34
	}
}
