package ru.itmo.hw14;

import java.util.*;



public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритета
        //  Ответ в консоль
        int[] counts = new int[MessagePriority.values().length];
        for(Message message:messageList){
            counts[message.getPriority().ordinal()]+=1;
        }
        System.out.println(counts);
        }


    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль


        int[] codes=new int[10];
        for(Message message:messageList){
            codes[message.getCode()]+=1;
        }
        System.out.println(codes);
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message>original=new HashSet<>(messageList);
        System.out.println(original.size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        return new ArrayList<>(new  LinkedHashSet<>(messageList));
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        Iterator<Message>iterator= messageList.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getPriority()==priority){
                iterator.remove();
            }
        }
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        Iterator<Message>iterator= messageList.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getPriority()!=priority){
                iterator.remove();
            }
        }
    }

}
