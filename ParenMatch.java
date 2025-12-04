//Question 1

/* One application of stacks is to keep track of things that must match up such as parentheses in an expression or
braces in a program. In the case of parentheses when a left parenthesis is encountered it is pushed on the stack
and when a right parenthesis is encountered its matching left parenthesis is popped from the stack. If the stack
has no left parenthesis, that means the parentheses don’t match—there is an extra right parenthesis. If the
expression ends with at least one left parenthesis still on the stack then again the parentheses don’t
match—there is an extra left parenthesis.
File ParenMatch.java contains the skeleton of a program to match parentheses in an expression. It uses the
Stack class provided by Java (in java.util). Complete the program by adding a loop to process the line entered to
see if it contains matching parentheses. Just ignore characters that are neither left nor right parentheses. Your
loop should stop as soon as it detects an error. After the loop print a message indicating what happened—the
parentheses match, there are too many left parentheses, or there are too many right parentheses. Also print the
part of the string up to where the error was detected. */


import java.util.*;
import java.util.Scanner;
public class ParenMatch
{
    public static void main (String[] args)
    {
        Stack s = new Stack();
        String line; 
        Scanner scan = new Scanner(System.in);
        System.out.println ("\nParenthesis Matching");
        System.out.print ("Enter a parenthesized expression: ");
        line = scan.nextLine();
        boolean codeError = false;
        int errorForTheIndex = -1;

        for (int i = 0; i < line.length() && !codeError; i++)
        {
            char ch = line.charAt(i);

            if (ch == '(')
            {
                s.push(ch);
            }
            else if (ch == ')')
            {
                if (s.empty())
                {
                    codeError = true;
                    errorForTheIndex = i;
                } else {
                    s.pop();
                }
            }
        }

        if (codeError) {
            System.out.println("There is too many right parentheses.");
            System.out.println("Error at: " + line.substring(0, errorForTheIndex + 1));
        }
        else if (!s.empty()) {
            System.out.println("There is too many left parentheses.");
            System.out.println("The error happens at: " + line);
        }
        else {
            System.out.println("Parentheses match.");
        }
    }
}
