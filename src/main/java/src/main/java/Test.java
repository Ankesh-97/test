package src.main.java;

import java.math.BigDecimal;
import java.text.*;
import java.util.Locale;

public class Test {
    public static void main(String[] args) throws ParseException {
        BigDecimal number = new BigDecimal(10000);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();

        decimalFormatSymbols.setGroupingSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("#,###",decimalFormatSymbols);
        decimalFormat.setParseBigDecimal(true);
        //decimalFormat.setMaximumFractionDigits(2);
        String formattedResult = decimalFormat.format(0000000);

        System.out.println("Formatted Number: "+formattedResult);
    }
}


