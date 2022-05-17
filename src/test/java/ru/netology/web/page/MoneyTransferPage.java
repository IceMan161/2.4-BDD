package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {

    private SelenideElement transferAmount = $("[data-test-id = 'amount'] .input__control");
    private SelenideElement transferFrom = $("[data-test-id = 'from'] .input__control");
    private SelenideElement transferButton = $("[data-test-id = 'action-transfer'] .button__text");

    public MoneyTransferPage() {
    }

    public DashboardPage transfer(DataHelper.CardsInfo cardsInfo, String amount) {
        transferAmount.setValue(amount);
        transferFrom.setValue(cardsInfo.getCard());
        transferButton.click();
        return new DashboardPage();
    }

}
