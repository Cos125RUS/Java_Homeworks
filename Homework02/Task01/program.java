package Task01;
//Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}


import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Map;

public class program {
    public static void main(String[] args) {
        String title = "select * from students where ";
//        StringBuilder request = new StringBuilder();
//        request.append(title);
        String student = readJSON().replace("{", "").
                replace("}", "").trim();
        System.out.println(student);
        breaker(student);
    }

    public static String readJSON() {
        String path = "C:\\repo\\Java\\Homeworks\\Homework02\\Task01\\student.json";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder addStudent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                addStudent.append(line);
            }
            return addStudent.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void breaker(String line) {
//        Map<String, String> res = new HashMap<>();
        String[] sepor = {"name", "country", "city", "age"};
        for (String key: sepor) {
            int index = line.lastIndexOf(key) + key.length() + 4;
            int i = index;
            while (line.charAt(i) != '"'){
                System.out.print(line.charAt(i));
                i++;
            }
            char[] value = new char[i - index];
            line.getChars(index, i, value, 0);
            System.out.println(value.toString());
//            res.put(key,value);
        }


//        char[] text = line.toCharArray();
//        int size = line.length();
//        int i = 0;
//        while (i< size){
//            if (text[i] == ':'){
//                System.out.println(i);
//            }
//            i++;
//        }

//        return res;
    }
}
