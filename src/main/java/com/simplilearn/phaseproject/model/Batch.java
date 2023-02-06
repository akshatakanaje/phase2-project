package com.simplilearn.phaseproject.model;


import java.sql.Time;
import java.util.Date;

public class Batch {
	
	// data properties of batch model
	private int batchId;
	private String batchName;
	private Time startTime;
	private Time endTime;
	private Date startDate;
	private Date endDate;
	
	
	// default constructor
	public Batch() {
		
	}

	
	// parameterized constructor
	public Batch(int batchId, String batchName, Time startTime, Time endTime, Date startDate, Date endDate) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	
	// getter & setter methods
	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	// override to string
	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchName=" + batchName + ", startTime=" + startTime + ", endTime="
				+ endTime + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
