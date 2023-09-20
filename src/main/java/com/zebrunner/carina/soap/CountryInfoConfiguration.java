package com.zebrunner.carina.soap;

import com.zebrunner.carina.utils.R;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryInfoConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(R.TESTDATA.get("ws.soap.generated"));
        return marshaller;
    }

    @Bean
    public CountryInfoClient countryInfoClient(Jaxb2Marshaller marshaller) {
        CountryInfoClient countryInfoClient = new CountryInfoClient();
        countryInfoClient.setDefaultUri(R.TESTDATA.get("ws.soap.uri.default"));
        countryInfoClient.setMarshaller(marshaller);
        countryInfoClient.setUnmarshaller(marshaller);
        return countryInfoClient;
    }

}
