package ru.netology.web.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;


import static com.codeborne.selenide.Selenide.$;
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
        $("[data-test-id = 'amount'] .input__control").setValue("1000");
        $("[data-test-id = 'from'] .input__control").setValue("5559 0000 0000 0002");
        $("[data-test-id = 'action-transfer'] .button__text").click();


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
        $("[data-test-id = 'amount'] .input__control").setValue("1000");
        $("[data-test-id = 'from'] .input__control").setValue("5559 0000 0000 0001");
        $("[data-test-id = 'action-transfer'] .button__text").click();

    }

}
