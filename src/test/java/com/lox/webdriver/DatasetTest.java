package com.lox.webdriver;

import org.junit.Test;

public class DatasetTest extends BaseTest {

    @Test
    public void DatasetPage_should_load_successfully(){
        gotoDatasetPage()
        .verifyDatasetPage();
    }

}
