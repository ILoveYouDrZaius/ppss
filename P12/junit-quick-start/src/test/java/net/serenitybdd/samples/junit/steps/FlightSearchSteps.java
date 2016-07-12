package net.serenitybdd.samples.junit.steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.samples.junit.pages.FlightDetailsPage;
import net.serenitybdd.samples.junit.pages.FlightSearchPage;
import net.serenitybdd.samples.junit.pages.FlightSearchResultsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.assertj.core.api.Assertions.assertThat;


public class FlightSearchSteps {
    FlightSearchPage flightSearchPage;
    FlightSearchResultsPage flightSearchResultsPage;
    FlightDetailsPage flightDetailsPage;

    @Step("A customer searchers for flights between {0} and {1}")
    public void searches_for_flights_between(String departure, String destination) {
         flightSearchPage.searchForFlightsFrom(departure).to(destination);
    }

    @Step
    public void view_flight_details_for_flight(int flightNumber) {
        flightSearchResultsPage.selectFlightNumber(flightNumber);
    }

    @Step
    public void should_see_the_destination_city_in_the_summary(String destination) {
        String expectedDestinationCity = destination;

        assertThat(flightDetailsPage.getDestinationCity()).isEqualTo(expectedDestinationCity);
    }

    @Step("A customer searches for flight offers")
    public void searches_for_flight_offers() {
        flightSearchPage.searchForOfferFlights();
    }

    @Step("The customer should see int the summary departure = {0}, destination = {1} and price = {2}")
    public void should_see_in_the_summary(String from, String to, float price) {
        assertThat(flightDetailsPage.getDepartureCity()).isEqualTo(from);
        assertThat(flightDetailsPage.getDestinationCity()).isEqualTo(to);
        assertThat(flightDetailsPage.getPrice()).isEqualTo(price);
    }


}
