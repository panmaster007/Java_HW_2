// Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Пример данной строки {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow

import java.util.Scanner;

// public class Task_1 {
//     public static void main(String[] args) {
//         String inString;
//         String resultStr = "select * from students WHERE "; // результирующая строка, начало
//         StringBuilder sb = new StringBuilder();
        
//         sb.append(resultStr);
//         System.out.println();
//         // Принимаем от пользователя строку
//         System.out.printf("Введите строку: ");
//         Scanner sc = new Scanner(System.in);
//         inString = sc.nextLine();
//         System.out.println();
//         // Убираем скобки в начале и конце
//         inString = inString.substring(1,(inString.length()-1));
//         // Разбиваем строку на элементы строкового массива
//         String[] fieldsArr = inString.split(",");
//         // Создаем массив для хранения обработанных данных
//         String[][] fArr = new String[fieldsArr.length][2];
//         String tempStr;
        
//         boolean beforeIsNotNull = false; // флаг-указатель на то, что данная запись - не первая вносимая
//         int ind;//индекс двоеточия в элементе fieldsArr
//         for (int i = 0; i < (fieldsArr.length); i++) {
//                 tempStr = fieldsArr[i];
//                 // Разбиваем поля по двоеточию (названию-значению) и заполняем массив "чистыми" элементами
//                 ind = tempStr.indexOf(':');
//                 fArr[i][0] = tempStr.substring(1,ind-1);
//                 fArr[i][1] = tempStr.substring(ind+2,tempStr.length()-1);
//                 // дополняем строку-заготовку данными, где значения поля не равны "null"
//                 if ((fArr[i][1]).equals("null") != true) {
//                     tempStr = fArr[i][0] +  " " + '=' +  " "  + fArr[i][1];
//                     if (beforeIsNotNull == true) {
//                         tempStr = " AND " + tempStr;
//                     }
//                     // дополняем финальную строку (результирующую) итогами работы цикла
//                     sb.append(tempStr);
//                     beforeIsNotNull = true;
//                 }
//         }
//         System.out.println(sb);                                            
//         System.out.println();   
//     }
// }

// package Lesson_2.HW;

public class Task_1 {
    public static void main(String[] args) throws Exception {
        String[] list = my_lib.ReadLineFromFile("dataSelect.txt");
        System.out.println(list[0]);
        StringBuilder resultSelect = LineInList(list[0]);
        System.out.println(resultSelect);
    }

    public static StringBuilder LineInList(String line) {
        String line1 = line.replace("{", "");
        String line2 = line1.replace("}", "");
        String line3 = line2.replaceAll("\"", "");
        System.out.println(line3);
        StringBuilder result = new StringBuilder("select * from students where ");

        String[] arrayData = line3.split(", ");
        for (int i = 0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            if (arrData[1].equals("null") == false) {
                if (i != 0) {
                    result.append(", ");
                    result.append(arrData[0]);
                    result.append(" = ");
                    result.append(arrData[1]);
                } else {
                    result.append(arrData[0]);
                    result.append(" = ");
                    result.append(arrData[1]);
                }
            }

        }
        return result;
    }
}
