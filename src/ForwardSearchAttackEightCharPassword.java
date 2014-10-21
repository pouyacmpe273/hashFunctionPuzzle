import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by Pouya on 10/19/2014.
 */
public class ForwardSearchAttackEightCharPassword {

    //brute forcin' it.
//    private static List<Character> characterList = new ArrayList<Character>();
    private static List<Character> characterList = new LinkedList<Character>(Arrays.asList('q','w','n','i','+','5','8','0'));
    int k = 3;
    private Map<String, String> shaKeyValues = new HashMap<String, String>();

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
