package cn.edu.nenu.clzc.commons.entites.examination;

import java.util.Date;

public class ParamQuestion {
    private String id;

    private String questionsId;
    
    private String questionOutline;

	private String questionNumber;

    private String questionAnalysis;

    private String questionAnswer;

    private Double questionMark;

    private Date questionTime;

    private String questionIsDelete;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionsId() {
		return questionsId;
	}

	public void setQuestionsId(String questionsId) {
		this.questionsId = questionsId;
	}

	public String getQuestionOutline() {
		return questionOutline;
	}

	public void setQuestionOutline(String questionOutline) {
		this.questionOutline = questionOutline;
	}

	public String getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(String questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getQuestionAnalysis() {
		return questionAnalysis;
	}

	public void setQuestionAnalysis(String questionAnalysis) {
		this.questionAnalysis = questionAnalysis;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public Double getQuestionMark() {
		return questionMark;
	}

	public void setQuestionMark(Double questionMark) {
		this.questionMark = questionMark;
	}

	public Date getQuestionTime() {
		return questionTime;
	}

	public void setQuestionTime(Date questionTime) {
		this.questionTime = questionTime;
	}

	public String getQuestionIsDelete() {
		return questionIsDelete;
	}

	public void setQuestionIsDelete(String questionIsDelete) {
		this.questionIsDelete = questionIsDelete;
	}

    
}