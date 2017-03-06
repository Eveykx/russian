package cn.edu.nenu.clzc.dao.examination;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.nenu.clzc.commons.core.AbstractDao;
import cn.edu.nenu.clzc.commons.core.expandhandler.ExpandBeanHandler;
import cn.edu.nenu.clzc.commons.core.expandhandler.ExpandBeanListHandler;
import cn.edu.nenu.clzc.commons.entites.examination.ParamQuestionsArticle;
import cn.edu.nenu.clzc.commons.enumeration.exception.DaoExceptionEnum;
import cn.edu.nenu.clzc.commons.exception.ContextException;

/**
* @ClassName: ParamQuestionsArticleDao
* @Description: 大题文章的Dao层操作(这里用一句话描述这个类的作用)
* @author Kyrie Irving
* @date 2016年12月5日 下午7:09:57
 */
public class ParamQuestionsArticleDao extends AbstractDao {
 
    /**
     *    
    * @Title: addQuestionsArticle
    * @Description: 添加一篇大题文章(这里用一句话描述这个方法的作用)
    * @author Kyrie Irving
    * @param @param paramQuestionsArticle
    * @param @return
    * @param @throws Exception    设定文件
    * @return String    返回类型
    * @throws
     */
    public String addQuestionsArticle(ParamQuestionsArticle paramQuestionsArticle) throws Exception {
		String articleQuestionsId = paramQuestionsArticle.getArticleQuestionsId();
		String article = paramQuestionsArticle.getArticle();
		String articleInfo = paramQuestionsArticle.getArticleInfo();
		Date articleTime = new Date();
		String sql = "INSERT INTO param_questions_article ( param_questions_article.article_questions_id, param_questions_article.article, param_questions_article.article_info, param_questions_article.article_time ) VALUES (?,?,?,?)";
		Object[] params = {articleQuestionsId, article, articleInfo, articleTime};
		String id = null;
		try {
			id = insert(sql, params);
		} catch (ContextException | SQLException e) {
			logger.error(DaoExceptionEnum.AddQuestionsArticleFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.AddQuestionsArticleFaild.getInfo());
		}
		return id;
	}
	
	
    
    /**
     * 
     * @Title: deleteQuestionsArticle
     * @Description: 修改大题文章的显示状态
     * @return: int
     * @throws: Exception
     */
    public int deleteQuestionsArticle(String id, String value) throws Exception {
    	int temp = 0;
    	String sql = "UPDATE param_questions_article SET article_is_delete = ? WHERE id = ?";
    	Object[] params = {value, id};
    	try {
			temp = update(sql, params);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.DeleteQuestionsArticleFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.DeleteQuestionsArticleFaild.getInfo());
		}
    	return temp;
    }

	
    /**
	 * 
	* @Title: selectQuestionsArticlesByuestionsArticlesId
	* @Description: 根据文章大题主键Id来查找答应大题下的文章(这里用一句话描述这个方法的作用)
	* @author Kyrie Irving
	* @param @param articleQuestionsId
	* @param @return
	* @param @throws Exception    设定文件
	* @return List<ParamQuestionsArticle>    返回类型
	* @throws
	 */
	public ParamQuestionsArticle selectQuestionsArticlesByuestionsArticlesId(String articleQuestionsId) throws Exception {
		ParamQuestionsArticle paramQuestionsArticle = new ParamQuestionsArticle();
		String sql = "SELECT param_questions_article.article, param_questions_article.article_info, param_questions_article.article_time FROM param_questions_article INNER JOIN param_questions ON param_questions_article.article_questions_id = param_questions.id WHERE param_questions_article.article_questions_id = ? AND param_questions_article.article_is_delete = '0' ORDER BY param_questions_article.article_time ASC";
		Object param = articleQuestionsId;
		try {
			paramQuestionsArticle = query(sql, new ExpandBeanHandler<ParamQuestionsArticle>(ParamQuestionsArticle.class), param);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectQuestionsArticlesByuestionsArticlesIdFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectQuestionsArticlesByuestionsArticlesIdFaild.getInfo());
		}
		return paramQuestionsArticle;
	}
	


}
