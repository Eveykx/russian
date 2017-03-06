package cn.edu.nenu.clzc.commons.entites.student;

import java.util.Date;

public class StudentDone {
	private String id;

	private String studentId;

	private String examinationOrTestId;

	private String studentDoneType;

	private Date studentDoneTime;

	private String studentDoneQuestionsNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getExaminationOrTestId() {
		return examinationOrTestId;
	}

	public void setExaminationOrTestId(String examinationOrTestId) {
		this.examinationOrTestId = examinationOrTestId;
	}

	public String getStudentDoneType() {
		return studentDoneType;
	}

	public void setStudentDoneType(String studentDoneType) {
		this.studentDoneType = studentDoneType;
	}

	public Date getStudentDoneTime() {
		return studentDoneTime;
	}

	public void setStudentDoneTime(Date studentDoneTime) {
		this.studentDoneTime = studentDoneTime;
	}

	public String getStudentDoneQuestionsNumber() {
		return studentDoneQuestionsNumber;
	}

	public void setStudentDoneQuestionsNumber(String studentDoneQuestionsNumber) {
		this.studentDoneQuestionsNumber = studentDoneQuestionsNumber;
	}
	
	
	
}