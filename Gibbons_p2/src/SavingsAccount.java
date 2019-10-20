
public class SavingsAccount
{
    private double savingsBalance;
    private static double annualInterestRate;

    public  SavingsAccount(double balance)
    {
        savingsBalance = balance;
    }

    public void CalculateMonthlyInterest()
    {
        for(int i = 0; i < 12; i++)
        {
            savingsBalance += ((annualInterestRate * savingsBalance) / 12);
        }
        System.out.printf("New balance: %.2f\n", savingsBalance);
    }

    private static void ChangeInterestRate(double newRate)
    {
        annualInterestRate = newRate;
    }

    public static void ModifyInterestRate(double newRate)
    {
        ChangeInterestRate(newRate);
    }

}
