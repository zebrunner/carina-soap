package com.zebrunner.carina.soap;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zebrunner.carina.soap.base.SOAPTest;

import countryinfo.wsdl.CapitalCityResponse;

/**
 * This sample shows how to create SOAP API tests.
 *
 * @author qpsdemo
 */
@SpringBootTest
@ContextConfiguration(classes = {CountryInfoConfiguration.class})
public class SOAPSampleTest extends SOAPTest {

    @Autowired
    private CountryInfoClient countryInfoClient;

    @Test(testName = "Get capital city by country ISO code")
    @MethodOwner(owner = "qpsdemo")
    @Parameters({"countryISOCode", "capitalCity"})
    @TestPriority(value = Priority.P1)
    public void getInfo(String countryISOCode, String capitalCity) {
        CapitalCityResponse capitalCityResponse = countryInfoClient.getCapitalCityResponse(countryISOCode);
        Assert.assertEquals(String.valueOf(capitalCityResponse.getCapitalCityResult()), capitalCity);
    }

}
