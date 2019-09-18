package controllers;

import dao.MovieDao;
import model.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllShowtimesController
{
    @Autowired
    MovieDao movieRepo;

    @CrossOrigin
    @GetMapping(value = "/getAllShowtimes")
    public List<Movies> getAllShowtimes()
    {
        List<Movies> moviesList = movieRepo.getAllMovies();

        return moviesList;
    }
}
