package com.app.Daily_Quote_Generator.service;


import com.app.Daily_Quote_Generator.model.Quote;
import com.app.Daily_Quote_Generator.repository.QuoteRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteService {

    public QuoteRepo quoteRepo;

    public QuoteService(QuoteRepo quoteRepo) {
        this.quoteRepo = quoteRepo;
    }

    public List<Quote> getQuotes() {
        return quoteRepo.findAll();
    }

    public Quote getQuoteById(int id) {
        return quoteRepo.findById(id).orElse(null);
    }

    public Quote saveQuote(Quote quote) {
        return quoteRepo.save(quote);
    }

    public String deleteQuote(int id) {
        quoteRepo.deleteById(id);
        return "Quote removed !! " + id;
    }


    public List<Quote> getQuotesByCategory(String category) {
        List<Quote> allQuotes = quoteRepo.findAll();

        List<Quote> categoryQuotes = new ArrayList<>();

        for (Quote quote : allQuotes) {
            if (quote.getCategory().equalsIgnoreCase(category)) {
                categoryQuotes.add(quote);
            }
        }

        return categoryQuotes;
    }

    public List<Quote> getQuotesByAuthor(String author) {
        List<Quote> allQuotes = quoteRepo.findAll();

        List<Quote> authorQuotes = new ArrayList<>();

        for (Quote quote : allQuotes) {
            if (quote.getAuthor().equalsIgnoreCase(author)) {
                authorQuotes.add(quote);
            }
        }

        return authorQuotes;
    }


    public Quote getRandomQuote() {
        List<Quote> allQuotes = quoteRepo.findAll();
        int randomIndex = (int) (Math.random() * allQuotes.size());
        return allQuotes.get(randomIndex);
    }
}
