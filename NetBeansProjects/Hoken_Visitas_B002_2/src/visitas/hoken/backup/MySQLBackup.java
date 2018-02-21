/*
 *  Todos os direitos reservados. Elaine Cec�lia Gatto. 2018
 *    * 
 */
package visitas.hoken.backup;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Elaine Cecília Gatto - Cissa (elainececiliagatto@gmail.com)
 */
public class MySQLBackup {

    public MySQLBackup() {
    }

    public String executar() {
        int numerodobackup = 0;
        String mensagem = "";
        String novonome = "NovoBackup";
        String arquivo = "Backup";
        String nomeDeUsuario = System.getProperty("user.name"); //User account name
        String caminho = "C:\\Users\\" + nomeDeUsuario + "\\Documents\\Hoken_Visitas\\Backup\\Backup.sql";
        String caminhoAbsoluto = "C:\\Users\\" + nomeDeUsuario + "\\Documents\\Hoken_Visitas\\Backup\\";
        File bck = new File(caminho);

        try {
            if (!bck.isFile()) {
                String comando = "C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqldump.exe";
                ProcessBuilder pb = new ProcessBuilder(comando, "--user=root", "--password=0Pi@", "visitas", "--result-file=" + caminho);
                pb.start();
                mensagem = "Cópia de segurança realizada com sucesso";
            } else {
                while (bck.exists()) {
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    String caminho2 = "C:\\Users\\" + nomeDeUsuario + "\\Documents\\Hoken_Visitas\\Backup\\" + arquivo + "-" + (numerodobackup++) + ".sql";
                    bck = new File(caminho2);
                    System.out.println("NOVO NOME: " + novonome);
                    System.out.println("CAMINHO ABSOLUTO: " + caminho2);
                    caminhoAbsoluto = caminho2;
                }
                String comando = "C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqldump.exe";
                ProcessBuilder pb = new ProcessBuilder(comando, "--user=root", "--password=0Pi@", "visitas", "--result-file=" + caminhoAbsoluto);
                pb.start();
                mensagem = "Cópia de segurança realizada com sucesso";
            }
        } catch (Exception e) {
            mensagem = "Cópia de segurança NÃO pôde ser realizada!";
        }

        return mensagem;
    }

}
