package cn.edu.nenu.clzc.commons.entites.student;

import java.util.Date;

public class StudentTest {
    private String id;

    private String studentId;

    private String studentTestType;

    private String studentTestInfo;

    private String questionsId;

    private Date studentTestTime;

    private String studentTestIsDelete;

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

	public String getStudentTestType() {
		return studentTestType;
	}

	public void setStudentTestType(String studentTestType) {
		this.studentTestType = studentTestType;
	}

	public String getStudentTestInfo() {
		return studentTestInfo;
	}

	public void setStudentTestInfo(String studentTestInfo) {
		this.studentTestInfo = studentTestInfo;
	}

	public String getQuestionsId() {
		return questionsId;
	}

	public void setQuestionsId(String questionsId) {
		this.questionsId = questionsId;
	}

	public Date getStudentTestTime() {
		return studentTestTime;
	}

	public void setStudentTestTime(Date studentTestTime) {
		this.studentTestTime = studentTestTime;
	}

	public String getStudentTestIsDelete() {
		return studentTestIsDelete;
	}

	public void setStudentTestIsDelete(String studentTestIsDelete) {
		this.studentTestIsDelete = studentTestIsDelete;
	}

   
}