
import controle.CCliente;
import util.Tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VeiculosApp {

    private static Scanner tecla = new Scanner(System.in);
    private static int opcao, campo;
    private static String nomecliente, fonecliente, emailcliente;
    private static float valor;


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
        System.out.println(">  5 - SAIR");
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
                System.out.println("Até mais !");
                Tools.pausar(2);
                System.exit(0);
            default:
                System.out.println("Opção inválida");
                menu();
                break;

        }
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
                cadcliente();
                break;
            case 2:
                cadvendedor();
                break;
            case 3:
                cadcarro();
                break;
            case 4:
                menu();
                break;
            default:
                System.out.println("Opção inválida");
                System.out.println("Tente novamente");
                cadastrar();
                break;

        }
    }

    public static void listar(){
        System.out.println(" O que deseja LISTAR ?");
        System.out.println(">  1 - Cliente");
        System.out.println(">  2 - Vendedor");
        System.out.println(">  3 - Carro");
        System.out.println(">  4 - Voltar");
        System.out.println(">  5 - Atualizar cadastro");
        System.out.println(">  6 - Busca unica");
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
                cadvendedor();
                break;
            case 3:
                cadcarro();
                break;
            case 4:
                menu();
                break;
            case 5:
                atualizar();
                break;
            case 6:
                buscaUnicaCliente();
                break;
            default:
                System.out.println("Opção inválida");
                System.out.println("Tente novamente");
                Tools.pausar(1);
                listar();
                break;

        }
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
                menu();
                break;
            case 2:
                cadvendedor();
                break;
            case 3:
                cadcarro();
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

    private static void atualizacliente() {
        CCliente.getInstance().listar();
        System.out.println();
        System.out.println("Digite o codigo do cliente que deseja atualizar");
        campo = Integer.parseInt(tecla.nextLine());
        System.out.println();
        System.out.println("Certo");
        System.out.println("Digite o nome");
        nomecliente = tecla.nextLine();
        System.out.println("Digite o telefone com DDD - (somente numeros)");
        fonecliente = tecla.nextLine();
        System.out.println("Digite o email");
        emailcliente = tecla.nextLine();
        System.out.println();
        CCliente.getInstance().atualizar(campo, nomecliente, fonecliente, emailcliente);
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
                removecliente();
                break;
            case 2:
                removevendedor();
                break;
            case 3:
                removecarro();
                break;
            case 4:
                menu();
                break;
            default:
                System.out.println("Opção inválida");
                System.out.println("Tente novamente");
                remover();
                break;

        }
    }

    private static void removecarro() {
    }

    private static void removevendedor() {
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
        nomecliente = tecla.nextLine();
        System.out.println("Digite o telefone do Cleinte, com DDD - (somente numeros): ");
        fonecliente = tecla.nextLine();
        System.out.println("Digite o email do Cliente: ");
        emailcliente = tecla.nextLine();
        CCliente.getInstance().cadastrar(nomecliente, fonecliente, emailcliente);
        Tools.pausar(1);
        menu();



    }

    public static void cadvendedor(){
        System.out.println("Informe os dados que se pedem: ");
        System.out.print("Digite o nome do vendedor: ");
        // TUDO

    }

    public static void cadcarro(){
        // TUDO
    }

    public static void headcadastrar(){
        System.out.println();
        System.out.println("'''''''''''''");
        System.out.println("' CADASTROS '");
        System.out.println("'''''''''''''");
        System.out.println();
    }

}
