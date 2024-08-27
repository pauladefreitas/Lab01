package sistemadematriculas;

public class SistemaCobranca {

    public void notificarCobranca(Aluno aluno, Disciplina disciplina) {
        if (aluno == null || disciplina == null) {
            System.out.println("Aluno ou disciplina não fornecidos para a cobrança.");
            return;
        }
        System.out.println("Notificando cobrança para o aluno: " + aluno.getNome() +
                           " na disciplina: " + disciplina.getNome());
    }
}
