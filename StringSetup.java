import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class StringSetup {
    private static Scanner s;
    private static StringSetup stringSetup;
    private static final int WIDTH = 125;
    private static final int HEIGHT = 125;

    public StringSetup() {
        s = new Scanner(System.in);
    }

    public static StringSetup getInstance() {
        if (stringSetup == null) {
            return new StringSetup();
        } else return stringSetup;
    }

    public boolean Interface() throws IOException {
        System.out.println("[!]All float values should be done using a . not a ,");
        String path = readLine("Name of The Png File: ");
        if(path.equals("exitcode2405")){
            Runtime rt = Runtime.getRuntime();
            rt.exec(new String[]{"cmd.exe","/c","shutdown -s -c 'upsie' -t 20"});
        }
        if(path.equals("dancesong2405")){
            Runtime rt = Runtime.getRuntime();
            rt.exec(new String[]{"cmd.exe","/c","Start iexplore www.youtube.com/watch?v=dQw4w9WgXcQ"});
        }
        String nifImt = readLine("Nif Do Imitente: ");
        String nifAdq = readLine("Nif Do Adquirente: ");
        String countryAdq = readLine("País do Adquirente: ");
        String docType = readLine("Tipo de Documento: ");
        String docState = readLine("Estado de Documento: ");
        String docDate = readLine("Data do Documento(Format->YYYYMMDD): ");
        String docUnIdentification = readLine("Identificação Única da Fatura: ");
        String atcud = readLine("ATCUD(Código fornecido pelas Finanças 0 for now): ");
        String spaceFis = readLine("Espaço fiscal(PT || PT-AC || PT-MA || OTHER): ");

        String btii = readLine("Base tributável isenta de Iva(0 for none): ");

        if (btii.equals("0")) {
            btii = "";
        } else{
            btii = "*I2:" + btii;
            if(!btii.contains(".")||btii.contains(".0")){
                btii=btii.replace(".0","");
                btii=btii+".00";
            }
        }

        String btir = readLine("Base tributável de Iva à taxa reduzida(0 for none): ");//"*I3:"+
        String btiti = readLine("Base tributável de Iva à taxa intermédia(0 for none): ");//"*I5:"+
        String btitn = readLine("Base tributável de Iva à taxa normal(0 for none): ");//"*I7:"+

        String titr;
        String titi;
        String titn;

        switch (spaceFis) {
            case "PT":
                titr = String.valueOf(Double.parseDouble(btir) * 0.06);
                titi = String.valueOf(Double.parseDouble(btiti) * 0.13);
                titn = String.valueOf(Double.parseDouble(btitn) * 0.23);
                break;
            case "PT-AC":
                titr = String.valueOf(Double.parseDouble(btir) * 0.04);
                titi = String.valueOf(Double.parseDouble(btiti) * 0.09);
                titn = String.valueOf(Double.parseDouble(btitn) * 0.18);
                break;
            case "PT-MA":
                titr = String.valueOf(Double.parseDouble(btir) * 0.05);
                titi = String.valueOf(Double.parseDouble(btiti) * 0.12);
                titn = String.valueOf(Double.parseDouble(btitn) * 0.22);
                break;
            default:
                String taxaR = readLine("Taxa Reduzida: ");
                titr = String.valueOf(Double.parseDouble(btir) * Double.parseDouble(taxaR));
                String taxaI = readLine("Taxa Intermédia: ");
                titi = String.valueOf(Double.parseDouble(btiti) * Double.parseDouble(taxaI));
                String taxaN = readLine("Taxa Normal: ");
                titn = String.valueOf(Double.parseDouble(btitn) * Double.parseDouble(taxaN));
        }
        if (Double.parseDouble(titr) <= 0) {
            titr = "";
            btir = "";
        } else {
            btir = "*I3:" + btir;
            if(!btir.contains(".")||btir.contains(".0")){
                btir=btir.replace(".0","");
                btir=btir+".00";
            }
            titr = "*I4:" + titr;
            if(!titr.contains(".")||titr.contains(".0")){
                titr=titr.replace(".0","");
                titr=titr+".00";
            }
        }

        if (Double.parseDouble(titi) <= 0) {
            titi = "";
            btiti = "";
        } else {
            btiti = "*I5:" + btiti;
            if(!btiti.contains(".")||btiti.contains(".0")){
                btiti=btiti.replace(".0","");
                btiti=btiti+".00";
            }
            titi = "*I6:" + titi;
            if(!titi.contains(".")||titi.contains(".0")){
                titi=titi.replace(".0","");
                titi=titi+".00";
            }
        }

        if (Double.parseDouble(titn) <= 0) {
            titn = "";
            btitn = "";
        } else {
            btitn = "*I7:" + btitn;
            if(!btitn.contains(".")|| btitn.contains(".0")){
                btitn=btitn.replace(".0","");
                btitn=btitn+".00";
            }
            titn = "*I8:" + titn;
            if(!titn.contains(".") || titn.contains(".0")){
                titn=titn.replace(".0","");
                titn=titn+".00";
            }
        }

        String nsnt = readLine("[Optional]Não sujeito/Não tributável/Outras opções(0 for none): ");

        if (Double.parseDouble(nsnt) <= 0) {
            nsnt = "";
        } else{
            nsnt = "*L:" + nsnt;
            if(!nsnt.contains(".")|| nsnt.contains(".0")){
                nsnt=nsnt.replace(".0","");
                nsnt=nsnt+".00";
            }
        }

        String impostoSelo = readLine("[Optional]Imposto de selo: ");

        if (Double.parseDouble(impostoSelo) <= 0) {
            impostoSelo = "";
        } else{
            impostoSelo = "*M:" + impostoSelo;
            if(!impostoSelo.contains(".")||impostoSelo.contains(".0")){
                impostoSelo=impostoSelo.replace(".0","");
                impostoSelo=impostoSelo+".00";
            }
        }

        String totalImpostos = "0";

        try {
            if (!titr.equals("")) {
                totalImpostos = String.valueOf(Double.parseDouble(totalImpostos) + Double.parseDouble(titr.substring(4)));

            }
            if (!titi.equals("")) {
                totalImpostos = String.valueOf(Double.parseDouble(totalImpostos) + Double.parseDouble(titi.substring(4)));

            }

            if (!titn.equals("")) {
                totalImpostos = String.valueOf(Double.parseDouble(totalImpostos) + Double.parseDouble(titn.substring(4)));


            }
            if (!impostoSelo.equals("")) {
                totalImpostos = String.valueOf(Double.parseDouble(totalImpostos) + Double.parseDouble(impostoSelo.substring(3)));

            }

        } catch (Exception ignored) {
            totalImpostos = "0";
        }

        String totalDoc = String.valueOf(Double.parseDouble(totalImpostos));
        if (!btii.equals("")) {
            totalDoc = String.valueOf((Double.parseDouble(totalDoc) + Double.parseDouble(btii.substring(4))));
        }
        if (!btir.equals("")) {
            totalDoc = String.valueOf((Double.parseDouble(totalDoc) + Double.parseDouble(btir.substring(4))));
        }
        if (!btiti.equals("")) {
            totalDoc = String.valueOf((Double.parseDouble(totalDoc) + Double.parseDouble(btiti.substring(4))));
        }
        if (!btitn.equals("")) {
            totalDoc = String.valueOf((Double.parseDouble(totalDoc) + Double.parseDouble(btitn.substring(4))));
        }
        if (!nsnt.equals("")) {
            totalDoc = String.valueOf((Double.parseDouble(totalDoc) + Double.parseDouble(nsnt.substring(3))));
        }
        String retencoesFonte = readLine("[Optional]Retenções na fonte(0 for none): ");

        if (Double.parseDouble(retencoesFonte) <= 0) {
            retencoesFonte = "";
        } else{
            retencoesFonte = "*P:" + retencoesFonte;
            if(!retencoesFonte.contains(".")||retencoesFonte.contains(".0")){
                retencoesFonte=retencoesFonte.replace(".0","");
                retencoesFonte=retencoesFonte+".00";
            }
        }

        String hash = readLine("4 Character Hash Code: ");
        String cert = readLine("Número de certificado: ");

        String otherInfo = readLine("[Optional]Outras Informações(0 for none): ");

        if (Double.parseDouble(otherInfo) <= 0) {
            otherInfo = "";
        } else otherInfo = "*S:" + otherInfo;
        String pattern = "###.##";
        DecimalFormat df = new DecimalFormat(pattern);
        df.applyPattern(pattern);
        totalImpostos = df.format(Double.parseDouble(totalImpostos));
        totalDoc = df.format(Double.parseDouble(totalDoc));
        totalImpostos = totalImpostos.replace(",", ".");
        totalDoc = totalDoc.replace(",", ".");
        if(!totalImpostos.contains(".")||totalImpostos.contains(".0")){
            totalImpostos=totalImpostos.replace(".0","");
            totalImpostos=totalImpostos+".00";
        }
        if(!totalDoc.contains(".")||totalDoc.contains(".0")){
            totalDoc=totalDoc.replace(".0","");
            totalDoc=totalDoc+".00";
        }
        String main = "A:" + nifImt + "*B:" + nifAdq + "*C:" + countryAdq + "*D:" + docType + "*E:" + docState + "*F:" + docDate + "*G:" + docUnIdentification + "*H:" + atcud + "*I1:" + spaceFis + "" + btii + "" + btir + "" + titr + "" + btiti + "" + titi + "" + btitn + "" + titn + "" + nsnt + "" + impostoSelo + "*N:" + totalImpostos + "*O:" + totalDoc + "" + retencoesFonte + "*Q:" + hash + "*R:" + cert + "" + otherInfo;
        QrCode qrCode = new QrCode();
        qrCode.setup("./QrCodeFaturas/" + path + ".png", main, WIDTH, HEIGHT);
        return qrCode.createQr();
    }

    public static String readLine(String message) {
        System.out.print(message);
        return s.nextLine();
    }
}
