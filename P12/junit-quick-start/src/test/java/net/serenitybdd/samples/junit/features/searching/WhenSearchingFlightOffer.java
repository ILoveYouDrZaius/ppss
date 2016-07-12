package net.serenitybdd.samples.junit.features.searching;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.samples.junit.steps.FlightSearchSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@Narrative(text={"In order to choose the cheaper flight for my travels",
                 "As a traveller",
                 "I want to be able to search for flight offers"
                 })

@RunWith(SerenityRunner.class)
public class WhenSearchingFlightOffer {

    @Managed(driver = "firefox")
    WebDriver driver;

    @Steps
    FlightSearchSteps theCustomer;

    @Test
    public void should_display_price_and_other_details_for_flights() {
        // GIVEN
        theCustomer.searches_for_flight_offers();
        // WHEN
        theCustomer.view_flight_details_for_flight(1);
        // THEN
        theCustomer.should_see_in_the_summary("Madrid", "New York", 400.00f);

    }

}
