import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleReader implements TitleReader{
    private final File source;

    public TsvTitleReader(File source) {
        this.source = source;
    }

    @Override
    public List<Title> read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(source));
        readHeadersWith(reader);
        return readTitlesWith(reader);
    }

    private static List<Title> readTitlesWith(BufferedReader reader) throws IOException {
        List<Title> titles = new ArrayList<>();
        while (true){
            String l = reader.readLine();
            if (l == null) break;
            String[] columns = l.split("\t");
            titles.add(new Title(columns[0], Title.TitleType.valueOf(columns[0].toUpperCase()), columns[1]));
        }
        return titles;
    }

    private static void readHeadersWith(BufferedReader reader) throws IOException {
        reader.readLine();
    }
}