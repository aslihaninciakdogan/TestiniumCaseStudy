package org.testinium.beymen.scenarios;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testinium.beymen.base.BaseScenario;
import org.testinium.beymen.functions.CaseStudyFunction;

public class CaseStudyScenario extends BaseScenario {
    CaseStudyFunction caseStudyFunction;

    static Logger logger = Logger.getLogger(CaseStudyScenario.class.getName());
    @Before
    public void before(){
        caseStudyFunction = new CaseStudyFunction(getWebDriver());
    }

    @Test
    public void test(){
        if (!caseStudyFunction.checkPage()){
            logger.info("Test senaryosu başlatıldı.");
            after();
        }

        caseStudyFunction
                .acceptCookies()
                .chooseGender("KADIN")
                .search(getTextFromExcel(0,0))
                .clearSearch()
                .search(getTextFromExcel(0,1))
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
        logger.info("Test senaryosu tamamlandı.");
        tearDown();
    }
}
