// Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.
// 1 3 4 2
// 1 3 2 4
// 1 2 3 4

import java.io.IOException;
import java.util.logging.*;

public class Task_2 {
    public static String prA(int[] arg) {
        String workStr="";
        for (int i = 0; i < arg.length; i++){
                System.out.printf(arg[i] + ", ", "utf-8");
                workStr += arg[i] + ", ";

            }
            System.out.println();
        return workStr;
    }
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Task_2.class.getName());
        FileHandler fh = new FileHandler("sort_log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        int[] digArray = new int[] {13, 63, 1, 7};
        prA(digArray);
        int size = digArray.length;
        int bigger = digArray[0];
        for (int i = 1; i < size-1; i++) {
            for (int currPos = 0; currPos < size-1; currPos++) {
                
                if (digArray[currPos] > digArray[(currPos+1)]) {
                    bigger = digArray[currPos];
                    digArray[currPos] = digArray[currPos+1];
                    digArray[currPos+1] = bigger;
                }
                logger.log(Level.WARNING, "Всё в порядке!");
                logger.info(prA(digArray));
                prA(digArray);

            }    
        }
    }
}
