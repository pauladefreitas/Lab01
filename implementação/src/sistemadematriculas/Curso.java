package sistemadematriculas;

import java.util.List;

public class Curso {
    
    private String nome; 
    private int numCreditos;
    private List<Disciplina> disciplinas;

    public Curso(String nome, int numCreditos, int cargaHoraria) {
        this.nome = nome;
        this.numCreditos = numCreditos;
    }

    public String getNome() {
        return this.nome;
    }

    public int getNumCreditos() {
        return this.numCreditos;
    }

    public List<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        
    }

    public void removerDisciplina(Disciplina disciplina) {
        
    }

}
