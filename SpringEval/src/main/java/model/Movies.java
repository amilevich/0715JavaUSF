package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Movies
{
    @Id
    @Column(name = "movie_name")
    public String movieName;

    @JoinColumn(name = "rating_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Ratings rating;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<Showtimes> showtimes;

    public Movies() {}

    public Movies(String movieName, Ratings rating, List<Showtimes> showtimes) {
        this.movieName = movieName;
        this.rating = rating;
        this.showtimes = showtimes;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Ratings getRating() {
        return rating;
    }

    public void setRating(Ratings rating) {
        this.rating = rating;
    }

    public List<Showtimes> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(List<Showtimes> showtimes) {
        this.showtimes = showtimes;
    }
}
