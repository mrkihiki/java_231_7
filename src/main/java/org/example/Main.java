package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //public static Gson gson;
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //System.out.printf("Hello and welcome!");
        File input = new File("books.json");
        Gson gson =new Gson();
        List<Visitor> visitors;
        try {
            visitors= gson.fromJson(new FileReader(input),new TypeToken<>(){});
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //1
        System.out.println("task: 1");
        System.out.println("visitors count = "+visitors.size());
        visitors.forEach(System.out::println);
        //2
        System.out.println("task: 2");
        List<Book> favoriteBooks = visitors.stream()
                .flatMap(e ->e.getFavoriteBooks().stream())
                //.flatMap(e->e.getName().describeConstable().stream())
                .distinct()
                .toList();
        System.out.println(favoriteBooks.size());
        favoriteBooks.forEach(System.out::println);
        //3
        System.out.println("task: 3");
        favoriteBooks.stream()
                .sorted(Comparator.comparing(Book::getPublishingYear))
                .forEach(System.out::println);
        //4
        System.out.println("task: 4");
        boolean hasJaneAusten=favoriteBooks.stream()
                .anyMatch(book -> book.getAuthor().equals("Jane Austen"));
        System.out.println(hasJaneAusten);
        //5
        System.out.println("task: 5");
        System.out.println("max number of books in favorites: "
                +visitors.stream()
                .mapToInt(visitor -> visitor.getFavoriteBooks().size())
                .max().orElse(0));
        //6
        System.out.println("task: 6");
        //System.out.println(visitors.stream().Map(e->e.getFavoriteBooks()));
//        int x = visitors.stream()
//                .flatMap(e ->e.getFavoriteBooks().stream())
//                //.flatMap(e->e.getName().describeConstable().stream())
//                .toList().size();
        float average = (float) visitors.stream()
                .mapToInt(e ->e.getFavoriteBooks().size())
                .average().orElse(0);
        List<Sms> sms = visitors.stream()
                .filter(Visitor::isSubscribed)
                .map(visitor -> {
                    int favoriteCount = visitor.getFavoriteBooks().size();
                    if (favoriteCount > average) {
                        return new Sms(visitor.getPhone(), "you are a bookworm");
                    } else if (favoriteCount < average) {
                        return new Sms(visitor.getPhone(), "read more");
                    } else {
                        return new Sms(visitor.getPhone(), "fine");
                    }
                })
                .toList();
        sms.forEach(System.out::println);


    }
}