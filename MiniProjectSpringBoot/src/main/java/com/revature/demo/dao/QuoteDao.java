package com.revature.demo.dao;

import com.revature.demo.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteDao extends JpaRepository<Quote, Integer>
{

}
