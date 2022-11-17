package model;

public class Book {
    
    private int id;
    private String isbn;
    private String title;
    private int id_genre;
    private int id_publisher;
    private int id_author;
    private int edition;
    private int rating;
    private String status;
    private String description;
    
    public Book() {
    }

    public Book(int id, String isbn, String title, int id_genre, int id_publisher, int id_author, int edition, int rating, String status, String description) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.id_genre = id_genre;
        this.id_publisher = id_publisher;
        this.id_author = id_author;
        this.edition = edition;
        this.rating = rating;
        this.status = status;
        this.description = description;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    public int getId_publisher() {
        return id_publisher;
    }

    public void setId_publisher(int id_publisher) {
        this.id_publisher = id_publisher;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title;
    }
}

