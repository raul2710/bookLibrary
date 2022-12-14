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
    private String tableName = "";
    
    public LoanDAO(){
        //abrir uma nova conexão com o banco de dados
        this.con = DatabaseConnection.conectar();
    }
    
    //ACTION: Register loan
    public int add(Loan loan){
        try {
            String SQL = "insert into " + this.tableName + "(name) "
                    + "values (?)";
                    
            cmd = con.prepareStatement(
                SQL,
                Statement.RETURN_GENERATED_KEYS
            );
            
            //definir o valor do parâmetro
            cmd.setInt(1, loan.getId_book());
            cmd.setInt(2, loan.getId_book());
            cmd.setInt(3, loan.getId_user());
            cmd.setDate(4, loan.getDateBorrow());
            cmd.setDate(5, loan.getDateDevolution());
            cmd.setString(6, loan.getStatus());
            
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
            String SQL = "update tb_loan set name=? where id=?";
            
            cmd = con.prepareStatement(SQL);
            
            //definir o valor do parâmetro
            cmd.setInt(1, loan.getId_book());
            cmd.setInt(2, loan.getId_book());
            cmd.setInt(3, loan.getId_user());
            cmd.setDate(4, loan.getDateBorrow());
            cmd.setDate(5, loan.getDateDevolution());
            cmd.setString(6, loan.getStatus());
            cmd.setInt(7, loan.getId());
            
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
    
    public List<Loan> searchByName(String name){
        try {
            String SQL = "select * from tb_loan where data=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, name);
            
            ResultSet rs = cmd.executeQuery();
            List<Loan> lista = new ArrayList<>();
            
            while(rs.next()){
                Loan m = new Loan(
                    rs.getInt("id"),
                    rs.getInt("id_book"),
                    rs.getInt("id_user"),
                    rs.getDate("dateBorrow"),
                    rs.getDate("dateDevolution"),
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
            String SQL = "select * from tb_loan where id=?";
            
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
                    rs.getDate("dateDevolution"),
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
            String SQL = "select * from tb_loan order by id";
            
            cmd = con.prepareStatement(SQL);
            
            ResultSet rs = cmd.executeQuery();
            List<Loan> lista = new ArrayList<>();
            
            while(rs.next()){
                Loan m = new Loan(
                    rs.getInt("id"),
                    rs.getInt("id_book"),
                    rs.getInt("id_user"),
                    rs.getDate("dateBorrow"),
                    rs.getDate("dateDevolution"),
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