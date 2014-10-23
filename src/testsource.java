import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TestSource {

    public void justTestingFileReading() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("data/test2.tsv"));
        String line = null;
        while ((line = reader.readLine()) != null) {
            line = reader.readLine();


        }


    }
}