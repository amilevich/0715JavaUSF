package model;

import javax.persistence.*;

@Entity
@Table
public class Showtimes
{
    @Id
    @Column(name = "showtime_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int showtimeId;

    @Column(name = "time")
    private String time;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie", referencedColumnName = "movie_name")
    private Movies movie;

    public Showtimes() {}

    public Showtimes(String time, Movies movie) {
        this.time = time;
        this.movie = movie;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
