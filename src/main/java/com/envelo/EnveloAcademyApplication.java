package com.envelo;

import com.envelo.kanye.KanyeQuote;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EnveloAcademyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(EnveloAcademyApplication.class, args);

        KanyeQuote kanyeQuote = appContext.getBean(KanyeQuote.class);
        kanyeQuote.askForQuote();
    }

}
