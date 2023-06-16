// Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Пример данной строки {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        String inString;
        String finStr = "select * from students WHERE "; // результирующая строка, начало
        StringBuilder sb = new StringBuilder();
        
        sb.append(finStr);
        System.out.println();
        // Принимаем от пользователя строку
        System.out.printf("Enter string: ");
        Scanner sc = new Scanner(System.in);
        inString = sc.nextLine();
        System.out.println();
        // Убираем скобки в начале и конце
        inString = inString.substring(1,(inString.length()-1));
        // Разбиваем строку на элементы строкового массива
        String[] fieldsArr = inString.split(",");
        // Создаем массив для хранения обработанных данных
        String[][] fArr = new String[fieldsArr.length][2];
        String tempStr;
        
        boolean beforeIsNotNull = false; // флаг-указатель на то, что данная запись - не первая вносимая
        int ind;//индекс двоеточия в элементе fieldsArr
        for (int i = 0; i < (fieldsArr.length); i++) {
                tempStr = fieldsArr[i];
                // Разбиваем поля по двоеточию (названию-значению) и заполняем массив "чистыми" элементами
                ind = tempStr.indexOf(':');
                fArr[i][0] = tempStr.substring(1,ind-1);
                fArr[i][1] = tempStr.substring(ind+2,tempStr.length()-1);
                // дополняем строку-заготовку данными, где значения поля не равны "null"
                if ((fArr[i][1]).equals("null") != true) {
                    tempStr = fArr[i][0] +  " " + '=' +  " "  + fArr[i][1];
                    if (beforeIsNotNull == true) {
                        tempStr = " AND " + tempStr;
                    }
                    // дополняем финальную строку (результирующую) итогами работы цикла
                    sb.append(tempStr);
                    beforeIsNotNull = true;
                }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(sb);
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println();
    
    }
}