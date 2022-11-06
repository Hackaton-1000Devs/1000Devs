public class Vaga {
    private String empresa;
    private String titulo;
    private String local;
    private String site;
    private String LinkVaga;

    public Vaga(String empresa, String titulo, String local, String site, String LinkVaga) {
        this.empresa = empresa;
        this.titulo = titulo;
        this.local = local;
        this.site = site;
        this.LinkVaga = LinkVaga;
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

	public String getLinkVaga() {
		return LinkVaga;
	}
    
    
}
