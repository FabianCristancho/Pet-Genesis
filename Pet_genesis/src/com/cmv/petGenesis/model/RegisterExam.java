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
	private Exam exam;
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
	 * Obtiene el examen
	 * @return exam e
	 */
	public Exam getExam() {
		return exam;
	}

	/**
	 * Cambia el examen
	 * @param exam e
	 */
	public void setExam(Exam exam) {
		this.exam = exam;
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
}
