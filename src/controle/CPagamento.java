package controle;

import modelo.Pagamento;
import service.SPagamento;
import util.Tools;

public class CPagamento {

    private static CPagamento cPagamento;
    private SPagamento sPagamento = SPagamento.getInstance();

    private CPagamento(){}

    public static CPagamento getInstance(){
        if(cPagamento == null){
            cPagamento = new CPagamento();
        }
        return cPagamento;
    }

    public void cadastrar(String tipo){
        Pagamento pagamento = new Pagamento();
        pagamento.setTipo(tipo);
        if(sPagamento.cadastrar(pagamento)){
            System.out.println();
            System.out.println("Cadastrado com sucesso");
            System.out.println();
        } else {
            System.out.println();
            System.err.println("Não foi possivel cadastrar");
            System.out.println();
        }
    }

    public void remover(int id){

        if(sPagamento.remover(id)){
            System.out.println();
            System.out.println("Pagamento removido com sucesso");
            System.out.println();
        } else {
            System.out.println();
            System.err.println("Não foi possivel remover o codigo "+id);
            System.out.println();
        }
    }

    public void listar() {
        System.out.println();
        System.out.println(".: Lista de todos os tipos de pagamento :.");
        System.out.println();
        for(Pagamento c: sPagamento.listar()){
            System.out.println("Cod.: "+c.getId());
            System.out.println("Marca.: "+c.getTipo());
            System.out.println("----------------------------");
            Tools.pausar(1);
        }
        System.out.println();

    }

}
