package data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import main.Menu;
import utility.QuestionGroup;

public class Questions {
	public static QuestionGroup load(Integer nxtgrp) {
		QuestionGroup qg = null;
		try {
			Connection conn = DBConnector.getConnection();

			String sql = "select * from menu where questiongrpid = ? order by optionid asc, fieldid asc";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, nxtgrp);
			ResultSet rs = stmt.executeQuery();

			TreeMap<Integer, String> questions = new TreeMap<Integer, String>();
			TreeMap<Integer, Integer> optionid = new TreeMap<Integer, Integer>(); // <answerKey,choiceid>
			TreeMap<Integer, Integer> nextquestiongrpid = new TreeMap<Integer, Integer>(); // <answerKey,nextquestiongrpid>
			TreeMap<Integer, Integer> fieldid = new TreeMap<Integer, Integer>(); // <answerKey,printorder>
			TreeMap<Integer, String> scantype = new TreeMap<Integer, String>(); // <answerKey,scannertype>
			TreeMap<Integer, Boolean> repeat = new TreeMap<Integer, Boolean>(); // <answerKey,repeat>

			while (rs.next()) {
				Menu.toPrint += rs.getString("question") + "\n";
				questions.put(rs.getInt("answerKey"), rs.getString("question"));
				optionid.put(rs.getInt("answerKey"), rs.getInt("optionid"));
				nextquestiongrpid.put(rs.getInt("answerKey"), rs.getInt("nextquestiongrpid"));
				fieldid.put(rs.getInt("answerKey"), rs.getInt("fieldid"));
				scantype.put(rs.getInt("answerKey"), rs.getString("scannertype"));
				repeat.put(rs.getInt("answerKey"), rs.getBoolean("repeat"));
			}
			
			qg = new QuestionGroup(nxtgrp, questions, optionid, nextquestiongrpid, scantype,
					fieldid, repeat);
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return qg;
	}
}
