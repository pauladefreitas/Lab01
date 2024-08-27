import java.util.ArrayList;
import java.util.List;

public class SistemaMatriculas {
    private List<Disciplina> disciplinas;
    private SistemaCobranca sistemaCobranca;

    public SistemaMatriculas(List<Disciplina> disciplinas, SistemaCobranca sistemaCobranca) {
        this.disciplinas = disciplinas != null ? disciplinas : new ArrayList<>();
        this.sistemaCobranca = sistemaCobranca;
    }

    public List<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public SistemaCobranca getSistemaCobranca() {
        return this.sistemaCobranca;
    }

    public void matricularAluno(Aluno aluno, Disciplina disciplina) {
        if (aluno == null || disciplina == null) {
            System.err.println("Aluno ou disciplina não fornecidos para matrícula.");
            return;
        } 
        
        else if (disciplina.getAlunos() != null && disciplina.getAlunos().contains(aluno)) {
            System.out.println("O aluno " + aluno.getNome() + " já está matriculado na disciplina: " + disciplina.getNome());
            return;
        } 
        
        else {
            aluno.matricular(disciplina);
            disciplina.adicionarAluno(aluno);
            System.out.println("Aluno " + aluno.getNome() + " matriculado na disciplina: " + disciplina.getNome());
            notificarSistemaCobrancas(aluno, disciplina);
        }
    }

    public void cancelarMatricula(Aluno aluno, Disciplina disciplina) {
        if (aluno == null || disciplina == null) {
            System.err.println("Aluno ou disciplina não fornecidos para cancelamento de matrícula.");
            return;
        }

        else if (!disciplina.getAlunos().contains(aluno)) {
            System.out.println("O aluno " + aluno.getNome() + " não está matriculado na disciplina: " + disciplina.getNome());
            return;
        } 

        else {
            aluno.cancelarMatricula(disciplina);
            disciplina.removerAluno(aluno);
            System.out.println("Matrícula do aluno " + aluno.getNome() + " cancelada na disciplina: " + disciplina.getNome());
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
