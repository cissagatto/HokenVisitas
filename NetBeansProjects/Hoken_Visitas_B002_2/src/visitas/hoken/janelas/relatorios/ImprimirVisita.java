/*
 *  Todos os direitos reservados.
 *    * 
 */
package visitas.hoken.janelas.relatorios;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import visitas.hoken.modelos.*;
import visitas.hoken.utils.*;

/**
 *
 * @author Elaine Cecília Gatto - Cissa (elainececiliagatto@gmail.com)
 */
public class ImprimirVisita {

    Utils u = new Utils();

    public ImprimirVisita(Visitas visita) throws IOException {
        Document doc = null;
        OutputStream os = null;
        try {
            if (doc != null) {
                System.err.println("\n O DOCUMENTO NÃO ESTÁ VAZIO!! ");
            }
                    
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
            String nomeDeUsuario = System.getProperty("user.name");         
            String caminho = "C:\\Users\\" + nomeDeUsuario + "\\Documents\\Hoken_Visitas\\Relatórios\\Visitas.pdf";
                    
            os = new FileOutputStream(caminho);
            //os = new FileOutputStream("Visita.pdf");
            PdfWriter.getInstance(doc, os);
            doc.open();

            Font f = new Font(FontFamily.HELVETICA, 20, Font.BOLD);            
            Image figura = Image.getInstance(getClass().getResource("/visitas/hoken/imagens/hoken.jpeg"));
                    
            figura.setAlignment(Element.ALIGN_CENTER);
            doc.add(figura);

            Paragraph p2 = new Paragraph("\n\n\n");
            doc.add(p2);

            PdfPTable table = new PdfPTable(2);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

            PdfPCell header = new PdfPCell(new Paragraph("INFORMAÇÕES DA VISITA"));
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setColspan(2);
            table.addCell(header);
            table.addCell("Nome do Cliente: ");            
            table.addCell(visita.getNome());
            table.addCell("Endereço: ");
            table.addCell(visita.getEndereco());
            table.addCell("Complemento: ");
            table.addCell(visita.getComplemento());
            table.addCell("Bairro: ");
            table.addCell(visita.getBairro());
            table.addCell("Cidade: ");
            table.addCell(visita.getCidade());
            table.addCell("Estado: ");
            table.addCell(visita.getEstado());
            table.addCell("CEP: ");
            table.addCell(visita.getCep());
            table.addCell("Telefone Fixo: ");
            table.addCell(visita.getTelefoneFixo());
            table.addCell("Celular: ");
            table.addCell(visita.getTelefoneCelular());
            table.addCell("Recado: ");
            table.addCell(visita.getTelefoneRecado());
            table.addCell("Data: ");
            table.addCell(df.format(visita.getData()));
            table.addCell("Horário: ");
            table.addCell(visita.getHora().toString());
            table.addCell("Dia da Semana: ");
            table.addCell(visita.getDiaSemana());
            table.addCell("Indicação: ");
            table.addCell(visita.getIndicacao());
            table.addCell("Vendedor Principal: ");
            table.addCell(visita.getVendedor1());
            table.addCell("Vendedor Secundário: ");
            table.addCell(visita.getVendedor2());
            table.addCell("Observações: ");
            table.addCell(visita.getObservacoes());
            table.addCell("Venda Concretizada? ");
            table.addCell(" (   ) Sim         (   ) Não ");
            doc.add(table);
        } catch (DocumentException de) {
            System.err.println("\n ERRO DE DOCUMENT EXCEPTION NA CLASSE IMPRIMIR VISITA");
            System.err.println("\n CAUSA:   \t" + de.getCause());
            System.err.println("\n MENSAGEM \t" + de.getMessage());
            System.err.println("\n ====================================================");
        } catch (IOException ioe) {
            System.err.println("\n ERRO DE IOEXCEPTION NA CLASSE IMPRIMIR VISITA");
            System.err.println("\n CAUSA:   \t" + ioe.getCause());
            System.err.println("\n MENSAGEM \t" + ioe.getMessage());
            System.err.println("\n ====================================================");
        } finally {
            if (doc != null) {
                System.err.println("\n doc.close()");
                doc.close();
            }
            if (os != null) {
                System.err.println("\n os.close()");
                os.close();
            }
        }
    }

}
