package bcit;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**TODO: Investigate why faces-config redirection doesn't do anything --->  this is because we need to do link redirection with a href, and not calling an action method
 * 		'play again' still saves state, need to hard refresh the page to start a new game
 */
@Named("game")
@ConversationScoped
public class GameBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer numberOfTries;
	private Integer answer;
	private Integer lowerBound = 1;
	private Integer upperBound = 100;
	private String userInput;
	
	private String debug = "initial";
	private Integer attempts = 0;
	private String errorMessage = "";
	
	@Inject @Random int randomNumber; 
	@Inject Conversation conversation;
	
	@PostConstruct
	public void init() {
		//attempts = 0;
		System.out.println("inside init");
		conversation.begin();
		debug = "ur number is: " + randomNumber;
	}
	
	
	public String checkGuess() {
		System.out.println("inside checkGuess");
		attempts++;
		int userGuess;
		try {
			userGuess = Integer.parseInt(userInput);
		}
		catch(Exception e) {
			errorMessage = "You did not enter a valid integer";
			return "invalidEntry";
		}
		//int userGuess = Integer.parseInt(userInput);
		
		if (userGuess < lowerBound || userGuess > upperBound) {
			errorMessage = "You entered a number that is out of range.";
			return "invalidEntry";
		}
		if (randomNumber > userGuess) {
			lowerBound = userGuess + 1;
			//userInput = "inside if";
			debug = "correct number is: " + Integer.toString(randomNumber);
			return "tooLow";
		}
		else if (randomNumber < userGuess){
			upperBound = userGuess - 1;
			debug = "correct number is: " + Integer.toString(randomNumber);
			//userInput = "too high";
			return "tooHigh";
		}
		else {
			debug = "" + randomNumber;
			conversation.end();
			return "correctGuess";
			
		}
		//debug = Integer.toString(randomNumber);
	    //return "tooHigh";
	}
	
	public Integer getNumberOfTries() {
		return numberOfTries;
	}
	public void setNumberOfTries(Integer numberOfTries) {
		this.numberOfTries = numberOfTries;
	}
	public Integer getAnswer() {
		return answer;
	}
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
	public Integer getLowerBound() {
		return lowerBound;
	}
	public void setLowerBound(Integer lowerBound) {
		this.lowerBound = lowerBound;
	}
	public Integer getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(Integer upperBound) {
		this.upperBound = upperBound;
	}
	
	public String getUserInput() {
		return userInput;
	}
	
	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}
	
	public String getDebug() {
		return debug;
	}
	
	public void setDebug(String debug) {
		this.debug = debug;
	}
	
	public int getAttempts() {
		return attempts;
	}
	
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String text) {
		errorMessage = text;
	}
	
	
	
}
