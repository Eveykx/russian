package cn.edu.nenu.clzc.commons.entites.teacher;

import java.sql.Time;
import java.util.Date;

public class TeacherExamination {
    private String id;

    private String unitId;

    private String editionId;
    
    private Double examinationPersistTime;

    private String examinationCreateUsername;

    private String examinationQuestionsType;

    private Date examinationTime;

    private String examinationIsDelete;

    private String examinationInfo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getEditionId() {
		return editionId;
	}

	public void setEditionId(String editionId) {
		this.editionId = editionId;
	}

	public Double getExaminationPersistTime() {
		return examinationPersistTime;
	}

	public void setExaminationPersistTime(Double examinationPersistTime) {
		this.examinationPersistTime = examinationPersistTime;
	}

	public String getExaminationCreateUsername() {
		return examinationCreateUsername;
	}

	public void setExaminationCreateUsername(String examinationCreateUsername) {
		this.examinationCreateUsername = examinationCreateUsername;
	}

	public String getExaminationQuestionsType() {
		return examinationQuestionsType;
	}

	public void setExaminationQuestionsType(String examinationQuestionsType) {
		this.examinationQuestionsType = examinationQuestionsType;
	}

	public Date getExaminationTime() {
		return examinationTime;
	}

	public void setExaminationTime(Date examinationTime) {
		this.examinationTime = examinationTime;
	}

	public String getExaminationIsDelete() {
		return examinationIsDelete;
	}

	public void setExaminationIsDelete(String examinationIsDelete) {
		this.examinationIsDelete = examinationIsDelete;
	}

	public String getExaminationInfo() {
		return examinationInfo;
	}

	public void setExaminationInfo(String examinationInfo) {
		this.examinationInfo = examinationInfo;
	}
   
    
}