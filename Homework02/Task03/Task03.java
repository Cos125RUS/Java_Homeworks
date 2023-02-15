package Task03;
//3.** (Для преподавателя: если не успели выполнить задание 7,
// дать наводку из этого задания) Дана json строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder,
// создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Task03 {
    static String[] attributes = {"фамилия", "оценка", "предмет"};
    static String[] requestAttributes = {"Студент", "получил", "по предмету"};
    static int attributeNums = attributes.length;


    public static void main(String[] args) throws Exception {
        String[][] students = replaceLines(extraction());
        String[] request = addRequest(students);
        printRequest(request);
    }

    static String[][] extraction() throws Exception {
        String path = "C:\\repo\\Java\\Homeworks\\Homework02\\Task03\\Students.json";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        int count = 0;
        while ((line = reader.readLine()) != null){
            if (line.contains(attributes[0])){
                count++;
            }
        }
        String[][] students = new String[count][attributeNums];
        int i = -1;
        int j = 0;
        reader = new BufferedReader(new FileReader(path));
        while ((line = reader.readLine()) != null) {
            if (!line.contains("{") && !line.contains("}")
                    && !line.contains("[") && !line.contains("]")
                    && line.length()>1){
                if (line.contains(attributes[0])){
                    i++;
                    j = 0;
                }
                students[i][j] = line.trim();
                j++;
            }
        }
        return students;
    }

    static String[][] replaceLines(String[][] students){
        for (int i = 0; i < students.length; i++)
            for (int j = 0; j < attributeNums; j++) {
                students[i][j] = students[i][j].replaceAll(attributes[j], "")
                        .replaceAll(": ", "")
                        .replace('"', ' ').replace(',', ' ').trim();
                if (j == 2)
                    students[i][j] = students[i][j].concat(".");
            }
        return students;
    }

    static String[] addRequest(String[][] student){
        int size = student.length;
        String[] requests = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < attributeNums; j++)
                sb.append(requestAttributes[j]).append(" ").append(student[i][j]).append(" ");
            requests[i] = sb.toString();
        }
        return requests;
    }

    static void printRequest(String[] students){
        int size = students.length;
        for (int i = 0; i < size; i++)
            System.out.println(students[i]);
    }
}