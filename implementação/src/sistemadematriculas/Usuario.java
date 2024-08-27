

public class Usuario {
    protected String senha;
    protected Boolean logado; 

    public Usuario(String senha) {
        this.senha = senha;
        this.logado = false;
    }

    public void logar(String senha) {
        if (this.senha.equals(senha)) {
            this.logado = true;
            System.out.println("Usuário logado com sucesso.");
        } else {
            System.out.println("Senha incorreta. Não foi possível logar.");
        }
    }

    public void deslogar() {
        this.logado = false;
        System.out.println("Usuário deslogado com sucesso.");
    }

    public Boolean isLogado() {
        System.out.println("Verificando status de login: " + logado);
        return logado;
    }
}
