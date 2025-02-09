package com.app.Daily_Quote_Generator.controller;

import com.app.Daily_Quote_Generator.model.Quote;
import com.app.Daily_Quote_Generator.service.QuoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class QuoteController {

    public QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to Daily Quote Generator";
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/allQuotes")
    public List<Quote> getAllQuotes() {
        return service.getQuotes();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/quote/{id}")
    public Quote getQuoteById(int id) {
        return service.getQuoteById(id);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/category/{category}")
    public List<Quote> getQuotesByCategory(@PathVariable String category) {
        return service.getQuotesByCategory(category);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/author/{author}")
    public List<Quote> getQuotesByAuthor(@PathVariable String author) {
        return service.getQuotesByAuthor(author);
    }


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/delete/{id}")
    public String deleteQuote(@PathVariable int id) {
        return service.deleteQuote(id);
    }

//    @GetMapping("/update")
//    public Quote updateQuote(Quote quote) {
//        return service.updateQuote(quote);
//    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/addQuote")
    public Quote saveQuote(@RequestBody Quote quote) {
        return service.saveQuote(quote);
    }


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/randomQuote")
    public Quote getRandomQuote() {
        // Get total count of quotes
        Quote q = service.getRandomQuote();
        return q;
    }


}
