package br.ucsal.semoc.easydrug;

import java.io.Serializable;

public class Medicamento  implements Serializable {
    private Integer id = 0;
    private String nome;
    private String dosagem;
    private String hora;
    private String data;


    public Medicamento(String nome, String dosagem, String hora, String data) {
        this.id = id++;
        this.nome = nome;
        this.dosagem = dosagem;
        this.hora = hora;
        this.data = data;
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