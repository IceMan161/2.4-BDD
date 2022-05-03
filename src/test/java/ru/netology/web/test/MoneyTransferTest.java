package ru.netology.web.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;


import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

    @Test
    void shouldTransferMoneyBetweenOwnCards() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();

        var verificationPage = loginPage.validLogin(authInfo);
        var verifyInfo = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verifyInfo);
        var moneyTransferPage = dashboardPage.validCardFirst();
        var cardsInfo = DataHelper.getCardsInfo();
        var transferFirst = moneyTransferPage.transferAmountFirstCard(cardsInfo);

    }

    @Test

    void mustTransferToSecondCard() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verifyInfo = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verifyInfo);
        var moneyTransferPage = dashboardPage.validCardSecond();
        var cardsInfo = DataHelper.getCardsInfo();
        var transferSecond = moneyTransferPage.transferAmountSecondCard(cardsInfo);

    }

}
