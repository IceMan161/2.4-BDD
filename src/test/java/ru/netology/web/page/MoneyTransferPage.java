package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {

    private SelenideElement transferAmount = $("[data-test-id = 'amount'] .input__control");
    private SelenideElement transferFrom = $("[data-test-id = 'from'] .input__control");
    private SelenideElement transferButton = $("[data-test-id = 'action-transfer'] .button__text");

    public MoneyTransferPage() {
    }

    public DashboardPage transferAmountFirstCard(DataHelper.CardsInfo info) {
        transferAmount.setValue(info.getTransferAmount());
        transferFrom.setValue(info.getSecondCard());
        transferButton.click();
        return new DashboardPage();
    }

    public DashboardPage transferAmountSecondCard(DataHelper.CardsInfo info) {
        transferAmount.setValue(info.getTransferAmount());
        transferFrom.setValue(info.getFirstCard());
        transferButton.click();
        return new DashboardPage();
    }


}
