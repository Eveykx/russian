package cn.edu.nenu.clzc.commons.enumeration.question;

import java.util.Random;

import org.apache.commons.io.filefilter.PrefixFileFilter;

public enum QuestionsEnum {
	
	RussianToChinese("01", "俄译汉"),
	
	ChineseToRussian("02", "汉译俄"),
	
	ChoiceQuestion("03", "选择题"),
	
	CombineSentence("04", "连词成句"),
	
	ClozeTestQuestion("05", "完形填空题"),
	
	TranslateUnderlineSentence("06", "划线句翻译"),
	
	MakeSentence("07", "造句"),
	
	Composition("08", "作文"),
	
	CompleteSentence("09", "完成句子补全对话"),
	
	ChangeTheWord("10", "变换词的形式填空题"),
	
	ChooseTheWord("11", "选词填空题");
	

	
	
	private String prefix;
	
	private String type;
	
	
	private QuestionsEnum(String prefix, String type) {
		this.prefix = prefix;
		this.type = type;
	}
	
	private String generatorQuestionNumber(){
		int random = 0;
		random = new Double(Math.random()*9000).intValue()+1000;
		
		return prefix + random;
	}
	public static String generatorQuestionNumber(String questionNum){
		if (questionNum == null || questionNum.length() != 6) {
			throw new IllegalArgumentException();
		}
		int random = 0;
		random = new Double(Math.random()*9000).intValue()+1000;
		
		return questionNum.substring(0, 2) + random;
	}
	
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public static String getQuestionNum(String type){
		QuestionsEnum[] questionsEnums = QuestionsEnum.values();		
		QuestionsEnum tmpEnum = null;
		for (int i = 0; i < questionsEnums.length; i++) {
			QuestionsEnum questionsEnum = questionsEnums[i];			
			if (type != null){
				if (type.equals(questionsEnum.getType())) {
					tmpEnum = questionsEnum;
					break;
				}
			} 
		}		
		return tmpEnum.generatorQuestionNumber();
	}
	

	public static String getQuestionSixNum(String type){
		QuestionsEnum[] questionsEnums = QuestionsEnum.values();		
		QuestionsEnum tmpEnum = null;
		for (int i = 0; i < questionsEnums.length; i++) {
			QuestionsEnum questionsEnum = questionsEnums[i];			
			if (type != null){
				if (type.equals(questionsEnum.getType())) {
					tmpEnum = questionsEnum;
					break;
				}
			} 
		}		
		return tmpEnum.generatorQuestionSixNumber();
	}
	
	
	
	private String generatorQuestionSixNumber() {
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
		    int index = rand.nextInt(i);
		    int tmp = array[index];
		    array[index] = array[i - 1];
		    array[i - 1] = tmp;
		}
		int result = 0;
		for(int i = 0; i < 6; i++)
		    result = result * 10 + array[i];
		return prefix + result;
	}
	
	
	public static String generatorQuestionSixNumber(String questionNum) {
		if (questionNum == null || questionNum.length() != 8) {
			throw new IllegalArgumentException();
		}
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
		    int index = rand.nextInt(i);
		    int tmp = array[index];
		    array[index] = array[i - 1];
		    array[i - 1] = tmp;
		}
		int result = 0;
		for(int i = 0; i < 6; i++)
		    result = result * 10 + array[i];
		return questionNum.substring(0, 2) + result;
	}
	
	
}
