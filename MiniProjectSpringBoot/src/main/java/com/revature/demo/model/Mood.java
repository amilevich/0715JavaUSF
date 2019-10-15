package com.revature.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "mood")
public class Mood
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "mood")
    private String mood;

    public Mood(String mood)
    {
        this.mood = mood;
    }

    public Mood() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
