package com.zebrunner.carina.soap;

import com.zebrunner.carina.utils.R;
import countryinfo.wsdl.CapitalCity;
import countryinfo.wsdl.CapitalCityResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class CountryInfoClient extends WebServiceGatewaySupport {

    public CapitalCityResponse getCapitalCityResponse(String isoCode) {
        CapitalCity capitalCity = new CapitalCity();
        capitalCity.setSCountryISOCode(isoCode);
        log.info("Requesting capital for {}", isoCode);
        return (CapitalCityResponse) getWebServiceTemplate()
                .marshalSendAndReceive(R.TESTDATA.get("ws.soap.wsdl.url"), capitalCity,
                        new SoapActionCallback(String.format("%s/%s", R.TESTDATA.get("ws.soap.wsdl.tns"), "CapitalCity")));
    }

}
