//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
// Knowledge used to create this code was borrowed from internet forums and Java textbooks. 

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.Scanner;

public class Password_Generator {
    public Password_Generator() {
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        
        System.out.print("What would you like the file name to be?" + 
        "(Name of the website or service you want to use it for is the most preferable option): ");
        
        String fileName = input.next();
        
        File txtFile = new File(fileName + ".txt");
        
        if (txtFile.exists()) {
            System.out.print("\nThe file has been created already");
            System.exit(0);
        } 
        else {
            PrintWriter PassW = new PrintWriter(txtFile);
            //all possibilities are placed into this one string variable. 
            String possibilities = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
            
            SecureRandom parameter = new SecureRandom();
            
            System.out.print("\nThis program is meant to generate a random alphanumeric password.");
            
            System.out.print("\nHow many digits long would you like the password to be? ");
            
            int digit = input.nextInt();
            
            System.out.print("\nYour password has been generated. Check the file in the same folder as this program.");
            
            PassW.print(genPass(parameter, possibilities, digit));
            
            PassW.close();
        }

    }
    
//this helps extract a character in the possibilities string variable.
    public static String genPass(SecureRandom secure, String cha, int lngth) {
        char[] text = new char[lngth];

        for(int i = 0; i < lngth; ++i) {
            text[i] = cha.charAt(secure.nextInt(cha.length()));
        }

        return new String(text);
    }
}
