/*
 *  Todos os direitos reservados.
 *    
 */
package visitas.hoken.utils;

import java.io.IOException;
import java.net.SocketTimeoutException;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Elaine Cecília Gatto - Cissa (elainececiliagatto@gmail.com)
 */
public class buscaCEP {

    public String getEndereco(String CEP) throws IOException {
        try {
            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP).timeout(120000).get();
            Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
            for (Element urlEndereco : urlPesquisa) {
                return urlEndereco.text();
            }
        } catch (SocketTimeoutException e) {
            e.getCause();
            e.getMessage();
        } catch (HttpStatusException w) {
            w.getCause();
            w.getMessage();
        }
        return CEP;
    }

    public String getBairro(String CEP) throws IOException {
        try {
            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP).timeout(120000).get();
            Elements urlPesquisa = doc.select("td:gt(1)");
            for (Element urlBairro : urlPesquisa) {
                return urlBairro.text();
            }
        } catch (SocketTimeoutException e) {
            e.getCause();
            e.getMessage();
        } catch (HttpStatusException w) {
            w.getCause();
            w.getMessage();
        }
        return CEP;
    }

    public String getCidade(String CEP) throws IOException {
        try {
            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP).timeout(120000).get();
            Elements urlPesquisa = doc.select("span[itemprop=addressLocality]");
            for (Element urlCidade : urlPesquisa) {
                return urlCidade.text();
            }
        } catch (SocketTimeoutException e) {
            e.getCause();
            e.getMessage();
        } catch (HttpStatusException w) {
            w.getCause();
            w.getMessage();
        }
        return CEP;
    }

    public String getUF(String CEP) throws IOException {
        try {
            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP).timeout(120000).get();
            Elements urlPesquisa = doc.select("span[itemprop=addressRegion]");
            for (Element urlUF : urlPesquisa) {
                return urlUF.text();
            }
        } catch (SocketTimeoutException e) {
            e.getCause();
            e.getMessage();
        } catch (HttpStatusException w) {
            w.getCause();
            w.getMessage();
        }
        return CEP;
    }
}
