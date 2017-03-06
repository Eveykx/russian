package cn.edu.nenu.clzc.service.test.examination;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.edu.nenu.clzc.commons.core.BaseTest;
import cn.edu.nenu.clzc.commons.exception.ContextException;
import cn.edu.nenu.clzc.commons.vo.examination.ParamQuestionVo;
import cn.edu.nenu.clzc.commons.vo.examination.ParamQuestionsVo;
import cn.edu.nenu.clzc.commons.vo.teacher.TeacherExaminationVo;
import cn.edu.nenu.clzc.service.examination.ParamQuestionsService;

public class ParamQuestionsServiceTest extends BaseTest {

	ParamQuestionsService paramQuestionsService = new ParamQuestionsService();
	
	@Test
	public void testAddQuestions() throws ContextException {
		List<ParamQuestionVo> list = new ArrayList<ParamQuestionVo>();
		for(int i = 0; i < 6; i++) {
			ParamQuestionVo paramQuestionVo = new ParamQuestionVo();
			paramQuestionVo.setQuestionOutline("xx#yy#zz#" + i);
			paramQuestionVo.setQuestionAnalysis("!!!" + i);
			paramQuestionVo.setQuestionAnswer("!!!" + i);
			paramQuestionVo.setQuestionMark(2.0);
			list.add(paramQuestionVo);
		}
		ParamQuestionsVo paramQuestionsVo = new ParamQuestionsVo();
		paramQuestionsVo.setQuestionsTitle("标题5");
		paramQuestionsVo.setQuestionsInfo("简介5");
		paramQuestionsVo.setQuestionsTypeId("a");
		paramQuestionsVo.setQuestionsArticle("文章5");
		paramQuestionsVo.setQuestionsArticleInfo("文章简介5");
		paramQuestionsVo.setExaminationId("1");
		paramQuestionsService.addQuestions(paramQuestionsVo, list);
	}

	@Test
	public void testDeleteQuestions() throws ContextException {
		paramQuestionsService.deleteQuestions("df83000c-2f37-4f7d-8954-5f010c3848a9", "1");
	}

	@Test
	public void testSelectQuestionsByExam() throws ContextException {
		List<ParamQuestionsVo> list = new ArrayList<ParamQuestionsVo>();
		list = paramQuestionsService.selectQuestionsByExam("1");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getQuestionsTitle());
			List<ParamQuestionVo> questionList = new ArrayList<ParamQuestionVo>();
			questionList = list.get(i).getQuestionlist();
			for(int j = 0; j < questionList.size(); j++) {
				String[] s = questionList.get(j).getOutline();
				for(int k = 0; k < s.length; k++) {
					System.out.print(s[k]);
				}
			}
		}
	}

	@Test
	public void testSelectAllQuestionsByExam() throws ContextException {
		List<ParamQuestionsVo> list = new ArrayList<ParamQuestionsVo>();
		list = paramQuestionsService.selectAllQuestionsByExam("1");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getQuestionsTitle());
			List<ParamQuestionVo> questionList = new ArrayList<ParamQuestionVo>();
			questionList = list.get(i).getQuestionlist();
			for(int j = 0; j < questionList.size(); j++) {
				String[] s = questionList.get(j).getOutline();
				for(int k = 0; k < s.length; k++) {
					System.out.print(s[k]);
				}
			}
		}
	}

	@Test
	public void testSelectQuestionsByType() throws ContextException {
		TeacherExaminationVo teacherExaminationVo = new TeacherExaminationVo();
		teacherExaminationVo.setExaminationQuestionsType("俄译汉#选择题#连词成句");
		List<ParamQuestionsVo> list = new ArrayList<ParamQuestionsVo>();
		list = paramQuestionsService.selectQuestionsByType(teacherExaminationVo);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getQuestionsTitle());
			List<ParamQuestionVo> questionList = new ArrayList<ParamQuestionVo>();
			questionList = list.get(i).getQuestionlist();
			for(int j = 0; j < questionList.size(); j++) {
				String[] s = questionList.get(j).getOutline();
				for(int k = 0; k < s.length; k++) {
					System.out.print(s[k]);
				}
			}
		}
	}

}
