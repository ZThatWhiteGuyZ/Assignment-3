import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class ArithmeticCAI
{

    static int TypeChoice(Scanner userIn)
    {
        System.out.printf("What type of problem would you like to practice?\n1: Addition\n2: Multiplication\n3: Subtraction\n4: Division\n5: Mix\n");
        return (userIn.nextInt());
    }

    static int Sum(int difficulty, int type)
    {
        Scanner input = new Scanner(System.in);
        Random summandRand = new SecureRandom();
        Random responseRand = new Random();
        int level = 1, answer, correctCheck = 0;

        for (int i = 0; i < difficulty; i++)
            level *= 10;

        int summand1 = summandRand.nextInt(level), summand2 = summandRand.nextInt(level);


        while (correctCheck == 0)
        {
            int response = (1 + responseRand.nextInt(4));

            SumPrint(summand1, summand2);
            answer = input.nextInt();


            if (answer == (summand1 + summand2))
            {
                CorrectResponsePrint(response);
                correctCheck = 1;
            }
            else
            {
                IncorrectResponsePrint(response);

                if (GotItWrong(summand1, summand2, response, type) == 0)
                    correctCheck = 0;

                else
                    return 0;
            }
        }
        return 1;
    }

    static int Product(int difficulty, int type)
    {
        Scanner input = new Scanner(System.in);
        Random coefficientRand = new SecureRandom();
        Random responseRand = new Random();
        int level = 1, answer, correctCheck = 0;

        for (int i = 0; i < difficulty; i++)
            level *= 10;

        int coefficient1 = coefficientRand.nextInt(level), coefficient2 = coefficientRand.nextInt(level);


        while (correctCheck == 0)
        {
            int response = (1 + responseRand.nextInt(4));

            ProductPrint(coefficient1, coefficient2);
            answer = input.nextInt();


            if (answer == (coefficient1 * coefficient2))
            {
                CorrectResponsePrint(response);
                correctCheck = 1;
            }
            else
            {
                IncorrectResponsePrint(response);

                if (GotItWrong(coefficient1, coefficient2, response, type) == 0)
                    correctCheck = 0;

                else
                    return 0;
            }
        }
        return 1;
    }

    static int Difference(int difficulty, int type)
    {
        Scanner input = new Scanner(System.in);
        Random subtrahendMinuend = new SecureRandom();
        Random responseRand = new Random();
        int level = 1, answer, correctCheck = 0;

        for (int i = 0; i < difficulty; i++)
            level *= 10;

        int subtrahend = subtrahendMinuend.nextInt(level), minuend = subtrahendMinuend.nextInt(level);


        while (correctCheck == 0)
        {
            int response = (1 + responseRand.nextInt(4));

            DifferencePrint(subtrahend, minuend);
            answer = input.nextInt();


            if (answer == (subtrahend - minuend))
            {
                CorrectResponsePrint(response);
                correctCheck = 1;
            }
            else
            {
                IncorrectResponsePrint(response);

                if (GotItWrong(subtrahend, minuend, response, type) == 0)
                    correctCheck = 0;

                else
                    return 0;
            }
        }
        return 1;
    }

    static int Quotient(int difficulty, int type)
    {
        Scanner input = new Scanner(System.in);
        Random dividendDivisorRand = new SecureRandom();
        Random responseRand = new Random();
        int level = 1, correctCheck = 0;
        double answer;
        final double THRESHOLD = .001;

        for (int i = 0; i < difficulty; i++)
            level *= 10;

        int dividend = dividendDivisorRand.nextInt(level), divisor = dividendDivisorRand.nextInt(level);

        if (divisor > dividend)
        {
            int temp;
            temp = divisor;
            divisor = dividend;
            dividend = temp;
        }

        while (correctCheck == 0)
        {
            int response = (1 + responseRand.nextInt(4));

            if (divisor == 0)
                divisor++;

            QuotientPrint(dividend, divisor);
            answer = input.nextDouble();

            if (Math.abs(answer) - Math.abs((double) dividend / (double) divisor) < THRESHOLD)
            {
                CorrectResponsePrint(response);
                correctCheck = 1;
            }
            else
            {
                IncorrectResponsePrint(response);

                if (GotItWrong(dividend, divisor, response, type) == 0)
                    correctCheck = 0;

                else
                    return 0;
            }
        }
        return 1;
    }

    static int Mix(int difficulty, int mixQuestionNumber, int questionNumber, int correctResponseCount, int continueCheck, Scanner userIn, int mixFactor)
    {
        Random typeRand = new Random();
        int type = 1 + typeRand.nextInt(4);

        {
            for(mixFactor = 0; mixFactor < questionNumber; mixFactor++)
            {
                correctResponseCount += ProblemType((mixQuestionNumber / mixQuestionNumber), questionNumber, correctResponseCount, type, difficulty, continueCheck, userIn, mixFactor);

                if(continueCheck == 0)
                    return continueCheck;
                else
                    type = 1 + typeRand.nextInt(4);
            }
        }
        return 0;
    }

    static void SumPrint(int summand1, int summand2)
    {
        System.out.println("How much is " + summand1 + " plus " + summand2 + "?");
    }

    static void ProductPrint(int coefficient1, int coefficient2)
    {
        System.out.println("How much is " + coefficient1 + " times " + coefficient2 + "?");
    }

    static void DifferencePrint(int subtrahend, int minuend)
    {
        System.out.println("How much is " + subtrahend + " minus " + minuend + "?");
    }

    static void QuotientPrint(int dividend, int divisor)
    {
        System.out.println("How much is " + dividend + " divided by " + divisor + "? Please use round to four decimal places.");
    }

    static void CorrectResponsePrint(int response)
    {
        switch (response)
        {
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
        }
    }

    static void IncorrectResponsePrint(int response)
    {
        switch (response)
        {
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don't give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
        }
    }

    static int GotItWrong(int term1, int term2, int response, int type)
    {
        Scanner input = new Scanner(System.in);
        int answer;
        double quotient;
        final double THRESHOLD = .001;

        switch(type)
        {
            case 1:
            {
                SumPrint(term1, term2);
                answer = input.nextInt();

                if (answer == (term1 + term2))
                {
                    CorrectResponsePrint(response);
                    return 1;
                }
                else
                    return 0;
            }
            case 2:
            {
                ProductPrint(term1, term2);
                answer = input.nextInt();

                if (answer == (term1 * term2))
                {
                    CorrectResponsePrint(response);
                    return 1;
                }
                else
                    return 0;
            }
            case 3:
            {
                DifferencePrint(term1, term2);
                answer = input.nextInt();

                if (answer == (term1 - term2))
                {
                    CorrectResponsePrint(response);
                    return 1;
                }
                else
                    return 0;
            }
            case 4:
            {
                QuotientPrint(term1, term2);
                quotient = input.nextDouble();

                if (Math.abs(quotient) - Math.abs((double) term1 / (double) term2) < THRESHOLD)
                {
                    CorrectResponsePrint(response);
                    return 1;
                }

                else
                {
                    return 0;
                }
            }
        }
        return 0;
    }

    static int DifficultyChoice(Scanner userIn)
    {
        System.out.println("What level would you like to select? (1 - 4)");
        return (userIn.nextInt());
    }

    static int ProblemType(int mixQuestionNumber , int questionNumber, int correctResponseCount, int type, int difficulty, int continueCheck, Scanner userIn, int mixFactor)
    {

        switch (type)
        {
            case 1:
            {
                for (int i = 0; i < mixQuestionNumber; i++)
                {
                    correctResponseCount += Sum(difficulty, type);

                    if (i == (questionNumber - 1) || mixFactor == (questionNumber - 1))
                    {
                        System.out.println((float) (correctResponseCount * (100 / questionNumber)) + "%");

                        if ((float) (correctResponseCount * (100 / questionNumber)) >= 75.0)
                            System.out.println("Congratulations, you are ready to go to the next level!");
                        else
                            System.out.println("Please ask your teacher for extra help.");

                        System.out.println("If you wish to start a new session, input 1. Otherwise, input -1.");
                        continueCheck = userIn.nextInt();

                        if (continueCheck == 1)
                        {
                            correctResponseCount = 0;
                            difficulty = DifficultyChoice(userIn);
                            type = TypeChoice(userIn);
                            ProblemType(mixQuestionNumber, questionNumber, correctResponseCount, type, difficulty, continueCheck, userIn, mixFactor);
                        }
                        else
                        {
                            continueCheck = 0;
                            return(continueCheck);
                        }
                    }
                }
                break;
            }

            case 2:
            {
                for (int i = 0; i < mixQuestionNumber; i++)
                {
                    correctResponseCount += Product(difficulty, type);

                    if (i == (questionNumber - 1) || mixFactor == (questionNumber - 1))
                    {
                        System.out.println((float) (correctResponseCount * (100 / questionNumber)) + "%");

                        if ((float) (correctResponseCount * (100 / questionNumber)) >= 75.0)
                            System.out.println("Congratulations, you are ready to go to the next level!");
                        else
                            System.out.println("Please ask your teacher for extra help.");

                        System.out.println("If you wish to start a new session, input 1. Otherwise, input -1.");
                        continueCheck = userIn.nextInt();

                        if (continueCheck == 1)
                        {
                            correctResponseCount = 0;
                            difficulty = DifficultyChoice(userIn);
                            type = TypeChoice(userIn);
                            ProblemType(mixQuestionNumber, questionNumber, correctResponseCount, type, difficulty, continueCheck, userIn, mixFactor);
                        }
                        else
                        {
                            continueCheck = 0;
                            return(continueCheck);
                        }
                    }
                }
                break;
            }

            case 3:
            {
                for (int i = 0; i < mixQuestionNumber; i++)
                {
                    correctResponseCount += Difference(difficulty, type);

                    if (i == (questionNumber - 1) || mixFactor == (questionNumber - 1))
                    {
                        System.out.println((float) (correctResponseCount * (100 / questionNumber)) + "%");

                        if ((float) (correctResponseCount * (100 / questionNumber)) >= 75.0)
                            System.out.println("Congratulations, you are ready to go to the next level!");
                        else
                            System.out.println("Please ask your teacher for extra help.");

                        System.out.println("If you wish to start a new session, input 1. Otherwise, input -1.");
                        continueCheck = userIn.nextInt();

                        if (continueCheck == 1)
                        {
                            correctResponseCount = 0;
                            difficulty = DifficultyChoice(userIn);
                            type = TypeChoice(userIn);
                            ProblemType(mixQuestionNumber, questionNumber, correctResponseCount, type, difficulty, continueCheck, userIn, mixFactor);
                        }
                        else
                        {
                            continueCheck = 0;
                            return(continueCheck);
                        }
                    }
                }
                break;
            }

            case 4:
            {
                for (int i = 0; i < mixQuestionNumber; i++)
                {
                    correctResponseCount += Quotient(difficulty, type);

                    if (i == (questionNumber - 1) || mixFactor == (questionNumber - 1))
                    {
                        System.out.println((float) (correctResponseCount * (100 / questionNumber)) + "%");

                        if ((float) (correctResponseCount * (100 / questionNumber)) >= 75.0)
                            System.out.println("Congratulations, you are ready to go to the next level!");
                        else
                            System.out.println("Please ask your teacher for extra help.");

                        System.out.println("If you wish to start a new session, input 1. Otherwise, input -1.");
                        continueCheck = userIn.nextInt();

                        if (continueCheck == 1)
                        {
                            correctResponseCount = 0;
                            difficulty = DifficultyChoice(userIn);
                            type = TypeChoice(userIn);
                            ProblemType(mixQuestionNumber, questionNumber, correctResponseCount, type, difficulty, continueCheck, userIn, mixFactor);
                        }
                        else
                        {
                            continueCheck = 0;
                            return(continueCheck);
                        }
                    }
                }
                break;
            }

            case 5:
            {
                mixFactor = 0;
                Mix(difficulty, mixQuestionNumber, questionNumber, correctResponseCount, continueCheck, userIn, mixFactor);
                break;
            }
        }
        return 1;
    }

    public static void main(String args[])
    {
        int questionNumber = 5, mixQuestionNum = 5, continueCheck = -5, difficulty = 0, type = 0, mixFactor = -1, correctResponseCount = 0;

        Scanner userIn = new Scanner(System.in);

        difficulty = DifficultyChoice(userIn);
        type = TypeChoice(userIn);


        ProblemType(mixQuestionNum, questionNumber, correctResponseCount, type, difficulty, continueCheck, userIn, mixFactor);

    }
}
