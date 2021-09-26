package com.gerimedica.test.tests;

import com.gerimedica.test.VangofConfig;
import com.gerimedica.test.auth.UsersProvider;
import com.gerimedica.test.core.logging.Logger;
import com.gerimedica.test.core.properties.PropertiesLoader;
import com.gerimedica.test.core.properties.PropertiesSupplier;
import com.gerimedica.test.pages.Homepage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.testng.ITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertEquals;

public class BaseVangofTest implements ITest {

    protected VangofConfig config = ConfigFactory.create(VangofConfig.class, System.getProperties());
    protected List<String> sqlQueries = new ArrayList<>();
    private String testName;

    @BeforeSuite
    public void configuration() {
        Logger.log().info("Adding Allure Selenide listener");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide(Allure.getLifecycle()));
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        // Logger.log().info("Adding Report Portal Selenide listener");
        //   SelenideLogger.addListener("ReportPortalSelenide", new ReportPortalSelenide());
        PropertiesLoader.loadSystemProperties();

        Configuration.browserCapabilities.setCapability("enableVNC", PropertiesSupplier.getPropertyAsBoolean("enableVNC", false));
        Configuration.browserCapabilities.setCapability("enableVideo", PropertiesSupplier.getPropertyAsBoolean("enableVideo", false));
        Configuration.browserCapabilities.setCapability("videoName", PropertiesSupplier.getProperty("video.name", "Atrium.mp4"));
        Configuration.timeout = 20000;
       // UsersProvider.init(config);
        Logger.log().info("Configuration completed");
    }

    @BeforeMethod(alwaysRun = true)
    public void setTestName(Method method, Object[] params) {

        if (method.isAnnotationPresent(Test.class) &&
                StringUtils.isNoneEmpty(method.getAnnotation(Test.class).testName())) {
            this.testName = this.getClass().getSimpleName() + "." + method.getAnnotation(Test.class).testName();
        } else {
            this.testName = this.getClass().getSimpleName() + "." + method.getName();
        }
        if (Objects.nonNull(params) && params.length > 0) {
            String param = params[0].toString();
            this.testName = this.testName + "(" + (StringUtils.isBlank(param) || StringUtils.isEmpty(param) ? "empty" : param) + ")";
        }
    }


    protected void accpectcookies() {
        if ($(By.xpath("//div[@class='cookie-banner-buttons']")).isDisplayed()) {
            $(By.xpath("//button[@type='button' and @class='cookie-banner-button btn-transparent']"))
                    .shouldBe(Condition.visible).click();
        }
    }

    protected Homepage pageopen() {
        String url = config.baseUrl();
        Logger.log().info("Opening page {}", url);
        Selenide.open(url);
        accpectcookies();

        return new Homepage();
    }

    protected void clearCookies() {
        Selenide.clearBrowserCookies();
    }

    protected void switchToTab(int index) {
        switchTo().window(index - 1);
    }

    protected void shouldHaveUrlEqualTo(String expectedUrl) {
        String url = WebDriverRunner.url();
        assertEquals(url, expectedUrl);
    }

    @Override
    public String getTestName() {
        return testName;
    }
}
