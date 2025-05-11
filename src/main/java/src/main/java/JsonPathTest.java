package src.main.java;

public class JsonPathTest {
    public static void main(String[] args) {
        String result = castJsonPathResult("dimensionpricelist->'dimensionPriceList'->13->'dimensionId'->0->'dimension'->>'dimensionId'","NUMBER");
        System.out.println(result);
    }

    private static String castJsonPathResult(String selectColumn,String type) {

        StringBuilder sb = new StringBuilder("(cast(").append(selectColumn)
                .append(" AS "+ "VARCHAR").append("))");

        return sb.toString();
    }
}
