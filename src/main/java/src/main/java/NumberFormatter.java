package src.main.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import org.apache.commons.collections4.MapUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Map;
import java.util.Objects;

public class NumberFormatter {
    static String report = "{\"displayName\":null,\"baseField\":{\"fieldType\":\"FIELD\",\"fieldName\":\"BillingDay\",\"dbName\":\"billing_day\",\"fieldAlias\":\"Billing_Day\",\"fieldLabel\":\"Billing Day\",\"objectName\":\"Account\",\"objectDbName\":\"account\",\"decimalPlaces\":0,\"groupBy\":false,\"rowGroup\":false,\"encrypted\":false,\"roundOffTo\":0,\"dataType\":\"NUMBER\",\"fieldType\":\"FIELD\",\"additionalProperties\":{\"updatable\":true,\"aggregatable\":false,\"groupable\":true,\"sortable\":false},\"monthOffset\":0},\"showNumbersIn\":null,\"pivoted\":false,\"renderPicklistColors\":false,\"dataFormat\":null,\"multiplier\":0,\"thousandSeparator\":\"\\u0000\",\"decimalSeparator\":\"\\u0000\",\"columnCalculationsConfig\":[],\"gridOptions\":{\"columnWidth\":0,\"options\":null}}";
    static String record = "{\"createdBy\":\"8cae644e-3ae4-11ec-ab3c-f3c66ca6cff6\",\"modifiedBy\":\"9e66da0c-44b0-4ba1-8964-3a568d2452ad\",\"createdDate\":\"2022-05-02T09:37:47.107502\",\"modifiedDate\":\"2023-10-26T14:39:38.498\",\"version\":0,\"id\":\"035dcc9d-4f8a-40b1-bfe4-e392de05cec6\",\"name\":\"Unified\",\"type\":\"TEST\",\"description\":\"Testing 12345\",\"subDomain\":\"unified\",\"status\":\"ACTIVE\",\"timezone\":\"America/Indiana/Marengo\",\"dateFormat\":\"MM/dd/yyyy\",\"dateTimeFormat\":\"MM/dd/yyyy hh:mm a\",\"currencySettings\":{\"roundOffTo\":2,\"globalCurrencyCode\":\"INR\"},\"enabledComponents\":[\"pricing-studio\",\"administration\",\"billing-analytics\",\"billing-center\",\"intelligence-hub\",\"deal-studio\"],\"hierarchyTypes\":[{\"type\":\"Platform Provider\",\"level\":1},{\"type\":\"Network Provider\",\"level\":2},{\"type\":\"App Provider\",\"level\":3}]}";
    static String r = "{\"Billing_Day\":1}";
     public static void main(String[] args) throws JsonProcessingException, ParseException {
       var valueDTO=formatValue();
       System.out.println(valueDTO);
    }


    public static ValueDTO formatValue() throws JsonProcessingException, ParseException {
        ObjectMapper ob = new ObjectMapper();
        Map<String, Object> map = ob.readValue(record,Map.class);
        Map<String, Object> reportField =  ob.readValue(report,Map.class);
        Map<String, Object> recordMap =  ob.readValue(r,Map.class);
        Object value = "1234k";
        if (Objects.isNull(value)) {
            return new ValueDTO();
        }

        // TODO : Do we have a reportContext to avoid this call for every cell
        String tenantNumberFormat = MapUtils.getString(map, "numberFormat", null);
        String defaultNumberFormat = "#,###.00";
        DecimalFormat df = new DecimalFormat("#");
        int numberOfDecimalPlaces = 2;;
        ValueDTO vd = new ValueDTO();
        if (StringUtils.isBlank(tenantNumberFormat)) {
            df.setMaximumFractionDigits(numberOfDecimalPlaces);
            df.applyPattern(defaultNumberFormat);
            BigDecimal fv = BigDecimal.valueOf(df.parse(df.format(value)).doubleValue())
                    .setScale(numberOfDecimalPlaces, 3);
            vd.setFv(fv);
            vd.setV(fv.toString());
            vd.setK(value);
        }else {
            Object formattedValue;
            if (map.get("numberFormat") != null) {
                df = new DecimalFormat(MapUtils.getString(map, "numberFormat", "#.00"));
                formattedValue = Double.parseDouble(df.format(value));
            } else {
                formattedValue = value;
            }
            vd.setFv(convertDecimalToInt(((Number) formattedValue).doubleValue()).toString());
            vd.setV(formattedValue.toString());
            vd.setK(value);
        }
        return vd;
    }
    private static Object convertDecimalToInt(double decimalNum) {
        if (decimalNum % 1 == 0) {
            return (int) decimalNum;
        } else if (decimalNum % 1 == 0.0) {
            return (int) decimalNum;
        }
        return decimalNum;
    }
}


class ValueDTO {

    //Formatted value
    private Object fv;
    //Raw value
    private Object k;
    //Resolved value
    private String v;
    //suffix
    private String s;
    //prefix
    private String p;

    private String color;


    public void setFv(Object fv) {
        this.fv=fv;
    }

    public void setV(String string) {
        this.v = string;
    }

    public void setK(Object value) {
        this.k = value;
    }

    public Object getFv() {
        return this.fv;
    }

    public String getV() {
        return this.v;
    }

    public Object getK() {
        return this.k;
    }
}



