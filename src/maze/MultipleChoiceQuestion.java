package maze;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleChoiceQuestion extends Question implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6005025379921405733L;

	private int myAltAns1;
	
	private int myAltAns2;
	
	private int myAltAns3;
	
	private boolean correctAnswer = false; //default false

	
	public MultipleChoiceQuestion(String theQuestion, boolean isTom, int theAnswer, int theAltAns1, int theAltAns2, int theAltAns3) {
		super(theQuestion, isTom, theAnswer);
		this.myAltAns1 = theAltAns1;
		this.myAltAns2 = theAltAns2;
		this.myAltAns3 = theAltAns3;
	}
	
	public int getAltAns1() {
		return myAltAns1;
	}
	
	public boolean getCorrectAnswer() {
		return correctAnswer;
	}
	
	public int getAltAns2() {
		return myAltAns2;
	}
	
	public int getAltAns3() {
		return myAltAns3;
	}
	
	@Override
	public void displayQuestion() {
		System.out.println("Question: " + getQuestion());
		System.out.println("Answer: " + getAnswer());
		System.out.println("Wrong Answers: " + getAltAns1() + ", " + getAltAns2() + ", " + getAltAns3());
		System.out.println("isTom Question: " + getTom() + "\n");
	}
	
}
