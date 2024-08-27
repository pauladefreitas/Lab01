

public class SistemaCobranca {

    private Boolean notificar = false;

    public void notificarCobranca(Aluno aluno, Disciplina disciplina) {
        if (aluno == null || disciplina == null) {
            System.out.println("Aluno ou disciplina não fornecidos para a cobrança.");
        } else {
            System.out.println("Notificando cobrança para o aluno: " + aluno.getNome() + " na disciplina: " + disciplina.getNome());
            notificar = true;
        }
    }

    public Boolean isNotificado() {
        return notificar;
    }
}