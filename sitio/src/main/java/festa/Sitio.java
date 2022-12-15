package festa;

import java.util.Observable;

public class Sitio extends Observable  {

    private String nome;
    private String endereco;
    private float preco;
    private Integer capacidade;


    public Sitio(String nome, String endereco, float preco, Integer capacidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.preco = preco;
        this.capacidade = capacidade;
    }

    public void getSitio() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Sítio{" +
                "nome='" + nome + '\'' +
                ", endereço='" + endereco + '\'' +
                ", preço=" + preco +
                ", capacidade=" + capacidade +
                '}';
    }

}
