package exercicios_alura.projetos.java.ti.limite_cartao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var comprador = new Produtos();
        var teclado = new Scanner(System.in);
        int decisao = 1;
        double valorTotal = 0;
        comprador.setLimite(1000);

        System.out.println("Limite do cartão: R$ "+ comprador.getLimite());
        System.out.println("********************************************");
        double valorAtual = comprador.getLimite();
        do {
            System.out.println("Digite a descrição do produto");
            System.out.print("Produto: ");
            comprador.setItem(teclado.next());
            System.out.println();
            System.out.println("Digite o valor da compra:");
            System.out.print("R$ ");
            comprador.setValorItem(teclado.nextDouble());
            
            if(comprador.getValorItem() <= valorAtual) {
                System.out.println("Compra Realizada!");
                System.out.println("------------------------------");
                System.out.println("Digite 0 para Sair ou 1 para Continuar");
                decisao = teclado.nextInt();
                comprador.adicionarProduto(comprador.getItem(), comprador.getValorItem()); /* -> Aqui foi chamado um
                 metodo public void adicionarProduto(String item, double valorItem) */
            } else {
                System.out.println("Saldo Insulficiente!!!");
                decisao = 0;
            }
            valorAtual = valorAtual- comprador.getValorItem();
        } while (decisao == 1 && valorAtual > 0);
        System.out.println("********************************************");
        System.out.println("************ COMPRAS REALIZADAS ************");

        for (Produtos produto : comprador.getProdutos()){
            System.out.println(produto.getItem() + " R$ " + produto.getValorItem());
            valorTotal = valorTotal + produto.getValorItem();
        }
        System.out.println();
        System.out.println("Valor Total");
        System.out.println("R$ "+ valorTotal);

        System.out.println("********************************************");
        System.out.println("Saldo: R$"+ valorAtual);
        System.out.println("********************************************");
    }
}