import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class BuscaVagas {
    public static ArrayList<Vaga> request(Fonte[] fontes) {
        ArrayList<Vaga> vagas = new ArrayList<>();

        try {
            for (Fonte fonte : fontes) {
                final Document doc = Jsoup.connect(fonte.getUrl()).get();

                for (Element row : doc.select(
                        fonte.getComponente())) {
                    if (!row.select(fonte.getBuscaTitulo()).text().equals("")) {
                        final String empresa =
                                row.select(fonte.getBuscaEmpresa()).text().contains("Empresa ConfidencialPor que?") ? "Empresa Confidencial" : row.select(fonte.getBuscaEmpresa()).text();
                        final String titulo = row.select(fonte.getBuscaTitulo()).text();
                        final String local = row.select(fonte.getBuscaLocal()).text();
                        final String site = fonte.getNome();

                        vagas.add(new Vaga(empresa, titulo, local, site));
                    }
                    else
                        continue;
                }
            }
        } catch (IOException e) {
            return null;
        }

        return vagas;
    }
}
