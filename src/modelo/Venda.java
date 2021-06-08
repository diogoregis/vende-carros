package modelo;

public class Venda {

    private int id;
    private Carro carro;
    private Seguro seguro;
    private Vendedor vendedor;
    private Cliente cliente;
    private Pagamento pagamento;

    public Venda(){}

    public Venda(int id, Carro carro, Seguro seguro, Vendedor vendedor, Cliente cliente, Pagamento pagamento){
        this.id = id;
        this.carro = carro;
        this.seguro = seguro;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.pagamento = pagamento;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarro() {
        return carro.getId();
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public int getSeguro() {
        return seguro.getId();
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public int getVendedor() {
        return vendedor.getId();
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getCliente() {
        return cliente.getId();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getPagamento() {
        return pagamento.getId();
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
