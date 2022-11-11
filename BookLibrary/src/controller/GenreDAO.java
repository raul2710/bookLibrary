package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Genre;

public class GenreDAO {
    
    private Connection con;
    private PreparedStatement cmd;
    private String tableName = "tb_genre";
    
    public GenreDAO(){
        //abrir uma nova conexão com o banco de dados
        this.con = DatabaseConnection.conectar();
    }
    
    //ACTION: Register author
    public int add(Genre genre){
        try {
            String SQL = "insert into " + this.tableName + "(name) "
                    + "values (?)";
                    
            cmd = con.prepareStatement(
                SQL,
                Statement.RETURN_GENERATED_KEYS
            );
            
            //definir o valor do parâmetro
            cmd.setString(1, genre.getName());
            
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
    
    public boolean remove(int id){
        try {
            String SQL = "delete from " + this.tableName + " where id=?";
            
            cmd = con.prepareStatement(SQL);
            
            //definir o valor do parâmetro
            cmd.setInt(1, id);
            
            if (cmd.executeUpdate() > 0){
                //Tudo certo com a atualização
                return true;
            }else{
                //Ocorreu um erro ao atualizar;
                return false;
            }
            
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return false;
        }finally{
            DatabaseConnection.desconectar(con);
        }
    }
    
     public int update(Genre genre){
        try {
            String SQL = "update " + this.tableName + " set name=? where id=?";
            
            cmd = con.prepareStatement(SQL);
            
            //definir o valor do parâmetro
            cmd.setString(1, genre.getName());
            cmd.setInt(2, genre.getId());
            
            if (cmd.executeUpdate() > 0){
                //Tudo certo com a atualização
                return genre.getId();
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
    
    public List<Genre> searchByName(String name){
        try {
            String SQL = "select * from " + this.tableName + " where data=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, name);
            
            ResultSet rs = cmd.executeQuery();
            List<Genre> lista = new ArrayList<>();
            
            while(rs.next()){
                Genre m = new Genre(
                    rs.getInt("id"),
                    rs.getString("name")
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
    
    public Genre searchById(int id){
        try {
            String SQL = "select * from " + this.tableName + " where id=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Genre m = new Genre(
                    rs.getInt("id"),
                    rs.getString("name")
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
    
    public List<Genre> listById(){
        try {
            String SQL = "select * from " + this.tableName + " order by id";
            
            cmd = con.prepareStatement(SQL);
            
            ResultSet rs = cmd.executeQuery();
            List<Genre> lista = new ArrayList<>();
            
            while(rs.next()){
                Genre m = new Genre(
                    rs.getInt("id"),
                    rs.getString("name")
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
    
    public List<Genre> listByName(){
        try {
            String SQL = "select * from " + this.tableName + " order by name";
            
            cmd = con.prepareStatement(SQL);
            
            ResultSet rs = cmd.executeQuery();
            List<Genre> lista = new ArrayList<>();
            
            while(rs.next()){
                Genre m = new Genre(
                    rs.getInt("id"),
                    rs.getString("name")
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
