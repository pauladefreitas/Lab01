package sistemadematriculas;

import java.util.List;

public class Aluno extends Usuario {
    private Curso curso;
    private String nome;
    private String matricula;
    private List<Disciplina> disciplinas;

    public Aluno(String senha, String nome, String matricula, Curso curso) {
        super(senha); 
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public List<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public void matricular(Disciplina disciplina) {
        
    }

    public void cancelarMatricula(Disciplina disciplina) {
        
    }

    @Override
    public String toString() {
        return null; //stub
    }
}
