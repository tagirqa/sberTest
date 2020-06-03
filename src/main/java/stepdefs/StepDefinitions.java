package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sber.ru.steps.IpotekaSteps;
import sber.ru.steps.MainPageSteps;

public class StepDefinitions {
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private IpotekaSteps ipotekaSteps = new IpotekaSteps();

    @When("наводимся на ипотеку")
    public void selectMenuItem() {
        mainPageSteps.selectMenu();
    }

    @When("выбрали пункт готовое жилье")
    public void selectReadyHouse() {
        mainPageSteps.selectIpoteka();
    }

    @When("скролл до калькулятора")
    public void scrollToCalc(){
        ipotekaSteps.inputFields();
    }
    @When("заполняем поле стоимость недвижимости")
    public void inputTextCostEstate() {
        ipotekaSteps.fieldCost();
    }

    @When("заполняем первоначальный взнос")
    public void inputTextFirstMoney() {
        ipotekaSteps.fieldFirstMoney();
    }

    @When("заполняем срок ипотеки")
    public void inputTextAgePushMoney() {
        ipotekaSteps.fieldAgePushMoney();
    }

    @When("убираем галочку с зарплатного клиента банка")
    public void checkboxPaidToCard() {
        ipotekaSteps.checkboxPaidToCard();
    }

    @When("ставим галочку 'есть возможность подтвердить доход справкой'")
    public void checkboxCanConfirmIncome() {
        ipotekaSteps.waitCheckBoxCanConfirmIncome();
    }

    @When("ставим галочку молодая семья")
    public void checkboxYoungFamily() {
        ipotekaSteps.checkboxYoungFamilyDiscount();
    }

    @Then("сумма кредита равняется {string}")
    public void checkTextSumCredit(String value) {
        ipotekaSteps.checkTextSumCredit(value);
    }

    @Then("ежемесячный платеж {string}")
    public void checkTextFirstMoney(String value) {
        ipotekaSteps.checkTextFirstMoney(value);
    }

    @Then("нужный доход {string}")
    public void checkTextInCome(String value) {
        ipotekaSteps.checkTextInCome(value);
    }

    @Then("процентная ставка равняется {string}")
    public void checkTextRate(String value) {
        ipotekaSteps.checkTextRate(value);
    }

}
