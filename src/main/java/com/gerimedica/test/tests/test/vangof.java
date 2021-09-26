package com.gerimedica.test.tests.test;

import com.gerimedica.test.tests.BaseVangofTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class vangof extends BaseVangofTest {

    @Test(description = "Test case 1")
    @Description("Go to the collection search by clicking -link(Ontdek de collectie) " +
            "and verify with title and Collectie string in the next page")
    public void ClickonOntdekdecollectie() {
        pageopen()
                .clickon_Ontdek_de_collectie()
                .shouldHavetitle("Collectie - Van Gogh Museum")
        ;
    }

    @Test(description = "Test case 2")
    @Description("Search the painting with title “Het Gele Huis” from the search box " +
            "and Verify that you get more than 700 results")
    public void verify_search_result_count_collectie() {
        pageopen()
                .clickon_Ontdek_de_collectie()
                .shouldHavetitle("Collectie - Van Gogh Museum")
                .should_be_able_to_do_search("Het Gele Huis", 700)
        ;
    }


    @Test(description = "Test case 3")
    @Description("Search the painting with title “Het Gele Huis” from the search box" +
            "Click on the first result" +
            "Verify that you get this painting from  Objectgegevens section data")
    public void clickon_objectgegevens_and_verify_theobjects() {
        pageopen()
                .clickon_Ontdek_de_collectie()
                .shouldHavetitle("Collectie - Van Gogh Museum")
                .clickon_first_element()
                .goto_the_hetgelehuis_page()
                .shouldHavetitle("Vincent van Gogh - Het Gele Huis (De straat) - Van Gogh Museum")
                .click_on_Objectgegevens_and_verify_Fnummber_Jhnumber_Inventarisnummer();

    }

    @Test(description = "it was not part of  given test case")
    public void clickon_first_element_and_verify_the_hetgelehuis_page_title() {
        pageopen()
                .clickon_Ontdek_de_collectie()
                .shouldHavetitle("Collectie - Van Gogh Museum")
                .should_be_able_to_do_search("Het Gele Huis", 700)
                .clickon_first_element()
                .goto_the_hetgelehuis_page()
                .shouldHavetitle("Vincent van Gogh - Het Gele Huis (De straat) - Van Gogh Museum");

    }


}
