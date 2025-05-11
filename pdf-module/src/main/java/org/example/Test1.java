package org.example;

import java.time.*;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        //Thu Feb 27 09:55:41 UTC 2025
//        1740650141000
//        1740650141000
        LocalDateTime localDateTime = LocalDateTime.of(2025,2,27, 9,55,41,0);
        long timestamp=localDateTime.toInstant(getZoneOffset("UTC")).toEpochMilli();
        System.out.println("Timestamp: "+timestamp);
        ZonedDateTime utcDateTime1 = Instant.ofEpochMilli(1740742560000L).atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println("UTC Date Time: "+utcDateTime1);
    }

    public static ZoneOffset getZoneOffset(String timeZone) {
        return ZoneId.of(timeZone).getRules().getOffset(
                Instant.now());
    }
}
