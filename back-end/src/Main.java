import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Fonte[] fontes = {
                new Fonte(
                        "https://www.linkedin.com/jobs/search?keywords=Software%20Development&location=Bauru%2C%20São%20Paulo%2C%20Brazil&geoId=&trk=homepage-jobseeker_jobs-search-bar_search-submit&position=1&pageNum=0",
                        "Linkedin",
                        "ul.jobs-search__results-list li",
                        "a[class=hidden-nested-link]",
                        "h3[class=base-search-card__title]",
                        "span[class=job-search-card__location]"
                ),
                new Fonte(
                        "https://www.catho.com.br/vagas/programador/",
                        "Catho",
                        "ul.sc-hrWEMg li",
                        "p[class=sc-cmTdod hVSlrJ]",
                        "h2[class=Title__Heading-sc-14fvmc0-0 fGTSAd sc-iELTvK jNpEBd]",
                        "button[class=sc-iyvyFf kIwChr]"
                )
        };

        ArrayList<Vaga> vagas = BuscaVagas.request(fontes);

        for (Vaga v : vagas) {
            System.out.println("*****");
            System.out.println(v.getSite());
            System.out.println(v.getEmpresa());
            System.out.println(v.getTitulo());
            System.out.println(v.getLocal());
            System.out.println("*****\n");
        }
    }
}