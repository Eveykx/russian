package cn.edu.nenu.clzc.commons.entites.examination;

import java.util.Date;

public class ParamUnit {
    private String id;

    private String unitName;

    private String unitInfo;

    private String editionId;

    private Date unitTime;

    private String unitIsDelete;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitInfo() {
		return unitInfo;
	}

	public void setUnitInfo(String unitInfo) {
		this.unitInfo = unitInfo;
	}

	public String getEditionId() {
		return editionId;
	}

	public void setEditionId(String editionId) {
		this.editionId = editionId;
	}

	public Date getUnitTime() {
		return unitTime;
	}

	public void setUnitTime(Date unitTime) {
		this.unitTime = unitTime;
	}

	public String getUnitIsDelete() {
		return unitIsDelete;
	}

	public void setUnitIsDelete(String unitIsDelete) {
		this.unitIsDelete = unitIsDelete;
	}

    
}