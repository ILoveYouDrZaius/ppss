package net.serenitybdd.samples.junit.features.earning_points;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.samples.junit.model.Status;
import net.serenitybdd.samples.junit.steps.TravellerStatusSteps;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static net.serenitybdd.samples.junit.model.Status.*;


@RunWith(SerenityParameterizedRunner.class)
public class WhenEarningFrequentFlyerStatusUpgrades {

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {0,     Bronze},
                {9999,  Bronze},
                {10000, Silver},
                {49999, Silver},
                {50000, Gold}
        });
    }

    private final int kilometersTravelled;
    private final Status expectedStatus;

    public WhenEarningFrequentFlyerStatusUpgrades(int kilometersTravelled,
                                                  Status expectedStatus) {
        this.kilometersTravelled = kilometersTravelled;
        this.expectedStatus = expectedStatus;
    }

    @Steps
    TravellerStatusSteps travellerSteps;

    @Test
    public void shouldEarnNextStatusWithEnoughPoints() {
        // GIVEN
        travellerSteps.a_traveller_joins_the_frequent_flyer_program();

        // WHEN
        travellerSteps.the_traveller_flies(kilometersTravelled);

        // THEN
        travellerSteps.traveller_should_have_a_status_of(expectedStatus);
    }
}


