package com.revature.demo.controller;

import com.revature.demo.dao.MoodDao;
import com.revature.demo.model.Mood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class RandomMoodController
{
    @Autowired
    private MoodDao moodDao;

    @CrossOrigin
    @GetMapping(value = "/randomMood")
    public Mood getRandomMood()
    {
        List<Mood> moodList = moodDao.findAll();
        Random random = new Random();
        int randomIndex = random.nextInt(moodList.size());

        return  moodList.get(randomIndex);
    }
}
