package util;

import javax.swing.text.MaskFormatter;
import java.text.*;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Tools {

    static NumberFormat nf = new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static String telefoneFormatar(String value, String pattern) {
        MaskFormatter mf;
        try {
            mf = new MaskFormatter(pattern);
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(value);
        } catch (ParseException ex) {
            return value;
        }
    }

    public static void pausar(int segundos){
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            System.err.println("Erro so pausar "+segundos+" segundos.");
        }
    }

    public static String precoFormata(float preco){
        return Tools.nf.format(preco);
    }

}
