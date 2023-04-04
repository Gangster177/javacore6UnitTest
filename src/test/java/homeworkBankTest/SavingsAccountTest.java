package homeworkBankTest;

import homeworkBank.Account;
import homeworkBank.CheckingAccount;
import homeworkBank.CreditAccount;
import homeworkBank.SavingsAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SavingsAccountTest {
    private static Account checking;
    private static Account credit;
    private static Account saving;
    private static int testNumber;

    @BeforeAll
    public static void startTest() {
        System.out.println("Running Test");
        testNumber = 0;
    }

    @BeforeEach
    public void iniTest() {
        testNumber++;
        System.out.println("Starting test №: " + testNumber);
    }

    @Test
    public void checkingPayTest() {
        //given
        checking = new CheckingAccount(100);
        int balance = 50;
        //when
        checking.pay(50);
        //then
        Assertions.assertEquals(checking.getBalance(), balance);
    }

    @Test
    public void creditPayTest() {
        //given
        credit = new CreditAccount(100);
        int balance = 0;
        //when
        credit.pay(100);
        //then
        Assertions.assertEquals(credit.getBalance(), balance);
    }

    @Test
    public void creditMaxedAddMoneyTest() {
        //given
        credit = new CreditAccount(0);
        int balance = 0;
        //when
        credit.addMoney(100);
        //then
        Assertions.assertEquals(credit.getBalance(), balance);
    }

    @Test
    public void creditTransferTest() {
        //given
        credit = new CreditAccount(0);
        saving = new SavingsAccount(0);
        int balance = -100;
        //when
        credit.transfer(saving, 100);
        //then
        Assertions.assertNotEquals(saving.getBalance(), balance);
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    public void creditSetBalanceTest(int a, int b, int c) {
        //given
        credit = new CreditAccount(a);
        int balance = b;
        //when
        credit.setBalance(c);
        //then
        Assertions.assertEquals(credit.getBalance(), balance);
    }

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(50, 50, 0),
                Arguments.of(0, 0, 500)
        );
    }
}