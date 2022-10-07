package com.envelo.kanye;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Component
public class KanyeQuote {

    private static final String KANYE_URI = "https://api.kanye.rest/";
    private static final String NEXT_QUOTE = "next";
    private static final Logger log = LoggerFactory.getLogger(KanyeQuote.class);

    private RestTemplate restTemplate = new RestTemplate();
    private Set<String> quotes = new HashSet<>();

    public void askForQuote() {
        printRandomQuote();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (NEXT_QUOTE.equals(scanner.next())) {
                printRandomQuote();
            } else {
                log.warn("The command is incorrect. To get next quote type: " + NEXT_QUOTE);
            }
        }
    }

    private void printRandomQuote() {
        System.out.println(getRandomQuote());
    }

    private String getRandomQuote() {
        try {
            Quote quote = restTemplate.getForObject(KANYE_URI, Quote.class);
            if (quotes.contains(quote)) {
                return "Quote already downloaded.";
            } else {
                quotes.add(quote.toString());
                return quote.toString();
            }
        } catch (Exception e) {
            return "Cannot download a quote, because: " + e.getMessage();
        }
    }

}
