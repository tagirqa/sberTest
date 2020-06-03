package sber.ru;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sber.ru.steps.BaseSteps;
import sber.ru.steps.IpotekaSteps;
import sber.ru.steps.MainPageSteps;

public class AllureTest {

    private MainPageSteps mainPageSteps = new MainPageSteps();
    private IpotekaSteps ipotekaSteps = new IpotekaSteps();

    @Before
    public void setUp() {
        BaseSteps.setUp();
    }

    @Test
    public void targetTopBarIpotekaAndSelectReadyHouse() {
        mainPageSteps
                .selectMenu()
                .selectIpoteka();

        ipotekaSteps
                .inputFields()
                .fieldCost()
                .fieldFirstMoney()
                .fieldAgePushMoney()
                .checkboxPaidToCard()
                .waitCheckBoxCanConfirmIncome()
                .checkboxYoungFamilyDiscount()
                .checkTextSumCredit("2 122 000 ₽")
                .checkTextFirstMoney("16 922 ₽")
                .checkTextInCome("28 203 ₽")
                .checkTextRate("11 %");
    }


    @After
    public void tearDown() {
        BaseSteps.tearDown();
    }
}
