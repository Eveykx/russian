package cn.edu.nenu.clzc.dao.examination;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.edu.nenu.clzc.commons.core.AbstractDao;
import cn.edu.nenu.clzc.commons.core.expandhandler.ExpandBeanListHandler;
import cn.edu.nenu.clzc.commons.entites.examination.ParamQuestionsType;
import cn.edu.nenu.clzc.commons.enumeration.exception.DaoExceptionEnum;
import cn.edu.nenu.clzc.commons.exception.ContextException;

/**
 * 
 * @author 杨可欣
 * @Title ParamQuestionsTypeDao.java
 * @Description 大题题型的Dao
 * @time 2016年12月1日 下午11:34:45
 */

public class ParamQuestionsTypeDao extends AbstractDao {

	
	/**
	 * 
	 * @Title: addQuestionsType
	 * @Description: 增加一种题型
	 * @return: String
	 * @throws Exception 
	 */
	public String addQuestionsType(ParamQuestionsType paramQuestionsType) throws Exception {
		String questionsTypeName = paramQuestionsType.getQuestionsTypeName();
		String questionsObjectiveOrSubjective = paramQuestionsType.getQuestionsObjectiveOrSubjective();
		Date questionsTypeTime = new Date();
		String questionTypeInfo = paramQuestionsType.getQuestionsTypeInfo();
		String sql = "INSERT INTO param_questions_type (questions_type_name, questions_objective_or_subjective, questions_type_time, questions_type_info) values (?, ?, ?, ?)";
		Object[] params = {questionsTypeName, questionsObjectiveOrSubjective, questionsTypeTime, questionTypeInfo};
		String id = null;
		try {
			id = insert(sql, params);
		} catch (ContextException | SQLException e) {
			logger.error(DaoExceptionEnum.AddQuestionsTypeFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.AddQuestionsTypeFaild.getInfo());
		}
		return id;
	}
	
	
	/**
	 * 
	 * @Title: deleteQuestionsType
	 * @Description: 删除一种题型
	 * @return: int
	 * @throws Exception 
	 */
	public int deleteQuestionsType(String id, String questionsTypeIsDelete) throws Exception {
		int temp = 0;
		String sql = "UPDATE param_questions_type SET questions_type_is_delete = ? WHERE id = ?";
		Object[] params = {questionsTypeIsDelete, id};
		try {
			temp = update(sql, params);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.DelelteQuestionsTypeFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.DelelteQuestionsTypeFaild.getInfo());
		}
		return temp;	
	}
	
	
	/**
	 * 
	 * @Title: selectType
	 * @Description: 查找可见题型
	 * @return: List<ParamQuestionsType>
	 * @throws Exception 
	 */
	public List<ParamQuestionsType> selectType() throws Exception {
		List<ParamQuestionsType> list = new ArrayList<ParamQuestionsType>();
		String sql = "SELECT * from param_questions_type WHERE questions_type_is_delete = '0' ORDER BY questions_type_time ASC";
		try {
			list = query(sql, new ExpandBeanListHandler<ParamQuestionsType>(ParamQuestionsType.class));
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectTypeFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectTypeFaild.getInfo());
		}
		return list;
	}
	
	
	/**
	 * 
	 * @Title: selectAllType
	 * @Description: 查询出所有的题型
	 * @return: List<ParamQuestionsType>
	 * @throws Exception 
	 */
	public List<ParamQuestionsType> selectAllType() throws Exception {
		List<ParamQuestionsType> list = new ArrayList<ParamQuestionsType>();
		String sql = "SELECT * from param_questions_type ORDER BY questions_type_time ASC";
		try {
			list = query(sql, new ExpandBeanListHandler<ParamQuestionsType>(ParamQuestionsType.class));
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectAllTypeFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectAllTypeFaild.getInfo());
		}
		return list;
	}
	
	
	/**
	 * 
	 * @Title: selectById
	 * @Description: 根据id查找大题类型名
	 * @return: String
	 * @throws Exception 
	 */
	public String selectById(String id) throws Exception {
		String type;
		String sql = "SELECT questions_type_name from param_questions_type WHERE id = ?";
		Object param = id;
		try {
			type = query(sql, new ScalarHandler<String>(), param);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectByIdlTypeFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectByIdlTypeFaild.getInfo());
		}
		return type;
	}
	
	
	
	
	
}
