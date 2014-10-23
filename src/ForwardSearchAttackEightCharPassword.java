import java.io.*;
import java.lang.String;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by Pouya on 10/19/2014.
 */
public class ForwardSearchAttackEightCharPassword{

    //brute forcin' it.
//    private static List<Character> characterList = new ArrayList<Character>(Arrays.asList("q","w","n","i","+","5","8","0"));



    public static void main (String[] args) throws IOException {
        String whatisit = makePass();
    }


    private static List<String> characterList = new LinkedList<String>(Arrays.asList("q","w","n","i","+","5","8","0"));
    int k = 3;
    static int counter = 0;
    private Map<String, String> shaKeyValues = new HashMap<String, String>();
    static String partialString = "";

    public static String makePass() throws IOException {
        if (counter == 3) {
            writeToFile();

        }
        else {
            counter++;
            for (int i = 0; i < 3; i++) {
                partialString = partialString + makePass();
            }
        }
        return partialString;
    }

    public static void makePass2() throws IOException {
        if(counter == 3) {
            writeToFile();
        }
        else {
            for (int i = 0; i < 3; i++) {
                partialString += characterList.get(i);
                counter++;
                makePass2();

            }
        }
    }

    public static void writeToFile() throws IOException {


        File file = new File("data/testoutput.txt");
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write(partialString);
        writer.newLine();
        writer.close();
        counter = 0;
        partialString = "";

    }

    public void doLoop() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < (k ^ 16) ; j++) {}
        }
    }

    public void test(int size) throws NoSuchAlgorithmException {
        if (size == 1) {
            for (int i = 0; i < 16; i++) {
                String built_number = String.valueOf(characterList.get(i));
                String shaValue = HashTextTest.sha1(built_number);
                shaKeyValues.put(built_number, shaValue);
            }
        }
        else {
            for (int i = 0; i < 16; i++) {
                test(size - 1);
            }
        }
    }

}
