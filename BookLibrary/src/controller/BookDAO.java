package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.BookInformation;

public class BookDAO {
    
    private Connection con;
    private PreparedStatement cmd;
    private String tableName = "tb_book";
    
    public BookDAO(){
        //abrir uma nova conexão com o banco de dados
        this.con = DatabaseConnection.conectar();
    }

    //ACTION: Register book
    public int add(Book book){
        try {
            String SQL = "insert into " + this.tableName + "(isbn, title, id_genre, id_publisher,"
                    + " id_author, edition, rating, status, description) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
            cmd = con.prepareStatement(
                SQL,
                Statement.RETURN_GENERATED_KEYS
            );
            
            //definir o valor do parâmetro
            cmd.setString(1, book.getIsbn());
            cmd.setString(2, book.getTitle());
            cmd.setInt(3, book.getId_genre());
            cmd.setInt(4, book.getId_publisher());
            cmd.setInt(5, book.getId_author());
            cmd.setInt(6, book.getEdition());
            cmd.setInt(7, book.getRating());
            cmd.setString(8, book.getStatus());
            cmd.setString(9, book.getDescription());
            
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
    
    public int update(Book book){
        try {
            String SQL = "update " + this.tableName + " set isbn=?, title=?, id_genre=?, id_publisher=?, "
                    + "id_author=?, edition=?, rating=?, status=?, description=? where id=? ";
            
            cmd = con.prepareStatement(SQL);
            
            //definir o valor do parâmetro
            cmd.setString(1, book.getIsbn());
            cmd.setString(2, book.getTitle());
            cmd.setInt(3, book.getId_genre());
            cmd.setInt(4, book.getId_publisher());
            cmd.setInt(5, book.getId_author());
            cmd.setInt(6, book.getEdition());
            cmd.setInt(7, book.getRating());
            cmd.setString(8, book.getStatus());
            cmd.setString(9, book.getDescription());
            cmd.setInt(10, book.getId());
            
            if (cmd.executeUpdate() > 0){
                //Tudo certo com a atualização
                return book.getId();
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
    
    public List<Book> searchByTitle(String title){
        try {
            String SQL = "select * from " + this.tableName + " where name=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, title);
            
            ResultSet rs = cmd.executeQuery();
            List<Book> lista = new ArrayList<>();
            
            while(rs.next()){
                Book m = new Book(
                    rs.getInt("id"),
                    rs.getString("isbn"),
                    rs.getString("title"),
                    rs.getInt("id_genre"),
                    rs.getInt("id_publisher"),
                    rs.getInt("id_author"),
                    rs.getInt("edition"),
                    rs.getInt("rating"), 
                    rs.getString("status"),
                    rs.getString("description")
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
    
    public Book searchById(int id){
        try {
            String SQL = "select * from " + this.tableName + " where id=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Book m = new Book(
                    rs.getInt("id"),
                    rs.getString("isbn"),
                    rs.getString("title"),
                    rs.getInt("id_genre"),
                    rs.getInt("id_publisher"),
                    rs.getInt("id_author"),
                    rs.getInt("edition"),
                    rs.getInt("rating"), 
                    rs.getString("status"),
                    rs.getString("description")
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
    
    public Book searchByIsbn(String isbn){
        try {
            String SQL = "select * from " + this.tableName + " where isbn=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, isbn);
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Book m = new Book(
                    rs.getInt("id"),
                    rs.getString("isbn"),
                    rs.getString("title"),
                    rs.getInt("id_genre"),
                    rs.getInt("id_publisher"),
                    rs.getInt("id_author"),
                    rs.getInt("edition"),
                    rs.getInt("rating"), 
                    rs.getString("status"),
                    rs.getString("description")
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
    
    public List<Book> searchByPublisher(String publisher){
        try {
            String SQL = "select * from " + this.tableName + " where status=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, publisher);
            
            ResultSet rs = cmd.executeQuery();
            List<Book> lista = new ArrayList<>();
            
            while(rs.next()){
                Book m = new Book(
                    rs.getInt("id"),
                    rs.getString("isbn"),
                    rs.getString("title"),
                    rs.getInt("id_genre"),
                    rs.getInt("id_publisher"),
                    rs.getInt("id_author"),
                    rs.getInt("edition"),
                    rs.getInt("rating"), 
                    rs.getString("status"),
                    rs.getString("description")
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
    
    public List<Book> searchByAuthor(String status){
        try {
            String SQL = "select * from " + this.tableName + " where status=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, status);
            
            ResultSet rs = cmd.executeQuery();
            List<Book> lista = new ArrayList<>();
            
            while(rs.next()){
                Book m = new Book(
                    rs.getInt("id"),
                    rs.getString("isbn"),
                    rs.getString("title"),
                    rs.getInt("id_genre"),
                    rs.getInt("id_publisher"),
                    rs.getInt("id_author"),
                    rs.getInt("edition"),
                    rs.getInt("rating"), 
                    rs.getString("status"),
                    rs.getString("description")
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
    
    public List<Book> listById(){
        try {
            String SQL = "select * from " + this.tableName + " order by id";
            
            cmd = con.prepareStatement(SQL);
            
            ResultSet rs = cmd.executeQuery();
            List<Book> lista = new ArrayList<>();
            
            while(rs.next()){
                Book m = new Book(
                    rs.getInt("id"),
                    rs.getString("isbn"),
                    rs.getString("title"),
                    rs.getInt("id_genre"),
                    rs.getInt("id_publisher"),
                    rs.getInt("id_author"),
                    rs.getInt("edition"),
                    rs.getInt("rating"), 
                    rs.getString("status"),
                    rs.getString("description")
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
    
    public BookInformation searchByIdInformation(int id){
        try {
            String SQL = "select book.id, book.isbn, book.title, genre.name as genre_name,\n" +
            "   publisher.name as publisher_name, author.name as author_name, book.rating, " +
            "   book.edition, book.status, book.description\n" +
            "    from tb_book as book\n" +
            "    join tb_genre as genre\n" +
            "       on book.id_genre = genre.id\n" +
            "    inner join tb_author as author\n" +
            "       on book.id_author = author.id\n" +
            "    inner join tb_publisher as publisher\n" +
            "       on book.id_publisher = publisher.id\n" +
            "    where book.id=? ";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            
            ResultSet rs = cmd.executeQuery();
            
            if(rs.next()){
                BookInformation bookInfo = new BookInformation(
                    rs.getInt("id"),
                    rs.getString("isbn"),
                    rs.getString("title"),
                    rs.getString("genre_name"),
                    rs.getString("publisher_name"),
                    rs.getString("author_name"),
                    rs.getInt("edition"),
                    rs.getInt("rating") ,
                    rs.getString("status"),
                    rs.getString("description")
                );
                return bookInfo;
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
    
    public List<BookInformation> listBookInformation(String where, String search){
        try {
            String SQL = "select book.id, book.isbn, book.title, genre.name as genre_name,\n" +
            "    publisher.name as publisher_name, author.name as author_name, book.rating, " +
            "    book.edition, book.status, book.description\n" +
            "    from tb_book as book\n" +
            "    join tb_genre as genre\n" +
            "       on book.id_genre = genre.id\n" +
            "    inner join tb_author as author\n" +
            "       on book.id_author = author.id\n" +
            "    inner join tb_publisher as publisher\n" +
            "       on book.id_publisher = publisher.id\n" +
            "    where "+ where +" ilike ? ";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, "%" + search + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<BookInformation> bookList = new ArrayList<>();
            
            while(rs.next()){
                BookInformation bookInfo = new BookInformation(
                    rs.getInt("id"),
                    rs.getString("isbn"),
                    rs.getString("title"),
                    rs.getString("genre_name"),
                    rs.getString("publisher_name"),
                    rs.getString("author_name"),
                    rs.getInt("edition"),
                    rs.getInt("rating"),
                    rs.getString("status"),
                    rs.getString("description")
                );
                bookList.add(bookInfo);
            }
            return bookList;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            DatabaseConnection.desconectar(con);
        }
    }
}
