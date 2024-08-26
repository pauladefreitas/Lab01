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
        return this.nome;
    }

    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public boolean isAtiva() {
        return this.ativa;
    }

    public boolean getAtiva() {
        return this.ativa;
    }

    public void ativarDisciplina() {
        
    }

    public void desativarDisciplina() {
        
    }

    public void adicionarAluno(Aluno aluno) {
        
    }

    public void removerAluno(Aluno aluno) {
        
    }

}
