package cn.edu.nenu.clzc.service.examination;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nenu.clzc.commons.entites.teacher.TeacherExamination;
import cn.edu.nenu.clzc.commons.exception.ContextException;
import cn.edu.nenu.clzc.commons.extend.ServiceExtend;
import cn.edu.nenu.clzc.commons.vo.teacher.TeacherExaminationVo;

/**
 * 
 * @author 我要睡觉了
 * @Title TeacherExaminationService.java
 * @Description 试题的service
 * @time 2016年12月4日 下午8:49:57
 */

public class TeacherExaminationService extends ServiceExtend {

	
	/**
	 *  
	 * @Title: addExamination
	 * @Description: 添加一套试卷
	 * @return: String
	 * @throws ContextException 
	 */
	public String addExamination(TeacherExaminationVo teacherExaminationVo) throws ContextException {
		String id = null;
		try {
			id = teacherExaminationDao.addExamination(teacherExaminationVo);
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return id;
	}
	
	
	/**
	 * 
	 * @Title: deleteExamination
	 * @Description: 更改一套试题是否可见
	 * @return: int
	 * @throws: ContextException
	 */
	public int deleteExamination(String id, String value) throws ContextException {
		int temp = 0;
		try {
			temp = teacherExaminationDao.deleteExamination(id, value);
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return temp;
	}
	
	
	/**
	 * 
	 * @Title: selectExaminationByUnit
	 * @Description: 根据单元分页查询出所有可见试卷
	 * @return: List<TeacherExamination>
	 * @throws: ContextException
	 */
	public List<TeacherExaminationVo> selectExaminationByUnit(String unitId, int currentPage) throws ContextException {
		List<TeacherExaminationVo> list = new ArrayList<TeacherExaminationVo>();
		try {
			list = teacherExaminationDao.selectExaminationByUnit(unitId, currentPage);
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return list;
	}
	
	
	/**
	 * 
	 * @Title: selectExaminationByUnitPage
	 * @Description: 根据单元查询出可见试卷的分页总页数
	 * @return: int
	 * @throws: ContextException
	 */
	public int selectExaminationByUnitPage(String unitId) throws ContextException {
		int size;
		try {
			size = teacherExaminationDao.selectExaminationByUnitPage(unitId);
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return size;
	}
	
	
	/**
	 * 
	 * @Title: selectAllExaminationByUnit
	 * @Description: 根据单元分页查询出所有试卷
	 * @return: List<TeacherExamination>
	 * @throws ContextException 
	 */
	public List<TeacherExaminationVo> selectAllExaminationByUnit(String unitId, int currentPage) throws ContextException {
		List<TeacherExaminationVo> list = new ArrayList<TeacherExaminationVo>();
		try {
			list = teacherExaminationDao.selectAllExaminationByUnit(unitId, currentPage);
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return list;
	}
	
	
	/**
	 * 
	 * @Title: selectAllExaminationByUnitPage
	 * @Description: 根据单元查询出所有试卷的分页总页数
	 * @return: int
	 * @throws: ContextException
	 */
	public int selectAllExaminationByUnitPage(String unitId) throws ContextException {
		int size;
		try {
			size = teacherExaminationDao.selectAllExaminationByUnitPage(unitId);
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return size;
	}
	
	
	/**
	 * 
	 * @Title: selectExaminationByEdition
	 * @Description: 根据册id查询出固定的综合测试题
	 * @return: List<TeacherExaminationVo>
	 * @throws ContextException 
	 */
	public List<TeacherExaminationVo> selectExaminationByEdition(String editionId) throws ContextException {
		List<TeacherExaminationVo> list = new ArrayList<TeacherExaminationVo>();
		try {
			list = teacherExaminationDao.selectExaminationByEdition(editionId);
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return list;
	}

	
	/**
	 * 
	 * @Title: selectIdByInfo
	 * @Description: 根据试卷描述查找到其id
	 * @return: String
	 * @throws ContextException 
	 */
	public String selectIdByInfo(String examinationInfo) throws ContextException {
		String id = null;
		try {
			id = teacherExaminationDao.selectIdByInfo(examinationInfo);
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return id;
	}
	
	
	/**
	 * 
	 * @Title: selectOneById
	 * @Description: 根据id查找出对应的试卷
	 * @return: TeacherExaminationVo
	 * @throws ContextException 
	 */
	public TeacherExaminationVo selectOneById(String id) throws ContextException { 
		TeacherExaminationVo teacherExaminationVo = new TeacherExaminationVo();
		try {
			teacherExaminationVo = teacherExaminationDao.selectOneById(id);
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return teacherExaminationVo;
	}
	
	
	
}
