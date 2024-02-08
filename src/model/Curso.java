package model;

import java.util.List;

public class Curso {

    private String nome;
    private String descricao;
    private List<Professor> professores;
    private int cargaHoraria;

    public Curso(String nome, String descricao, List<Professor> professores, int cargaHoraria) {
        this.nome = nome;
        this.descricao = descricao;
        this.professores = professores;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", professores=" + professores +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }

    public void progress() {
        System.out.println("Progresso ainda não definido. \n");
    }

    public void notas() {
        System.out.println("Notas ainda não publicadas. \n");
    }

    public void participacao() {
        System.out.println("Participação ainda não computada. \n");
    }
}
