package com.cmv.petGenesis.model;

public class Exam {

	private int idExam;
	private String nameExam;
	private String descriptionExam;

	public Exam() {
	}

	public Exam(int idExam) {
		this.idExam = idExam;
	}

	public int getIdExam() {
		return idExam;
	}

	public void setIdExam(int idExam) {
		this.idExam = idExam;
	}

	public String getNameExam() {
		return nameExam;
	}

	public void setNameExam(String nameExam) {
		this.nameExam = nameExam;
	}

	public String getDescriptionExam() {
		return descriptionExam;
	}

	public void setDescriptionExam(String descriptionExam) {
		this.descriptionExam = descriptionExam;
	}

}
