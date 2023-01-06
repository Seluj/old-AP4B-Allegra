import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {
    //generate the verification code
    public static String getCode() {
        //Create an Arraylist
        ArrayList<Character> list = new ArrayList<>();
        //add letters a-z A-Z
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));//a - z
            list.add((char) ('A' + i));//A - Z
        }

        //get four random character
        String result = "";
        Random r = new Random();
        for (int i = 0; i < 4; i++) {

            int randomIndex = r.nextInt(list.size());
            char c = list.get(randomIndex);
            result = result + c;
        }

        //add number to it  0~9
        int number = r.nextInt(10);
        //add the number after the result
        result = result + number;
        //System.out.println(result);

        char[] chars = result.toCharArray();//

        int index = r.nextInt(chars.length);
        //random the character and the number
        char temp = chars[4];
        chars[4] = chars[index];
        chars[index] = temp;
        //change character into string
        String code = new String(chars);

        return code;};
}