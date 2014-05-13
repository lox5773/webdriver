package com.lox.webdriver;

import org.junit.Test;

public class OrganizationTest extends BaseTest {

    @Test
    public void organizationPage_should_load_successfully(){
        gotoOrganizationPage()
        .verifyOrganizationPage();
    }

}
