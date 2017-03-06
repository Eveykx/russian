package cn.edu.nenu.clzc.commons.enumeration.exception;

public enum DaoExceptionEnum {
	/*系统模块定义异常枚举开始*/
	GetRolesByUsernameFaild("根据用户名查询角色异常！",10001),
	
	GetPermissionsByUsernameFaild("根据用户名查询权限异常！",10002),
	
	GetUserByUsernameFaild("根据用户名获取用户信息异常！",10003),
	
	SysPermissionDaoInsertFaild("权限插入失败",10004),
	
	/*系统模块定义异常枚举结束*/	
	
	
	/*留言板模块定义异常枚举开始*/
	AddMessageFaild("增添一条留言失败", 20001),
	
	UpdateMessageFaild("更改一条留言的显示状态失败", 20003),
	
	SelectAllMessageFaild("所有留言的分页查询失败", 20004),
	
	SelectByUserNameFaild("搜索用户的用户名来查找对应的留言失败", 20005),
	
	SelectFirstPageMessageFaild("留言板首页的分页显示失败", 20006),
	
	SelectByIdFaild("根据留言的id查看它的详细信息失败", 20007),
	
	SelectAllPageFaild("计算全部页数异常", 20008),
	

	SelectLikePageFaild("模糊查询计算全部页数异常", 20009), 

	SelectFirstPageMessagePageFaild("计算前台页面可以显示的留言的分页页数异常", 20010), 
	
	SelectByUserNamePageFaild("计算模糊查询留言分页页数的方法异常", 20011),
	
	/*留言板模块定义异常枚举结束*/
	
	
	 /* 册模块定义异常枚举开始 */
	
		AddEditionFaild("添加试卷失败", 30001), 
		
		UpdateEditionFaild("修改册的状态失败", 30002), 
		
		SelectEditionFaild("查找可见的册失败",30003),
		
		SelectBackEditionFaild("查找所有的册失败",30008),

		
		/* 册模块定义异常枚举结束*/

		 
		/*单元模块定义异常枚举开始*/
			
		AddUnitFaild("添加单元失败",30004),
			
		UpdateUnitFaild("修改单元失败",30005),
			
		SelectUnitByEditionFaild("根据册名查找单元失败",30006),
			
		SelectFirstUnitPageFaild("查找前台显示的单元数失败",30007),
		
		SelectBackUnitByEditionFaild("查找后台显示的单元失败",30009),
			
		/*单元模块定义异常枚举结束*/
	
	
	/*小题定义异常枚举开始*/
	
	AddQuestionFaild("添加一道小题失败", 31001),
	
	DeleteQuestionFaild("删除一道小题失败", 31002),
	
	SelectQuestionFaild("查询所有可见小题失败", 31003),
	
	SelectAllQuestionFaild("查询所有小题失败", 31004), 
	
	CheckQuestionNumberFaild("检查小题编号是否重复失败", 31005),

	/*小题定义异常枚举结束*/
	
	/*试卷类型异常枚举开始*/
	AddQuestionsTypeFaild("增加一种题型失败", 32001),
	
	DelelteQuestionsTypeFaild("删除一种题型失败", 32002),
	
	SelectTypeFaild("查找可见题型失败", 32003),
	
	SelectAllTypeFaild("查找所有题型失败", 32004),
	
	SelectByIdlTypeFaild("根据id查找对应类型名失败", 32005),
	
	/*试卷类型异常枚举结束*/
	
	
	
	/*试卷模块异常枚举开始*/
	AddExaminationFaild("添加一套试卷失败", 33001),
	
	DeleteExaminationFaild("删除一套试卷失败", 33002),
	
	SelectExaminationByUnitFaild("分页查询出所有可见试卷失败", 33003),
	
	SelectExaminationByUnitPageFaild("分页查询出所有可见试卷页数失败", 33004),
	
	SelectAllExaminationByUnitFaild("分页查询出所有试卷失败", 33005),
	
	SelectAllExaminationByUnitPageFaild("分页查询出所有试卷页数失败", 33006),
	
	SelectExaminationByEditionFaild("查询出册总综合测试题失败", 33007),
	
	SelectIdByInfoFaild("根据试卷描述查找到其id", 33008),
	
	SelectOneByIdFaild("根据id查找到对应的试卷失败", 33009),
	/*试卷模块异常枚举结束*/
	
	
	

	/*自组卷异常枚举定义开始*/
	
	AddStudentTestFaild("添加自组卷失败",33001),
	
	DeleteStudentTestFaild("删除学生自组卷失败",33002),
	
	SelectStudentTestByStudentTestInfoFaild("根据自组卷信息查询学生自组卷失败",33003),
	
	SelectStudentTestByStudentIdFaild("根据学生ID查询可见的学生自组卷失败",33004),
	
	SelectAllStudentTestByStudentIdFaild("根据学生的ID查询该学生所有自组卷失败",33005),
	
	SelectStudentTestPageFaild("查询可见学生自组卷数失败",33006),
	
	SelectStudentTestByStudentTestInfoPageFaild("根据学生自组卷描述模糊查询自组卷数失败",33007),
	
	SelectAllStudentTestPageFaild("查询所有学生自组卷数失败",33008),
	
	/*自组卷异常枚举定义结束*/
	
	/*文章主题异常枚举定义开始*/
	
	AddQuestionsArticleFaild("添加大题文章失败",35001),
	
	DeleteQuestionsArticleFaild("修改大题文章的显示状态失败", 35002),
	
	SelectQuestionsArticlesByuestionsArticlesIdFaild("根据文章大题主键Id来查找答应大题下的文章失败",35003),
	
	/*文章主题异常枚举定义结束*/

	
	
	
	/*大题模块异常枚举开始*/
	AddQuestionsFaild("添加一道大题失败", 34001),
	
	DeleteQuestionsFaild("更改一道大题是否可见失败", 34002),
	

	SelectQuestionsByExamFaild("按照一套试卷的规定题型随即抽取题目失败", 34003),
	
	SelectAllQuestionsByExamFaild("按照试卷查询出所有的大题失败", 34004),
	
	SelectQuestionsByTypeFaild("按照一套试卷的规定题型随即抽取题目失败", 34005),
	
	CheckNumberFaild("检查大题编号是否已存在失败", 34006),

	/* 大题模块定义异常枚举结束*/


	/* 大题模块定义异常枚举结束*/ 

	/*学生完成试卷模块异常枚举定义开始*/
	
	AddStudentDoneFaild("添加学生已经完成试卷失败",36001),
	

	SelectExaminationOrTestIdFaild("查询学生已完成的试卷失败",36002),
	
	UpdataStudentDoneMarkFaild("更新学生已完成的试卷成绩失败",36003),
	
	/*学生完成试卷模块异常枚举定义结束*/
	
	/*学生完成客观题定义异常枚举开始*/
	AddObjQuestionFaild("增加一道学生完成的客观题失败", 35001),
	
	AddTeacherCommentFaild("老师疲倦时进行备注失败", 35002),
	
	JudgeQuestionFaild("判断该客观题学生答案正误失败", 35003),
	
	SelectObjQuestionsFaild("根据小题题号查询出学生的答案和老师的批改失败", 35004),
	
	
	/*学成完成客观题定义异常枚举结束*/
	
	/*学生完成主观题定义异常枚举开始*/
	AddSubQuestionFaild("添加一道学生完成的主观小题失败", 36001),
	
	AddSubTeacherCommentFaild("老师添加一条主观小题的批注失败", 36002),
	
	SelectSubQuestionFaild("根据小题id查询出学生的写过的试题失败", 36003),
	
	

	
	

	
	
	


	
	
	/*后台管理用户信息模块定义异常开始*/
	InsertUserFaild("导入老师/学生账户信息失败",40001),
	
	UpdateUserFaild("修改老师/学生信息失败",40002),           ;
	/*后台管理用户信息模块定义异常开始*/
	private int id;
	private String info;

	DaoExceptionEnum(String info,int id) {
		this.id=id;
		this.info=info;
	}
	

	public int getId() {
		return id;
	}

	public String getInfo() {
		return info;
	}

	
}
