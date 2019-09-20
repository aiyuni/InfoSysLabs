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
	
	@Inject @bcit.Random int randomNumber; 
	@Inject Conversation conversation;
	
	@PostConstruct
	public void init() {
		//attempts = 0;
		if (attempts == 0) {
			conversation.begin();
		}
	}
	
	@PreDestroy
	public void destroy(){
		attempts = 0;
		conversation.end();
	}
	
	public String checkGuess() {
		System.out.println("inside checkGuess");
		attempts++;
		
		int userGuess = Integer.parseInt(userInput);
		
		if (randomNumber > Integer.parseInt(userInput)) {
			lowerBound = Integer.parseInt(userInput) + 1;
			//userInput = "inside if";
			debug = "correct number is: " + Integer.toString(randomNumber);
			return "tooLow";
		}
		else if (randomNumber < Integer.parseInt(userInput)){
			upperBound = Integer.parseInt(userInput) + 1;
			debug = "correct number is: " + Integer.toString(randomNumber);
			//userInput = "too high";
			return "tooHigh";
		}
		else {
			debug = "" + randomNumber;
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
	
	
	
	
}
