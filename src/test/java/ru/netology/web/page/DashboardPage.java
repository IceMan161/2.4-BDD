package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement firstCard = $("[data-test-id = '92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement firstButton = $("[data-test-id = '92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button__text");
    private SelenideElement secondCard = $("[data-test-id = '0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement secondButton = $("[data-test-id = '0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button__text");

    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public DashboardPage() {
    }

    public MoneyTransferPage validCardFirst() {
        firstButton.click();
        return new MoneyTransferPage();
    }

    public MoneyTransferPage validCardSecond() {
        secondButton.click();
        return new MoneyTransferPage();
    }

//    public int getCardBalance(String id) {
//        val text = cards.first().text();
//        return extractBalance(text);
//    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

}
