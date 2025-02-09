package com.app.Daily_Quote_Generator.repository;


import com.app.Daily_Quote_Generator.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepo extends JpaRepository<Quote, Integer> {

    List<Quote> findByCategory(String string);

    List<Quote> findByAuthor(String author);
}
