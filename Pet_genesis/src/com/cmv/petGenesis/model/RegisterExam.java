package com.cmv.petGenesis.model;

public class RegisterExam {

	private int idRegister;
	private Consult consult;
	private Exam exam;
	private String resultExam;
	private String diagnosticExam;

	public int getIdRegister() {
		return idRegister;
	}

	public void setIdRegister(int idRegister) {
		this.idRegister = idRegister;
	}

	public Consult getConsult() {
		return consult;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public String getResultExam() {
		return resultExam;
	}

	public void setResultExam(String resultExam) {
		this.resultExam = resultExam;
	}

	public String getDiagnosticExam() {
		return diagnosticExam;
	}

	public void setDiagnosticExam(String diagnosticExam) {
		this.diagnosticExam = diagnosticExam;
	}
}
