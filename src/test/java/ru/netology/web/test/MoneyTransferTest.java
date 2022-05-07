package ru.netology.web.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;


import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

    @BeforeEach
    void shouldSet() {
        Configuration.headless = true;
        open("http://localhost:9999");
    }

    @Test
    void mustTransferToFirstCard() {

//        Configuration.holdBrowserOpen = true;
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();

        var verificationPage = loginPage.validLogin(authInfo);
        var verifyInfo = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verifyInfo);
        var moneyTransferPage = dashboardPage.validCardFirst();
        var cardsInfo = DataHelper.getCardsInfo();
        var transferFirst = moneyTransferPage.transferAmountFirstCard(cardsInfo);
        transferFirst.getCardBalance("[data-test-id = '92df3f1c-a033-48e6-8390-206f6b1f56c0']");

    }

    @Test

    void mustTransferToSecondCard() {

//        Configuration.holdBrowserOpen = true;
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verifyInfo = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verifyInfo);
        var moneyTransferPage = dashboardPage.validCardSecond();
        var cardsInfo = DataHelper.getCardsInfo();
        var transferSecond = moneyTransferPage.transferAmountSecondCard(cardsInfo);
        transferSecond.getCardBalance("[data-test-id = '0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    }

}
