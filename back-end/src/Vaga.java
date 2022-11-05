public class Vaga {
    private String empresa;
    private String titulo;
    private String local;
    private String site;

    public Vaga(String empresa, String titulo, String local, String site) {
        this.empresa = empresa;
        this.titulo = titulo;
        this.local = local;
        this.site = site;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getLocal() {
        return local;
    }

    public String getSite() {
        return site;
    }
}
