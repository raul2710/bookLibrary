/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 836461
 */
public class Book {
    
    private String title;
    private String publisher;
    private String author;
    private int isbn;
    private String genre;
    private String description;
    
    //Construct
    public Book(){
        this.title = null;
        this.publisher = null;
        this.author = null;
    }

    public Book(String title, String publisher, String author, int isbn, String genre, String description) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.isbn = isbn;
        //this.recomendedAge = recomendedAge;
        this.genre = genre;
        this.description = description;
    }
    
    //Get and setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

