package sistemadematriculas;

import java.util.List;

public class Professor extends Usuario {
    private String nome;
    private Disciplina disciplina;

    public Professor(String nome, Disciplina disciplina, String senha) {
        super(senha);
        this.nome = nome;
        this.disciplina = disciplina;
        System.out.println("Professor criado com nome: " + nome + ", disciplina: " + (disciplina != null ? disciplina.getNome() : "nenhuma") + ", senha: " + senha);
    }

    public String getNome() {
        System.out.println("Retornando nome do professor: " + nome);
        return nome;
    }

    public Disciplina getDisciplina() {
        System.out.println("Retornando disciplina do professor: " + (disciplina != null ? disciplina.getNome() : "nenhuma"));
        return disciplina;
    }

    public List<Aluno> listarAlunosMatriculados(Disciplina disciplina) {
        System.out.println("Listando alunos matriculados na disciplina: " + (disciplina != null ? disciplina.getNome() : "nenhuma"));
        return null;
    }
}
