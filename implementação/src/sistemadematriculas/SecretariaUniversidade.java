package sistemadematriculas;

import java.util.List;

public class SecretariaUniversidade {
    private List<Disciplina> disciplinas;
    private List<Aluno> alunos;
    private List<Professor> professores;

    public SecretariaUniversidade(List<Disciplina> disciplinas, List<Aluno> alunos, List<Professor> professores) {
        this.disciplinas = disciplinas;
        this.alunos = alunos;
        this.professores = professores;
    }

    public List<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public List<Professor> getProfessores() {
        return this.professores;
    }

    public String gerarCurriculo() {
        return ("Gerando currículo com " +
        "disciplinas: " + (disciplinas != null ? disciplinas.size() : "nenhuma") +
        ", alunos: " + (alunos != null ? alunos.size() : "nenhum") +
        ", professores: " + (professores != null ? professores.size() : "nenhum"));
    }
}
