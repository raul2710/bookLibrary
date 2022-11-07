package model;

import java.sql.Date;

public class Loan {
    
    private int id;
    private int id_book;
    private int id_user;
    private Date dateBorrow;
    private Date dateReturn;
    private String status;

    public Loan() {
    }

    public Loan(int id, int id_book, int id_user, Date dateBorrow, Date dateReturn, String status) {
        this.id = id;
        this.id_book = id_book;
        this.id_user = id_user;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(Date dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
