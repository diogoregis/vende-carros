package service;

import dao.PagamentoDAO;
import modelo.Pagamento;
import repositorio.IPagamento;

import java.util.List;

public class SPagamento {

    private static SPagamento sPagamento;
    private IPagamento iPagamento = PagamentoDAO.getInstance();

    private SPagamento(){

    }

    public static SPagamento getInstance(){
        if(sPagamento == null){
            sPagamento = new SPagamento();
        }
        return sPagamento;
    }

    public boolean cadastrar(Pagamento pagamento){
        return iPagamento.cadastrar(pagamento);
    }

    public boolean remover(int id){
        return iPagamento.remover(id);
    }

    public List<Pagamento> listar(){
        return iPagamento.listar();
    }

}
