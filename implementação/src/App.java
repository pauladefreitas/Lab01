package sistemadematriculas;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Professor prof1 = new Professor("Dr. Silva", null, "senha123");
        Professor prof2 = new Professor("Profa. Santos", null, "senha456");

        Disciplina disciplina1 = new Disciplina("Matemática", 60, prof1);
        Disciplina disciplina2 = new Disciplina("Física", 45, prof2);

        Curso curso1 = new Curso("Engenharia", 30, 200);
        Curso curso2 = new Curso("Computação", 25, 180);

        Aluno aluno1 = new Aluno("senhaAlunos1", "João", "12345", curso1);
        Aluno aluno2 = new Aluno("senhaAlunos2", "Maria", "67890", curso2);

        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinas.add(disciplina1);
        disciplinas.add(disciplina2);

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno1);
        alunos.add(aluno2);

        List<Professor> professores = new ArrayList<>();
        professores.add(prof1);
        professores.add(prof2);

        SistemaCobranca sistemaCobranca = new SistemaCobranca();
        SistemaMatriculas sistemaMatriculas = new SistemaMatriculas(cursos, sistemaCobranca);
        SecretariaUniversidade secretaria = new SecretariaUniversidade(disciplinas, alunos, professores);

        aluno1.matricular(disciplina1);
        aluno2.cancelarMatricula(disciplina2);

        aluno1.logar("senhaAlunos1");
        System.out.println("Status de login do aluno1: " + aluno1.isLogado());
        aluno1.deslogar();
        System.out.println("Status de login do aluno1 após deslogar: " + aluno1.isLogado());

        System.out.println(aluno1);
        System.out.println(disciplina1);
        System.out.println(curso1);
    }
}
