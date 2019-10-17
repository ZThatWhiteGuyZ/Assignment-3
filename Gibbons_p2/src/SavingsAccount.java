//import ;

public class SavingsAccount
{
    private int savingsBalance;
    private static float annualInterestRate;

    public  SavingsAccount(int balance)
    {
        savingsBalance = balance;
    }

    public void CalculateMonthlyInterest()
    {
        savingsBalance += ((annualInterestRate * savingsBalance) / 12);
    }

    private static void ChangeInterestRate(float newRate)
    {
        annualInterestRate = newRate;
    }

    public static void ModifyInterestRate(float newRate)
    {
        ChangeInterestRate(newRate);
    }

}
