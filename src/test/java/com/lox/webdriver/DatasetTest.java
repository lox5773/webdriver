package com.lox.webdriver;

import org.junit.Test;

import static com.lox.webdriver.Data.*;

public class DatasetTest extends BaseTest {

    @Test
    public void DatasetPage_should_load_successfully(){
        gotoDatasetPage()
        .verifyDatasetPage();
    }

    @Test
    public void should_create_dataset_successfully(){
        gotoLoginPage()
                .loginAs(TEST_USER_NAME, TEST_USER_PASSWORD);

        gotoDatasetPage()
                .createDataSet()
                .verifyDatasetCreatedSuccessfully();
    }




}
