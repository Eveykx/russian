package cn.edu.nenu.clzc.service.examination;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nenu.clzc.commons.entites.examination.ParamQuestions;
import cn.edu.nenu.clzc.commons.entites.examination.ParamQuestionsArticle;
import cn.edu.nenu.clzc.commons.enumeration.question.QuestionsEnum;
import cn.edu.nenu.clzc.commons.exception.ContextException;
import cn.edu.nenu.clzc.commons.extend.ServiceExtend;
import cn.edu.nenu.clzc.commons.vo.examination.ParamQuestionVo;
import cn.edu.nenu.clzc.commons.vo.examination.ParamQuestionsVo;
import cn.edu.nenu.clzc.commons.vo.teacher.TeacherExaminationVo;

/**
 * 
 * @author 我要睡觉了
 * @Title ParamQuestionsService.java
 * @Description 大题的service
 * @time 2016年12月7日 上午8:54:54
 */

public class ParamQuestionsService extends ServiceExtend {

	
	/**
	 * 
	 * @Title: addQuestions
	 * @Description: 添加一道大题，同时添加该大题的大题文章和包含的小题
	 * @return: String 
	 * @throws ContextException 
	 */
	public String addQuestions(ParamQuestionsVo paramQuestionsVo, List<ParamQuestionVo> questionlist) throws ContextException {
		String id = null;
		ParamQuestionsArticle paramQuestionsArticle = new ParamQuestionsArticle();
		// 大题文章的属性提取出来
		String questionsArticle = paramQuestionsVo.getQuestionsArticle();
		String questionsArticleInfo = paramQuestionsVo.getQuestionsArticleInfo();
		// 存进大题文章对象
		paramQuestionsArticle.setArticle(questionsArticle);
		paramQuestionsArticle.setArticleInfo(questionsArticleInfo);
		try {
			// 生成大题编号
			String type = paramQuestionsTypeDao.selectById(paramQuestionsVo.getQuestionsTypeId());
			String questionsNumber = QuestionsEnum.getQuestionNum(type);
			if(paramQuestionsDao.checkNumber(questionsNumber))
				questionsNumber = QuestionsEnum.generatorQuestionNumber(questionsNumber);
			paramQuestionsVo.setQuestionsNumber(questionsNumber);
			id = paramQuestionsDao.addQuestions(paramQuestionsVo);
			if(questionsArticle != null && questionsArticleInfo != null) {
				paramQuestionsArticle.setArticleQuestionsId(id);
				paramQuestionsArticleDao.addQuestionsArticle(paramQuestionsArticle);
			}
			for(int i = 0; i < questionlist.size(); i++) {
				ParamQuestionVo paramQuestionVo = questionlist.get(i);				
				String questionNumber = QuestionsEnum.getQuestionSixNum(type);
				if(paramQuestionDao.checkQuestionNumber(questionNumber))
					questionNumber = QuestionsEnum.generatorQuestionSixNumber(questionNumber);
				paramQuestionVo.setQuestionNumber(questionNumber);
				paramQuestionVo.setQuestionsId(id);
				paramQuestionDao.addQuestion(paramQuestionVo);
			}
			
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return id;
	}
	
	
	/**
	 * 
	 * @Title: deleteQuestions
	 * @Description: 更改大题是否可见
	 * @return: int
	 * @throws ContextException 
	 */
	public int deleteQuestions(String id, String value) throws ContextException {
		int temp = 0;
		try {
			temp = paramQuestionsDao.deleteQuestions(id, value);
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return temp;
	}
	
	
	/**
	 * 
	 * @Title: selectQuestionsByExam
	 * @Description: 按照试卷查询出所有可见的大题
	 * @return: List<ParamQuestions>
	 * @throws ContextException 
	 */
	public List<ParamQuestionsVo> selectQuestionsByExam(String examinationId) throws ContextException {
		List<ParamQuestionsVo> list = new ArrayList<ParamQuestionsVo>();
		try {
			list = paramQuestionsDao.selectQuestionsByExam(examinationId);
			for(int i = 0; i < list.size(); i++) {
				String questionsArticle = paramQuestionsArticleDao.selectQuestionsArticlesByuestionsArticlesId(list.get(i).getId()).getArticle();
				String questionsArticleInfo = paramQuestionsArticleDao.selectQuestionsArticlesByuestionsArticlesId(list.get(i).getId()).getArticleInfo();
				list.get(i).setQuestionsArticle(questionsArticle);
				list.get(i).setQuestionsArticleInfo(questionsArticleInfo);
				List<ParamQuestionVo> questionlist = paramQuestionDao.selectQuestion(list.get(i).getId());
				for(int j = 0; j < questionlist.size(); j++) {
					getOutline(questionlist.get(j));
				}
				list.get(i).setQuestionlist(questionlist);
			}
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return list;
	}
	
	
	/**
	 * 
	 * @Title: selectAllQuestionsByExam
	 * @Description: 按照试卷查询出所有的大题
	 * @return: List<ParamQuestions>
	 * @throws ContextException 
	 */
	public List<ParamQuestionsVo> selectAllQuestionsByExam(String examinationId) throws ContextException {
		List<ParamQuestionsVo> list = new ArrayList<ParamQuestionsVo>();
		try {
			list = paramQuestionsDao.selectAllQuestionsByExam(examinationId);
			for(int i = 0; i < list.size(); i++) {
				String questionsArticle = paramQuestionsArticleDao.selectQuestionsArticlesByuestionsArticlesId(list.get(i).getId()).getArticle();
				String questionsArticleInfo = paramQuestionsArticleDao.selectQuestionsArticlesByuestionsArticlesId(list.get(i).getId()).getArticleInfo();
				list.get(i).setQuestionsArticle(questionsArticle);
				list.get(i).setQuestionsArticleInfo(questionsArticleInfo);
				List<ParamQuestionVo> questionlist = paramQuestionDao.selectAllQuestion(list.get(i).getId());
				for(int j = 0; j < questionlist.size(); j++) {
					getOutline(questionlist.get(j));
				}
				list.get(i).setQuestionlist(questionlist);
			}
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return list;
	}
	
	
	/**
	 * 
	 * @Title: selectQuestionsByType
	 * @Description: 根据一套试卷所给的题型随即把大题抽取出来
	 * @return: List<ParamQuestionsVo>
	 * @throws: ContextException
	 */
	public List<ParamQuestionsVo> selectQuestionsByType(TeacherExaminationVo teacherExaminationVo) throws ContextException {
		List<ParamQuestionsVo> list = new ArrayList<ParamQuestionsVo>();
		String[] questionsType = getQuestionsType(teacherExaminationVo);
		int size = questionsType.length;
		try {
			for(int i = 0; i < size; i++) {
				ParamQuestionsVo paramQuestionsVo = new ParamQuestionsVo();
				paramQuestionsVo = paramQuestionsDao.selectQuestionsByType(questionsType[i]);
				String questionsArticle = paramQuestionsArticleDao.selectQuestionsArticlesByuestionsArticlesId(paramQuestionsVo.getId()).getArticle();
				String questionsArticleInfo = paramQuestionsArticleDao.selectQuestionsArticlesByuestionsArticlesId(paramQuestionsVo.getId()).getArticleInfo();
				paramQuestionsVo.setQuestionsArticle(questionsArticle);
				paramQuestionsVo.setQuestionsArticleInfo(questionsArticleInfo);
				List<ParamQuestionVo> questionlist = paramQuestionDao.selectQuestion(paramQuestionsVo.getId());
				for(int j = 0; j < questionlist.size(); j++) {
					getOutline(questionlist.get(j));
				}
				paramQuestionsVo.setQuestionlist(questionlist);
				list.add(paramQuestionsVo);
			}
		} catch (Exception e) {
			logger.error(e);
			throw new ContextException(e);
		}
		return list;
	}
	

	
	/**
	 * 
	 * @Title: getOutline
	 * @Description: 将选择类型的题的题干和选项放入数组中
	 * @return: String[]
	 */
	public String[] getOutline(ParamQuestionVo paramQuestionVo) {
		int size = paramQuestionVo.getQuestionOutline().length();
		String[] outline = paramQuestionVo.getQuestionOutline().split("#", size);
		paramQuestionVo.setOutline(outline);
		return outline;
	}
	
	
	/**
	 * 
	 * @Title: getQuestionsType
	 * @Description: 将一套试卷中包含的题型存入数组中
	 * @return: String[]
	 * @throws:
	 */
	public String[] getQuestionsType(TeacherExaminationVo teacherExaminationVo) {
		int size = teacherExaminationVo.getExaminationQuestionsType().length();
		String[] questionsType = teacherExaminationVo.getExaminationQuestionsType().split("#", size);
		teacherExaminationVo.setQuestionsType(questionsType);
		return questionsType;
	}
	

}
