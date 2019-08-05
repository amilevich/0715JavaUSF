package model;

import java.util.TreeMap;

import seed.QuestionAnswers;

public class QuestionAnswer {
	public static TreeMap<Integer, QuestionAnswer> questionAnswers = new TreeMap<Integer, QuestionAnswer>();
	public String question;
	public TreeMap<Integer, Answer> answers = new TreeMap<Integer, Answer>();
	
	public QuestionAnswer(Integer qaID, String question, TreeMap<Integer, Answer> answers) {
		//this.qaID = qaID;
		this.question = question;
		this.answers = answers;
		questionAnswers.put(qaID, this);
	}

	
	public static Integer getNumberOfFields(Integer qaID) {
		return questionAnswers.get(qaID).answers.size();
	}
	
	public static String displayQuestion(Integer qaID) {
		return questionAnswers.get(qaID).question;
	}
	
	public static String displayFieldString(Integer qaID, Integer fieldID) {
		
		return questionAnswers.get(qaID).answers.get(fieldID).answer;
	}
	
	public static Integer displayField(Integer qaID, Integer fieldID) {
		System.out.println(  questionAnswers.get(qaID).answers.get(fieldID).answer  );
		return questionAnswers.get(qaID).answers.get(fieldID).nextQuestionNumber;
	}
	
	public static Integer displayField(Integer qaID) {
		try {
			return questionAnswers.get(qaID).answers.get(1).nextQuestionNumber;
		} catch (NullPointerException e) {
			return questionAnswers.get(qaID).answers.get(2).nextQuestionNumber;
		}
	}
	
	public static String displayChoices(Integer qaID) {
		StringBuilder str = new StringBuilder("");
		Integer answersSize = questionAnswers.get(qaID).answers.size();
		for(Integer i = 1; i <= answersSize; i++) {
			str.append(  questionAnswers.get(qaID).answers.get(i).answer + "\n" );
		}
		
		//System.out.println(str);  
		return str.toString();
		
	}

	public static Integer nextQuestion (Integer qaID, Integer answer) {
		return questionAnswers.get(qaID).answers.get(answer).nextQuestionNumber;
	}
	
	public static boolean notFound(Integer qaID, Integer i) throws NullPointerException {
		if (   questionAnswers.get(qaID).answers.get(i).answer  == null ) {
			return true;
		}
		return false;
	}
}
