import java.security.MessageDigest;

public class ParallelBruteForceSha256 extends Thread {

    private String avelino = "Avelino194217463";
    private String hex = "000000030BC26B9F5732EEFA3D2A6136D30C6C0332E15E6580B82AC0A70781B6";
    private String strHex = "0000000";
    private String bin = "000000000000000000000000000000";
    private String name = "Guilherme";
    private String nameNumber = "";
    private String numHex = "";
    private String num = "";
    private String str = "";
    private String binary = "";
    private long start;
    private long end;
    private Obj obj;

    public ParallelBruteForceSha256(long start, long end, Obj obj) {
        this.start = start;
        this.end = end;
        this.obj = obj;
    }

    @Override
    public void run() {
        for (long i = start; i < end; i++) {
            if (this.obj.getFound()) this.interrupt();
            nameNumber = name + i;
            numHex = sha256(nameNumber).substring(0, 7);
            if (numHex.equals(strHex)) {
                str = sha256(nameNumber);
                num = hexToBin(str).substring(0, 30);
                binary = hexToBin(str);
                if (num.equals(bin)) {
                    markFounded();
                    break;
                }
            }
//            System.out.println(i);
        }
    }

    private synchronized void markFounded() {
        this.obj.setKey(this.nameNumber);
        this.obj.setFound(Boolean.TRUE);
    }

    public String sha256(final String base) {
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

    private String hexToBin(String hex) {
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
}
