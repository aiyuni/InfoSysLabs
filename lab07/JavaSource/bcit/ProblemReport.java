package bcit;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named("problemReports")
@ConversationScoped
public class ProblemReport implements Serializable {
	
	@Inject private Project project;
	
	 @Inject Conversation conversation;
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	private Integer number;  //use Integer here
	private String date; //use String here if Date doesn't work
	private String originator;
	private String modulesAffected;
	private String description;
	private String recommendedSolution;
	private String severity;
	private String priority;
	private String dateAssigned;
	private String dateFixed;
	private boolean scope;
	
	private Status priorityStatus;
	private Status severityStatus;
	
	public enum Status {
        LOW, MEDIUM, HIGH, CRITICAL;
        public String toString() {
            return name().toLowerCase();
        }
	}
	
	@PostConstruct
    public void init() {
        conversation.begin();
    }

   /* @PreDestroy
    public void destroy() {
        conversation.end();
    } */
	    
	/**
	 * Gets a map of all the status types based on the Status enum
	 * @return
	 */
	public Map<String, Status> getStatusType() {
        Map<String, Status> map = new LinkedHashMap<>();
        for (Status status : Status.values()) {
            map.put(status.toString().toLowerCase(), status);  //label, value (enum.toString, "text")
        }
        return map;
    }
	
	public String getTitle() {
		if (scope) {
			return "In Scope: Software Problem Report";
		}
		else {
			return "Not in scope: Engineer Change Request";
		}
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer num) {
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
		return priority.toLowerCase();
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getModulesAffected() {
		return modulesAffected;
	}

	public void setModulesAffected(String modulesAffected) {
		this.modulesAffected = modulesAffected;
	}

	public String getSeverity() {
		return severity.toLowerCase();
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getDateAssigned() {
		return dateAssigned;
	}

	public void setDateAssigned(String dateAssigned) {
		this.dateAssigned = dateAssigned;
	}

	public String getDateFixed() {
		return dateFixed;
	}

	public void setDateFixed(String dateFixed) {
		this.dateFixed = dateFixed;
	}
	
	public boolean getScope() {
		return scope;
	}
	public void setScope(boolean value) {
		this.scope = value;
	}

	public Status getPriorityStatus() {
		return priorityStatus;
	}

	public void setPriorityStatus(Status priorityStatus) {
		this.priorityStatus = priorityStatus;
	}
	
	public Status getSeverityStatus() {
        return severityStatus;
    }

    public void setSeverityStatus(Status severityStatus) {
        this.severityStatus = severityStatus;
    }


	public String submit() {
		return "success";
	}
	
    public String edit() {
        return "edit";
    }
    
    public String enterNewProblem() {
        conversation.end();
        return "new";
    }
}

