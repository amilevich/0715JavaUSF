package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Ratings
{
    @Id
    @Column(name = "rating_id")
    private int ratingId;

    @Column(name = "rating")
    private String rating;

    public Ratings() {}

    public Ratings(int ratingId, String rating) {
        this.ratingId = ratingId;
        this.rating = rating;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
