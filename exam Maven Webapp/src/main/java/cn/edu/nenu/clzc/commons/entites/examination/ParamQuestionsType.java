package cn.edu.nenu.clzc.commons.entites.examination;

import java.util.Date;

public class ParamQuestionsType {
    private String id;

    private String questionsTypeName;

    private String questionsObjectiveOrSubjective;

    private Date questionsTypeTime;

    private String questionsTypeIsDelete;

    private String questionsTypeInfo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionsTypeName() {
		return questionsTypeName;
	}

	public void setQuestionsTypeName(String questionsTypeName) {
		this.questionsTypeName = questionsTypeName;
	}

	public String getQuestionsObjectiveOrSubjective() {
		return questionsObjectiveOrSubjective;
	}

	public void setQuestionsObjectiveOrSubjective(
			String questionsObjectiveOrSubjective) {
		this.questionsObjectiveOrSubjective = questionsObjectiveOrSubjective;
	}

	public Date getQuestionsTypeTime() {
		return questionsTypeTime;
	}

	public void setQuestionsTypeTime(Date questionsTypeTime) {
		this.questionsTypeTime = questionsTypeTime;
	}

	public String getQuestionsTypeIsDelete() {
		return questionsTypeIsDelete;
	}

	public void setQuestionsTypeIsDelete(String questionsTypeIsDelete) {
		this.questionsTypeIsDelete = questionsTypeIsDelete;
	}

	public String getQuestionsTypeInfo() {
		return questionsTypeInfo;
	}

	public void setQuestionsTypeInfo(String questionsTypeInfo) {
		this.questionsTypeInfo = questionsTypeInfo;
	}

    
}