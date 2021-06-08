
import controle.*;
import service.SVendedor;
import util.Tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VeiculosApp {

    private static Scanner tecla = new Scanner(System.in);
    private static int opcao, campo;
    private static String nome, fonecliente, emailcliente, marca, modelo, cor, ano;
    private static float preco;


    public static void main(String[] args) {

        head();
        menu();

    }

    public static void menu(){
        System.out.println(".: Selecione uma opção :.");
        System.out.println(">  1 - CADASTRAR");
        System.out.println(">  2 - LISTAR");
        System.out.println(">  3 - REMOVER");
        System.out.println(">  4 - VENDER");
        System.out.println(">  5 - SEGUROS");
        System.out.println(">  6 - SAIR");
        System.out.println("------------------");
        System.out.println("Digite uma opção: ");


        try{
            opcao = Integer.parseInt(tecla.nextLine());
        }catch (InputMismatchException e){
            menu();
        }catch (NumberFormatException f){
            menu();
        }

        switch (opcao){
            case 1:
                cadastrar();
                break;
            case 2:
                listar();
                break;
            case 3:
                remover();
                break;
            case 4:
                vender();
                break;
            case 5:
                seguros();
            case 6:
                System.out.println("Até mais !");
                Tools.pausar(2);
                System.exit(0);
            default:
                System.out.println("Opção inválida");
                menu();
                break;

        }
    }

    private static void seguros() {
        System.out.println();
        System.out.println("'''''''''''''");
        System.out.println("'  SEGUROS  '");
        System.out.println("'''''''''''''");
        System.out.println();
        System.out.println(".: Selecione uma opção :.");
        System.out.println(">  1 - CADASTRAR");
        System.out.println(">  2 - LISTAR");
        System.out.println(">  3 - REMOVER");
        System.out.println(">  4 - VOLTAR");
        try{
            opcao = Integer.parseInt(tecla.nextLine());
        }catch (InputMismatchException e){
            menu();
        }catch (NumberFormatException f){
            menu();
        }

        switch (opcao){
            case 1:
                cadseguros();
                break;
            case 2:
                CSeguro.getInstance().listar();
                menu();
                break;
            case 3:
                removerseguros();
                break;
            case 4:
                menu();
            default:
                System.out.println("Opção inválida");
                seguros();
                break;

        }
    }

    private static void removerseguros() {
        System.out.println();
        CSeguro.getInstance().listar();
        System.out.println("Digite o codigo do Seguro de que deseja remover");
        campo = Integer.parseInt(tecla.nextLine());
        CSeguro.getInstance().remover(campo);
        System.out.println();
        menu();
    }

    private static void cadseguros() {
        System.out.println();
        System.out.println("Digite o nome ou tipo do seguro");
        nome = tecla.nextLine();
        CSeguro.getInstance().cadastrar(nome);
        menu();
    }

    public static void head(){
        System.out.println(" ________________________");
        System.out.println("|       BEM-VINDO        |");
        System.out.println("|   VENDE VEICULOS APP   |");
        System.out.println("|                  v0.16 |");
        System.out.println(" ------------------------");
    }

    public static void cadastrar(){
        System.out.println(" O que deseja cadastar ?");
        System.out.println(">  1 - Cliente");
        System.out.println(">  2 - Vendedor");
        System.out.println(">  3 - Carro");
        System.out.println(">  4 - Pagamento");
        System.out.println(">  5 - Voltar");
        System.out.println("------------------");
        System.out.println("Digite uma opção: ");

        try{
            opcao = Integer.parseInt(tecla.nextLine());
        }catch (InputMismatchException e){
            menu();
        }catch (NumberFormatException f){
            menu();
        }


        switch (opcao){
            case 1:
                cadcliente();
                break;
            case 2:
                cadvendedor();
                break;
            case 3:
                cadcarro();
                break;
            case 4:
                cadpagamento();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Opção inválida");
                System.out.println("Tente novamente");
                cadastrar();
                break;

        }
    }

    private static void cadpagamento() {
        System.out.println();
        System.out.println("Digite a forma de pagamento");
        nome = tecla.nextLine();
        CPagamento.getInstance().cadastrar(nome);
        menu();
    }

    public static void listar(){
        System.out.println(" O que deseja LISTAR ?");
        System.out.println(">  1 - Cliente");
        System.out.println(">  2 - Vendedor");
        System.out.println(">  3 - Carro");
        System.out.println(">  4 - Voltar");
        System.out.println(">  5 - Atualizar cadastro");
        System.out.println(">  6 - Busca unica");
        System.out.println(">  7 - Pagamentos");
        System.out.println("------------------");
        System.out.println("Digite uma opção: ");

        try{
            opcao = Integer.parseInt(tecla.nextLine());
        }catch (InputMismatchException e){
            menu();
        }catch (NumberFormatException f){
            menu();
        }


        switch (opcao){
            case 1:
                CCliente.getInstance().listar();
                menu();
                break;
            case 2:
                CVendedor.getInstance().listar();
                menu();
                break;
            case 3:
                CCarro.getInstance().listar();
                menu();
                break;
            case 4:
                menu();
                break;
            case 5:
                atualizar();
                break;
            case 6:
                buscaUnica();
                break;
            case 7:
                CPagamento.getInstance().listar();
                menu();
                break;
            default:
                System.out.println("Opção inválida");
                System.out.println("Tente novamente");
                Tools.pausar(1);
                listar();
                break;

        }
    }


    private static void buscaUnica() {

        System.out.println(" O que deseja LISTAR ?");
        System.out.println(">  1 - Cliente");
        System.out.println(">  2 - Vendedor");
        System.out.println(">  3 - Carro");
        System.out.println(">  4 - Voltar");
        System.out.println("------------------");
        System.out.println("Digite uma opção: ");

        try{
            opcao = Integer.parseInt(tecla.nextLine());
        }catch (InputMismatchException e){
            menu();
        }catch (NumberFormatException f){
            menu();
        }


        switch (opcao){
            case 1:
                buscaUnicaCliente();
                break;
            case 2:
                buscaUnicaVendedor();
                break;
            case 3:
                buscaUnicaCarro();
                break;
            case 4:
                menu();
                break;
            default:
                System.out.println("Opção inválida");
                System.out.println("Tente novamente");
                Tools.pausar(1);
                buscaUnica();
                break;

        }
    }

    private static void buscaUnicaCarro() {
        System.out.println();
        System.out.println("informe o codigo id do carro: ");
        campo = Integer.parseInt(tecla.nextLine());
        CCarro.getInstance().buscaUnica(campo);
        menu();
    }

    private static void buscaUnicaVendedor() {
        System.out.println();
        System.out.println("Informe o codigo id - do vendedor");
        campo = Integer.parseInt(tecla.nextLine());
        CVendedor.getInstance().buscaUnica(campo);
        menu();
    }

    private static void buscaUnicaCliente() {
        System.out.println();
        System.out.println("Informe o codigo do cliente:");
        try{
            campo = Integer.parseInt(tecla.nextLine());
        }catch (InputMismatchException e){
            menu();
        }catch (NumberFormatException f){
            menu();
        }
        CCliente.getInstance().buscaUnica(campo);
        menu();

    }

    private static void atualizar() {
        System.out.println(" O que deseja ATUALIZAR ?");
        System.out.println(">  1 - Cliente");
        System.out.println(">  2 - Vendedor");
        System.out.println(">  3 - Carro");
        System.out.println(">  4 - Voltar para menu principal");
        System.out.println("------------------");
        System.out.println("Digite uma opção: ");

        try{
            opcao = Integer.parseInt(tecla.nextLine());
        }catch (InputMismatchException e){
            menu();
        }catch (NumberFormatException f){
            menu();
        }


        switch (opcao){
            case 1:
                atualizacliente();
                break;
            case 2:
                atualizavendedor();
                break;
            case 3:
                atualizaCarro();
                break;
            case 4:
                menu();
                break;
            case 5:
                atualizar();
                break;
            default:
                System.out.println("Opção inválida");
                System.out.println("Tente novamente");
                Tools.pausar(1);
                listar();
                break;

        }
    }

    private static void atualizaCarro() {
        System.out.println();
        CCarro.getInstance().listar();
        System.out.println("Informe o codigo do carro que deseja alterar: ");
        campo = Integer.parseInt(tecla.nextLine());
        System.out.println("Informe a marca:");
        marca = tecla.nextLine();
        System.out.println("Informe o modelo");
        modelo = tecla.nextLine();
        System.out.println("Informe a cor");
        cor = tecla.nextLine();
        System.out.println("Informe o ano");
        ano = tecla.nextLine();
        System.out.println("Informe o preço");
        preco = Float.parseFloat(tecla.nextLine());
        CCarro.getInstance().atualizar(campo, marca, modelo, cor, preco, ano);
        menu();

    }

    private static void atualizavendedor() {
        System.out.println();
        CVendedor.getInstance().listar();
        System.out.println("Informe o codigo do vendedor que deseja atualizar.");
        campo = Integer.parseInt(tecla.nextLine());
        System.out.println("Informe o novo nome");
        nome = tecla.nextLine();
        CVendedor.getInstance().atualizar(campo, nome);
        menu();
    }

    private static void atualizacliente() {
        CCliente.getInstance().listar();
        System.out.println();
        System.out.println("Digite o codigo do cliente que deseja atualizar");
        campo = Integer.parseInt(tecla.nextLine());
        System.out.println();
        System.out.println("Certo");
        System.out.println("Digite o nome");
        nome = tecla.nextLine();
        System.out.println("Digite o telefone com DDD - (somente numeros)");
        fonecliente = tecla.nextLine();
        System.out.println("Digite o email");
        emailcliente = tecla.nextLine();
        System.out.println();
        CCliente.getInstance().atualizar(campo, nome, fonecliente, emailcliente);
        System.out.println();

    }

    public static void vender(){
        // TUDO
    }
    public static void remover(){

        System.out.println(" O que deseja REMOVER ?");
        System.out.println(">  1 - Cliente");
        System.out.println(">  2 - Vendedor");
        System.out.println(">  3 - Carro");
        System.out.println(">  4 - Pagamento");
        System.out.println(">  5 - Voltar");
        System.out.println("------------------");
        System.out.println("Digite uma opção: ");

        try{
            opcao = Integer.parseInt(tecla.nextLine());
        }catch (InputMismatchException e){
            menu();
        }catch (NumberFormatException f){
            menu();
        }


        switch (opcao){
            case 1:
                removecliente();
                break;
            case 2:
                removevendedor();
                break;
            case 3:
                removecarro();
                break;
            case 4:
                removerpagamento();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Opção inválida");
                System.out.println("Tente novamente");
                remover();
                break;

        }
    }

    private static void removerpagamento() {
        System.out.println();
        CPagamento.getInstance().listar();
        System.out.println("Informe o codigo do pagamento que deseja remover: ");
        campo = Integer.parseInt(tecla.nextLine());
        CPagamento.getInstance().remover(campo);
        menu();
    }

    private static void removecarro() {
        System.out.println();
        CCarro.getInstance().listar();
        System.out.println("Informe o codigo do carro que deseja remover: ");
        campo = Integer.parseInt(tecla.nextLine());
        CCarro.getInstance().remover(campo);
        menu();
    }

    private static void removevendedor() {
        System.out.println();
        CVendedor.getInstance().listar();
        System.out.println();
        System.out.println("Digite o codigo do vendedor que deseja remover");
        campo = Integer.parseInt(tecla.nextLine());
        CVendedor.getInstance().remover(campo);
        menu();
    }

    private static void removecliente() {
        System.out.println();
        CCliente.getInstance().listar();
        System.out.println();
        System.out.println(".: Infome o codigo do cliente que deseja remover :.");
        try{
            campo = Integer.parseInt(tecla.nextLine());
        }catch (InputMismatchException e){
            System.out.println("Digite um numero INTEIRO, POSITIVO e VALIDO");
            System.out.println("Tente novamente");
            Tools.pausar(1);
            removecliente();
        }catch (NumberFormatException f){
            System.out.println("Digite um numero INTEIRO, POSITIVO e VALIDO");
            System.out.println("Tente novamente");
            Tools.pausar(1);
            removecliente();
        }
        CCliente.getInstance().remover(campo);
        System.out.println();
        menu();

    }

    public static void cadcliente(){

        headcadastrar();
        System.out.println("Digite o nome do Cliente: ");
        nome = tecla.nextLine();
        System.out.println("Digite o telefone do Cleinte, com DDD - (somente numeros): ");
        fonecliente = tecla.nextLine();
        System.out.println("Digite o email do Cliente: ");
        emailcliente = tecla.nextLine();
        CCliente.getInstance().cadastrar(nome, fonecliente, emailcliente);
        Tools.pausar(1);
        menu();



    }

    public static void cadvendedor(){
        headcadastrar();
        System.out.println();
        System.out.print("Digite o nome do vendedor: ");
        nome = tecla.nextLine();
        CVendedor.getInstance().cadastrar(nome);
        Tools.pausar(1);
        menu();
    }

    public static void cadcarro(){
        headcadastrar();
        System.out.println("Informe a marca do carro:");
        marca = tecla.nextLine();
        System.out.println("Informe o modelo do carro");
        modelo = tecla.nextLine();
        System.out.println("Informe a cor do carro");
        cor = tecla.nextLine();
        System.out.println("Informe o ano do carro");
        ano = tecla.nextLine();
        System.out.println("Informe o preço de venda do carro");
        preco = Float.parseFloat(tecla.nextLine());
        CCarro.getInstance().cadastrar(marca, modelo, cor, preco, ano);
        menu();
    }

    public static void headcadastrar(){
        System.out.println();
        System.out.println("'''''''''''''");
        System.out.println("' CADASTROS '");
        System.out.println("'''''''''''''");
        System.out.println();
    }

}
