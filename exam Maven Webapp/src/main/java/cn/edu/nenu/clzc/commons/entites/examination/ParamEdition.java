package cn.edu.nenu.clzc.commons.entites.examination;

import java.util.Date;

public class ParamEdition {
    private String id;

    private String editionName;

    private String editionInfo;

    private Date editionTime;

    private String editionIsDelete;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEditionName() {
		return editionName;
	}

	public void setEditionName(String editionName) {
		this.editionName = editionName;
	}

	public String getEditionInfo() {
		return editionInfo;
	}

	public void setEditionInfo(String editionInfo) {
		this.editionInfo = editionInfo;
	}

	public Date getEditionTime() {
		return editionTime;
	}

	public void setEditionTime(Date editionTime) {
		this.editionTime = editionTime;
	}

	public String getEditionIsDelete() {
		return editionIsDelete;
	}

	public void setEditionIsDelete(String editionIsDelete) {
		this.editionIsDelete = editionIsDelete;
	}

      
}