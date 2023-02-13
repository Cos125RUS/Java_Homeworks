package Task01;
//Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}


import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;


public class Task01 {
    static String[] sepor = {"name", "country", "city", "age"};
    static int size = 4;

    public static void main(String[] args) {
        String title = "select * from students where ";
        String[] student = readJSON();
        String[] values = getValue(student);
        Map <String, String> pair = addPair(values);
        String request = addRequest(pair, title);
        System.out.println(request);
    }

    public static String[] readJSON() {
        String path = "C:\\repo\\Java\\Homeworks\\Homework02\\Task01\\student.json";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String[] addStudent = new String[size];
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (!line.equals("{") && !line.equals("}")){
                    addStudent[i] = line.trim();
                    i++;
                }
            }
            return addStudent;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static String[] getValue(String[] student){
        String[] values = new String[size];
        for (int i = 0; i < size; i++) {
            values[i] = student[i].replaceAll(sepor[i], "")
                    .replaceAll(": ", "")
                    .replace('"',' ').replace(',',' ').trim();
        }
        return values;
    }

    public static Map<String, String> addPair(String[] values){
        Map<String, String> pair = new HashMap<>();
        for (int i = 0; i < size; i++)
            if (!values[i].equals("null"))
                pair.put(sepor[i], values[i]);
        return pair;
    }

    public static String addRequest(Map<String, String> pair, String title){
        StringBuilder request = new StringBuilder();
        request.append(title);
        int size = pair.size();
        int i = 0;
        for (Entry<String, String> entry: pair.entrySet()) {
            request.append(entry.getKey()).append(" = ")
                    .append(entry.getValue());
            if (i < size - 1){
                request.append(" and ");
                i++;
            }
        }
        return request.toString();
    }
}
