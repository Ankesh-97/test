package org.example;

public class StringExtract {
    public static void main(String[] args) {
        String str = "AddressList";
        str = str.toUpperCase();
        int index = str.indexOf("LIST");
        if (index != -1) {
            System.out.println(str.substring(0, index));
        } else {
            System.out.println("No match found");
        }
    }
}
