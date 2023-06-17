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
        char oper;
        String resStr="";
        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getLogger(Task_4.class.getName());
        FileHandler fh = new FileHandler("calc_log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        while (getOut != true) {
            System.out.printf("Введите первое число: ");
            double numA = sc.nextDouble();

            System.out.printf("Введите символ операции ('+','-','*','/'): ");
            oper = sc.next().charAt(0);

            System.out.printf("Введите второе число: ");
            double numB = sc.nextDouble();
            System.out.println();

            switch (oper) {
                case '+':
                    result = numA + numB;
                    System.out.printf("%.2f %c %.2f = %.2f\n", numA, oper, numB, result);
                    resStr = numA + " " + oper + " " + numB + " = " + result;
                    logger.log(Level.WARNING, "Всё в порядке!");
                    logger.info(resStr);
                    break;
                case '-':
                    result = numA - numB;
                    System.out.printf("%.2f %c %.2f = %.2f\n", numA, oper, numB, result);
                    resStr = numA + " " + oper + " " + numB + " = " + result;
                    logger.log(Level.WARNING, "Всё в порядке!");
                    logger.info(resStr);
                    break;
                case '*':
                    result = numA * numB;
                    System.out.printf("%.2f %c %.2f = %.2f\n", numA, oper, numB, result);
                    resStr = numA + " " + oper + " " + numB + " = " + result;
                    logger.log(Level.WARNING, "Всё в порядке!");
                    logger.info(resStr);
                    break;
                case '/':
                    result = numA / numB;
                    System.out.printf("%.2f %c %.2f = %.2f\n", numA, oper, numB, result);
                    resStr = numA + " " + oper + " " + numB + " = " + result;
                    logger.log(Level.WARNING, "Всё в порядке!");
                    logger.info(resStr);
                    break;
                default:
                    getOut = true;
                    break;
            
            }
            System.out.printf("Продолжить? ('Y' or 'y'): ");
            oper = sc.next().charAt(0);
            if (oper == 'y' || oper == 'Y') {
                getOut = false;
            } else getOut = true;
        }
        System.out.println();
        sc.close();
    }
}