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
        System.out.println("Retornando carga horária da disciplina: " + cargaHoraria);
        return cargaHoraria;
    }

    public List<Aluno> getAlunos() {
        System.out.println("Retornando lista de alunos da disciplina: " + alunos);
        return alunos;
    }

    public Professor getProfessor() {
        System.out.println("Retornando professor da disciplina: " + professor.getNome());
        return professor;
    }

    public boolean isAtiva() {
        System.out.println("Verificando se a disciplina está ativa: " + ativa);
        return ativa;
    }

    public boolean getAtiva() {
        System.out.println("Retornando status de atividade da disciplina: " + ativa);
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
    }

    public void removerAluno(Aluno aluno) {
        System.out.println("Removendo aluno " + aluno.getNome() + " da disciplina: " + nome);
    }

    @Override
    public String toString() {
        return "Disciplina{nome='" + nome + "', cargaHoraria=" + cargaHoraria + ", professor=" + professor.getNome() + ", ativa=" + ativa + "}";
    }
}
