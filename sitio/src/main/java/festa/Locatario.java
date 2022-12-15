package festa;

import java.util.Observable;
import java.util.Observer;

public class Locatario implements Observer {

    private String nome;
    private String ultimaAtualizacao;

    public Locatario(String nome){
        this.nome = nome;
    }

    public String getUltimaAtualizacao(){
        return this.ultimaAtualizacao;
    }

    public void addObserver(Sitio sitio) {

        sitio.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg1) {
        this.ultimaAtualizacao = this.nome + ", sítio disponível para alugar: " + observable.toString();
    }


}
