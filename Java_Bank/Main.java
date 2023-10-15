public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.put(100.0);
        account.take(50.0);
        System.out.println("Основной Счёт:");
        System.out.println("Пополнение: 100.0");
        System.out.println("Снятие: 50.0");
        System.out.println("Остаток: " + account.getAmount());

        CreditAccount creditAccount = new CreditAccount();
        creditAccount.put(100.0);
        creditAccount.take(50.0);
        System.out.println("Кредитный Счёт:");
        System.out.println("Пополнение: 100.0");
        System.out.println("Снятие: 50.0");
        System.out.println("Остаток: " + creditAccount.getAmount());

        DepositAccount depositAccount = new DepositAccount();
        depositAccount.put(100.0);
        depositAccount.take(50.0);
        depositAccount.take(30.0);
        System.out.println("Депозитный Счёт:");
        System.out.println("Пополнение: 100.0");
        System.out.println("Снятие: 50.0");
        System.out.println("Снятие: 30.0");
        System.out.println("Остаток: " + depositAccount.getAmount());
    }
}