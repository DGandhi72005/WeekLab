import java.util.*;

public class EvaluatingTheParenthesis
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter expression: ");

        //(putting for memory) - input should be ( 1 + ( ( 2 - 3 ) * ( 14 * 5 ) ) ) as my test

        Scanner scan = new Scanner(input.nextLine());
        double result = evaluationRecursive(scan);
        System.out.println(result);
    }

    private static double evaluationRecursive(Scanner scan)
    {
        String valueForRecursion = scan.next();

        if (valueForRecursion.equals("(")) {
            double firstVariable = evaluationRecursive(scan);
            String operationOfTheVariable = scan.next();
            double SecondVariable;

            if (operationOfTheVariable.equals("sqrt")) {
                SecondVariable = 0;
                double value = evaluationRecursive(scan);
                scan.next();
                return Math.sqrt(value);
            } else {
                SecondVariable = evaluationRecursive(scan);
                scan.next();

                if (operationOfTheVariable.equals("+")) return firstVariable + SecondVariable;
                if (operationOfTheVariable.equals("-")) return firstVariable - SecondVariable;
                if (operationOfTheVariable.equals("*")) return firstVariable * SecondVariable;
                if (operationOfTheVariable.equals("/")) return firstVariable / SecondVariable;
            }
        }
        return Double.parseDouble(valueForRecursion);
    }
}
