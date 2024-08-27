package sistemadematriculas;

import java.util.List;

public class Aluno extends Usuario {
    private Curso curso;
    private String nome;
    private String matricula;
    private List<Disciplina> disciplinas;

    public Aluno(String senha, String nome, String matricula, Curso curso) {
        super(senha); 
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void matricular(Disciplina disciplina) {
        System.out.println("Matriculando o aluno " + this.nome + " na disciplina: " + disciplina.getNome());
        disciplinas.add(disciplina);
        disciplina.adicionarAluno(aluno);
    }

    public void cancelarMatricula(Disciplina disciplina) {
        if (disciplinas.remove(disciplina)) {
            System.out.println("Removendo disciplina " + disciplina.getNome() + " da disciplina: " + nome);
            disciplina.cancelarMatricula(aluno);
        } else {
            System.out.println("Aluno " + this.nome + " não está matriculado na disciplina: " + disciplina.getNome());
        }
    }

    @Override
    public String toString() {
        return "Aluno{nome='" + nome + "', matricula='" + matricula + "', curso='" + curso.getNome() + "'}";
        System.out.println("Dados do aluno: " + dadosAluno);
    }
}
