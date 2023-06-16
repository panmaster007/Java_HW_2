// К калькулятору из предыдущего ДЗ добавить логирование.
// 3+4=7
// 1+2=3
// 6/3=2

import java.util.Scanner;
import java.io.IOException;
import java.util.logging.*;

public class Task_4 {
    public static void main(String[] args)  throws IOException {
        double result;
        boolean getOut = false;
        char opChar;
        String resStr="";
        System.out.println("-----------------------------------------------");
        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getLogger(Task_4.class.getName());
        FileHandler fh = new FileHandler("calculator_log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        // System.out.println("-----------------------------------------------");

        while (getOut != true) {
            System.out.printf("Enter number: ");
            double numA = sc.nextDouble();

            System.out.printf("Enter arithmetic operation symbol (one of '+','-','*','/'): ");
            opChar = sc.next().charAt(0);

            System.out.printf("Enter second number: ");
            double numB = sc.nextDouble();
            System.out.println();

            switch (opChar) {
                case '+':
                    result = numA + numB;
                    System.out.printf("%.2f %c %.2f = %.2f\n", numA, opChar, numB, result);
                    resStr = numA + " " + opChar + " " + numB + " = " + result;
                    logger.log(Level.WARNING, "No WARNING, everything is fine!");
                    logger.info(resStr);
                    break;
                case '-':
                    result = numA - numB;
                    System.out.printf("%.2f %c %.2f = %.2f\n", numA, opChar, numB, result);
                    resStr = numA + " " + opChar + " " + numB + " = " + result;
                    logger.log(Level.WARNING, "No WARNING, everything is fine!");
                    logger.info(resStr);
                    break;
                case '*':
                    result = numA * numB;
                    System.out.printf("%.2f %c %.2f = %.2f\n", numA, opChar, numB, result);
                    resStr = numA + " " + opChar + " " + numB + " = " + result;
                    logger.log(Level.WARNING, "No WARNING, everything is fine!");
                    logger.info(resStr);
                    break;
                case '/':
                    result = numA / numB;
                    System.out.printf("%.2f %c %.2f = %.2f\n", numA, opChar, numB, result);
                    resStr = numA + " " + opChar + " " + numB + " = " + result;
                    logger.log(Level.WARNING, "No WARNING, everything is fine!");
                    logger.info(resStr);
                    break;
                default:
                    getOut = true;
                    break;
            
            }
            System.out.println("-----------------------------------------------");
            System.out.printf("Once more? ('Y' or 'y'): ");
            opChar = sc.next().charAt(0);
            //if(opChar != 'y') getOut = true;
            if (opChar == 'y' || opChar == 'Y') {
                getOut = false;
            } else getOut = true;
        }
        System.out.println();
        sc.close();
        // logger.log(Level.WARNING, "No WARNING, everything is fine!");
        // logger.info(resStr);
        
    }
}