package models;

import java.util.ArrayList;
import java.util.Map;

public class Book {
    private String title;
    private String author;
    private int year;
    private String imageURL;
    private static ArrayList<Book> instances = new ArrayList<>();
    private int id;

    public Book(String title, String author, int year, String imageURL) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.imageURL = imageURL;
        instances.add(this);
        this.id = instances.size();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getImageURL() {
        return imageURL;
    }

    public static ArrayList<Book> getAll() {
        return instances;
    }
    public static void clearAllBooks(){
        instances.clear();
    }

    public int getId() {
        return id;
    }

    public static Book findById(int id){
        return instances.get(id-1);
    }
}
