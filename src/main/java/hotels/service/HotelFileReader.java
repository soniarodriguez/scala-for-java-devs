package hotels.service;

import java.util.List;

public interface HotelFileReader {
    List<String> readFile(String sourcePath);
}
