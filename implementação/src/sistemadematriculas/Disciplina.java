package sistemadematriculas;

import java.util.List;

public class Disciplina {
    private String nome;
    private int cargaHoraria;
    private List<Aluno> alunos;
    private Professor professor;
    private boolean ativa;

    public Disciplina(String nome, int cargaHoraria, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.ativa = false;
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

    public boolean isAtiva() {
        return ativa;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public void ativarDisciplina() {
        this.ativa = true;
        System.out.println("Disciplina " + nome + " ativada.");
    }

    public void desativarDisciplina() {
        this.ativa = false;
        System.out.println("Disciplina " + nome + " desativada.");
    }

    public void adicionarAluno(Aluno aluno) {
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

    @Override
    public String toString() {
        return "Disciplina{nome='" + nome + "', cargaHoraria=" + cargaHoraria + ", professor=" + professor.getNome() + ", ativa=" + ativa + "}";
    }
}
