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
        var balanceBeforeFirst = dashboardPage.getCardBalance(DataHelper.getCardsInfoFirst().getId());
        var balanceBeforeSecond = dashboardPage.getCardBalance(DataHelper.getCardsInfoSecond().getId());
        var moneyTransferPage = dashboardPage.validCardFirst();
        var transferFirst = moneyTransferPage.transfer(DataHelper.getCardsInfoSecond(), "5000");
        var balanceAfterFirst = transferFirst.getCardBalance(DataHelper.getCardsInfoFirst().getId());
        var balanceAfterSecond = dashboardPage.getCardBalance(DataHelper.getCardsInfoSecond().getId());
        assertEquals(balanceBeforeFirst + 5000, balanceAfterFirst);
        assertEquals(balanceBeforeSecond - 5000, balanceAfterSecond);
    }

    @Test
    void mustTransferToSecondCard() {

//        Configuration.holdBrowserOpen = true;
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verifyInfo = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verifyInfo);
        var balanceBeforeSecond = dashboardPage.getCardBalance(DataHelper.getCardsInfoSecond().getId());
        var balanceBeforeFirst = dashboardPage.getCardBalance(DataHelper.getCardsInfoFirst().getId());
        var moneyTransferPage = dashboardPage.validCardSecond();
        var transferSecond = moneyTransferPage.transfer(DataHelper.getCardsInfoFirst(), "5000");
        var balanceAfterSecond = transferSecond.getCardBalance(DataHelper.getCardsInfoSecond().getId());
        var balanceAfterFirst = dashboardPage.getCardBalance(DataHelper.getCardsInfoFirst().getId());
        assertEquals(balanceBeforeSecond + 5000, balanceAfterSecond);
        assertEquals(balanceBeforeFirst - 5000, balanceAfterFirst);

    }

    @Test
    void shouldCancelTransfer() {

//        Configuration.holdBrowserOpen = true;
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verifyInfo = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verifyInfo);
        var balanceBeforeFirst = dashboardPage.getCardBalance(DataHelper.getCardsInfoFirst().getId());
        var balanceBeforeSecond = dashboardPage.getCardBalance(DataHelper.getCardsInfoSecond().getId());
        var moneyTransferPage = dashboardPage.validCardFirst();
        var transferFirst = moneyTransferPage.transfer(DataHelper.getCardsInfoSecond(), "11000");
        var balanceAfterFirst = transferFirst.getCardBalance(DataHelper.getCardsInfoFirst().getId());
        var balanceAfterSecond = dashboardPage.getCardBalance(DataHelper.getCardsInfoSecond().getId());
        assertEquals(balanceBeforeFirst, balanceAfterFirst);
        assertEquals(balanceBeforeSecond, balanceAfterSecond);

    }

}
