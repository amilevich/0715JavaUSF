package utility;

import java.util.TreeMap;

import utility.ds.MapOps;

public class QuestionGroup {
	public Integer questiongrpid;
	public TreeMap<Integer, String> question; // <answerKey,question>
	
	public TreeMap<Integer, Integer> optionid; // <answerKey,choiceid>
	public TreeMap<Integer, Integer> optionidRev; // <choiceid,answerKey>
	
	public TreeMap<Integer, Integer> nextquestiongrpid; // <answerKey,nextquestiongrpid>
	public TreeMap<Integer, Integer> nextquestiongrpIdRev; // <nextquestiongrpid, answerKey>
	
	public TreeMap<Integer, Integer> fieldid; // <answerKey,printorder>
	public TreeMap<Integer, Integer> fieldidRev; // <printorder,answerKey>
	
	
	public TreeMap<Integer, String> scantype; // <answerKey,scannertype>
	public TreeMap<Integer, Boolean> repeat; // <answerKey,repeat>
	
	public QuestionGroup(Integer questiongrpid, TreeMap<Integer, String> question, TreeMap<Integer, Integer> optionid,
			TreeMap<Integer, Integer> nextquestiongrpid, TreeMap<Integer, String> scantype,
			TreeMap<Integer, Integer> fieldid, TreeMap<Integer, Boolean> repeat) {
		this.questiongrpid = questiongrpid;
		this.question = question;
		this.optionid = optionid;
		this.nextquestiongrpid = nextquestiongrpid;
		this.scantype = scantype;
		this.fieldid = fieldid;
		this.repeat = repeat;
		this.reverseKeys();
	}
	
	public QuestionGroup() {
		// TODO Auto-generated constructor stub
	}

	public Integer getAnswerKeyByOptionID(Integer optionid) {
		return this.optionidRev.get(optionid);
	}
	
	public Integer getNextGroupIDByAnswerKey (Integer answerkey) {
		return this.nextquestiongrpid.get(answerkey);
	}
	
	public Integer getNextGroupID (Integer optionid) {
		Integer answerkey = this.optionidRev.get(optionid);
		return this.nextquestiongrpid.get(answerkey);
	}
	
	public void reverseKeys() {
		optionidRev = MapOps.reverse(optionid);
		nextquestiongrpIdRev = MapOps.reverse(nextquestiongrpid);
		fieldidRev = MapOps.reverse(fieldid);
	}
}
