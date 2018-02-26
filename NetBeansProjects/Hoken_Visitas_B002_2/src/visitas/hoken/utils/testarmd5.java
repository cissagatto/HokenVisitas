/*
 *  Todos os direitos reservados. Elaine Cec�lia Gatto. 2018
 *    * 
 */
package visitas.hoken.utils;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Alan
 */
public class testarmd5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // TODO code application logic here
        
        MD5 md5 = new MD5();
        System.out.println(md5.criptografar("1234"));
                
    }
    
}
