package cn.edu.nenu.clzc.commons.entites.student;

import java.util.Date;

public class ObjectiveQuestion {
	String id;
	
	String studentId;
	
	String examinationId;
	
	String questionId;
	
	String studentAnswer;
	
	String teacherComment;
	
	String answerRightOrWrong;
	
	String answerIsDelete;
	
	Date answerTime;

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

	public String getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(String examinationId) {
		this.examinationId = examinationId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getStudentAnswer() {
		return studentAnswer;
	}

	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}

	public String getTeacherComment() {
		return teacherComment;
	}

	public void setTeacherComment(String teacherComment) {
		this.teacherComment = teacherComment;
	}

	public String getAnswerRightOrWrong() {
		return answerRightOrWrong;
	}

	public void setAnswerRightOrWrong(String answerRightOrWrong) {
		this.answerRightOrWrong = answerRightOrWrong;
	}

	public String getAnswerIsDelete() {
		return answerIsDelete;
	}

	public void setAnswerIsDelete(String answerIsDelete) {
		this.answerIsDelete = answerIsDelete;
	}

	public Date getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}

	
}
