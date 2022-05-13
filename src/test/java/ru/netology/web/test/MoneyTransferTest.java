package ru.netology.web.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        var balanceBefore = dashboardPage.getCardBalance(DataHelper.getCardsInfoFirst().getId());
        var moneyTransferPage = dashboardPage.validCardFirst();
        var transferFirst = moneyTransferPage.transferAmountFirstCard();
        var balanceAfter = transferFirst.getCardBalance(DataHelper.getCardsInfoFirst().getId());
        assertEquals(balanceBefore + 2000, balanceAfter);

    }

    @Test
    void mustTransferToSecondCard() {

//        Configuration.holdBrowserOpen = true;
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verifyInfo = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verifyInfo);
        var balanceBefore = dashboardPage.getCardBalance(DataHelper.getCardsInfoSecond().getId());
        var moneyTransferPage = dashboardPage.validCardSecond();
        var transferSecond = moneyTransferPage.transferAmountSecondCard();
        var balanceAfter = transferSecond.getCardBalance(DataHelper.getCardsInfoSecond().getId());
        assertEquals(balanceBefore + 2000, balanceAfter);

    }

}
