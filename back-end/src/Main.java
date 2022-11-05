import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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
                )
        };
        String result = request(fontes);

        System.out.println(result);
    }

    private static String request(Fonte[] fontes) {
        StringBuilder sb = new StringBuilder();

        try {
            sb.append("[\n");
            for (Fonte fonte : fontes) {
                final Document doc = Jsoup.connect(fonte.getUrl()).get();

                for (Element row : doc.select(
                        fonte.getComponente())) {
                    if (!row.select(fonte.getBuscaTitulo()).text().equals("")) {
                        final String site = fonte.getNome();
                        final String empresa = row.select(fonte.getBuscaEmpresa()).text();
                        final String titulo = row.select(fonte.getBuscaTitulo()).text();
                        final String local = row.select(fonte.getBuscaLocal()).text();

                        sb.append("\t{\n");
                        sb.append("\t\t\"fonte\": \"").append(site).append("\"\n");
                        sb.append("\t\t\"empresa\": \"").append(empresa).append("\"\n");
                        sb.append("\t\t\"titulo\": \"").append(titulo).append("\"\n");
                        sb.append("\t\t\"local\": \"").append(local).append("\"\n");
                        sb.append("\t},\n");
                    }
                    else
                        continue;
                }
            }
            sb.append("]\n");
        } catch (IOException e) {
            return null;
        }

        return sb.toString();
    }
}