package com.revature.demo.controller;

import com.revature.demo.dao.QuoteDao;
import com.revature.demo.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class RandomQuoteController
{
    @Autowired
    private QuoteDao quoteDao;

    @CrossOrigin
    @GetMapping(value = "/randomQuote")
    public Quote getRandomQuote()
    {
        List<Quote> quoteList = quoteDao.findAll();
        Random random = new Random();
        int randomIndex = random.nextInt(quoteList.size());

        return quoteList.get(randomIndex);
    }
}
