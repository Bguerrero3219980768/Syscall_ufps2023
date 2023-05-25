/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Gederson
 */
public class othertest {
    public static void main(String[] args) throws IOException {
        String comando[]= { "cmd.exe", "/c", "tasklist /v /fo csv" };
        
        Process proceso = Runtime.getRuntime().exec(comando);
        
        BufferedReader buff
                = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        String line;
        String msg="";
        
        while ((line = buff.readLine()) != null) {
            msg+=line+"\n";
            
        }
            System.out.println(msg);
    }
}
