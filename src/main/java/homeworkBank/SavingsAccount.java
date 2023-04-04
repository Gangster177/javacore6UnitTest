package homeworkBank;

public class SavingsAccount extends Account {   //  Сберегательный счет

    public SavingsAccount(int balance) {
        super(balance);
    }

    @Override
    public void pay(int amount) {
        System.out.println("Списание средств невозможно. Операции: 1.Перевод 2.Пополнение");
    }

    @Override
    public void transfer(Account account, int amount) { //не можем уходить в минус
        if (amount > balance) {
            System.out.println("Сберегательный счет: Недостаточно средств");
        } else {
            int destination = account.getBalance();
            int balance = amount;
            account.setBalance(balance);
            if (destination == account.getBalance())
                System.out.println("Money transfer error!");
            else {
                balance = -balance;
                setBalance(balance);
                System.out.println("Сберегательный счет: перевод в размере " + amount + " Баланс: " + getBalance());
            }
        }
    }

    @Override
    public void addMoney(int amount) {
        int balance = amount;
        setBalance(balance);
        System.out.println("Сберегательный счет: пополнение в размере " + amount + " Баланс: " + getBalance());
    }
}