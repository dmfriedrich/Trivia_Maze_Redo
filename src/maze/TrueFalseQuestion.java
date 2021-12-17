package maze;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TrueFalseQuestion extends Question implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 343271035066272031L;
	private int myFalseAns;
	
	public TrueFalseQuestion(String theQuestion, boolean isTom, int theAnswer, int theFalseAns) {
		super(theQuestion, isTom, theAnswer);
		this.myFalseAns = theFalseAns;
	}
	
	public int getFalseAns() {
		return myFalseAns;
	}
	
	@Override
	public void displayQuestion() {
		System.out.println("Question: " + getQuestion());
		System.out.println("Answer: " + getAnswer());
		System.out.println("Wrong Answer: " + getFalseAns());
		System.out.println("isTom Question: " + getTom() + "\n");
	}
	
}
