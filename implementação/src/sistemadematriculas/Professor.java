

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
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Aluno> listarAlunosMatriculados(Disciplina disciplina) {
        if (disciplina == null) {
            System.out.println("Nenhuma disciplina fornecida.");
            return null;
        }
        System.out.println("Listando alunos matriculados na disciplina: " + disciplina.getNome());
        return disciplina.getAlunos();
    }

    @Override
    public String toString() {
        String disciplinaNome = (disciplina != null) ? disciplina.getNome() : "nenhuma";
        return "Professor {nome='" + nome + "', disciplina='" + disciplinaNome + "'}";
    }
}
