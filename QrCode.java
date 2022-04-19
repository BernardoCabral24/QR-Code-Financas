import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QrCode {

    private String file_path = null;
    private String str = null;
    private int width = -1;
    private int height = -1;

    public void setup(String path, String str, int width, int height) {
        this.file_path = path;
        this.str = str;
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getPath() {
        return file_path;
    }

    public String getStr() {
        return str;
    }

    public boolean createQr() {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            Path path = FileSystems.getDefault().getPath(file_path);
            BitMatrix bitMatrix = qrCodeWriter.encode(str, BarcodeFormat.QR_CODE, width, height);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
