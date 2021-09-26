package com.gerimedica.test.pages;


import com.gerimedica.test.core.logging.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class Collectie {

    private By collectie = By.xpath("//h1[@class='heading-1 page-header-heading']");
    private By searchbutton = By.xpath("//input[@placeholder='Zoek een kunstwerk' and @class='collection-search-input']");
    private By resultcount = By.xpath("//span[@class='results']");
    private By firstelement = By.xpath("//a[@title='Het Gele Huis (De straat)'][1]");

    public Collectie shouldHavetitle(String message) {
        Logger.log().info("Verifying Collectie string");
        $(collectie).shouldHave(exactText("Collectie"));
        Assert.assertEquals(message, title());
        return this;
    }

    public Collectie should_be_able_to_do_search(String message, int count) {
        Logger.log().info("should be able to do search", message);
        $(searchbutton).shouldBe(visible).click();
        $(searchbutton).shouldBe(visible).setValue(message).pressEnter();
        Assert.assertTrue(Integer.parseInt($(resultcount).getOwnText()) > count, "the result count is less than supplied count");
        return this;
    }

    public Collectie clickon_first_element() {
        $(firstelement).shouldBe(visible).hover().click();

        return this;
    }

    public HetGeleHuis goto_the_hetgelehuis_page() {

        Logger.log().info(" search button has been clicked");
        return new HetGeleHuis();

    }

}
