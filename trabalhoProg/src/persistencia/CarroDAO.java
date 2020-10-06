package persistencia;


import persistencia.Carro;
import java.sql.*;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CarroDAO {
    
    Conexao connect;
   PreparedStatement ps;
    String comand;
    ResultSet rs;
    
    
    public CarroDAO() throws SQLException{
        connect = new Conexao("jdbc:derby://localhost:1527/teste","root","root");
        
    }
    
    //             INCLUIR
    
    public void incluir(Carro car) throws SQLException{
        
      comand =  "insert into ROOT.CARRO (MARCA, MODELO, ANO) values (?, ?, ?)";
        
        
          ps = connect.getMinhaConexao().prepareStatement(comand);
            
            ps.setString(1, car.getMarca());
            ps.setString(2, car.getModelo());
            ps.setInt(3, car.getAno());
            
            ps.executeUpdate();
            ps.close();
            
            System.out.println(car + " Foi inserido com sucesso!");
     }
    
    
    //             MOSTRA 
    
    public List<Carro> mostraCarros() throws SQLException{
        List<Carro> listaDeCarros = new ArrayList<Carro>();
        
        
       comand = "SELECT * FROM ROOT.CARRO";
        
       ps = connect.getMinhaConexao().prepareStatement(comand);


        rs = ps.executeQuery();
        
        while(rs.next()){
            
            Carro c = new Carro();
            
           preencherObjeto(c, rs);
            
            listaDeCarros.add(c);
        } 
        return listaDeCarros;
    }
    
    
    
    //             RETORNA PASSANDO PARAMETROS
    
    public List<Carro> listaDeconsulta (String marca){
    
        List<Carro> consulta = new ArrayList<Carro>();
        
        try{
                comand = "select * from carro where marca = ?";

                ps = connect.getMinhaConexao().prepareStatement(comand);

                ps.setString(1, marca);
                 rs = ps.executeQuery();

                while(rs.next()){

                    Carro c = new Carro();

                   preencherObjeto(c, rs);

                    consulta.add(c);
                    ps.close();

                } 
        } catch(SQLException ex){
            System.out.println("CARRO NÃO ENCONTRADO " );
        }
        
        return consulta;
    }
    
    
    
    //            EXCLUI PRODUTOS
    
    public void deletar(String marca){
        
        comand = "delete from carro where marca = ?";
       
        try {
            ps = connect.getMinhaConexao().prepareStatement(comand);
            ps.setString(1, marca);
            ps.executeUpdate();
            ps.close();
            System.out.println("O Carro " + marca +  " Foi Deletado.");
        } catch (SQLException ex) {
            System.out.println("ERRO!!! NÃO FOI POSSIVEL DELETAR.");
        }
       
       
    }
    
    //            ATULIZA OS PRODUTOS
    
    public void atualizar(String marca, String marcaAtualizada) {
        Carro c = listaDeconsulta(marca).get(0);
        
        comand = "update root.carro set marca = ? where id = ?";
        
        try {
            ps = connect.getMinhaConexao().prepareStatement(comand);
            ps.setString(1, marcaAtualizada);
            ps.setInt(2, c.getId());
            ps.executeUpdate();
            ps.close();
            System.out.println("Produdo" + marcaAtualizada + " Atualizadoo!!");
        } catch (SQLException ex) {
            System.out.println("Não foi possivel atualizar!" + ex.getMessage());
        }
        
        
       
    }
    
    //             PREENCHE O OBJETO CRIADO A PARTIR DA CLASSE CARRO
    private void preencherObjeto(Carro c1, ResultSet rs) throws SQLException{
            c1.setMarca(rs.getString("marca"));
            c1.setModelo(rs.getString("modelo"));
            c1.setAno(rs.getInt("ano"));
   
   }

    
}
