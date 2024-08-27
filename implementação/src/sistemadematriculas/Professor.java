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

    @Override
    public String toString() {
        String disciplinaNome = (disciplina != null) ? disciplina.getNome() : "nenhuma";
        String dadosProfessor = "Professor{nome='" + nome + "', disciplina='" + disciplinaNome + "'}";
        System.out.println("Dados do professor: " + dadosProfessor);
        return dadosProfessor;
    }
}
