package homeworkBank;

public class CheckingAccount extends Account {   //  Расчетный счет
    public CheckingAccount(int balance) {
        super(balance);
    }

    @Override
    public void pay(int amount) {
        if (amount > balance) {
            System.out.println("Расчетный счет: Недостаточно средств");
        } else {
            int balance = -amount;
            setBalance(balance);
            System.out.println("Расчетный счет: Списание на сумму: " + amount + " Баланс: " + getBalance());
        }
    }

    @Override
    public void transfer(Account account, int amount) {  //не можем уходить в минус
        if (amount > balance) {
            System.out.println("Расчетный счет: Недостаточно средств");
        } else {
            int destination = account.getBalance();
            int balance = amount;
            account.setBalance(balance);
            if (destination == account.getBalance())
                System.out.println("Money transfer error!");
            else {
                balance = -balance;
                setBalance(balance);
                System.out.println("Расчетный счет: Перевод в размере: " + amount + " Баланс: " + getBalance());
            }
        }
    }

    @Override
    public void addMoney(int amount) {
        int balance = amount;
        setBalance(balance);
        System.out.println("Расчетный счет: Пополнение на сумму: " + amount + " Баланс: " + getBalance());
    }
}