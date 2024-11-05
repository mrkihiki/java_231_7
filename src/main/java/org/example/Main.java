package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println("visitors count = "+visitors.size());
        visitors.forEach(e -> System.out.println(e));
        //2

    }
}