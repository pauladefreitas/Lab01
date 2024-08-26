package sistemadematriculas;

import java.util.List;

public class SistemaMatriculas {
    private List<Curso> cursos;
    private SistemaCobranca sistemaCobranca;

    public List<Curso> getCursos() {
        return this.cursos;
    }

    public SistemaCobranca getSistemaCobranca() {
        return this.sistemaCobranca;
    }

    public SistemaMatriculas(List<Curso> cursos, SistemaCobranca sistemaCobranca) {
        this.cursos = cursos;
        this.sistemaCobranca = sistemaCobranca;
    }

    public void matricularAluno(Aluno aluno, Disciplina disciplina) {
        
    }

    public void cancelarMatricula(Aluno aluno, Disciplina disciplina) {
        
    }

    public void finalizarPeriodoMatriculas() {
        
    }

    private void notificarSistemaCobrancas(Aluno aluno, Disciplina disciplina) {
        
    }
}
