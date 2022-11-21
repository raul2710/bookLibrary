package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Loan;

public class LoanDAO {

    private Connection con;
    private PreparedStatement cmd;
    private String tableName = "tb_loan";
    
    public LoanDAO(){
        //abrir uma nova conexão com o banco de dados
        this.con = DatabaseConnection.conectar();
    }
    
    //ACTION: Register loan
    public int add(Loan loan){
        try {
            String SQL = "insert into " + this.tableName + "(id_book, id_user, dateBorrow, dateReturn, status) "
                    + "values (?, ?, ?, ?, ?)";
                    
            cmd = con.prepareStatement(
                SQL,
                Statement.RETURN_GENERATED_KEYS
            );
            
            //definir o valor do parâmetro
            cmd.setInt(1, loan.getId_book());
            cmd.setInt(2, loan.getId_user());
            cmd.setDate(3, loan.getDateBorrow());
            cmd.setDate(4, loan.getDateReturn());
            cmd.setString(5, loan.getStatus());
            
            //executar a operação
            if (cmd.executeUpdate() > 0){
                //operação realizada com sucesso!
                ResultSet rs = cmd.getGeneratedKeys();
                return rs.next() ? rs.getInt(1) : -1;
            }else{
                //não foi possível realizar a operação
                return -1;
            }
            
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }finally{
            DatabaseConnection.desconectar(con);
        }
    }
    
    public int update(Loan loan){
        try {
            String SQL = "update " + this.tableName + " set id_book=?, id_user=?, "
                    + "dateBorrow=?, dateReturn=?, status=? where id=?";
            
            cmd = con.prepareStatement(SQL);
            
            //definir o valor do parâmetro
            cmd.setInt(1, loan.getId_book());
            cmd.setInt(2, loan.getId_user());
            cmd.setDate(3, loan.getDateBorrow());
            cmd.setDate(4, loan.getDateReturn());
            cmd.setString(5, loan.getStatus());
            cmd.setInt(6, loan.getId());
            
            if (cmd.executeUpdate() > 0){
                //Tudo certo com a atualização
                return loan.getId();
            }else{
                //Ocorreu um erro ao atualizar;
                return -1;
            }
            
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }finally{
            DatabaseConnection.desconectar(con);
        }
    }
    
    public List<Loan> searchByUserId(int id){
        try {
            String SQL = "select * from " + this.tableName + " where id_user=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            
            ResultSet rs = cmd.executeQuery();
            List<Loan> lista = new ArrayList<>();
            
            while(rs.next()){
                Loan m = new Loan(
                    rs.getInt("id"),
                    rs.getInt("id_book"),
                    rs.getInt("id_user"),
                    rs.getDate("dateBorrow"),
                    rs.getDate("dateReturn"),
                    rs.getString("status")     
                );
                lista.add(m);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            DatabaseConnection.desconectar(con);
        }
    }
    
    public List<Loan> searchByBookId(int id){
        try {
            String SQL = "select * from " + this.tableName + " where id_book=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            
            ResultSet rs = cmd.executeQuery();
            List<Loan> lista = new ArrayList<>();
            
            while(rs.next()){
                Loan m = new Loan(
                    rs.getInt("id"),
                    rs.getInt("id_book"),
                    rs.getInt("id_user"),
                    rs.getDate("dateBorrow"),
                    rs.getDate("dateReturn"),
                    rs.getString("status")     
                );
                lista.add(m);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            DatabaseConnection.desconectar(con);
        }
    }
    
    public List<Loan> searchByStatusReturned(){
        try {
            String SQL = "select * from " + this.tableName + " where status='Entregue'";
            
            cmd = con.prepareStatement(SQL);
            
            ResultSet rs = cmd.executeQuery();
            List<Loan> lista = new ArrayList<>();
            
            while(rs.next()){
                Loan m = new Loan(
                    rs.getInt("id"),
                    rs.getInt("id_book"),
                    rs.getInt("id_user"),
                    rs.getDate("dateBorrow"),
                    rs.getDate("dateReturn"),
                    rs.getString("status")     
                );
                lista.add(m);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            DatabaseConnection.desconectar(con);
        }
    }
    
    public List<Loan> searchByStatusNotReturned(){
        try {
            String SQL = "select * from " + this.tableName + " where status='Não entregue'";
            
            cmd = con.prepareStatement(SQL);
            
            ResultSet rs = cmd.executeQuery();
            List<Loan> lista = new ArrayList<>();
            
            while(rs.next()){
                Loan m = new Loan(
                    rs.getInt("id"),
                    rs.getInt("id_book"),
                    rs.getInt("id_user"),
                    rs.getDate("dateBorrow"),
                    rs.getDate("dateReturn"),
                    rs.getString("status")     
                );
                lista.add(m);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            DatabaseConnection.desconectar(con);
        }
    }
    
    public Loan searchById(int id){
        try {
            String SQL = "select * from " + this.tableName + " where id=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Loan m = new Loan(
                    rs.getInt("id"),
                    rs.getInt("id_book"),
                    rs.getInt("id_user"),
                    rs.getDate("dateBorrow"),
                    rs.getDate("dateReturn"),
                    rs.getString("status")      
                );
                return m;
            }else{
                return null;
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            DatabaseConnection.desconectar(con);
        }
    }
    
    public List<Loan> listById(){
        try {
            String SQL = "select * from " + this.tableName + " order by id";
            
            cmd = con.prepareStatement(SQL);
            
            ResultSet rs = cmd.executeQuery();
            List<Loan> lista = new ArrayList<>();
            
            while(rs.next()){
                Loan m = new Loan(
                    rs.getInt("id"),
                    rs.getInt("id_book"),
                    rs.getInt("id_user"),
                    rs.getDate("dateBorrow"),
                    rs.getDate("dateReturn"),
                    rs.getString("status")    
                );
                lista.add(m);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            DatabaseConnection.desconectar(con);
        }
    }
}