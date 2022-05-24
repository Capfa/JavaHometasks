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

        System.out.println(countWords(words));


        // TODO:: дана мапа (customerMap).
        //  Написать статический метод, который принимает на вход агрументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(newCustomerMap(customerMap, 20, 50));

        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод (можно статический):
        //  1. написать метод, принимающий на вход слово и возвращающий частоту
        //  встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы
        //  по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        // Map<String, Long>,
        // где - ключи (String) - слово,
        // значения (Long) - частота встречаемости
        // ArrayList<Map.Entry<String, Long>>
        // отсортировать список по Long с помощью компаратора
        printTopTen(text);


    }

    static List<String> cityMethod(HashMap<String, String> firstTaskMap, String city) {
        List<String> logins = new ArrayList<>();
        for (Map.Entry<String, String> pair : firstTaskMap.entrySet()) {
            if (pair.getValue().equals(city)) {
                logins.add(pair.getKey());
            }
        }
        return logins;
    }

    static Map<String, Integer> countWords(List<String> words) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (!count.containsKey(word)) {
                count.put(word, 1);

            } else {
                int x = count.get(word);
                count.replace(word, x += 1);
            }
        }
        return count;
    }

    static HashMap<String, Customer> newCustomerMap(HashMap<String, Customer> customerMap, int from, int to) {
        HashMap<String, Customer> newMap = new HashMap<>();
        for (Map.Entry<String, Customer> pair : customerMap.entrySet()) {
            if (pair.getValue().getAge() >= from && pair.getValue().getAge() <= to) {
                newMap.put(pair.getKey(), pair.getValue());
            }
        }
        return newMap;

    }

    private static int wordCount(String text, String wordToFind) {
        String[] words = text.split(" ");
        int count = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(wordToFind)) {
                count += 1;
            }
        }
        return count;

    }

    private static Map<Integer, Set<String>> getGroupsByLettersCount(String text) {
        Map<Integer, Set<String>> groups = new HashMap<>();
        String[] words = text.trim().toLowerCase().split(" ");
        for (String word : words) {
            // if (groups.containsKey(word.length())){
            //     groups.get(word.length()).add(word);
            //  }else{
            //      HashSet<String>hashSet=new HashSet<>();
            //      hashSet.add(word);
            //      groups.put(words.length,hashSet);
            //  }
            Set<String> counts = groups.getOrDefault(word.length(), new HashSet<>());
            counts.add(word);
            groups.put(word.length(), counts);
        }
        return groups;
    }


    private static void printTopTen(String text) {
        String[] words = text.trim().toLowerCase().split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(hashMap.entrySet());
        System.out.println(entries);
        entries.sort(new ValueComparator());

        for (int i = 0; i < 10; i++) {
            System.out.println(entries.get(i).getKey());
        }
    }
}

class ValueComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o2.getValue() - o1.getValue();
    }


}

