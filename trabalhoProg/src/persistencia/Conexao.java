package persistencia;

import java.sql.*;


public class Conexao {
    
    private String  endereco ;    
    private String      user ;
    private String  password ;
    private Connection minhaConexao ;
    
    public Conexao(String ende, String u, String pass) throws SQLException{
        this.endereco = ende;
        this.user = u;
        this.password = pass;
        this.minhaConexao = DriverManager.getConnection(endereco,user,password);
    }
    
    public Connection getMinhaConexao(){
        return this.minhaConexao;
    }
}