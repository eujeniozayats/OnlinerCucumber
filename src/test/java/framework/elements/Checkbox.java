package framework.elements;

import org.openqa.selenium.By;

public class Checkbox extends BaseElement {

    public Checkbox(final By locator, final String name) {
        super(locator, name);
    }

    protected String getElementType() {
        return getLocale("logger.checkbox");
    }


}
