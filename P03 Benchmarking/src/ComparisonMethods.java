//////////////// P03Benchmarking //////////////////////////
//
// Title: ComparisonMethods
// Course: CS 300 Fall 2020
//
// Author: Jerry Yu
// Email: jcyu4@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
public class ComparisonMethods {
  /**
   * Adds every number from 1 to n to sum
   * 
   * @param n - the final number for a method that adds all values from 1 to n
   * @return the sum of all numbers 1 to n 
   * Complexity: O(N)
   */
  public static long bruteForce(long n) {
    long sum = n;
    // returns 0 if a negative number is inputed
    if (n < 0) {
      return 0;
    }
    // adds every number from 1 to n to sum
    while (n > 0) {
      sum = sum + n - 1;
      n--;
    }
    // returns the final sum
    return sum;
  }

  /**
   * @param n - the final number for a method that adds all values from 1 to n
   * @return the sum of all numbers 1 - n 
   * Complexity: O(1)
   */
  public static long constantTime(long n) {
    // returns 0 if a negative number is inputed
    if (n < 0) {
      return 0;
    }
    // calculates the sum by using the formula for the area of a triangle
    long sum = ((n + 1) * (n)) / 2;
    return sum;
  }
}
