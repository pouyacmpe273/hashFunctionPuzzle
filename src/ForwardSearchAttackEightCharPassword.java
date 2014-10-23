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
        makePass("",8);
    }


    private static List<String> characterList = new LinkedList<String>(Arrays.asList("q","w","n","i","+","5","8","0"));
    int k = 3;
    static int d = 0;
    private Map<String, String> shaKeyValues = new HashMap<String, String>();

    public static void makePass(String partialString, int iterator) throws IOException {
        if(iterator == 0) {
            writeToFile(partialString);
        }
        else {
            for (int i =0; i < 8; i++) {
                if (d == 2000) {
                    break;
                }
                partialString +=characterList.get(i);

                makePass( partialString, iterator-1 );
                d++;
            }
        }
    }

    public static void writeToFile(String textToFile) throws IOException {


        File file = new File("data/testoutput.txt");
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write(textToFile);
        writer.newLine();
        System.out.println(d);
        writer.close();
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
