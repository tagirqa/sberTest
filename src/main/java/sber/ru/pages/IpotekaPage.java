package sber.ru.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.*;
import sber.ru.steps.BaseSteps;


public class IpotekaPage extends BasePage {

    @FindBy(id = "calc-main")
    public WebElement ipotekaCalc;

    @FindBy(xpath = "//iframe[@title='Основной контент']")
    public WebElement iframeIpoteka;

    @FindBy(id = "estateCost")
    public WebElement estateCost;

    @FindBy(id = "initialFee")
    public WebElement initialFee;

    @FindBy(id = "creditTerm")
    public WebElement creditTerm;

    @FindBy(xpath = "//span[@data-test-id='amountOfCredit']")
    public WebElement realEstateCost;

    @FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
    public WebElement realMonthlyPayment;

    @FindBy(xpath = "//span[@data-test-id='requiredIncome']")
    public WebElement requiredIncome;

    @FindBy(xpath = "//span[@data-test-id='rate']")
    public WebElement rate;

    @FindBy(xpath = "//span[@class='dcCalc_input-row-tablet__inputPercents']")
    public WebElement procentIpotekaField;

    @FindBy(xpath = "//input[@data-test-id='paidToCard']/..")
    public WebElement paidToCard;

    @FindBy(xpath = "//input[@data-test-id='canConfirmIncome']/..")
    public WebElement canConfirmIncome;

    @FindBy(xpath = "//input[@data-test-id='youngFamilyDiscount']/..")
    public WebElement youngFamilyDiscount;

    public IpotekaPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public IpotekaPage waitFieldAndInput(final WebElement element, final String text) {
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();

        element.sendKeys(text);
        return this;
    }

    public IpotekaPage waitRefreshing(WebElement element, String value){
        WebDriverWait webDriverWait = new WebDriverWait(BaseSteps.getDriver(), 10);
        BaseSteps.wait.until(ExpectedConditions.visibilityOf(procentIpotekaField));
        webDriverWait.until(webDriver -> {

            return element.getText().equals(value);
        });
        return this;
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) BaseSteps.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }




}




