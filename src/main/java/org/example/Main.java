package org.example;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class Main {

    private static  RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    private static final BigDecimal TWO= new BigDecimal("2");
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100L);;



   public static void main(String[] args) throws Exception {

       int[] list = {2,4,6,7,5,3,1,3,5,6,7,8,5,3,6,7,5,9};


       for(int i= 0; i< list.length;i++){

           for(int j=0; j< list.length-1;j++){

               if(list[j] < list[j+1] ){
                   int prev  =  list[j];
                   int next  =list[j+1];
                   list[j] = next;
                   list[j+1] =  prev;

               }


           }
       }

       System.out.println(Arrays.toString( list));
   }


   private static void throwEx(){

       try{

           throw new MyException("Tumi", "Jump", "Joke");
       }catch (MyException e){
           System.out.println(e.getDance());
       }
   }

    public static BigDecimal processFeeCalculation(
            BigDecimal transactionAmount,
            long maximumFee,
            long minimumFee,
            double percentage,
            long fee,
            String feeType) {
        BigDecimal transactionFee;
        if ("feeType".equalsIgnoreCase(feeType)) {

            transactionFee = getPercentage(transactionAmount, BigDecimal.valueOf(percentage));
            BigDecimal feeMax = BigDecimal.valueOf(maximumFee);
            BigDecimal feeMin = BigDecimal.valueOf(minimumFee);
            System.out.println(transactionFee.compareTo(feeMax) > 0);
            System.out.println(transactionFee.compareTo(feeMin) < 0);
            if (transactionFee.compareTo(feeMax) > 0) transactionFee = feeMax;
            else if (transactionFee.compareTo(feeMin) < 0) {
                transactionFee = feeMin;
            }
        } else {
            transactionFee = BigDecimal.valueOf(fee);
        }
        return transactionFee;
    }

    public static BigDecimal getPercentage(BigDecimal amount, BigDecimal percentage) {
        BigDecimal result = amount.multiply(percentage);
        result = result.divide(HUNDRED, ROUNDING_MODE);
        return rounded(result);
    }

    private static BigDecimal rounded(BigDecimal number) {
        return number.setScale(2, ROUNDING_MODE);
    }


//    public int heightChecker(int[] heights) {
//
//       List<Integer> listofInteger = Arrays.stream(heights).boxed().toList();
//
//       int[] sortedTwo = Arrays.copyOf(heights, heights.length);
//       Arrays.sort(sortedTwo);
//
//
//
//    }
//
//         String test = "Coding is supa cool the new text following the format shown above";
//         String[] arrayOfString = test.split(" ");
//         List<String> listOfString = new ArrayList<>();
//
//         List<Integer> listOfIndex = new ArrayList<>();
//
//
//
//
//         for(int i=0; i<arrayOfString.length; i++){
//             String  shortest="";
//            int currentIndex = i;
//             for(int j=0; j<arrayOfString.length;j++){
//                  if(shortest.length()< arrayOfString[j].length() && !listOfIndex.contains(j)){
//                      currentIndex = j;
//                      shortest =arrayOfString[j];
//
//                  }
//
//             }
//
//             arrayOfString[currentIndex]="";
//             listOfIndex.add(currentIndex);
//             listOfString.add(shortest);
//
//
//
//         }
//
//
//       System.out.println(listOfIndex);
//       System.out.println(listOfString);



    public static String generateRandomString(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[length];
        secureRandom.nextBytes(randomBytes);

        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes).substring(0, length);
    }
    private static final String tweetAsRawJson = "{" +
            " \"created_at\" : \"{0}\"  " +
            "\"id\" : \"{1}\" " +
            "\"text\" : \"{2}\" " +
            "\"user\" : \"{3}\" " +
            "}";


    public static String toEndOfDay(String date) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec("21239cb3-6db7-42aa-aafa-713ad1252362".getBytes(), "HmacSHA256"));
        mac.update(date.getBytes(StandardCharsets.UTF_8));
        mac.update("2298".getBytes(StandardCharsets.UTF_8));
        mac.update("sid_request".getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(mac.doFinal());
    }
//
//    public static String getAuthData(String version, String pan, String pin, String expiryDate, String cvv2) throws Exception {
//        String authData = "";
//        String authDataCipher = version + "Z" + pan + "Z" + pin + "Z" + expiryDate + "Z" + cvv2;
//        // The Modulus and Public Exponent will be supplied by Interswitch. please ask for one
//        String modulus = "9c7b3ba621a26c4b02f48cfc07ef6ee0aed8e12b4bd11c5cc0abf80d5206be69e1891e60fc88e2d565e2fabe4d0cf630e318a6c721c3ded718d0c530cdf050387ad0a30a336899bbda877d0ec7c7c3ffe693988bfae0ffbab71b25468c7814924f022cb5fda36e0d2c30a7161fa1c6fb5fbd7d05adbef7e68d48f8b6c5f511827c4b1c5ed15b6f20555affc4d0857ef7ab2b5c18ba22bea5d3a79bd1834badb5878d8c7a4b19da20c1f62340b1f7fbf01d2f2e97c9714a9df376ac0ea58072b2b77aeb7872b54a89667519de44d0fc73540beeaec4cb778a45eebfbefe2d817a8a8319b2bc6d9fa714f5289ec7c0dbc43496d71cf2a642cb679b0fc4072fd2cf";
//        String publicExponent = "010001";
//        Security.addProvider(new BouncyCastleProvider());
//        RSAPublicKeySpec publicKeyspec = new RSAPublicKeySpec(new BigInteger(modulus, 16), new BigInteger(publicExponent, 16));
//        KeyFactory factory = KeyFactory.getInstance("RSA"); //, "JHBCI");
//        PublicKey publicKey = factory.generatePublic(publicKeyspec);
//        Cipher encryptCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
//        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
//        byte[] authDataBytes = encryptCipher.doFinal(authDataCipher.getBytes("UTF8"));
//        authData = Base64.getEncoder().encodeToString(authDataBytes).replaceAll("\\r|\\n", "");
//        return authData;
//    }



    public static String toCamelCase(String text) {

        text = text.toLowerCase();

        StringBuilder builder = new StringBuilder(text);

        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '_') {
                builder.deleteCharAt(i);
                System.out.println("her   " +builder);
                builder.replace(
                        i, i + 1,
                        String.valueOf(
                                Character.toUpperCase(
                                        builder.charAt(i))));
            }
        }

        return builder.toString();
    }


}