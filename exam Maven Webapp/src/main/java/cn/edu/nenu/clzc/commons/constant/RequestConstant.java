package cn.edu.nenu.clzc.commons.constant;

import cn.edu.nenu.clzc.commons.core.SystemConstant;

public class RequestConstant extends SystemConstant{
	/*系统模块定义开始*/
	
	/*user控制器*/
	public static final String USER_CONTROLLER="/bg/user";
	/*user控制器下面的登录action*/
	public static final String LOGIN_CONTROLLER = "/bg/user/login";
	/*user控制器下面的退出登录action*/
	public static final String LOGOUT_CONTROLLER = "/bg/user/logout";
	/*user控制器下面的无权访问action*/
	public static final String UNAUTHORIZED_CONTROLLER ="/bg/user/unauthorized" ;
	/*角色控制器*/
	public static final String SYSPERMISSION_CONTROLLER ="/bg/admin/permission" ;
	/*跳转到添加角色页面*/
	public static final String ADD_PERMISSION = "/bg/admin/permission/add" ;
	
	public static final String TO_ADD_PERMISSION = "/bg/admin/permission/to-add" ;
	
	public static final String TO_PERMISSION_LIST = "/bg/admin/permission/to-list" ;
	
	public static final String EXAMPLE_CONTROLLER = "/bg/example" ;
	
	public static final String EXAMPLE_CONTROLLER_MAPPING = "mapping" ;
	
	/*系统模块定义结束*/
	
	
	
	
	/*留言模块定义开始*/
	
	/*留言板前段控制器*/
	public static final String USERMESSAGE_CONTROLLER = "/bg/user/usermessage";
	/*留言板后端控制器*/
	public static final String USERMESSAGE_BACK_CONTROLLER = "/bg/teacher/usermessage";
	/*跳转留言板前台首页*/
	public static final String DISPATCH_FRONT_MESSAGE = "to_frontpage";
	/*ajax请求前段留言板的首页*/
	public static final String AJAX_GET_FRONT_MESSAGE = "frontpage";
	/*前往增加留言的页面*/
	public static final String DISPATCH_ADD_MESSAGE = "to_add";
	/*增添一条留言*/
	public static final String ADD_MESSAGE = "add";
	/*ajax请求一条留言的所有回复*/
	public static final String AJAX_GET_ALL_REPLY = "all_reply";
	/*跳转留言板后台首页*/
	public static final String DISPATCH_BACK_MESSAGE = "to_backpage";
	
	public static final String AJAX_GET_BACK_MESSAGE1 = "backpage";
	
	public static final String UPDATE_MESSAGE = "update";
	
	public static final String DISPATCH_SELECT_BY_NAME = "to_select_by_name";

	public static final String AJAX_SELECT_BY_NAME = "select_by_name";

	public static final String DISPATCH_REPLY_MESSAGE = "to_reply";

	public static final String REPLY_MESSAGE = "reply";


	
	/*留言模块定义结束*/
	
	
		
	
	
	/*试卷前段控制器*/
	public static final String EXAMINATION_CONTROLLER = "bg/user/examination";
	/*跳转到试卷前台首页*/
	public static final String DISPATCH_FRONT_EXAMINATION = "to_examfrontpage";
	/*ajax请求前段留言板的首页*/
	public static final String AJAX_GET_FRONT_EXAMINATION = "examfrontpage";
	/*ajax请求前台试卷册部分对应的单元*/
	public static final String AJAX_GET_UNIT_BY_EDITIONID = "edition_unitpage";
	/*ajax请求前台试卷部分单元对应的试卷*/
	public static final String AJAX_GET_EXAMINATION_BY_UNIT = "unit_examinationpage";
	/*ajax请求前台试卷部分试卷对应的所有题*/
	public static final String AJAX_GET_EXAMINATION_OR_TEST_QUESTIONS = "examinationOrTestQuestionsPage";
	/*跳转到前台显示试卷具体内容的页面*/
	public static final String DISPATCH_GET_EXAMINATION = "to_frontGetExamination";
    /*添加学生自组卷*/
	public static final String ADD_STUDENT_TEST = "add_studentTest";
	/*ajax请求前台学生自组卷*/
	public static final String AJAX_GET_STUDENT_TEST = "studentTestPage";
	/*跳转到增加学生自组卷页面*/
	public static final String DISPATCH_ADD_STUDENT_TEST = "to_addStudentTest";
	/*ajax请求查询所有题型*/
	public static final String AJAX_GET_QUESTION_TYPE = "questionType";
	/*ajax请求 根据题型查询可见的大题*/
	public static final String AJAX_GET_QUESTIONS = "question";
	/*跳转到前台学生已完成试卷页面*/
	public static final String DISPATCH_FRONT_STUDENT_DONE = "to_frontStudentDone";
	
	/*ajax请求 查询出学生已经完成的试卷*/
	public static final String AJAX_GET_STUDENT_DONE_EXAMINATION = "studentDonePage";

	
	
/*试卷后端模块定义开始*/
	
	public static final String EXAMINATION_BACK_CONTROLLER = "/bg/teacher/examination";
	
	public static final String DISPATCH_BACK_EDITION = "to_back_edition";
	
	public static final String AJAX_GET_BACK_EDITION = "back_edition";

	public static final String AJAX_GET_BACK_UNIT = "back_unit";

	public static final String AJAX_GET_EDITION_EXAMINATION_QUESTIONS = "back_edition_questions";
	
	public static final String DISPATCH_BACK_EXAMINATION = "to_back_exam";
	
	public static final String AJAX_GET_BACK_EXAMINATION = "back_exam";
	
	public static final String DISPATCH_QUESTIONS = "to_questions";
	
	public static final String AJAX_GET_BACK_QUESTIONS = "questions";

	public static final String DISPATCH_ADD_EXAMINATION = "to_add_examination";

	public static final String ADD_EXAMINATION = "add_examination";

	public static final String DISPATCH_ADD_EDITION = "to_add_edition";

	public static final String ADD_EDITION = "add_edition";

	public static final String DISPATCH_ADD_UNIT = "to_add_unit";
	
	public static final String ADD_UNIT = "add_unit";

	public static final String AJAX_UPDATE_EDITION = "delete_edition";

	public static final String AJAX_UPDATE_UNIT = "delete_unit";

	public static final String AJAX_UPDATE_EXAMINATION = "delete_examination";

	public static final String DISPATCH_STUDENT_DONE = "to_student_done";

	public static final String AJAX_GET_DONE_EXAMINATION = "done_questions";

	public static final String DISPATCH_ADD_QUESTIONS = "to_add_questions";
	
	public static final String ADD_QUESTIONS = "add_questions";
	

	
	
	
	
	
	
	
}
