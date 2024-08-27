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
        System.out.println("Retornando nome: " + nome);
        return nome;
    }

    public String getMatricula() {
        System.out.println("Retornando matrícula: " + matricula);
        return matricula;
    }

    public List<Disciplina> getDisciplinas() {
        System.out.println("Retornando lista de disciplinas: " + disciplinas);
        return disciplinas;
    }

    public void matricular(Disciplina disciplina) {
        System.out.println("Matriculando o aluno " + this.nome + " na disciplina: " + disciplina.getNome());
    }


    public void cancelarMatricula(Disciplina disciplina) {
        System.out.println("Cancelando a matrícula do aluno " + this.nome + " na disciplina: " + disciplina.getNome());
    }


    @Override
    public String toString() {
        return "Aluno{nome='" + nome + "', matricula='" + matricula + "', curso='" + curso.getNome() + "'}";
        System.out.println("Dados do aluno: " + dadosAluno);
    }

}
