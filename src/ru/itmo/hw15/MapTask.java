package ru.itmo.hw15;

import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который приннимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        System.out.println(cityMethod(firstTaskMap, city));


        // TODO:: дан список слов (words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов
        //  в списке вида Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(countWords (words) );


        // TODO:: дана мапа (customerMap).
        //  Написать статический метод, который принимает на вход агрументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(newCustomerMap(customerMap,20,50) );


    }

    static ArrayList<String> cityMethod(HashMap<String, String> firstTaskMap, String city) {
        ArrayList<String> logins = new ArrayList<>();
        for (Map.Entry<String, String> pair : firstTaskMap.entrySet()) {
            if (pair.getValue().equals(city)) {
                logins.add(pair.getKey());
            }
        }
        return logins;
    }

    static HashMap<String, Integer> countWords (List<String>words) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (!count.containsKey(word)) {
                count.put(word, 1);

            } else {
                int x=count.get(word);
                count.replace(word, x+= 1);
            }
        }
        return count;
    }
    static HashMap<String, Customer>  newCustomerMap (HashMap<String, Customer> customerMap, int from, int to) {
        HashMap<String,Customer>newMap=new HashMap<>();
        for (Map.Entry<String, Customer> pair : customerMap.entrySet()) {
            if (pair.getValue().getAge() >= from && pair.getValue().getAge()<=to) {
                newMap.put(pair.getKey(), pair.getValue());
            }
        }
        return newMap;

    }

}