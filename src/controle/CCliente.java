package controle;

import modelo.Cliente;
import service.SCliente;
import util.Tools;

public class CCliente {

    private static CCliente cCliente;
    private SCliente sCliente = SCliente.getInstance();

    private CCliente() {
    }

    public static CCliente getInstance() {
        if(cCliente == null){
            cCliente = new CCliente();
        }
        return cCliente;
    }

    public void cadastrar(String nome, String telefone, String email) {
        telefone = Tools.telefoneFormatar(telefone,"(##) #####-####");
        Cliente cliente = new Cliente(nome, telefone, email);
        if(SCliente.getInstance().cadastrar(cliente)){
            System.out.println("Cliente: "+ cliente.getNome() + ", cadastrado com sucesso !");
        } else {
            System.out.println("Erro ao tentar cadastrar o cliente "+cliente.getNome());
        }

    }

    public void listar() {
        System.out.println();
        System.out.println(".: Lista de todos os clientes cadastrados :.");
        System.out.println();
        for(Cliente c: SCliente.getInstance().listar()){
            System.out.println("Cod.: "+c.getId());
            System.out.println("Nome.: "+c.getNome());
            System.out.println("Telefone.: "+c.getTelefone());
            System.out.println("Email.: "+c.getEmail());
            System.out.println("----------------------------");
            Tools.pausar(1);
        }

    }

    public void remover(int id){
        if(SCliente.remover(id)){
            System.out.println("Removido com sucesso !");
        } else{
            System.err.println("Não foi possivel remover !");
        }


    }

    public void atualizar(int id, String nomecliente, String fonecliente, String emailcliente){
        Cliente cliente = new Cliente(id, nomecliente, fonecliente, emailcliente);
        if(SCliente.atualizar(cliente)){
            System.out.println();
            System.out.println("Cliente "+ cliente.getNome() + " atualizado com sucesso");
            System.out.println();
        }else {
            System.out.println();
            System.out.println("Erro ao tentar atualizar o cliente " + cliente.getNome());
            System.out.println();
        }
    }

    public void buscaUnica(int id){
        Cliente cliente = new Cliente(id);
        cliente = SCliente.buscaUnica(cliente);
        if(SCliente.buscaUnica(cliente) != null){
            System.out.println();
            System.out.println("Cliente Encontrado");
            System.out.println("------------------");
            System.out.println(cliente.getNome());
            System.out.println(cliente.getTelefone());
            System.out.println(cliente.getEmail());
            System.out.println("------------------");
            Tools.pausar(1);
        }else {
            System.out.println();
            System.err.println("Cliente não encontrado");
            System.out.println();
            Tools.pausar(1);
        }


    }

}
