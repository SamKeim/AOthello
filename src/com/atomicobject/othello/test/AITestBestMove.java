package com.atomicobject.othello.test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

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
 */
public class AITestBestMove {
	@Test
	public void testBestMoveOne() {
		// Check for Best Move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 1, 0, 1, 0, 0},
				                   {0, 0, 0, 0, 2, 2, 2, 0},
				                   {0, 0, 1, 2, 2, 2, 2, 0},
				                   {0, 0, 0, 2, 2, 2, 2, 0},
				                   {0, 0, 0, 2, 2, 2, 0, 0},
				                   {0, 0, 1, 0, 1, 2, 1, 0},
				                   {0, 0, 0, 0, 0, 1, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		assertEquals("[2, 7]", Arrays.toString(ai.computeMove(state)));
	}
	
	@Test
	public void testBestMoveTwo() {
		// Check for Best Move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 1, 0, 1, 0, 0},
				                   {0, 0, 0, 0, 2, 2, 2, 0},
				                   {0, 0, 1, 2, 2, 2, 2, 1},
				                   {0, 0, 1, 2, 2, 2, 2, 0},
				                   {0, 0, 0, 2, 2, 2, 0, 1},
				                   {0, 0, 1, 0, 1, 2, 1, 0},
				                   {0, 0, 0, 0, 0, 1, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		assertEquals("[0, 4]", Arrays.toString(ai.computeMove(state)));
	}	
	
	@Test
	public void testBestMoveThree() {
		// Check for Best Move
		AI ai = new AI();
		GameState state = new GameState();
		state.setPlayer(1);
		// Randomly generated board
		state.setBoard(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0},
				                   {0, 0, 0, 0, 2, 2, 2, 0},
				                   {0, 0, 1, 2, 2, 2, 2, 0},
				                   {0, 0, 0, 2, 1, 2, 2, 0},
				                   {0, 0, 0, 2, 2, 2, 0, 0},
				                   {0, 0, 1, 0, 1, 2, 1, 0},
				                   {0, 0, 0, 0, 0, 1, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		assertEquals("[2, 7]", Arrays.toString(ai.computeMove(state)));
	}
}
