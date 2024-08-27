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
        System.out.println("Secretaria da Universidade criada com " +
                           "disciplinas: " + (disciplinas != null ? disciplinas.size() : "nenhuma") +
                           ", alunos: " + (alunos != null ? alunos.size() : "nenhum") +
                           ", professores: " + (professores != null ? professores.size() : "nenhum"));
    }

    public List<Disciplina> getDisciplinas() {
        System.out.println("Retornando lista de disciplinas: " + disciplinas);
        return this.disciplinas;
    }

    public List<Aluno> getAlunos() {
        System.out.println("Retornando lista de alunos: " + alunos);
        return this.alunos;
    }

    public List<Professor> getProfessores() {
        System.out.println("Retornando lista de professores: " + professores);
        return this.professores;
    }

    public String gerarCurriculo() {
        System.out.println("Gerando currículo com " +
                           "disciplinas: " + (disciplinas != null ? disciplinas.size() : "nenhuma") +
                           ", alunos: " + (alunos != null ? alunos.size() : "nenhum") +
                           ", professores: " + (professores != null ? professores.size() : "nenhum"));
        return "Currículo gerado";
    }
}
