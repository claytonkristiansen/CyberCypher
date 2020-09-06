package com.example.cybercypher;

import java.util.ArrayList;
import java.util.Scanner;

class CyberCypher {


    private static boolean KeyCheck(String keyString)
    {
        char[] key = keyString.toCharArray();
        for(char c : key)
        {
            if(!((c > 47 && c < 58) || (c > 96 && c < 123)))
            {
                return false;
            }
        }
        if(key.length < 8 || key.length > 64 || key.length % 2 != 0)
        {
            return false;
        }
        return true;
    }

    //Takes full string as parameter, converts each character to binary equivalent, then inverts the binary
    private static String InvertBinary(String inputString)
    {
        char[] s = inputString.toCharArray();
        char[] outputString = new char[inputString.length()];
        for(int i = 0; i < s.length; i++)
        {
            char[] binaryString = CharToBinary(s[i]).toCharArray();
            for(int k = 0; k < binaryString.length; k++)
            {
                if(binaryString[k] == '0')
                {
                    binaryString[k] = '1';
                }
                else
                {
                    binaryString[k] = '0';
                }
            }
            outputString[i] = BinaryToChar(new String(binaryString));
        }
        return new String(outputString);
    }

    private static String CharToBinary(char c)
    {
        return String.format("%11s", Integer.toBinaryString(c)).replace(' ', '0');
    }

    private static char BinaryToChar(String binaryString)
    {
        char c = (char)(Integer.parseInt(binaryString, 2));
        return c;
    }

    private static String StringRotateRight(String inputString, int amount)
    {
        int len = inputString.length();
        char[] s = inputString.toCharArray();
        char[] sOutput = new char[len];
        for(int i = 0; i < len; i++)
        {
            int replaceDex = (i + amount) % len; //Wraps index back around
            sOutput[replaceDex] = s[i];
        }
        return new String(sOutput);
    }

    private static String StringRotateLeft(String inputString, int amount)
    {
        int len = inputString.length();
        char[] s = inputString.toCharArray();
        char[] sOutput = new char[len];
        for(int i = 0; i < len; i++)
        {
            int replaceDex = (i + len - (amount % len)) % len; //Wraps index back around
            sOutput[replaceDex] = s[i];
        }
        return new String(sOutput);
    }

    private static String IndividualBinaryRotateRight(String inputString, int amount)
    {
        int len = inputString.length();
        char[] arr = inputString.toCharArray();
        for(int i = 0; i < len; i++)
        {
            arr[i] = BinaryToChar(StringRotateRight(CharToBinary(arr[i]), amount));
        }
        return new String(arr);
    }

    private static String IndividualBinaryRotateLeft(String inputString, int amount)
    {
        int len = inputString.length();
        char[] arr = inputString.toCharArray();
        for(int i = 0; i < len; i++)
        {
            arr[i] = BinaryToChar(StringRotateLeft(CharToBinary(arr[i]), amount));
        }
        return new String(arr);
    }

    private static String ASCIIShiftRight(String inputString, int amount)
    {
        int len = inputString.length();
        char[] arr = inputString.toCharArray();
        for(int i = 0; i < len; i++)
        {
            arr[i] = (char)(arr[i] + amount);
        }
        return new String(arr);
    }

    private static String ASCIIShiftLeft(String inputString, int amount)
    {
        int len = inputString.length();
        char[] arr = inputString.toCharArray();
        for(int i = 0; i < len; i++)
        {
            arr[i] = (char)(arr[i] - amount);
        }
        return new String(arr);
    }

    public static String EncryptClayton(String input, String keyString) 
    {
        if(!KeyCheck(keyString))
        {
            throw new IllegalArgumentException("Key was not formatted correctly");
        }
        int inputLen = input.length();
        int keyLen = keyString.length();
        //String encryptedString = input;
        char[] key = keyString.toCharArray();

        for(int k = 0; k < keyLen; k += 2)
        {
            if((key[k] >= 48 && key[k] <= 53) || (key[k] >= 97 && key[k] <= 100))
            {
                if(key[k] >= 48 && key[k] <= 53)
                {
                    input = StringRotateRight(input, (int)key[k + 1]);
                }
                else
                {
                    input = StringRotateLeft(input, (int)key[k + 1]);
                }
            }
            if((key[k] >= 54 && key[k] <= 57) || (key[k] >= 101 && key[k] <= 105))
            {
                if(key[k] >= 54 && key[k] <= 57)
                {
                    input = IndividualBinaryRotateLeft(input, (int)key[k + 1]);
                }
                else
                {
                    input = IndividualBinaryRotateRight(input, (int)key[k + 1]);
                }
            }
            if((key[k] >= 106 && key[k] <= 113))
            {
                if(key[k] >= 106 && key[k] <= 109)
                {
                    input = ASCIIShiftRight(input, (int)key[k + 1]);
                }
                else
                {
                    input = ASCIIShiftLeft(input, (int)key[k + 1]);
                }
            }
            if((key[k] >= 114 && key[k] <= 122))
            {
                input = InvertBinary(input);
            }
        }
        
        //System.out.println(input);

        return input;
    }

    public static String DecryptClayton(String input, String keyString) 
    {
        if(!KeyCheck(keyString))
        {
            throw new IllegalArgumentException("Key was not formatted correctly");
        }
        int inputLen = input.length();
        int keyLen = keyString.length();
        //String encryptedString = input;
        char[] key = keyString.toCharArray();

        for(int k = keyLen - 2; k >= 0; k -= 2)
        {
            if((key[k] >= 48 && key[k] <= 53) || (key[k] >= 97 && key[k] <= 100))
            {
                if(key[k] >= 48 && key[k] <= 53)
                {
                    input = StringRotateLeft(input, (int)key[k + 1]);
                }
                else
                {
                    input = StringRotateRight(input, (int)key[k + 1]);
                }
            }
            if((key[k] >= 54 && key[k] <= 57) || (key[k] >= 101 && key[k] <= 105))
            {
                if(key[k] >= 54 && key[k] <= 57)
                {
                    input = IndividualBinaryRotateRight(input, (int)key[k + 1]);
                }
                else
                {
                    input = IndividualBinaryRotateLeft(input, (int)key[k + 1]);
                }
            }
            if((key[k] >= 106 && key[k] <= 113))
            {
                if(key[k] >= 106 && key[k] <= 109)
                {
                    input = ASCIIShiftLeft(input, (int)key[k + 1]);
                }
                else
                {
                    input = ASCIIShiftRight(input, (int)key[k + 1]);
                }
            }
            if((key[k] >= 114 && key[k] <= 122))
            {
                input = InvertBinary(input);
            }
        }
        
        //System.out.println(input);

        return input;
    }

    public static char[] getInput() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your string: ");
        String str = sc.nextLine();

        char[] arr = str.toCharArray();

        return arr;

    }

    public static String encryptNishi() {

        String inputTest = "hello world";

        ArrayList<Character> alpha = new ArrayList<Character>(); // stores the regular alphabet

        for (int i = 0; i < 26; i++) {
            alpha.add((char) (97 + i));
        }
        alpha.add(' ');

        int num_letters_off = 3;

        ArrayList<Character> coupleLettersOff = new ArrayList<Character>();
        // makes the letters 3 letters off
        for (int i = num_letters_off; i > 0; i--) {
            coupleLettersOff.add((char) (97 + 26 - i)); // adds the backend of letters
        }
        for (int i = 0; i < 26 - num_letters_off; i++) {
            coupleLettersOff.add((char) (97 + i)); // adds the rest minus however much the shift is
        }
        coupleLettersOff.add(' ');

        char[] inputArr = inputTest.toCharArray();
        char curr;

        ArrayList<Character> newOutput = new ArrayList<Character>();

        for (int i = 0; i < inputArr.length; i++) { // goes through the input char by char

            curr = inputArr[i];
            int myIndex = alpha.indexOf(curr);
            newOutput.add(coupleLettersOff.get(myIndex));
        }

        System.out.println(newOutput);

        char ran = 't'; // to see which letters map out to what
        int ind = alpha.indexOf(ran);

        System.out.print(coupleLettersOff.get(ind));

        return "";

    }

}