package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private SelenideElement heading = $("[data-test-id=dashboard]");
//    private SelenideElement firstCard = $("[data-test-id = '92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement firstButton = $("[data-test-id = '92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button__text");
//    private SelenideElement secondCard = $("[data-test-id = '0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement secondButton = $("[data-test-id = '0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button__text");

    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public MoneyTransferPage validCardFirst() {
        firstButton.click();
        return new MoneyTransferPage();
    }

    public MoneyTransferPage validCardSecond() {
        secondButton.click();
        return new MoneyTransferPage();
    }



}
