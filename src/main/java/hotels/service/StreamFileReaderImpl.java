package hotels.service;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFileReaderImpl implements HotelFileReader {
    @Override
    public List<String> readFile(String sourcePath) {
        URL resource = getClass().getResource(sourcePath);

        if (resource != null) {
            try (Stream<String> stream = Files.lines(Paths.get(resource.getPath()))) {
                return stream
                        .filter(line -> !line.isEmpty())
                        .collect(Collectors.toList());
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("File doesn't exist");
        }
        return new ArrayList<>();
    }

}
