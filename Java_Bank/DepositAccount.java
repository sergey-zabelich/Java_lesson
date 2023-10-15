import java.time.LocalDate;

public class DepositAccount extends Account {
    private LocalDate lastWithdrawalDate;

    @Override
    public void take(double amount) {
        LocalDate currentDate = LocalDate.now();
        if (lastWithdrawalDate == null || currentDate.getMonthValue() > lastWithdrawalDate.getMonthValue()) {
            super.take(amount);
            lastWithdrawalDate = currentDate;
        } else {
            System.out.println("Нельзя снимать средства чаще, чем раз в месяц");
        }
    }
}