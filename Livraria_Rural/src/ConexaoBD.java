import java.sql.*;

public class ConexaoBD {
    
    public static String URL = "jdbc:mysql://Admin:3306";
    public static String USER = "A dmin";
    public static String Senha = ""; //este banco de dados não possui senha

    //definindo os objetos das conexões
    private Connection dbConn = null;
    private Statement sqlMerge = null;
    private ResultSet resultSQL = null;

    //definindo o método para conexão do sistema com o banco de dados
    public void AbrirBD (){

        try{
            dbConn = DriverManager.getConnection(URL, USER, Senha);
            System.out.println("Conecato com sucesso ao banco de dados em:" +URL);
            sqlMerge = dbConn.createStatement();
        } catch(Exception Error){
            System.out.println("Erro ao conectar ao banco de dados:" +Error.getMessage());
        }
    }

    //definindo o método para encerrar a conexão do sistema com o bando de dados
    public void FecharBD () throws SQLException {
        sqlMerge.close();
        dbConn.close();
    }

    //método para executar uma query no banco de dados para chamar um objeto para executar os comandos do MySQL
    public int ExecutaCMD (String sql){
        try{
          return sqlMerge.executeUpdate(sql); //insert/delete/update/create  
        } catch(Exception Error){
            System.out.println("Erro ao conectar:" +Error.getMessage());
        }
        return -1;

    }
}
