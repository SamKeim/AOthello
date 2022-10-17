package com.atomicobject.othello.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 * Othello AI
 * @author Sam Keim
 * Atomic Object Assessment
 * October 2022
 * v2.0
 * 
 * AI Test Suite
 * Runs all available JUnit Test cases.
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
   AITestHorizontal.class,
   AITestVertical.class,
   AITestNegativeSlope.class,
   AITestPositiveSlope.class,
   AITestAllDirections.class,
   AITestBestMove.class
})

public class AITestSuite {   
}