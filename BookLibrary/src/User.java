
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raul
 */
public class User {
    
    private String name;
    private int age;
    private String email;
    private String password;
    private List<Book> bookLibrary = new ArrayList(); 
    
    //Construct
    public User() {
        this.name = null;
        this.age = 0;
        this.email = null;
        this.password = null;
    }
    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, int age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }
    
    //Get and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBookLibrary() {
        return bookLibrary;
    }

    public void setBookLibrary(List<Book> bookLibrary) {
        this.bookLibrary = bookLibrary;
    }
    
    
    
}
