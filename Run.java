public class Run implements Runnable{

    private final int count;
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

        int count = 0;

    public CalculaPrimos2(int count) {
        this.count = count;
    }

  //tarefa a realizar: procurar numeros primos no intervalo recebido
  @Override
  public void run() {
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
                if(num.equals(bin)) {
                    break;
                }
            }
            // System.out.println(count);
            count++;
        }

        System.out.println(Thread.currentThread().getName() + ": " + gui " terminou!");
  }
}