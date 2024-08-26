package sistemadematriculas;

public class Usuario {

    protected String senha;
    protected Boolean logado; 

    public Usuario(String senha) {
        this.senha = senha;
        this.logado = false;
    }

    public void logar(String senha) {

    }

    public void deslogar() {

    }

    public Boolean isLogado() {
        return logado;
    }

}
