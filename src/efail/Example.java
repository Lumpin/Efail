/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efail;

import static efail.ImportText.readFileAsString;
import static efail.ImportText.subString;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonas
 */
public class Example {
    public static String data;
    public static List<String> strings;

    public static String key = "abcdabcdabcdabcd";
    //abcdabcdabcdabcd - 61626364616263646162636461626364
    public static String cIV = "";
    //Pi
    //Das ist ein Tag! - 446173206973742065696e2054616721
    public static String cI = "";

    //Pc
    //Heute denke ich! - 48657574652064656e6b652069636821
    /**
     *
     *
     * @param arg
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String toHex(String arg) throws UnsupportedEncodingException {
        return String.format("%040x", new BigInteger(1, arg.getBytes("UTF-8")));
    }

    public static void readData() {

        try {
            data = readFileAsString("C:\\Users\\Jonas\\Desktop\\Init.txt");
            strings = subString(data);

            cIV = strings.get(0);
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void writeDataEnc(String iv, String str) {
        
        try {
            try (PrintWriter out = new PrintWriter("C:\\Users\\Jonas\\Desktop\\Encrypted.txt")) {

                out.println(iv + str);
            }
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeDataDec(String iv, String str) {
        
        try {
            try (PrintWriter out = new PrintWriter("C:\\Users\\Jonas\\Desktop\\Decrypted.txt")) {

                out.println(iv + str);
            }
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     *
     * @param arg
     * @return
     */
    public static String unHex(String arg) {

        String str = "";
        for (int i = 0; i < arg.length(); i += 2) {
            String s = arg.substring(i, (i + 2));
            int decimal = Integer.parseInt(s, 16);
            str = str + (char) decimal;
        }
        return str;
    }
}
