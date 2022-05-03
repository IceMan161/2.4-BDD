package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {

    private SelenideElement transferAmount = $("[data-test-id = 'amount'] .input__control");
    private SelenideElement transferFrom = $("[data-test-id = 'from'] .input__control");
    private SelenideElement transferButton = $("[data-test-id = 'action-transfer'] .button__text");

    public MoneyTransferPage() {
    }

    public DashboardPage transferAmountFirstCard() {
        transferAmount.setValue("1000");
        transferFrom.setValue("5559 0000 0000 0002");
        transferButton.click();
        return new DashboardPage();
    }

    public DashboardPage transferAmountSecondCard() {
        transferAmount.setValue("2000");
        transferFrom.setValue("5559 0000 0000 0001");
        transferButton.click();
        return new DashboardPage();
    }


}
