package cn.edu.nenu.clzc.commons.entites.examination;

import java.util.Date;

public class ParamQuestions {
    private String id;

    private String questionsNumber;

    private String examinationId;

    private String questionsTitle;

    private String questionsInfo;

    private String questionsTypeId;

    private Date questionsTime;

    private String questionsIsDelete;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionsNumber() {
		return questionsNumber;
	}

	public void setQuestionsNumber(String questionsNumber) {
		this.questionsNumber = questionsNumber;
	}

	public String getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(String examinationId) {
		this.examinationId = examinationId;
	}

	public String getQuestionsTitle() {
		return questionsTitle;
	}

	public void setQuestionsTitle(String questionsTitle) {
		this.questionsTitle = questionsTitle;
	}

	public String getQuestionsInfo() {
		return questionsInfo;
	}

	public void setQuestionsInfo(String questionsInfo) {
		this.questionsInfo = questionsInfo;
	}

	public String getQuestionsTypeId() {
		return questionsTypeId;
	}

	public void setQuestionsTypeId(String questionsTypeId) {
		this.questionsTypeId = questionsTypeId;
	}

	public Date getQuestionsTime() {
		return questionsTime;
	}

	public void setQuestionsTime(Date questionsTime) {
		this.questionsTime = questionsTime;
	}

	public String getQuestionsIsDelete() {
		return questionsIsDelete;
	}

	public void setQuestionsIsDelete(String questionsIsDelete) {
		this.questionsIsDelete = questionsIsDelete;
	}

    
    
}