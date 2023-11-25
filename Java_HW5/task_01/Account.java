package task_01;
public class Account {
    private double balance;

    public Account() {
        balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Account account = new Account();
        double amountToDeposit = 80.0; // сумма для пополнения счета
        double expectedBalance = 80.0; // ожидаемый баланс

        account.deposit(amountToDeposit);

        if (account.getBalance() == expectedBalance) {
            System.out.println("Баланс на счете составляет " + expectedBalance + " рублей");
        } else {
            System.out.println("Баланс на счете не соответствует ожидаемой сумме");
        }
    }
}