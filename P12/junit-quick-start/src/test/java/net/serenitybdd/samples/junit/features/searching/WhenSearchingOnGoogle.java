package net.serenitybdd.samples.junit.features.searching;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.samples.junit.pages.GooglePage;
import net.thucydides.core.annotations.Managed;
//import net.thucydides.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;


@RunWith(SerenityRunner.class)
public class WhenSearchingOnGoogle {

    @Managed(driver = "firefox")                                                                //<1>
    WebDriver driver;

    GooglePage googlePage;

    @Test
    @Ignore
    public void shouldInstantiateAWebDriverInstanceForAWebTest() {
        driver.get("http://www.google.es");

        driver.findElement(By.name("q")).sendKeys("firefly", Keys.ENTER);

        new WebDriverWait(driver,5).until(titleContains("Google Search"));

        assertThat(driver.getTitle()).isEqualTo("firefly - Google Search");
    }

    @Test
    public void shouldInstantiatedPageObjectsForAWebTest() {

        //método open(): Open the webdriver browser to the base URL,
        // determined by the DefaultUrl annotation if present
        googlePage.open();

        googlePage.searchFor("firefly");

        //assertThat(googlePage.getTitle()).isEqualTo("firefly - Google Search");
        assertThat(googlePage.getTitle()).isEqualTo("firefly - Buscar con Google");
    }
}


