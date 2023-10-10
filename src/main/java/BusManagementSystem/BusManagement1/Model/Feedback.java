package BusManagementSystem.BusManagement1.Model;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
@Entity
@DynamicUpdate
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedBackId;
	public Integer getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(Integer feedBackId) {
		this.feedBackId = feedBackId;
	}
	@Min(value=1, message="Rating must be in range of 1-5")
	@Max(value=5, message="Rating must be in range of 1-5")
	private Integer overallRating;

	public Integer getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(Integer overallRating) {
		this.overallRating = overallRating;
	}	
	@Min(value=1, message="Rating must be in range of 1-5")
	@Max(value=5, message="Rating must be in range of 1-5")
	private Integer busrating;
	public Integer getBusrating() {
		return busrating;
	}

	public void setBusrating(Integer busrating) {
		this.busrating = busrating;
	}

	private String comments;
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	@JsonIgnore
	@JoinColumn(name="userId")
	@ManyToOne
	private User user;
	@JsonIgnore
	@JoinColumn(name="busId")
	@ManyToOne
	private Bus busObj;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bus getBusObj() {
		return busObj;
	}

	public void setBusObj(Bus busObj) {
		this.busObj = busObj;
	}

	@Override
	public String toString() {
		return "Feedback [feedBackId=" + feedBackId + ", overallRating=" + overallRating + ", busrating=" + busrating
				+ ", comments=" + comments + ", user=" + user + ", busObj=" + busObj + "]";
	}


}