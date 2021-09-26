package com.gerimedica.test.pages;

import com.gerimedica.test.core.logging.Logger;
import com.codeborne.selenide.Selenide;

public class BasePage {

    public BasePage refreshPage() {
        Logger.log().info("Refreshing page");
        Selenide.refresh();
        return this;
    }
}
