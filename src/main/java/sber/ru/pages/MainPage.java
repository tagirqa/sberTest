package sber.ru.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sber.ru.steps.BaseSteps;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Ипотека')]")
    public WebElement menuBarIpoteka;

    @FindBy(xpath = "//ul[@aria-label='Подменю']//a[contains(text(),'Ипотека на готовое жильё')]")
    public WebElement ipotekaForReadyHouse;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

}
