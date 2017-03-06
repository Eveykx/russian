package cn.edu.nenu.clzc.dao.examination;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.edu.nenu.clzc.commons.core.AbstractDao;
import cn.edu.nenu.clzc.commons.core.expandhandler.ExpandBeanHandler;
import cn.edu.nenu.clzc.commons.core.expandhandler.ExpandBeanListHandler;
import cn.edu.nenu.clzc.commons.entites.examination.ParamQuestions;
import cn.edu.nenu.clzc.commons.enumeration.exception.DaoExceptionEnum;
import cn.edu.nenu.clzc.commons.exception.ContextException;
import cn.edu.nenu.clzc.commons.vo.examination.ParamQuestionsVo;

/**
 * 
 * @author 我要睡觉了
 * @Title ParamQuestionsDao.java
 * @Description 大题的Dao方法
 * @time 2016年12月5日 下午7:12:09
 */

public class ParamQuestionsDao extends AbstractDao {
	
	
	/**
	 * 
	 * @Title: addQuestions
	 * @Description: 添加一道大题
	 * @return: String 
	 * @throws Exception 
	 */
	public String addQuestions(ParamQuestionsVo paramQuestionsVo) throws Exception {
		String questionsNumber = paramQuestionsVo.getQuestionsNumber();
		String examinationId = paramQuestionsVo.getExaminationId();
		String questionsTitle = paramQuestionsVo.getQuestionsTitle();
		String questionsInfo = paramQuestionsVo.getQuestionsInfo();
		String questionsTypeId = paramQuestionsVo.getQuestionsTypeId();
		Date questionsTime = new Date();
		String sql = "INSERT INTO param_questions (questions_number, examination_id, questions_title, questions_info, questions_type_id, questions_time) VALUES (?, ?, ?, ?, ?, ?)";
		Object[] params = {questionsNumber, examinationId, questionsTitle, questionsInfo, questionsTypeId, questionsTime};
		String id = null;
		try {
			id = insert(sql, params);
		} catch (ContextException | SQLException e) {
			logger.error(DaoExceptionEnum.AddQuestionsFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.AddQuestionsFaild.getInfo());
		}
		return id;
	}
	
	
	/**
	 * 
	 * @Title: deleteQuestions
	 * @Description: 更改一道大题的可见状态
	 * @return: int
	 * @throws Exception 
	 */
	public int deleteQuestions(String id, String value) throws Exception {
		int temp = 0;
		String sql = "UPDATE param_questions SET questions_is_delete = ? WHERE id = ?";
		Object[] params = {value, id};
		try {
			temp = update(sql, params);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.DeleteQuestionsFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.DeleteQuestionsFaild.getInfo());
		}
		return temp;
	}
	
	
	/**
	 * 
	 * @Title: selectQuestionsByType
	 * @Description: 按照一套试卷的规定题型随即抽取题目
	 * @return: ParamQuestionsVo
	 * @throws Exception 
	 */
	public ParamQuestionsVo selectQuestionsByType(String questionsType) throws Exception {
		ParamQuestionsVo paramQuestionsVo = new ParamQuestionsVo();
		String sql = "SELECT param_questions.id, param_questions.examination_id, param_questions.questions_number, param_questions.questions_title, param_questions.questions_info, param_questions.questions_type_id, param_questions.questions_time, param_questions.questions_is_delete FROM param_questions INNER JOIN param_questions_type ON param_questions.questions_type_id = param_questions_type.id WHERE param_questions_type.questions_type_name = ? AND param_questions.questions_is_delete = '0' ORDER BY RAND() LIMIT 1";
		Object param = questionsType;
		try {
			paramQuestionsVo = query(sql, new ExpandBeanHandler<ParamQuestionsVo>(ParamQuestionsVo.class), param);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectQuestionsByTypeFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectQuestionsByTypeFaild.getInfo());
		}
		return paramQuestionsVo;
	}
	
	
	
	/**
	 * 
	 * @Title: selectQuestionsByExam
	 * @Description: 按照试卷查询出可见的大题
	 * @return: List<ParamQuestions>
	 * @throws Exception 
	 */
	public List<ParamQuestionsVo> selectQuestionsByExam(String examinationId) throws Exception {
		List<ParamQuestionsVo> list = new ArrayList<ParamQuestionsVo>();
		String sql = "SELECT param_questions.id, param_questions.questions_number, param_questions.examination_id, param_questions.questions_title, param_questions.questions_info, param_questions.questions_type_id, param_questions.questions_time, param_questions.questions_is_delete from param_questions INNER JOIN teacher_examination ON param_questions.examination_id = teacher_examination.id WHERE teacher_examination.id = ? AND param_questions.questions_is_delete = '0' ORDER BY param_questions.questions_time ASC";
		Object param = examinationId;
		try {
			list = query(sql, new ExpandBeanListHandler<ParamQuestionsVo>(ParamQuestionsVo.class), param);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectAllQuestionsByExamFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectAllQuestionsByExamFaild.getInfo());
		}
		return list;
	}
	
	
	
	/**
	 * 
	 * @Title: selectQuestionsByExam
	 * @Description: 按照试卷查询出所有的大题
	 * @return: List<ParamQuestions>
	 * @throws Exception 
	 */
	public List<ParamQuestionsVo> selectAllQuestionsByExam(String examinationId) throws Exception {
		List<ParamQuestionsVo> list = new ArrayList<ParamQuestionsVo>();
		String sql = "SELECT param_questions.id, param_questions.questions_number, param_questions.examination_id, param_questions.questions_title, param_questions.questions_info, param_questions.questions_type_id, param_questions.questions_time, param_questions.questions_is_delete from param_questions INNER JOIN teacher_examination ON param_questions.examination_id = teacher_examination.id WHERE teacher_examination.id = ? ORDER BY param_questions.questions_time ASC";
		Object param = examinationId;
		try {
			list = query(sql, new ExpandBeanListHandler<ParamQuestionsVo>(ParamQuestionsVo.class), param);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectAllQuestionsByExamFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectAllQuestionsByExamFaild.getInfo());
		}
		return list;
	}
	
	
	/**
	 * 
	 * @Title: checkNumber
	 * @Description: 检查大题编号是否已经存在
	 * @return: boolean
	 * @throws Exception 
	 */
	public boolean checkNumber(String number) throws Exception {
		boolean flag = false;
		String sql = "SELECT COUNT(*) from param_questions WHERE questions_number = ?";
		Object param = number;
		int i = 0;
		try {
			i = query(sql, new ScalarHandler<Long>(), param).intValue();
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.CheckNumberFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.CheckNumberFaild.getInfo());
		}
		if(i > 0)
			flag = true;
		return flag;
	}
	
	
}	
