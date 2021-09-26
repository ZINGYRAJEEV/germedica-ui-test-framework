package com.gerimedica.test.pages;

import com.gerimedica.test.core.logging.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Homepage extends BasePage {
    By Ontdekdecollectie = By.linkText("Ontdek de collectie");

    public Homepage shouldHavetitle(String message) {
        Logger.log().info("Verifying error message is{}", message);
        // $(errorMessage).shouldHave(text(message));
        return this;
    }

    public Collectie clickon_Ontdek_de_collectie() {
        $(Ontdekdecollectie).should(exist).click();
        Logger.log().info(" search button has been clicked");
        return new Collectie();
    }


}
