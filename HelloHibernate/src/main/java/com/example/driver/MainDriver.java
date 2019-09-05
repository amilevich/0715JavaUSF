package com.example.driver;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.CharacterDao;
import com.example.dao.DirectorDao;
import com.example.dao.MovieDao;
import com.example.model.Director;
import com.example.model.Movie;
import com.example.model.Character;

public class MainDriver {
	
	public static CharacterDao charDao = new CharacterDao();
	public static DirectorDao dircDao = new DirectorDao();
	public static MovieDao movDao = new MovieDao();
	
	/*
	 * Hibernate exceptions are runtime exceptions that encapsulate JDBC exceptions.
	 * If an exception is thrown, the transactions are rolled back
	 */

	public static void main(String[] args) {
		insertInitialValues();
		System.out.println("done");
	}
	
	public static void insertInitialValues() {
		//directors
		Director dirc1 = new Director("Francis Ford Coppola");
		Director dirc2 = new Director("Peter Jackson");
		Director dirc3 = new Director("George Lucas");
		
		dircDao.insert(dirc1);
		dircDao.insert(dirc2);
		dircDao.insert(dirc3);
		
		//movies
		Movie mov1 = new Movie("GodFather", "crime family goes to something america", dirc1);
		Movie mov2 = new Movie("SpooderMan", "high school student becomes a spooder", dirc2);
		Movie mov3 = new Movie("Shrek", "Shrek is love, Shrek is life", dirc1);
		Movie mov4 = new Movie("Finding Nemo", "fish stuff swimming", dirc3);
		
		movDao.insert(mov1);
		movDao.insert(mov2);
		movDao.insert(mov3);
		movDao.insert(mov4);
		
		List<Movie> movList = new ArrayList<>();
		movList.add(mov1);
		movList.add(mov2);
		movList.add(mov3);
		movList.add(mov4);
		
		//characters
		Character char1 = new Character("Christian", "male", "to be a good christian", movList);
		Character char2 = new Character("Mulan", "female", "to become a man", movList);
		
		charDao.insert(char1);
		charDao.insert(char2);
			
	}
	
	/*
	 * L1 Caching - default caching strategy, connected directly to the
	 * session, objects cached in one session are not seen in another
	 * 
	 * L2 Caching - optional caching strategy, connected to the 
	 * SessionFactory, objects can be seen by all sessions. 
	 * Other dependencies to help accomplish L2:
	 * - EHCache, DSCache, JBoss Cache, Swarm Cache -> caching providers
	 * - hibernate.cache.provider -> set it to the package of the caching
	 * provider you are using
	 */

}
