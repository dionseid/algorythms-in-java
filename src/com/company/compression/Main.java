package com.company.compression;

public class Main {
    public static String compressedString(String message) {
        String compressedMessage = "";

        if (message.length() <= 100000) {
            message = message.toLowerCase();

            int counter = 1;
            String stringCounter;
            for (int i = 0; i < message.length() ; i++) {
//                System.out.println(i);
                if (i < message.length() - 1 && message.charAt(i) == message.charAt(i + 1)) {
                    counter++;
                } else {
                    if (counter > 1)
                        stringCounter = Integer.toString(counter);
                    else
                        stringCounter = "";
                    compressedMessage = compressedMessage.concat(message.substring(i, i + 1)).concat(stringCounter);
                    counter = 1;
                }
            }
//            for (int i = 1; i < message.length(); i++) {
//                if (message.charAt(i - 1) == message.charAt(i)) {
//                    counter++;
//                } else {
//                    if (counter > 1)
//                        stringCounter = Integer.toString(counter);
//                    else
//                        stringCounter = "";
//                    compressedMessage = compressedMessage.concat(message.substring(i - 1, i)).concat(stringCounter);
//                    counter = 1;
//                }
//            }

//            if (message.charAt(message.length() - 1) == message.charAt(message.length() - 2))
//                compressedMessage = compressedMessage.concat(message.substring(message.length() - 1)).concat(Integer.toString(counter));
        }

        return compressedMessage;
    }

    public static void main(String[] args) {
        System.out.println(compressedString("abaaasass")); // aba3sas2
        System.out.println(compressedString("abaaasasss")); // aba3sas3
        System.out.println(compressedString("abc")); // abc
        System.out.println(compressedString("abaabbbc")); // aba2b3c
    }
}
