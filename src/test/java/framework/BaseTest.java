package framework;

import org.testng.annotations.Test;

public abstract class BaseTest extends BaseEntity {

    public abstract void runTest() throws Exception;

    @Test
    public void xTest() throws Throwable {
        runTest();
    }

    protected String formatLogMsg(final String message) {
        return message;
    }
}
