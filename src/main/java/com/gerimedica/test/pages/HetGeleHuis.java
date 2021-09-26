package com.gerimedica.test.pages;


import com.gerimedica.test.core.logging.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;


public class HetGeleHuis {
    By hetgelehuis = By.xpath("//h1[@class='art-object-page-content-title heading-2']");
    By Objectgegevens = By.xpath("//button[@aria-label='Open Objectgegevens']");
    By fnumber = By.xpath("//dt[@class='definition-list-item-label']");
    By fvalue = By.xpath("//dd[@class='definition-list-item-value']");
    By jhnumber = By.xpath("//dt[@class='definition-list-item-label']");
    By jhvalue = By.xpath("//dd[@class='definition-list-item-value']");
    By inventarisnummer = By.xpath("//dt[@class='definition-list-item-label']");
    By nventarisnummervalue = By.xpath("//dd[@class='definition-list-item-value']");


    public HetGeleHuis shouldHavetitle(String message) {
        Logger.log().info("Verifying title of the page {}", message);
        $(hetgelehuis).shouldHave(exactText("Het Gele Huis (De straat)"));
        Assert.assertEquals(message, title());
        return this;
    }

    public HetGeleHuis click_on_Objectgegevens_and_verify_Fnummber_Jhnumber_Inventarisnummer() {

        Logger.log().info("click_on_Objectgegevens");
        $(Objectgegevens).shouldHave(exactText("Objectgegevens")).click();
        $$(fnumber).get(0).shouldHave(exactText("F-nummer"));
        $$(fvalue).get(0).shouldHave(exactText("F0464"));
        $$(jhnumber).get(1).shouldHave(exactText("JH-nummer"));
        $$(jhvalue).get(1).shouldHave(exactText("JH1589"));
        $$(inventarisnummer).get(2).shouldHave(exactText("Inventarisnummer"));
        $$(nventarisnummervalue).get(2).shouldHave(exactText("s0032V1962"));

        return this;
    }

}
