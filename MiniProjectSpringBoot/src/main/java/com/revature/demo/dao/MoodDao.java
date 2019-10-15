package com.revature.demo.dao;

import com.revature.demo.model.Mood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoodDao extends JpaRepository<Mood, Integer>
{

}
