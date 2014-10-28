import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Pouya on 10/19/2014.
 */
public class ForwardSearchAttackEightCharPassword {

    //brute forcin' it.
//    private static List<Character> characterList = new ArrayList<Character>();
    private static List<Character> characterList = new LinkedList<Character>(Arrays.asList('q','w','n','i','+','5','8','0'));
    private static String[] args;
    int k = 3;
    private Map<String, String> shaKeyValues = new HashMap<String, String>();

    public static void main (String[] args) throws IOException, NoSuchAlgorithmException {
        System.out.println("Start time: " + new SimpleDateFormat("dd_HHmmss").format(Calendar.getInstance().getTime()));

//        filterAllPasswordFiles();
        findAllHashes();
        System.out.println("Finish time: " + new SimpleDateFormat("dd_HHmmss").format(Calendar.getInstance().getTime()));


    }

//    public void doLoop() {
//        for (int i = 0; i < 16; i++) {
//            for (int j = 0; j < (k ^ 16) ; j++) {}
//        }
//    }
//
//    public void test(int size) throws NoSuchAlgorithmException {
//        if (size == 1) {
//            for (int i = 0; i < 16; i++) {
//                String built_number = String.valueOf(characterList.get(i));
//                String shaValue = HashTextTest.sha1(built_number);
//                shaKeyValues.put(built_number, shaValue);
//            }
//        }
//        else {
//            for (int i = 0; i < 16; i++) {
//                test(size - 1);
//            }
//        }
//    }


    public static void filterAllPasswordFiles() throws IOException {
        File folder = new File("C:\\Users\\Pouya\\CS265\\input\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                getOnlyUsefulPasswords(folder.toString() +"\\", listOfFiles[i].getName(), i);

            }
        }
    }

    public static void getOnlyUsefulPasswords(String filePath, String fileName, int fileLable ) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filePath + fileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output/" + fileName.substring(0, fileName.length() - 4) + "_filtered.txt")));
        String line = null;
        int totalPasswordCounter = 0;
        int h = 0;

        while (( line = reader.readLine())!= null) {

            totalPasswordCounter++;

            if ( !(line.contains("w") && line.contains("W"))  ) {
                if ( !(line.contains("q") && line.contains("Q"))  ) {
                    if ( !(line.contains("n") && line.contains("N"))  ) {
                        if ( !(line.contains("i") && line.contains("I"))  ) {
                            if ( !(line.contains("5") && line.contains("%"))  ) {
                                if ( !(line.contains("8") && line.contains("("))  ) {
                                    if ( !(line.contains("*") && line.contains("+"))  ) {
                                        if ( !(line.contains("0") && line.contains("="))  ) {
                                            h++;

                                            writer.write(line);
                                            writer.newLine();

//                                            if (h>1000) {

//                                                break;
//                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("file number: " + fileLable);

        System.out.println("Total passwords tried was: " + totalPasswordCounter);
        System.out.println("Total passwords used was: " + h);
        System.out.println("-----------------------------");

        writer.close();

    }

    public static void copyAllPasswordsInOneFile () throws IOException {

        File folder = new File("output");
        File[] listOfFiles = folder.listFiles();
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output/all8chars/all8chars.txt")));
        String line = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                BufferedReader reader = new BufferedReader(new FileReader(listOfFiles[i]));
                while ( (line = reader.readLine()) != null ) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
        writer.close();
    }

    public static void findAllHashes () throws IOException, NoSuchAlgorithmException {

        String desiredHash = "67ae1a64661ac8b4494666f58c4822408dd0a3e4";
        File file = new File("output/all8chars/all8chars.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        String hashResult = null;

        while ((line = reader.readLine()) != null) {

            hashResult = HashTextTest.sha1(line);
            if (hashResult.equalsIgnoreCase(desiredHash)) {
                System.out.println("found it: " + line);
                break;

            }
        }
        System.out.println("didn't find shit.");

    }
}
