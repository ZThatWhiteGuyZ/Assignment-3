import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest
{
    @Test
            public void Saver1Test()
    {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        saver1.ModifyInterestRate(.04);
        saver1.CalculateMonthlyInterest();

        assertEquals(2081.48, 2081.48, 0.01);
    }

    @Test
    public void Saver2Test()
    {
        SavingsAccount saver1 = new SavingsAccount(3000.00);
        saver1.ModifyInterestRate(.04);
        saver1.CalculateMonthlyInterest();

        assertEquals(3122.22, 3122.22, 0.01);
    }

    @Test
    public void InterestCHangeSaver1Test()
    {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        saver1.ModifyInterestRate(.05);
        saver1.CalculateMonthlyInterest();

        assertEquals(2102.32, 2102.32, 0.01);
    }

    @Test
    public void InterestChangeSaver2Test()
    {
        SavingsAccount saver1 = new SavingsAccount(3000.00);
        saver1.ModifyInterestRate(.05);
        saver1.CalculateMonthlyInterest();

        assertEquals(3153.49, 3153.49, 0.01);
    }
}
