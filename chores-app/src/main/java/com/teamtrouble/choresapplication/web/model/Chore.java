package com.teamtrouble.choresapplication.web.model;

import java.util.Date;

public class Chore {

	public enum Cadence {
		DAILY, WEEKLY, EVERY_2_WEEKS, EVERY_4_WEEKS
	}

	private int id;
	private String description;
	private Date targetDate;
	private boolean repeatAtCadence;

	private Cadence cadence;
	private String createdBy;
	private boolean isComplete;
	private String completedBy;

	public Chore(int id, String description, Date targetDate, boolean repeatAtCadence, Cadence cadence,
			String createdBy, boolean isComplete, String completedBy) {
		this.id = id;
		this.description = description;
		this.targetDate = targetDate;
		this.repeatAtCadence = repeatAtCadence;
		this.cadence = cadence;
		this.createdBy = createdBy;
		this.isComplete = isComplete;
		this.completedBy = completedBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getIsRepeatAtCadence() {
		return repeatAtCadence;
	}

	public void setIsRepeatAtCadence(boolean repeatAtCadence) {
		this.repeatAtCadence = repeatAtCadence;
	}

	public Cadence getCadence() {
		return cadence;
	}

	public void setCadence(Cadence cadence) {
		this.cadence = cadence;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public String getCompletedBy() {
		return completedBy;
	}

	public void setCompletedBy(String completedBy) {
		this.completedBy = completedBy;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadence == null) ? 0 : cadence.hashCode());
		result = prime * result + ((completedBy == null) ? 0 : completedBy.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + (isComplete ? 1231 : 1237);
		result = prime * result + (repeatAtCadence ? 1231 : 1237);
		result = prime * result + ((targetDate == null) ? 0 : targetDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chore other = (Chore) obj;
		if (cadence != other.cadence)
			return false;
		if (completedBy == null) {
			if (other.completedBy != null)
				return false;
		} else if (!completedBy.equals(other.completedBy))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (isComplete != other.isComplete)
			return false;
		if (repeatAtCadence != other.repeatAtCadence)
			return false;
		if (targetDate == null) {
			if (other.targetDate != null)
				return false;
		} else if (!targetDate.equals(other.targetDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chore [id=" + id + ", description=" + description + ", targetDate=" + targetDate + ", repeatAtCadence="
				+ repeatAtCadence + ", cadence=" + cadence + ", createdBy=" + createdBy + ", isComplete=" + isComplete
				+ ", completedBy=" + completedBy + "]";
	}

}
