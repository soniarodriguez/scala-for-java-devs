import hotels.ConsoleApp;
import hotels.service.FileReaderClassicImpl;
import hotels.service.FileReader;
import hotels.service.PricingServiceSimpleImpl;
import hotels.service.PricingService;


public class AppJavaRunner {

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderClassicImpl();
        PricingService pricingService = new PricingServiceSimpleImpl();

        (new ConsoleApp()).start(fileReader, pricingService);
    }

}
