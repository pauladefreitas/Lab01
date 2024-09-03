public class Aluno extends Usuario {
    private Curso curso;
    private String nome;
    private String matricula;

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

    @Override
    public String toString() {
        return "Aluno: Nome = " + nome + ";\nMatrícula = " + matricula + ";\nCurso = " + curso.getNome();
    }
}
