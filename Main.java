import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.*;

public class Main {

    public static String sha256(final String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    private static String hexToBin(String hex) {
        String bin = "";
        String binFragment = "";
        int iHex;
        hex = hex.trim();
        hex = hex.replaceFirst("0x", "");

        for(int i = 0; i < hex.length(); i++){
            iHex = Integer.parseInt(""+hex.charAt(i),16);
            binFragment = Integer.toBinaryString(iHex);

            while(binFragment.length() < 4){
                binFragment = "0" + binFragment;
            }
            bin += binFragment;
        }
        return bin;
    }

    public static void main(String[] args) {
        // Referencia
        String avelino = "Avelino194217463";
        String hex = "000000030BC26B9F5732EEFA3D2A6136D30C6C0332E15E6580B82AC0A70781B6";
        // String strHex = hex.substring(0, 7).toString();
        String strHex = "0000000";
        // String bin = hexToBin(hex).substring(0, 30).toString();
        String bin = "000000000000000000000000000000";


        String guilherme = "Guilherme";
        String gui = "";
        String numHex = "";
        String num = "";
        String str = "";
        String binary = "";

        boolean value = false;

        int count = 0;

        // compara o o valor hexadecimal
        // compara binário
        for(int i = 0;;) {
            gui = guilherme + String.valueOf(count);
            numHex = sha256(gui).substring(0, 7).toString();;
            if(numHex.equals(strHex)) {
                str = sha256(gui);
                System.out.println("sha256 hex: " + str);
                num = hexToBin(str).substring(0, 30).toString();
                System.out.println("num: " + num);
                binary = hexToBin(str);
                System.out.println("bin: " + binary);
                System.out.println("name: " + gui);
                System.out.println("count: " + count);
                value = true;
                if(num.equals(bin)) {
                    break;
                }
            }
            // System.out.println(count);
            count++;
        }

        // compara o valor binário
        // for(int i = 0;;) {
        //     gui = guilherme + String.valueOf(count);
        //     str = sha256(gui);
        //     num = hexToBin(str).substring(0, 30).toString();
        //     if(num.equals(bin)) { break; }
        //     if(count == 200000000) { break; }
        //     // System.out.println("str: " + str);
        //     // System.out.println("bin: " + bin);
        //     System.out.println("num: " + num);
        //     System.out.println("gui: " + gui);
        //     count++;
        // }

        System.out.println("RESULT: " + gui);
    }
}