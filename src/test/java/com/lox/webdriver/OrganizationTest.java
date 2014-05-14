package com.lox.webdriver;

import org.junit.Test;

import static com.lox.webdriver.Data.*;

public class OrganizationTest extends BaseTest {

    public void before(){
        super.before();
        gotoLoginPage()
                .loginAs(TEST_ADMIN_USER_NAME, TEST_ADMIN_USER_PASSWORD);
    }

    public void after(){
        gotoLoginPage()
                .loginAs(TEST_ADMIN_USER_NAME, TEST_ADMIN_USER_PASSWORD);

        gotoOrganizationCreationPage()
                .deleteOrganization(TEST_ORG1);

        super.after();
    }

    @Test
    public void organizationPage_should_load_successfully(){
        gotoOrganizationCreationPage()
        .verifyOrganizationCreationPage();
    }

    @Test
    public void testCreateOrganization() throws Exception {
        gotoOrganizationCreationPage()
                .createOrganization();
    }

}
