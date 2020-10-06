package model;


import persistencia.CarroDAO;
import persistencia.Carro;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;

public class Principal {

   
    public static void main(String[] args) throws SQLException {
        
//        Carro c1 = new Carro("VolksWagen", "Amarok", 2010);
//        Carro c2 = new Carro("Renault", "sandero", 2019);
//        Carro c3 = new Carro("Fiat", "PalioWekend", 2016);
//        Carro c4 = new Carro("Porschy", "Cayenne", 2019);
       
        CarroDAO persistencia = new CarroDAO();
        
//       persistencia.incluir(c1);
//       persistencia.incluir(c2);
//       persistencia.incluir(c3);
//       persistencia.incluir(c4);
        

//       List<Carro> lista = persistencia.listaDeconsulta(3);
//List<Carro> lista = persistencia.listaDeconsulta("Fiat");
//        persistencia.deletar("VolksWagen");


       persistencia.atualizar("Fiat", "Fiatt");
        

      List<Carro> lista = persistencia.mostraCarros();
        
        System.out.println(lista);
    }
    
}
