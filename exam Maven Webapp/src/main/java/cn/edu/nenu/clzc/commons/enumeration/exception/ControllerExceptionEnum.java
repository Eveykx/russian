package cn.edu.nenu.clzc.commons.enumeration.exception;

public enum ControllerExceptionEnum {
	/*系统模块开始*/
	UserLockedException("该用户名暂时不可登录，请联系管理员", 1000001),

	RoleNotAvailable("该角色暂时不可登录，请联系管理员", 1000002),
	
	UserNotFoundException("用户没找到！",10003),
	
	AuthorizationFaildException("授权失败！",10004),
	
	UnknownAccountException("未知的账号！",10005),
	
	IncorrectCredentialsException("密码错误",10006),
	
	AuthenticationException("认证失败！",10007),
	
	AuthorizationException("授权失败！",10008),
	
	AddPermissionFaild("添加权限失败！",10009),
	/*系统模块结束*/
	
	/*examination模块开始 id从2开始*/
	ExaminationEditionException("获取试卷页面的册失败",20001),
	
	GetUnitByEditionIdException("根据册的ID获取对应单元失败",20002),
	
	GetExaminationByUnitException("根据单元获取对应试卷失败",20003),
	
	GetExaminationOrTestQuestionException("按试卷查询可见大题失败",20004),
	
	GetStudentTestException("根据学生的ID查询学生自组卷失败",20005),
	
	AddStudentTestException("添加一个学生自组卷失败",20006),
	
	GetStudentDoneExaminationException("根据学生ID查询学生已完成的试卷失败",20007),
	
	/*examination模块结束 */
	
	/*teacher模块开始 id从3开始*/
	/*teacher模块结束*/
	
	/*studennt模块开始 id从4开始*/
	/*student模块结束*/

	
	/*message模块开始 id从5开始*/
	FrontPageException("进入留言板页面失败！", 50001),
	
	AddMessageException("增添留言失败！", 50002), 
	
	GetAllReplyException("获取所有回复失败", 50003), 
	
	BackPageException("进入后台留言板页面失败！", 50004), 
	
	UpdateMessageException("更改一条留言是否可见失败！", 50005),
	

	SelectByNameException("模糊查询结果页面显示失败！", 50006),


	/*message模块结束*/
	
	/*试卷后端开始*/
	 BackEditionException("ajax请求后端显示册失败！", 60001),
	 
	 BackUnitException("ajax请求后端显示单元失败！", 60002),
	 
	 EditionExaminationQuestionsException("ajax请求册总测试题的大题失败", 60003),
	 
	 BackExaminationException("ajax请求后端显示试卷失败！", 60003),
	 
	 BackQuestionsException("ajax请求后端显示具体试卷信息失败！", 60004),
	 
	 AddExaminationException("添加一套试卷失败！", 60005),
	 
	 AddEditionException("添加一个册失败！", 60006),
	 
	 AddUnitException("添加一个单元失败！", 60007),
	 
	 addQuestionsException("题库中添加一道大题失败", 60008),
	 
	 UpdateEditionException("更改一个册是否可见失败", 60008),
	 
	 UpdateUnitException("更改一个单元是否可见", 60009),
	 
	 UpdateExaminationException("更改一套试卷是否可见", 60010),
	 
	 GetDoneExaminationException("ajax请求显示该学生做过的试卷列表失败", 60011);
	
	 
		
	
	
	private int id;
	private String info;

	ControllerExceptionEnum(String info, int id) {
		this.id = id;
		this.info = info;
	}

	public int getId() {
		return id;
	}

	public String getInfo() {
		return info;
	}

}
