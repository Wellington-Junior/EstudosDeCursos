package persistencia;


public class Carro {
    
    private String   marca;
    private String  modelo;
    private int        ano;
    private int         id;
    
    
    public Carro(String marca, String modelo, int ano){
        this.marca  =  marca; 
        this.modelo = modelo;
        this.ano    =    ano;
    }
    
    public Carro(){
    
    }
    
     @Override
    public String toString(){
           return "\n Id: " + this.getId() + " Carro: " + this.marca + " -Marca: " + this.modelo + " -Ano: " + this.ano;
    }
    
    
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    
    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    
    public int getAno(){
        return ano;
    }
    public void setAno(int ano){
        this.ano = ano;
    }

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
