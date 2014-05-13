package com.lox.webdriver;

import org.junit.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchPage_should_load_successfully(){
        gotoSearchPage()
        .verifySearchPage();
    }

}
