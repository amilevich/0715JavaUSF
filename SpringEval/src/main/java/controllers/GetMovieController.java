package controllers;

import dao.MovieDao;
import model.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetMovieController
{
    @Autowired
    MovieDao movieRepo;

    @CrossOrigin
    @GetMapping(value = "/getMovie")
    public Movies getMovie(@RequestParam String name)
    {
        Movies movie = movieRepo.getMovieById(name);

        return movie;
    }
}
