package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAO {

    private Connection con;
    private PreparedStatement cmd;
    private String tableName = "tb_user";
    
    public UserDAO(){
        //abrir uma nova conexão com o banco de dados
        this.con = DatabaseConnection.conectar();
    }
    
    //ACTION: Search email and password
    public boolean isUserRegistered(String email, String password){
        try {
            String SQL = "select * from tb_user where email=? and password=MD5(?)";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, email);
            cmd.setString(2, password);
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            
            return rs.next();
            
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return false;
        }finally{
            DatabaseConnection.desconectar(con);
        }
    }
    
    //ACTION: Register user
    public int add(User user){
        try {
            String SQL = "insert into " + this.tableName + "(cpf, name, telephone, email, password, dateOfBirth, status) "
                    + "values (?, ?, ?, ?, ?, ?, ?)";
                    
            cmd = con.prepareStatement(
                SQL,
                Statement.RETURN_GENERATED_KEYS
            );
            
            //definir o valor do parâmetro
            cmd.setString(1, user.getCpf());
            cmd.setString(2, user.getName());
            cmd.setString(3, user.getTelephone());
            cmd.setString(4, user.getEmail());
            cmd.setString(5, user.getPassword());
            cmd.setDate(6, user.getDate_of_birth());
            cmd.setString(7, user.getStatus());
            
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
    
    public int update(User user){
        try {
            String SQL = "update tb_user set name=? where id=?";
            
            cmd = con.prepareStatement(SQL);
            
            //definir o valor do parâmetro
            cmd.setString(1, user.getCpf());
            cmd.setString(2, user.getName());
            cmd.setString(3, user.getTelephone());
            cmd.setString(4, user.getEmail());
            cmd.setString(5, user.getPassword());
            cmd.setDate(6, user.getDate_of_birth());
            cmd.setString(7, user.getStatus());
            cmd.setInt(8, user.getId());
            
            if (cmd.executeUpdate() > 0){
                //Tudo certo com a atualização
                return user.getId();
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
    
    public List<User> searchByName(String name){
        try {
            String SQL = "select * from tb_user where data=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, name);
            
            ResultSet rs = cmd.executeQuery();
            List<User> lista = new ArrayList<>();
            
            while(rs.next()){
                User m = new User(
                    rs.getInt("id"),
                    rs.getString("cpf"),
                    rs.getString("name"),
                    rs.getString("telephone"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getDate("date_of_birth"),
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
    
    public User searchById(int id){
        try {
            String SQL = "select * from tb_user where id=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                User m = new User(
                    rs.getInt("id"),
                    rs.getString("cpf"),
                    rs.getString("name"),
                    rs.getString("telephone"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getDate("date_of_birth"),
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
    
    public List<User> listById(){
        try {
            String SQL = "select * from tb_user order by id";
            
            cmd = con.prepareStatement(SQL);
            
            ResultSet rs = cmd.executeQuery();
            List<User> lista = new ArrayList<>();
            
            while(rs.next()){
                User m = new User(
                    rs.getInt("id"),
                    rs.getString("cpf"),
                    rs.getString("name"),
                    rs.getString("telephone"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getDate("date_of_birth"),
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
