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
        return numCreditos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        System.out.println("Adicionando disciplina: " + disciplina.getNome() + " ao curso: " + nome);
        disciplinas.add(disciplina); 
    }

    public void removerDisciplina(Disciplina disciplina) {
        if (disciplinas.remove(disciplina)) {
            System.out.println("Removendo disciplina: " + disciplina.getNome() + " do curso: " + nome);
        } else {
            System.out.println("Disciplina " + disciplina.getNome() + " não está matriculado na disciplina: " + nome);
        }
    }

    @Override
    public String toString() {
        return "Curso{nome='" + nome + "', numCreditos=" + numCreditos + "}";
    }
}
