package modelo;

public class Carro {

    private int id;
    private String marca;
    private String modelo;
    private String cor;
    private float preco;
    private String ano;

    public Carro(){

    }

    public Carro(int id, String marca, String modelo, String cor, float preco, String ano){
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.preco = preco;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
