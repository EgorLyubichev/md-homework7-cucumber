package org.lev.steps;

import com.codeborne.selenide.ElementsCollection;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.lev.pages.BasicPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BasicPageDefinition {

    BasicPage basicPage = new BasicPage();

    private static final By AUTOBARAKHOLKA = By.xpath("//span[@class='b-main-navigation__text'][contains(text(), 'Автобарахолка')]/..");
    private static final By CARS_UP_TO = By.xpath("//span[@class='b-main-navigation__dropdown-advert-sign'][contains(text(), 'Авто')]");
    private static final By MINSK_AUTOBARAKHOLKA = By.xpath("//a[@href='https://ab.onliner.by/city/minsk']/span[@class='b-main-navigation__dropdown-advert-sign'][contains(text(), 'Минск')]");
    private static final By GOMEL_AUTOBARAKHOLKA = By.xpath("//a[@href='https://ab.onliner.by/city/gomel']/span[@class='b-main-navigation__dropdown-advert-sign'][contains(text(), 'Гомель')]");
    private static final By MOGILEV_AUTOBARAKHOLKA = By.xpath("//a[@href='https://ab.onliner.by/city/mogilev']/span[@class='b-main-navigation__dropdown-advert-sign'][contains(text(), 'Могилев')]");
    private static final By VITEBSK_AUTOBARAKHOLKA = By.xpath("//a[@href='https://ab.onliner.by/city/vitebsk']/span[@class='b-main-navigation__dropdown-advert-sign'][contains(text(), 'Витебск')]");
    private static final By GRODNO_AUTOBARAKHOLKA = By.xpath("//a[@href='https://ab.onliner.by/city/grodno']/span[@class='b-main-navigation__dropdown-advert-sign'][contains(text(), 'Гродно')]");
    private static final By BREST_AUTOBARAKHOLKA = By.xpath("//a[@href='https://ab.onliner.by/city/brest']/span[@class='b-main-navigation__dropdown-advert-sign'][contains(text(), 'Брест')]");

    private static final By AUDI_BRAND = By.xpath("//a[@href='https://ab.onliner.by/audi']/span[@class='b-main-navigation__dropdown-advert-sign'][contains(text(), 'Audi')]");
    private static final By BMW_BRAND = By.xpath("//a[@href='https://ab.onliner.by/bmw']/span[@class='b-main-navigation__dropdown-advert-sign'][contains(text(), 'BMW')]");
    private static final By CITROEN_BRAND = By.xpath("//a[@href='https://ab.onliner.by/citroen']/span[@class='b-main-navigation__dropdown-advert-sign'][contains(text(), 'Citroen')]");
    private static final By FORD_BRAND = By.xpath("//a[@href='https://ab.onliner.by/ford']/span[@class='b-main-navigation__dropdown-advert-sign'][contains(text(), 'Ford')]");
    private static final By MAZDA_BRAND = By.xpath("//a[@href='https://ab.onliner.by/mazda']/span[@class='b-main-navigation__dropdown-advert-sign'][contains(text(), 'Mazda')]");
    private static final By MERCEDES_BRAND = By.xpath("//a[@href='https://ab.onliner.by/mercedes-benz']/span[@class='b-main-navigation__dropdown-advert-sign'][contains(text(), 'Mercedes-Benz')]");


    @When("hover the cursor over {string}")
    public void hoverTheCursorTheElement(String string) {
        switch (string) {
            case "Автобарахолка":
                basicPage.activateTheElement(AUTOBARAKHOLKA);
                break;
            default:
                System.err.println("ERROR: Case was not found to hover over '" + string + "'!");
        }
    }

    @Then("browse fields {string}")
    public void browseFields(String string) {
        switch (string) {
            case "Авто до ...":
                ElementsCollection carsUpToElements = $$(CARS_UP_TO);
                assertAll(
                        "Test categories 'Авто до ...'",
                        () -> assertEquals(2, carsUpToElements.size()),
                        () -> assertTrue(carsUpToElements.get(0).innerText().contains("Авто до 4000 р.")),
                        () -> assertTrue(carsUpToElements.get(1).innerText().contains("Авто до 10 000 р."))
                );
                break;
            case "cities":
                assertAll("test cities elements",
                        ()-> assertTrue($(MINSK_AUTOBARAKHOLKA).exists()),
                        ()-> assertTrue($(GOMEL_AUTOBARAKHOLKA).exists()),
                        ()-> assertTrue($(MOGILEV_AUTOBARAKHOLKA).exists()),
                        ()-> assertTrue($(VITEBSK_AUTOBARAKHOLKA).exists()),
                        ()-> assertTrue($(GRODNO_AUTOBARAKHOLKA).exists()),
                        ()-> assertTrue($(BREST_AUTOBARAKHOLKA).exists())
                );
                break;
            case "auto brands":
                assertAll("test car brands elements",
                        ()-> assertTrue($(AUDI_BRAND).exists()),
                        ()-> assertTrue($(BMW_BRAND).exists()),
                        ()-> assertTrue($(CITROEN_BRAND).exists()),
                        ()-> assertTrue($(FORD_BRAND).exists()),
                        ()-> assertTrue($(MAZDA_BRAND).exists()),
                        ()-> assertTrue($(MERCEDES_BRAND).exists())
                );
                break;
            default:
                System.err.println("ERROR: Case was not found text '" + string + "'!");

        }
    }
}
