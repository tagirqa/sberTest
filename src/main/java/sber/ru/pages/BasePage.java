package sber.ru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sber.ru.steps.BaseSteps;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    Actions actions = new Actions(BaseSteps.getDriver());


    public void clickElement(WebElement element){
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void waitVisibilityOf(WebElement element){
        BaseSteps.wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitClickable(WebElement element){
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void moveElement(WebElement element){
        BaseSteps.wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).build().perform();
    }
}
