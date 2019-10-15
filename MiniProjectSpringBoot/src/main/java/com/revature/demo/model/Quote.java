package com.revature.demo.model;

import javax.persistence.*;

@Entity
@Table
public class Quote
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "quote")
    private String quote;

    public Quote(String quote) {
        this.quote = quote;
    }

    public Quote() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
