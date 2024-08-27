

import java.util.List;
import java.util.ArrayList;

public class SecretariaUniversidade {
    private List<Disciplina> disciplinas;
    private List<Aluno> alunos;
    private List<Professor> professores;

    public SecretariaUniversidade(List<Disciplina> disciplinas, List<Aluno> alunos, List<Professor> professores) {
        this.disciplinas = disciplinas != null ? disciplinas : new ArrayList<>();
        this.alunos = alunos != null ? alunos : new ArrayList<>();
        this.professores = professores != null ? professores : new ArrayList<>();
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno " + aluno.getNome() + " adicionado."); //fazer checagem de matrícula
    }

    public void addProfessor(Professor professor) {
        professores.add(professor);
        System.out.println("Professor " + professor.getNome() + " adicionado.");
    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        System.out.println("Disciplina " + disciplina.getNome() + " adicionada.");
    }

    public String gerarCurriculo() {
        return ("Gerando currículo com " +
        "disciplinas: " + (disciplinas != null ? disciplinas.size() : "nenhuma") +
        ", alunos: " + (alunos != null ? alunos.size() : "nenhum") +
        ", professores: " + (professores != null ? professores.size() : "nenhum"));
    }
}
