import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private int cargaHoraria;
    private List<Aluno> alunos;
    private Professor professor;
    private boolean ativa;
    private Curso curso; 
    private boolean obrigatorio;
    private int numCreditos;

    public Disciplina(String nome, int cargaHoraria, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.ativa = false;
        this.alunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public boolean isAtiva() {
        return ativa = true;
    }

    public int getnumCreditos() {
        return numCreditos;
    }

    public void addAluno(Aluno aluno) {
        System.out.println("Adicionando aluno " + aluno.getNome() + " à disciplina: " + nome);
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        if (alunos.remove(aluno)) {
            System.out.println("Removendo aluno " + aluno.getNome() + " da disciplina: " + nome);
        } else {
            System.out.println("Aluno " + aluno.getNome() + " não está matriculado na disciplina: " + nome);
        }
    }

    public void periodoMatricula() {
        if (alunos.size() >= 3) {
            this.ativa = true;
            System.out.println("Disciplina " + nome + " será ofertada no próximo semestre.");
        } else {
            this.ativa = false;
            System.out.println("Disciplina " + nome + " não atingiu o número mínimo de alunos e será cancelada.");
        }
    }

    @Override
    public String toString() {
        return "Disciplina: Nome = " + nome + ";\nCarga horária = " + cargaHoraria + ";\nProfessor = " + professor.getNome() + ";\nAtiva = " + ativa;
    }
}
