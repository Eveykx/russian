package cn.edu.nenu.clzc.dao.examination;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.edu.nenu.clzc.commons.core.AbstractDao;
import cn.edu.nenu.clzc.commons.core.expandhandler.ExpandBeanHandler;
import cn.edu.nenu.clzc.commons.core.expandhandler.ExpandBeanListHandler;
import cn.edu.nenu.clzc.commons.entites.teacher.TeacherExamination;
import cn.edu.nenu.clzc.commons.enumeration.exception.DaoExceptionEnum;
import cn.edu.nenu.clzc.commons.exception.ContextException;
import cn.edu.nenu.clzc.commons.vo.teacher.TeacherExaminationVo;

/**
 * 
 * @author 我要睡觉了
 * @Title TeacherExaminationDao.java
 * @Description 测试卷的dao方法
 * @time 2016年12月4日 下午3:37:03
 */

public class TeacherExaminationDao extends AbstractDao {

	
	/**
	 * 
	 * @Title: addExamintation
	 * @Description: 增加一套试卷
	 * @return: String
	 * @throws Exception 
	 */
	public String addExamination(TeacherExaminationVo teacherExaminationVo) throws Exception {
		String unitId = teacherExaminationVo.getUnitId();
		String editionId = teacherExaminationVo.getEditionId();
		Double examinationPersistTime = teacherExaminationVo.getExaminationPersistTime();
		String examinationCreateUsername = teacherExaminationVo.getExaminationCreateUsername();
		String examinationQuestionsType = teacherExaminationVo.getExaminationQuestionsType();
		Date examinationTime = new Date();
		String examinationInfo = teacherExaminationVo.getExaminationInfo();
		String sql = "INSERT INTO teacher_examination (unit_id, edition_id, examination_persist_time, examination_create_username, examination_questions_type, examination_time, examination_info) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {unitId, editionId, examinationPersistTime, examinationCreateUsername, examinationQuestionsType, examinationTime, examinationInfo};
		String id = null;
		try {
			id = insert(sql, params);
		} catch (ContextException | SQLException e) {
			logger.error(DaoExceptionEnum.AddExaminationFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.AddExaminationFaild.getInfo());
		}
		return id;
	}
	
	
	/**
	 * 
	 * @Title: deleteExamination
	 * @Description: 删除一套试卷
	 * @return: int
	 * @throws Exception 
	 */
	public int deleteExamination(String id, String value) throws Exception {
		int temp = 0;
		String sql = "UPDATE teacher_examination SET examination_is_delete = ? WHERE id = ?";
		Object[] params = {id, value};
		try {
			temp = update(sql, params);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.DeleteExaminationFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.DeleteExaminationFaild.getInfo());
		}
		return temp;
	}
	
	
	/**
	 * 
	 * @Title: selectExaminationByUnit
	 * @Description: 根据单元分页查询出所有可见试卷
	 * @return: List<TeacherExamination>
	 * @throws Exception 
	 */
	public List<TeacherExaminationVo> selectExaminationByUnit(String unitId, int currentPage) throws Exception {
		List<TeacherExaminationVo> list = new  ArrayList<TeacherExaminationVo>();
		String sql = "SELECT teacher_examination.id, teacher_examination.examination_info, teacher_examination.edition_id, teacher_examination.unit_id, teacher_examination.examination_persist_time, teacher_examination.examination_create_username, teacher_examination.examination_questions_type, teacher_examination.examination_time, teacher_examination.examination_is_delete FROM teacher_examination WHERE teacher_examination.examination_is_delete = '0' AND teacher_examination.unit_id = ? ORDER BY teacher_examination.examination_time ASC LIMIT ?, ?";
		Object[] params = {unitId, (currentPage - 1) * PAGESIZE, PAGESIZE};
		try {
			list = query(sql, new ExpandBeanListHandler<TeacherExaminationVo>(TeacherExaminationVo.class), params);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectExaminationByUnitFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectExaminationByUnitFaild.getInfo());
		}
		return list;
	}
	
	
	/**
	 * 
	 * @Title: selectExaminationByUnitPage
	 * @Description: 根据单元查询出可见试卷的分页总页数
	 * @return: int
	 * @throws Exception 
	 */
	public int selectExaminationByUnitPage(String unitId) throws Exception {
		int totalRow = 0;
		String sql = "SELECT COUNT(*) from teacher_examination WHERE unit_id = ? AND examination_is_delete = '0'";
		Object[] params = {unitId};
		try {
			totalRow = query(sql, new ScalarHandler<Long>(), params).intValue();
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectExaminationByUnitPageFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectExaminationByUnitPageFaild.getInfo());
		}
		return size(totalRow);
	}
	
	
	/**
	 * 
	 * @Title: selectExaminationByUnit
	 * @Description: 根据单元分页查询出所有试题
	 * @return: List<TeacherExamination>
	 * @throws Exception 
	 */
	public List<TeacherExaminationVo> selectAllExaminationByUnit(String unitId, int currentPage) throws Exception {
		List<TeacherExaminationVo> list = new  ArrayList<TeacherExaminationVo>();
		String sql = "SELECT teacher_examination.id, teacher_examination.examination_info, teacher_examination.edition_id, teacher_examination.unit_id, teacher_examination.examination_persist_time, teacher_examination.examination_create_username, teacher_examination.examination_questions_type, teacher_examination.examination_time, teacher_examination.examination_is_delete FROM teacher_examination WHERE teacher_examination.unit_id = ? ORDER BY teacher_examination.examination_time ASC LIMIT ?, ?";
		Object[] params = {unitId, (currentPage - 1) * PAGESIZE, PAGESIZE};
		try {
			list = query(sql, new ExpandBeanListHandler<TeacherExaminationVo>(TeacherExaminationVo.class), params);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectAllExaminationByUnitFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectAllExaminationByUnitFaild.getInfo());
		}
		return list;
	}
	
	
	/**
	 * 
	 * @Title: selectExaminationByUnitPage
	 * @Description: 查询出试卷的分页总页数
	 * @return: int
	 * @throws Exception 
	 */
	public int selectAllExaminationByUnitPage(String unitId) throws Exception {
		int totalRow = 0;
		String sql = "SELECT COUNT(*) from teacher_examination WHERE unit_id = ?";
		Object[] params = {unitId};
		try {
			totalRow = query(sql, new ScalarHandler<Long>(), params).intValue();
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectAllExaminationByUnitPageFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectAllExaminationByUnitPageFaild.getInfo());
		}
		return size(totalRow);
	}
	
	
	/**
	 * 
	 * @Title: selectExaminationByEdition
	 * @Description: 根据册id查询出固定的综合测试题
	 * @return: List<TeacherExamination>
	 * @throws: Exception
	 */
	public List<TeacherExaminationVo> selectExaminationByEdition(String editionId) throws Exception {
		List<TeacherExaminationVo> list = new ArrayList<TeacherExaminationVo>();
		String sql = "SELECT teacher_examination.id, teacher_examination.examination_info, teacher_examination.edition_id, teacher_examination.unit_id, teacher_examination.examination_persist_time, teacher_examination.examination_create_username, teacher_examination.examination_questions_type, teacher_examination.examination_time, teacher_examination.examination_is_delete FROM teacher_examination WHERE teacher_examination.edition_id = ? AND teacher_examination.examination_is_delete = '0' ORDER BY teacher_examination.examination_time ASC";
		Object param = editionId;
		try {
			list = query(sql, new ExpandBeanListHandler<TeacherExaminationVo>(TeacherExaminationVo.class), param);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectExaminationByEditionFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectExaminationByEditionFaild.getInfo());
		}
		return list;
	}
	
	
	/**
	 * 
	 * @Title: selectIdByInfo
	 * @Description: 根据试卷描述查找到其id
	 * @return: String
	 * @throws Exception 
	 */
	public String selectIdByInfo(String examinationInfo) throws Exception {
		String id = null;
		String sql = "SELECT id from teacher_examination WHERE examination_info = ?";
		Object param = examinationInfo;
		try {
			id = query(sql, new ScalarHandler<String>(), param);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectIdByInfoFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectIdByInfoFaild.getInfo());
		}
		return id;
	}
	
	
	/**
	 * 
	 * @Title: selectOneById
	 * @Description: 根据id查找出对应的试卷
	 * @return: TeacherExaminationVo
	 * @throws Exception 
	 */
	public TeacherExaminationVo selectOneById(String id) throws Exception {
		TeacherExaminationVo teacherExaminationVo = new TeacherExaminationVo();
		String sql = "SELECT teacher_examination.id, teacher_examination.examination_info, teacher_examination.edition_id, teacher_examination.unit_id, teacher_examination.examination_persist_time, teacher_examination.examination_create_username, teacher_examination.examination_questions_type, teacher_examination.examination_time, teacher_examination.examination_is_delete FROM teacher_examination WHERE teacher_examination.id = ?";
		Object param = id;
		try {
			teacherExaminationVo = query(sql, new ExpandBeanHandler<TeacherExaminationVo>(TeacherExaminationVo.class), param);
		} catch (ContextException e) {
			logger.error(DaoExceptionEnum.SelectOneByIdFaild.getInfo(),e);
			throw new Exception(DaoExceptionEnum.SelectOneByIdFaild.getInfo());
		}
		return teacherExaminationVo;
	}
	
}
