package sistemadematriculas;

import java.util.List;

public class Curso {

    private String nome;
    private int numCreditos;
    private List<Disciplina> disciplinas;

    public Curso(String nome, int numCreditos) {
        this.nome = nome;
        this.numCreditos = numCreditos;
    }

    public String getNome() {
        return nome;
    }

    public int getNumCreditos() {
        System.out.println("Retornando número de créditos do curso: " + numCreditos);
        return numCreditos;
    }

    public List<Disciplina> getDisciplinas() {
        System.out.println("Retornando lista de disciplinas do curso: " + disciplinas);
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        System.out.println("Adicionando disciplina: " + disciplina.getNome() + " ao curso: " + nome);
    }

    public void removerDisciplina(Disciplina disciplina) {
        System.out.println("Removendo disciplina: " + disciplina.getNome() + " do curso: " + nome);
    }

    @Override
    public String toString() {
        return "Curso{nome='" + nome + "', numCreditos=" + numCreditos + "}";
        System.out.println("Dados do curso: " + dadosCurso);
    }
}
