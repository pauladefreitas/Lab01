import java.util.List;
import java.util.ArrayList;

public class Professor extends Usuario {
    private String nome;
    private List<Disciplina> disciplinas;

    public Professor(String nome, String senha) {
        super(senha);
        this.nome = nome;
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public String getNome() {
        return nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<Aluno> listarAlunosMatriculados(Disciplina disciplina) {
        if (disciplinas.contains(disciplina)) {
            return disciplina.getAlunos();
        } else {
            System.out.println("O professor não leciona esta disciplina.");
            return null;
        }
    }

    public void addDisciplinas(Disciplina disciplina) {
        disciplinas.add(disciplina); 
    }

    @Override
    public String toString() {
        return "Professor: \n Nome = " + nome + ".\nDisciplinas que leciona = " + disciplinas;
    }
}
