package sistemadematriculas;

import java.util.List;

public class SistemaMatriculas {
    private List<Curso> cursos;
    private SistemaCobranca sistemaCobranca;

    public SistemaMatriculas(List<Curso> cursos, SistemaCobranca sistemaCobranca) {
        this.cursos = cursos;
        this.sistemaCobranca = sistemaCobranca;
        System.out.println("Sistema de Matrículas criado com " +
                           "cursos: " + (cursos != null ? cursos.size() : "nenhum") +
                           " e sistema de cobrança: " + (sistemaCobranca != null ? "configurado" : "não configurado"));
    }

    public List<Curso> getCursos() {
        return this.cursos;
    }

    public SistemaCobranca getSistemaCobranca() {
        System.out.println("Retornando sistema de cobrança: " + sistemaCobranca);
        return this.sistemaCobranca;
    }

    public void matricularAluno(Aluno aluno, Disciplina disciplina) {
        if (aluno == null || disciplina == null) {
            System.out.println("Aluno ou disciplina não fornecidos para matrícula.");
            return;
        }
        System.out.println("Matriculando o aluno " + aluno.getNome() +
                           " na disciplina: " + disciplina.getNome());
        notificarSistemaCobrancas(aluno, disciplina);
    }

    public void cancelarMatricula(Aluno aluno, Disciplina disciplina) {
        if (aluno == null || disciplina == null) {
            System.out.println("Aluno ou disciplina não fornecidos para cancelamento de matrícula.");
            return;
        }
        System.out.println("Cancelando a matrícula do aluno " + aluno.getNome() +
                           " na disciplina: " + disciplina.getNome());
        notificarSistemaCobrancas(aluno, disciplina);
    }

    public void finalizarPeriodoMatriculas() {
        System.out.println("Finalizando o período de matrículas.");
    }

    private void notificarSistemaCobrancas(Aluno aluno, Disciplina disciplina) {
        if (sistemaCobranca == null) {
            System.out.println("Sistema de cobrança não configurado.");
            return;
        }
        System.out.println("Notificando sistema de cobranças para o aluno " + aluno.getNome() +
                           " na disciplina: " + disciplina.getNome());
        sistemaCobranca.notificarCobranca(aluno, disciplina);
    }
}
