package com.cmv.petGenesis.model;

public class ExamTPR {
	
	private int idTpr;
	private String temperature;
	private String pression;
	private String fCardiac;
	private String fRespiratory;
	
	public ExamTPR() {
	}
	
	public ExamTPR(int idTpr) {
		this.idTpr = idTpr;
	}
	
	public int getIdTpr() {
		return idTpr;
	}
	public void setIdTpr(int idTpr) {
		this.idTpr = idTpr;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getPression() {
		return pression;
	}
	public void setPression(String pression) {
		this.pression = pression;
	}
	public String getfCardiac() {
		return fCardiac;
	}
	public void setfCardiac(String fCardiac) {
		this.fCardiac = fCardiac;
	}
	public String getfRespiratory() {
		return fRespiratory;
	}
	public void setfRespiratory(String fRespiratory) {
		this.fRespiratory = fRespiratory;
	}
}
