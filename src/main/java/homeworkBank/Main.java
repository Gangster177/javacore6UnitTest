package homeworkBank;

import java.util.Date;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.printf("%tB %te, %tY",date,date,date);
        System.out.println();
        Account saving = new SavingsAccount(0);
        Account credit = new CreditAccount(0);
        Account checking = new CheckingAccount(0);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1.Сберегательный счет");
            System.out.println("2.Кредитный счет");
            System.out.println("3.Расчетный счет");
            System.out.println("4. - завершение");
            int operation = scanner.nextInt();
            if (4 == operation) {
                break;
            }
            switch (operation) {
                case 1:
                    System.out.println("Сберегательный счет. БАЛАНС: " + saving.getBalance());
                    System.out.println("1.Пополнение счета");
                    System.out.println("2.Перевод средств");
                    int pay = scanner.nextInt();
                    switch (pay) {
                        case 1:
                            System.out.println("Введите сумму:");
                            int cash = scanner.nextInt();
                            saving.addMoney(cash);
                            break;
                        case 2:
                            System.out.println("2.Кредитный счет");
                            System.out.println("3.Расчетный счет");
                            int moneyTransfer = scanner.nextInt();
                            if (moneyTransfer != 2 && moneyTransfer != 3) {
                                System.out.println("Такой операции нет...");
                                break;
                            }
                            System.out.println("Введите сумму:");
                            cash = scanner.nextInt();
                            if (moneyTransfer == 2) {
                                saving.transfer(credit, cash);
                            } else {
                                saving.transfer(checking, cash);
                            }
                            break;
                        default:
                            System.out.println("Такой операции нет");
                    }
                    break;
                case 2:
                    System.out.println("Кредитный счет. БАЛАНС: " + credit.getBalance());
                    System.out.println("1.Пополнение счета");
                    System.out.println("2.Перевод средств");
                    System.out.println("3.Списание средств");
                    pay = scanner.nextInt();
                    switch (pay) {
                        case 1:
                            System.out.println("Введите сумму:");
                            int cash = scanner.nextInt();
                            credit.addMoney(cash);
                            break;
                        case 2:
                            System.out.println("1.Сберегательный счет");
                            System.out.println("3.Расчетный счет");
                            int moneyTransfer = scanner.nextInt();
                            if (moneyTransfer != 1 && moneyTransfer != 3) {
                                System.out.println("Такой операции нет...");
                                break;
                            }
                            System.out.println("Введите сумму:");
                            cash = scanner.nextInt();
                            if (moneyTransfer == 1) {
                                credit.transfer(saving, cash);
                            } else {
                                credit.transfer(checking, cash);
                            }
                            break;
                        case 3:
                            System.out.println("Введите сумму:");
                            cash = scanner.nextInt();
                            credit.pay(cash);
                            break;
                        default:
                            System.out.println("Такой операции нет");
                    }
                    break;
                case 3:
                    System.out.println("Расчетный счет. БАЛАНС: " + checking.getBalance());
                    System.out.println("1.Пополнение счета");
                    System.out.println("2.Перевод средств");
                    System.out.println("3.Списани средств");
                    pay = scanner.nextInt();
                    switch (pay) {
                        case 1:
                            System.out.println("Введите сумму:");
                            int cash = scanner.nextInt();
                            checking.addMoney(cash);
                            break;
                        case 2:
                            System.out.println("1.Сберегательный счет");
                            System.out.println("2.Кредитный счет");
                            int moneyTransfer = scanner.nextInt();
                            if (moneyTransfer != 1 && moneyTransfer != 2) {
                                System.out.println("Такой операции нет...");
                                break;
                            }
                            System.out.println("Введите сумму:");
                            cash = scanner.nextInt();
                            if (moneyTransfer == 1) {
                                checking.transfer(saving, cash);
                            } else {
                                checking.transfer(credit, cash);
                            }
                            break;
                        case 3:
                            System.out.println("Введите сумму:");
                            cash = scanner.nextInt();
                            checking.pay(cash);
                            break;
                        default:
                            System.out.println("Такой операции нет");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Сберегательный счет: " + saving.getBalance());
        System.out.println("Кредитный счет: " + credit.getBalance());
        System.out.println("Расчетный счет: " + checking.getBalance());
    }
}