package framework.elements;

import org.openqa.selenium.By;

public class TextBox extends BaseElement {

    public TextBox(final By locator, final String name) {
        super(locator, name);
    }

    protected String getElementType() {
        return getLocale("logger.textbox");
    }


}