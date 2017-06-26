package br.com.ramonilho.metroapp.model;

/**
 * Created by logonrm on 26/06/2017.
 */

public class Line {

    private String cor;
    private String numero;
    private String urlImagem;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
