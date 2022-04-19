import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("[Console Mode Test]");
        StringSetup str = StringSetup.getInstance();
        boolean generated = str.Interface();
        if(generated){
            System.out.println("[+]Generated Successfully");
        }else{
            System.out.println("[!]Error Generating QR Code");
        }
        Thread.sleep(2000);
    }
}
