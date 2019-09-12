package bcit;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;

@Named("problemReport")
@ConversationScoped
public class ProblemReport implements Serializable {
	
	@Inject private Project project;
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	private int number;  //use Integer here
	private String date; //use String here if Date doesn't work
	private String originator;
	private String modulesAffected;
	private String description;
	private String recommendedSolution;
	private String priority;
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int num) {
		this.number = num;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}

	public String getOriginator() {
		return originator;
	}

	public void setOriginator(String originator) {
		this.originator = originator;
	}

	public String getModules() {
		return modulesAffected;
	}

	public void setModules(String modulesAffected) {
		this.modulesAffected = modulesAffected;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRecommendedSolution() {
		return recommendedSolution;
	}

	public void setRecommendedSolution(String recommendedSolution) {
		this.recommendedSolution = recommendedSolution;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
}

