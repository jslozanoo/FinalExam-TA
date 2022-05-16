package com.automation.web.data;

import org.testng.annotations.DataProvider;

import java.util.Random;

public class Data {

    @DataProvider(name = "user")
    public Object[][] inputData(){
        User user = new User("Juan", "Lozano",
                generateRandomEmail(), generateRandomString());
        return new Object[][]{{user}};
    }

    /**
     * Generate random string with a number at the end
     * @return String
     */
    private String generateRandomString(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        int lengthOfString = 6;

        for(int i = 0; i < lengthOfString; i++){
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            randomString.append(randomChar);
        }
        int randomNumber = random.nextInt(10);
        randomString.append(randomNumber);

        return randomString.toString();
    }

    /**
     * Generate random email
     * @return String
     */
    private String generateRandomEmail(){
        return generateRandomString() + "@gmail.com";
    }
}
