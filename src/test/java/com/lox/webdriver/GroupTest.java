package com.lox.webdriver;

import org.junit.Test;

public class GroupTest extends BaseTest {

    @Test
    public void groupPage_should_load_successfully(){
        gotoGroupPage()
        .verifyGroupPage();
    }
}
