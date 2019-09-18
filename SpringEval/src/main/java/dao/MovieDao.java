package dao;

import model.Movies;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository("movieRepo")
@Transactional
public class MovieDao
{
    @Autowired
    private SessionFactory factory;

    public Movies getMovieById(String name)
    {
        Session session = factory.openSession();
        Movies movie = session.get(Movies.class, name);
        session.close();
        return movie;
    }

    public List<Movies> getAllMovies()
    {
        Session session = factory.openSession();
        List<Movies> movieList = session.createQuery("from model.Movies", Movies.class).list();
        session.close();
        return  movieList;
    }
}
