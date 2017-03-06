package cn.edu.nenu.clzc.commons.entites.examination;

import java.util.Date;

public class ParamQuestionsArticle {
    private String id;

    private String articleQuestionsId;

    private String articleInfo;

    private Date articleTime;

    private String articleIsDelete;

    private String article;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArticleQuestionsId() {
		return articleQuestionsId;
	}

	public void setArticleQuestionsId(String articleQuestionsId) {
		this.articleQuestionsId = articleQuestionsId;
	}

	public String getArticleInfo() {
		return articleInfo;
	}

	public void setArticleInfo(String articleInfo) {
		this.articleInfo = articleInfo;
	}

	public Date getArticleTime() {
		return articleTime;
	}

	public void setArticleTime(Date articleTime) {
		this.articleTime = articleTime;
	}

	public String getArticleIsDelete() {
		return articleIsDelete;
	}

	public void setArticleIsDelete(String articleIsDelete) {
		this.articleIsDelete = articleIsDelete;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

    
}