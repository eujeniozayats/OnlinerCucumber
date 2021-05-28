package stepdefinitions;

import framework.BaseEntity;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseEntity {

    @Before
    public void setUp() {

        before();

    }

    @After
    public void tearDown() {

        after();

    }


    @Override
    protected String formatLogMsg(String message) {
        return message;
    }
}
