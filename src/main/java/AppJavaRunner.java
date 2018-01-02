import hotels.service.HotelFileReader;
import hotels.service.StreamFileReaderImpl;

import java.util.List;
import java.util.Scanner;

public class AppJavaRunner {

    public static void main(String[] args) {
        HotelFileReader hotelFileReader = new StreamFileReaderImpl();
        int action = -1;

        System.out.println("* * Welcome to hotels searcher * *");
        Scanner scanIn = new Scanner(System.in);

        while (action != 0) {
            System.out.println("\nSelect an action: ");
            System.out.println("\t1. Read hotels source file.");

            String inputString = scanIn.nextLine();
            try {
                action = Integer.valueOf(inputString);
                switch (action){
                    case 1:
                        List<String> hotels = hotelFileReader.readFile("/hotels.csv");
                        System.out.println("Hotels loaded:");
                        for(String hotel: hotels) {
                            System.out.println("\t" + hotel);
                        }
                        break;
                    case 0:
                        System.out.println("Bye!");
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid option!");
            }
            System.out.println("Press enter to continue.");
            scanIn.nextLine();
        }
        scanIn.close();
    }

}
