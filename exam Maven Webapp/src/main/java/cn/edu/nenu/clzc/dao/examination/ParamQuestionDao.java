package cn.edu.nenu.clzc.dao.examination;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.edu.nenu.clzc.commons.core.AbstractDao;
import cn.edu.nenu.clzc.commons.core.expandhandler.ExpandBeanListHandler;
import cn.edu.nenu.clzc.commons.entites.examination.ParamQuestion;
import cn.edu.nenu.clzc.commons.enumeration.exception.DaoExceptionEnum;
import cn.edu.nenu.clzc.commons.exception.ContextException;
import cn.edu.nenu.clzc.commons.vo.examination.ParamQuestionVo;

/**
 * 
 * @author 我要睡觉了
 * @Title ParamQuestionDao.java
 * @Description 关于小题的dao方法
 * @time 2016年11月26日 下午4:13:52
 */

public class ParamQuestionDao extends AbstractDao {
 
	/**
	 * 
	 * @Title: addQuestion
	 * @Description: 添加一道小题
	 * @return: String
	 * @throws: Exception
	 */
	public String addQuestion(ParamQuestionVo paramQuestionVo) throws Exception {
		String questionsId = paramQuestionVo.getQuestionsId();
		String questionOutline = paramQuestionVo.getQuestionOutline();
		String questionNumber = paramQuestionVo.getQuestionNumber();
		String questionAnalysis = paramQuestionVo.getQuestionAnalysis();
		String questionAnswer = paramQuestionVo.getQuestionAnswer();
		Double questionMark = paramQuestionVo.getQuestionMark();
		Date questionTime = new Date();
		String sql = "INSERT INTO param_question (questions_id, question_outline, question_number, question_analysis, question_answer, question_mark, question_time) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {questionsId, questionOutline, questionNumber, questionAnalysis, questionAnswer, questionMark, questionTime};
		String id = null;
		try {
			id = insert(sql, params);
		} catch (ContextException | SQLException e) {
			logger.error(DaoExceptionEnum.AddQuestionFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.AddQuestionFaild.getInfo());
		}
		return id;
	}
	
	
	/**
	 * 
	 * @Title: deleteQuestion
	 * @Description: 删除一道小题
	 * @return: int
	 * @throws: Exception
	 */
	public int deleteQuestion(String id, String questionIsDelete) throws Exception {
		String sql = "UPDATE param_question SET question_is_delete = ? WHERE id = ?";
		Object[] params = {questionIsDelete, id};
		int i = 0;
		try {
			i = update(sql, params);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.DeleteQuestionFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.DeleteQuestionFaild.getInfo());
		}
		return i;
	}
	
	
	/**
	 * 
	 * @Title: selectQuestion
	 * @Description: 根据大题查询出对应的所有可见小题
	 * @return: List<ParamQuestion>
	 * @throws Exception 
	 */
	public List<ParamQuestionVo> selectQuestion(String questionsId) throws Exception {
		List<ParamQuestionVo> list = new ArrayList<ParamQuestionVo>();
		String sql = "SELECT * from param_question WHERE questions_id = ? AND question_is_delete = '0' ORDER BY question_time ASC";
		Object param = questionsId;
		try {
			list = query(sql, new ExpandBeanListHandler<ParamQuestionVo>(ParamQuestionVo.class), param);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectQuestionFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectQuestionFaild.getInfo());
		}
		return list;
	}
	
	
	/**
	 * 
	 * @Title: selectAllQuestion
	 * @Description: 根据大题查询出所有小题
	 * @return: List<ParamQuestion>
	 * @throws: Exception
	 */
	public List<ParamQuestionVo> selectAllQuestion(String questionsId) throws Exception {
		List<ParamQuestionVo> list = new ArrayList<ParamQuestionVo>();
		String sql = "SELECT * from param_question WHERE questions_id = ? ORDER BY question_time ASC";
		Object param = questionsId;
		try {
			list = query(sql, new ExpandBeanListHandler<ParamQuestionVo>(ParamQuestionVo.class), param);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectAllQuestionFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectAllQuestionFaild.getInfo());
		}
		return list;
	}
	
	
	/**
	 * 
	 * @Title: checkQuestionNumber
	 * @Description: 检查小题编号是否重复
	 * @return: boolean
	 * @throws Exception 
	 */
	public boolean checkQuestionNumber(String questionNumber) throws Exception {
		boolean flag = false;
		String sql = "SELECT COUNT(*) from param_question WHERE question_number = ?";
		Object param = questionNumber;
		int i = 0;
		try {
			i = query(sql, new ScalarHandler<Long>(), param).intValue();
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.CheckQuestionNumberFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.CheckQuestionNumberFaild.getInfo());
		}
		if(i > 0) 
			flag = true;
		return flag;
	}
	


}
