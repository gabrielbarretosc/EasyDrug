package br.ucsal.semoc.easydrug;

import java.io.Serializable;

public class Medicamento  implements Serializable {

    private String nome;
    private String dosagem;
    private String hora;
    private String data;


    public Medicamento(String nome, String dosagem, String hora, String data) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.hora = hora;
        this.data = data;
    }

    @Override
    public String toString() {

        return nome+" "+ hora + "" + dosagem;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



}