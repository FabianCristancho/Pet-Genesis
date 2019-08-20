package com.cmv.petGenesis.model;

/**
 * Clase RegisterExam - Se encarga del manejo de los datos del registro del
 * exámen
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class RegisterExam {

	private int idRegister;
	private Consult consult;
	private ExamTPR examTPR;
	private ExamECOP examECOP;
	private ExamBody examBody;
	private String resultExam;
	private String diagnosticExam;

	/**
	 * Obteiene el id del registro
	 * @return idRegister id
	 */
	public int getIdRegister() {
		return idRegister;
	}

	/**
	 * Cambia el valor del id
	 * @param idRegister
	 */
	public void setIdRegister(int idRegister) {
		this.idRegister = idRegister;
	}

	/**
	 * Obtiene la consulta
	 * @return consult c
	 */
	public Consult getConsult() {
		return consult;
	}

	/**
	 * Cambia la consulta
	 * @param consult c
	 */
	public void setConsult(Consult consult) {
		this.consult = consult;
	}


	/**
	 * Obtiene el resultado del examen
	 * @return resultExam resultado
	 */
	public String getResultExam() {
		return resultExam;
	}

	/**
	 * Cambia el resultado del examen
	 * @param resultExam resultado
	 */
	public void setResultExam(String resultExam) {
		this.resultExam = resultExam;
	}

	/**
	 * Obtien el diagnostico del examen
	 * @return diagnosticExam d
	 */
	public String getDiagnosticExam() {
		return diagnosticExam;
	}

	/**
	 * Cambia el diagnostico del exámen
	 * @param diagnosticExam d
	 */
	public void setDiagnosticExam(String diagnosticExam) {
		this.diagnosticExam = diagnosticExam;
	}

	public ExamTPR getExamTPR() {
		return examTPR;
	}

	public void setExamTPR(ExamTPR examTPR) {
		this.examTPR = examTPR;
	}

	public ExamECOP getExamECOP() {
		return examECOP;
	}

	public void setExamECOP(ExamECOP examECOP) {
		this.examECOP = examECOP;
	}

	public ExamBody getExamBody() {
		return examBody;
	}

	public void setExamBody(ExamBody examBody) {
		this.examBody = examBody;
	}
	
}
