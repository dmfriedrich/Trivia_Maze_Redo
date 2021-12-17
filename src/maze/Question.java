/**
 * 
 */
package maze;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author stephg02, mtaesc
 *
 */
public class Question implements Serializable {
	// Question source: https://icebreakerideas.com/video-game-trivia/

	/**
	 * 
	 */
	private static final long serialVersionUID = 3792454534667635306L;

	private String myQuestion;
	
	private boolean myTom;
	
	private int myAnswer;
	
	private boolean correctAnswer = false; //default false
	
	
	public Question(String theQuestion, boolean isTom, int theAnswer) {
		this.myQuestion = theQuestion;
		this.myTom =  isTom;
		this.myAnswer = theAnswer;
	}
	
	public boolean inputValidation(String input) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch(NumberFormatException e ) {
	        return false;
	    }
	}
	
	public void setCorrectAnswer(final boolean theAns) {
	  this.correctAnswer = theAns;
	}
	
	/**
	 * Gets the correct answer for test question.
	 *
	 * @return the correct answer
	 */
	public boolean getCorrectAnswer() {
		return correctAnswer;
	}
	
	/**
	 * Gets the question from SQLite database question set.
	 *
	 * @return the question
	 */
	public String getQuestion() {
		return myQuestion;
	}
	
	/**
	 * Gets the answer for SQLite question.
	 *
	 * @return the answer
	 */
	public int getAnswer() {
		return myAnswer;
	}
	
	/**
	 * Gets the tom boolean value (checks if question for tom class or not).
	 *
	 * @return the tom
	 */
	public boolean getTom() {
		return myTom;
	}
	
	//abstract void queryFromTable();
	
	public void displayQuestion() {
		System.out.println("Question: " + getQuestion());
		System.out.println("Answer: " + getAnswer());
		System.out.println("isTom Question: " + getTom() + "\n");
	}
	

	/**
	 * Question prompt MC for test question.
	 *
	 * @param theResponse the the response
	 * @return true, if successful
	 */
	//TODO: Make abstract method to be implemented by children classes. 
	public boolean questionPromptMC(final Scanner theResponse) { // compare class objects
//		System.out.println(
//				"What's the first commercially successful video game?: \n1.Pong \n2.Tank \n3.Spacewar! \n4.Tennis for Two \n");
		System.out.println("Question: " + getQuestion());
		boolean done = false;

		//added try block. Will catch InputMismatchException when user enters the word answer instead of the answer number.
		try {
			while (done == false) {
				int input = theResponse.nextInt();
				int answer = getAnswer();
				if (input == answer) {
					correctAnswer = true;
					done = true;
				} else if (input != answer) {
					done = true;
				} else {
					System.out.println("invalid response; try again.");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Please enter the number of the answer.");
		}
		
		return correctAnswer;
	}
	
//	public boolean questionPromptMC(final Scanner theResponse) {
//      MultipleChoiceQuestion mc = null;
//      getQuestion();
//      boolean done = false;
//
//      //added try block. Will catch InputMismatchException when user enters the word answer instead of the answer number.
//      try {
//          while (done == false) {
//              String enter = theResponse.next();
//              if (enter == getAnswer()) {
//                  correctAnswer = true;
//                  done = true;
//              } else if (enter == mc.getMyWrongAns1() || enter == mc.getMyWrongAns2() || enter == mc.getMyWrongAns3()) {
//                  correctAnswer = false;
//                  done = true;
//              } else {
//                  System.out.println("invalid response; try again.");
//              }
//          }
//      } catch (InputMismatchException e) {
//          System.out.println("Please enter the number of the answer.");
//      }
//      
//      return correctAnswer;
//  }

}