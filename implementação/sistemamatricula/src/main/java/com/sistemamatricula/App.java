package com.sistemamatricula;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.RollbackException;
import jakarta.persistence.TransactionRequiredException;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("sistemamatricula");
            em = emf.createEntityManager();
        } catch (PersistenceException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return;
        }

        em.getTransaction().begin();

        try {
            Curso curso1 = new Curso("Engenharia de Software", 40);
            Curso curso2 = new Curso("Ciência da Computação", 50);

            em.persist(curso1);
            em.persist(curso2);

            Professor professor1 = new Professor("Ana Maria", "senha123");
            Professor professor2 = new Professor("Carlos Silva", "senha123");

            em.persist(professor1);
            em.persist(professor2);

            Disciplina disciplina1 = new Disciplina("Algoritmos", 60, professor1, curso1);
            Disciplina disciplina2 = new Disciplina("Banco de Dados", 60, professor2, curso2);

            em.persist(disciplina1);
            em.persist(disciplina2);

            Aluno aluno1 = new Aluno("senha123", "João Pedro", "20230001", curso1);
            Aluno aluno2 = new Aluno("senha123", "Mariana Lima", "20230002", curso2);

            em.persist(aluno1);
            em.persist(aluno2);

            em.getTransaction().commit();

            System.out.println("Dados iniciais cadastrados com sucesso.");

        } catch (EntityExistsException | RollbackException e) {
            System.err.println("Erro ao tentar persistir os dados iniciais: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }

        List<Aluno> alunos = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        List<Curso> cursos = new ArrayList<>();

        Cobranca sistemaCobranca = new Cobranca();
        SistemaMatriculas sistemaMatriculas = new SistemaMatriculas(disciplinas, sistemaCobranca);

        boolean sair = false;

        try {
            em.getTransaction().begin();

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
                System.out.println("9. Abrir período de matrículas");

                int escolha = 0;
                try {
                    escolha = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                    scanner.nextLine();
                    continue;
                }

                switch (escolha) {
                    case 1:
                        System.out.println("Digite o nome do aluno:");
                        String nomeAluno = scanner.nextLine();
                        System.out.println("Digite o número da matrícula:");
                        String matricula = scanner.nextLine();
                        System.out.println("Digite o nome do curso:");
                        String nomeCurso = scanner.nextLine();

                        Curso curso = new Curso(nomeCurso, 0);
                        try {
                            em.persist(curso);
                            Aluno aluno = new Aluno("senha123", nomeAluno, matricula, curso);
                            em.persist(aluno);
                            alunos.add(aluno);
                            System.out.println("Aluno cadastrado com sucesso.");
                        } catch (EntityExistsException e) {
                            System.err.println("Erro: O aluno já existe no banco de dados.");
                        } catch (TransactionRequiredException e) {
                            System.err.println("Erro: A transação é necessária para persistir a entidade.");
                        } catch (RollbackException e) {
                            System.err.println("Erro: Falha ao concluir a transação.");
                        }
                        System.out.println("------------------------------");
                        break;

                    case 2:
                        System.out.println("Digite o nome do curso:");
                        String nomeCursoCadastro = scanner.nextLine();
                        System.out.println("Digite o número de créditos do curso:");
                        int numCreditos = scanner.nextInt();
                        scanner.nextLine();
                        Curso cursoCadastro = new Curso(nomeCursoCadastro, numCreditos);
                        cursos.add(cursoCadastro);
                        em.persist(cursoCadastro);
                        System.out.println("Curso cadastrado com sucesso.");
                        System.out.println("------------------------------");
                        break;

                    case 3:
                        System.out.println("Digite o nome da disciplina:");
                        String nomeDisciplina = scanner.nextLine();
                        System.out.println("Digite a carga horária da disciplina:");
                        int cargaHoraria = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite o nome do professor:");
                        String nomeProfessor = scanner.nextLine();
                        System.out.println("Digite o nome do curso:");
                        String nomecursoCadastro = scanner.nextLine();
                        System.out.println("Digite o número de créditos do curso:");
                        int numcreditos = scanner.nextInt();
                        scanner.nextLine();
                        Curso cursocadastro = new Curso(nomecursoCadastro, numcreditos);
                        cursos.add(cursocadastro);
                        em.persist(cursocadastro);
                        Professor professor = new Professor(nomeProfessor, "senha123");
                        Disciplina disciplina = new Disciplina(nomeDisciplina, cargaHoraria, professor, cursocadastro);
                        disciplinas.add(disciplina);
                        em.persist(professor);
                        em.persist(disciplina);
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
                        Professor professorCadastro = new Professor(nomeProfessorCadastro, "senha123");
                        professores.add(professorCadastro);
                        if (disciplinaAssociada != null) {
                            professorCadastro.addDisciplinas(disciplinaAssociada);
                            System.out.println("Professor cadastrado com sucesso.");
                        } else {
                            System.out.println("Disciplina associada não encontrada.");
                        }
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

                    case 8:
                        sair = true;
                        System.out.println("Saindo do sistema.");
                        System.out.println("------------------------------");
                        break;

                    case 9:
                        sistemaMatriculas.abrirPeriodoMatriculas();
                        System.out.println("Período de matrículas aberto.");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        System.out.println("------------------------------");
                        break;
                }
            }

            try {
                em.getTransaction().commit();
            } catch (RollbackException e) {
                System.err.println("Erro ao tentar commitar a transação: " + e.getMessage());
                em.getTransaction().rollback();
            }

        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
            scanner.close();
        }
    }
}
