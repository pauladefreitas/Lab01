package sistemadematriculas;

import java.util.List;

public class SistemaMatriculas {
    private List<Curso> cursos;
    private SistemaCobranca sistemaCobranca;

    public SistemaMatriculas(List<Curso> cursos, SistemaCobranca sistemaCobranca) {
        this.cursos = cursos;
        this.sistemaCobranca = sistemaCobranca;
    }

    public List<Curso> getCursos() {
        return this.cursos;
    }

    public SistemaCobranca getSistemaCobranca() {
        return this.sistemaCobranca;
    }

    public void matricularAluno(Aluno aluno, Disciplina disciplina) {
        if (aluno == null || disciplina == null) {
            System.out.println("Aluno ou disciplina não fornecidos para matrícula.");
        } else {
            System.out.println("Matriculando o aluno " + aluno.getNome() + " na disciplina: " + disciplina.getNome());
            aluno.matricularAluno(disciplina);
            notificarSistemaCobrancas(aluno, disciplina);            
        }
    }

    public void cancelarMatricula(Aluno aluno, Disciplina disciplina) {
        if (aluno == null || disciplina == null) {
            System.out.println("Aluno ou disciplina não fornecidos para cancelamento de matrícula.");
        } else {
            System.out.println("Cancelando a matrícula do aluno " + aluno.getNome() + " na disciplina: " + disciplina.getNome());
            aluno.cancelarMatricula(disciplina);
            notificarSistemaCobrancas(aluno, disciplina);            
        }
    }

    public void finalizarPeriodoMatriculas() {
        System.out.println("Finalizando o período de matrículas.");
    }

    private void notificarSistemaCobrancas(Aluno aluno, Disciplina disciplina) {
        if (sistemaCobranca == null) {
            System.out.println("Sistema de cobrança não configurado.");
            return;
        }
        sistemaCobranca.notificarCobranca(aluno, disciplina);
    }
}
