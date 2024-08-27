import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        List<Curso> cursos = new ArrayList<>();

        SistemaCobranca sistemaCobranca = new SistemaCobranca();
        SistemaMatriculas sistemaMatriculas = new SistemaMatriculas(disciplinas, sistemaCobranca);
        SecretariaUniversidade secretariaUniversidade = new SecretariaUniversidade(disciplinas, alunos, professores);

        boolean sair = false;
        while (!sair) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Curso");
            System.out.println("3. Cadastrar Disciplina");
            System.out.println("4. Cadastrar Professor");
            System.out.println("5. Matricular Aluno");
            System.out.println("6. Cancelar Matrícula");
            System.out.println("7. Gerar Currículo");
            System.out.println("8. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do aluno:");
                    String nomeAluno = scanner.nextLine();
                    System.out.println("Digite o número da matrícula:");
                    String matricula = scanner.nextLine();
                    System.out.println("Digite o nome do curso:");
                    String nomeCurso = scanner.nextLine();
                    Curso curso = new Curso(nomeCurso, 0); // Exemplo com dados fictícios
                    Aluno aluno = new Aluno("senha123", nomeAluno, matricula, curso);
                    alunos.add(aluno);
                    System.out.println("Aluno cadastrado com sucesso.");
                    System.out.println("------------------------------");
                    break;

                case 2:
                    System.out.println("Digite o nome do curso:");
                    String nomeCursoCadastro = scanner.nextLine();
                    System.out.println("Digite o número de créditos do curso:");
                    int numCreditos = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    Curso cursoCadastro = new Curso(nomeCursoCadastro, numCreditos); // Exemplo com carga horária fictícia
                    cursos.add(cursoCadastro);
                    System.out.println("Curso cadastrado com sucesso.");
                    System.out.println("------------------------------");
                    break;

                case 3:
                    System.out.println("Digite o nome da disciplina:");
                    String nomeDisciplina = scanner.nextLine();
                    System.out.println("Digite a carga horária da disciplina:");
                    int cargaHoraria = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.println("Digite o nome do professor:");
                    String nomeProfessor = scanner.nextLine();
                    Professor professor = new Professor(nomeProfessor, null, "senha123"); // Exemplo com dados fictícios
                    Disciplina disciplina = new Disciplina(nomeDisciplina, cargaHoraria, professor);
                    disciplinas.add(disciplina);
                    System.out.println("Disciplina cadastrada com sucesso.");
                    System.out.println("------------------------------");
                    break;

                case 4:
                    System.out.println("Digite o nome do professor:");
                    String nomeProfessorCadastro = scanner.nextLine();
                    System.out.println("Digite o nome da disciplina associada:");
                    String nomeDisciplinaAssociada = scanner.nextLine();
                    Disciplina disciplinaAssociada = disciplinas.stream()
                            .filter(d -> d.getNome().equals(nomeDisciplinaAssociada))
                            .findFirst()
                            .orElse(null);
                    Professor professorCadastro = new Professor(nomeProfessorCadastro, disciplinaAssociada, "senha123");
                    professores.add(professorCadastro);
                    System.out.println("Professor cadastrado com sucesso.");
                    System.out.println("------------------------------");
                    break;

                case 5:
                    System.out.println("Digite o nome do aluno:");
                    String nomeAlunoMatricula = scanner.nextLine();
                    Aluno alunoMatricula = alunos.stream()
                            .filter(a -> a.getNome().equals(nomeAlunoMatricula))
                            .findFirst()
                            .orElse(null);
                    System.out.println("Digite o nome da disciplina para matrícula:");
                    String nomeDisciplinaMatricula = scanner.nextLine();
                    Disciplina disciplinaMatricula = disciplinas.stream()
                            .filter(d -> d.getNome().equals(nomeDisciplinaMatricula))
                            .findFirst()
                            .orElse(null);
                    if (alunoMatricula != null && disciplinaMatricula != null) {
                        sistemaMatriculas.matricularAluno(alunoMatricula, disciplinaMatricula);
                        System.out.println("Aluno matriculado com sucesso.");
                    } else {
                        System.out.println("Aluno ou disciplina não encontrados.");
                    }
                    System.out.println("------------------------------");
                    break;

                case 6:
                    System.out.println("Digite o nome do aluno:");
                    String nomeAlunoCancelamento = scanner.nextLine();
                    Aluno alunoCancelamento = alunos.stream()
                            .filter(a -> a.getNome().equals(nomeAlunoCancelamento))
                            .findFirst()
                            .orElse(null);
                    System.out.println("Digite o nome da disciplina para cancelamento:");
                    String nomeDisciplinaCancelamento = scanner.nextLine();
                    Disciplina disciplinaCancelamento = disciplinas.stream()
                            .filter(d -> d.getNome().equals(nomeDisciplinaCancelamento))
                            .findFirst()
                            .orElse(null);
                    if (alunoCancelamento != null && disciplinaCancelamento != null) {
                        sistemaMatriculas.cancelarMatricula(alunoCancelamento, disciplinaCancelamento);
                        System.out.println("Matrícula cancelada com sucesso.");
                    } else {
                        System.out.println("Aluno ou disciplina não encontrados.");
                    }
                    System.out.println("------------------------------");
                    break;

                case 7:
                    String curriculo = secretariaUniversidade.gerarCurriculo();
                    System.out.println("Currículo gerado:");
                    System.out.println(curriculo);
                    System.out.println("------------------------------");
                    break;

                case 8:
                    sair = true;
                    System.out.println("Saindo do sistema.");
                    System.out.println("------------------------------");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println("------------------------------");
                    break;
            }
        }

        scanner.close();
    }
}