package sistemadematriculas;

import java.util.List;

public class Professor extends Usuario {
    private String nome;
    private Disciplina disciplina; 

    public Professor(String nome, Disciplina disciplina, String senha) {
        super(senha);
        this.nome = nome;
        this.disciplina = disciplina;
    }

    public String getNome() {
        return this.nome;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public List<Aluno> listarAlunosMatriculados(Disciplina disciplina) {
        
        return null; //stub
    }
}
