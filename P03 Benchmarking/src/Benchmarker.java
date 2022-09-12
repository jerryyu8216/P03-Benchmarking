//////////////// P03 Benchmarking //////////////////////////
//
// Title: Benchmarker
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

import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class Benchmarker {

  public static void main(String[] args) {

  }

  /**
   * @param n - the value of n the method uses to compare bruteForce vs constantTime
   * @return a formatted string that includes the inputed n and the time it takes each method to
   *         calculate the sum
   * @throws NoSuchElemenetException if the sums calculated are not equal
   */
  public static String compare(long n) throws NoSuchElementException {
    String inputN = Long.toString(n);
    // records the time when the first method starts
    long start = (long) System.currentTimeMillis();
    // calculates the sum using the bruteForce method
    long sum1 = ComparisonMethods.bruteForce(n);
    // records the time when the first method is finished and when the second method starts
    long end1 = (long) System.currentTimeMillis();
    // calculates the sum using the constantTime method
    long sum2 = ComparisonMethods.constantTime(n);
    // records the time when the second method is finished
    long end2 = (long) System.currentTimeMillis();
    // calculates the time it took for the bruteForce method to calculate the sum
    long bruteForceTime = end1 - start;
    // calculates the time it took for the constantTime method to calculate the sum
    long formulaTime = end2 - end1;
    // throws a NoSuchElementException when the sums are not equal
    if (sum1 != sum2) {
      throw new NoSuchElementException("Error: Sums are not equal");
    }
    // returns a formatted string that contains the inputed n value and the two calculated times
    return inputN + "\t" + Long.toString(bruteForceTime) + "\t" + Long.toString(formulaTime) + "\n";
  }

  /**
   * @param f       - a file that will contain the results of the compare method
   * @param queryNs - an array which stores values of n for the compare method
   * @throws IOException if there is a problem creating the FileWriter object
   * @throws IOException if there is a problem when writing in the file
   * @throws IOException if there is a problem with closing the file
   */
  public static void createResultsFile(File f, long[] queryNs) {
    // creates new FileWriter Object
    FileWriter fw = null;
    // try catch block to see if there is a problem with creating the FileWriter Object
    try {
      fw = new FileWriter(f);
    }
    // if there is a problem it outputs an error message
    catch (IOException io1) {
      System.out.print("Exception encountered, unable to complete method.");
    }
    // iterates through the given array and writes the results of the compare method into the file
    for (int i = 0; i < queryNs.length; i++) {
      // try catch block to see if there is a problem when writing in the file
      try {
        fw.write(Benchmarker.compare(queryNs[i]));
      }
      // if there is a problem it outputs an error message
      catch (IOException io2) {
        System.out.print("Exception encountered while writing for value N =" + queryNs[i]);
      }
    }
    // try catch block to see if there is a problem with closing the file
    try {
      fw.close();
    }
    // if there is a problem then it outputs an error message
    catch (IOException io3) {
      System.out.print("Exception encountered while closing file");
    }
  }
}
