/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efail;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class ImportText {

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static List<String> subString(String text) {

        List<String> strings = new ArrayList<String>();
        int index = 0;

        while (index < text.length()) {
            strings.add(text.substring(index, Math.min(index + 16, text.length())));
            index += 16;
        }

        return strings;
    }

}
