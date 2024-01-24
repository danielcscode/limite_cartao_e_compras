package exercicios_alura.projetos.java.ti.limite_cartao;

import java.util.ArrayList;
import java.util.List;

public class Produtos extends Dados implements Comparable<Produtos>{
    private String item;
    private double valorItem;
    private List<Produtos> produtos; // -> Necessario a crescimo do List<+ a classe> e a variavel.

    public Produtos() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(String item, double valorItem) { /* -> Aqui foi configurado para que item escrito e o
       valor colcocado pelo usuario possa ser registrado e armazenado pelo produtos.add(novoProduto) */
        Produtos novoProduto = new Produtos();
        novoProduto.setItem(item);
        novoProduto.setValorItem(valorItem);
        produtos.add(novoProduto);
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }

    public double getValorItem() {
        return valorItem;
    }
    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    @Override
    public int compareTo(Produtos outroProduto) {
        return Double.valueOf(this.valorItem).compareTo(Double.valueOf(outroProduto.valorItem));
    }
}
