package org.testinium.beymen.scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testinium.beymen.base.BaseScenario;
import org.testinium.beymen.functions.CaseStudyFunction;

public class CaseStudyScenario extends BaseScenario {
    CaseStudyFunction caseStudyFunction;

    @Before
    public void before(){
        caseStudyFunction = new CaseStudyFunction(getWebDriver());
    }

    @Test
    public void test(){
        if (!caseStudyFunction.checkPage()){
            // log yazılacak.
            after();
        }

        caseStudyFunction
                .acceptCookies()
                .chooseGender("KADIN")
                .search("şort")
                .clearSearch()
                .search("gömlek")
                .pressEnterOnSearch()
                .clickProduct()
                .writeProductInfoToTxt()
                .addBasket()
                .comparePriceWithBasket()
                .increaseQuantity()
                .checkQuantity()
                .deleteItem()
                .checkBasket();
    }

    @After
    public void after(){
        tearDown();
    }
}
