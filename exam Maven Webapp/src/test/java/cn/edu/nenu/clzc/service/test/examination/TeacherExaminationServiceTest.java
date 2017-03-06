package cn.edu.nenu.clzc.service.test.examination;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.edu.nenu.clzc.commons.core.BaseTest;
import cn.edu.nenu.clzc.commons.exception.ContextException;
import cn.edu.nenu.clzc.commons.vo.teacher.TeacherExaminationVo;
import cn.edu.nenu.clzc.service.examination.TeacherExaminationService;

public class TeacherExaminationServiceTest extends BaseTest {

	TeacherExaminationService teacherExaminationService = new TeacherExaminationService();
	
	@Test
	public void testAddExamination() throws ContextException {
		TeacherExaminationVo teacherExaminationVo = new TeacherExaminationVo();
		teacherExaminationVo.setEditionId("1");
		teacherExaminationVo.setExaminationPersistTime(60.00);
		teacherExaminationVo.setExaminationCreateUsername("小乖柴");
		teacherExaminationVo.setExaminationInfo("第一套测试试卷");
		teacherExaminationService.addExamination(teacherExaminationVo);
	}

	@Test
	public void testDeleteExamination() throws ContextException {
		teacherExaminationService.deleteExamination("1", "909a7ee4-93ac-41bf-a74e-ee645aaf7ebd");
	}

	@Test
	public void testSelectExaminationByUnit() throws ContextException {
		List<TeacherExaminationVo> list = new ArrayList<TeacherExaminationVo>();
		list = teacherExaminationService.selectExaminationByUnit("1", 1);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getExaminationInfo());
		}
	}

	@Test
	public void testSelectExaminationByUnitPage() throws ContextException {
		int i = 0;
		i = teacherExaminationService.selectExaminationByUnitPage("1");
		System.out.println(i);
	}

	@Test
	public void testSelectAllExaminationByUnit() throws ContextException {
		List<TeacherExaminationVo> list = new ArrayList<TeacherExaminationVo>();
		list = teacherExaminationService.selectAllExaminationByUnit("1", 1);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getExaminationInfo());
		}
	}

	@Test
	public void testSelectAllExaminationByUnitPage() throws ContextException {
		int i = 0;
		i = teacherExaminationService.selectAllExaminationByUnitPage("1");
		System.out.println(i);
	}

	@Test
	public void testSelectExaminationByEdition() throws ContextException {
		List<TeacherExaminationVo> list = new ArrayList<TeacherExaminationVo>();
		list = teacherExaminationService.selectExaminationByEdition("1");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getExaminationInfo());
		}
	}

	@Test
	public void testSelectIdByInfo() throws ContextException {
		String id = null;
		id = teacherExaminationService.selectIdByInfo("第一套测试试卷");
		System.out.println(id);
	}

}
