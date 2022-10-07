package com.envelo.kanye;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    public Quote() {
    }

    private String quote;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return '\"' + quote + '\"' + " ~" +"\033[3mKanye West\033[0m";
    }
}
