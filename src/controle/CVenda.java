package controle;

import modelo.Venda;
import service.SVenda;


public class CVenda {

    private static CVenda cVenda;
    private SVenda sVenda = SVenda.getInstance();

    private CVenda(){};

    public static CVenda getInstance(){
        if(cVenda == null){
            cVenda = new CVenda();
        }
        return cVenda;
    }

    public void cadastrar(){
        Venda venda = new Venda();
    }
}
