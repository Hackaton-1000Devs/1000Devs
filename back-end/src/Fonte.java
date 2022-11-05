public class Fonte {
    private String url;
    private String nome;
    private String componente;
    private String buscaEmpresa;
    private String buscaTitulo;
    private String buscaLocal;

    public Fonte(String url, String nome, String componente, String buscaEmpresa, String buscaTitulo, String buscaLocal) {
        this.url = url;
        this.nome = nome;
        this.componente = componente;
        this.buscaEmpresa = buscaEmpresa;
        this.buscaTitulo = buscaTitulo;
        this.buscaLocal = buscaLocal;
    }

    public String getComponente() {
        return componente;
    }

    public String getUrl() {
        return url;
    }

    public String getNome() {
        return nome;
    }

    public String getBuscaEmpresa() {
        return buscaEmpresa;
    }

    public String getBuscaTitulo() {
        return buscaTitulo;
    }

    public String getBuscaLocal() {
        return buscaLocal;
    }
}
