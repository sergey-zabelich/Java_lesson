package task_02;
public class Account {
    private double balance;

    public Account() {
        balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств на счете");
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Account account = new Account();
        double amountToDeposit = 100.0; // сумма для пополнения счета
        double amountToWithdraw = 50.0; // сумма для снятия со счета
        double expectedBalance = amountToDeposit - amountToWithdraw; // ожидаемый баланс

        account.deposit(amountToDeposit);
        account.withdraw(amountToWithdraw);

        if (account.getBalance() == expectedBalance) {
            System.out.println("Баланс на счете составляет " + expectedBalance + " рублей");
        } else {
            System.out.println("Баланс на счете не соответствует ожидаемой сумме");
        }
    }
}