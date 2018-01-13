package hotels;


import hotels.service.FileReader;
import hotels.service.PricingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.lang.String.format;

public class ConsoleApp {

    public void start(FileReader fileReader, PricingService pricingService) {
        int action = -1;

        System.out.println("* * Welcome to hotels searcher * *");
        Scanner scanIn = new Scanner(System.in);

        while (action != 0) {
            System.out.println("\nSelect an action: ");
            System.out.println("\t1. Read hotels source file.");
            System.out.println("\t2. Get max price of a list.");
            System.out.println("\t0. To exit.");

            String inputString = scanIn.nextLine();
            try {
                action = Integer.valueOf(inputString);
                switch (action) {
                    case 0:
                        System.out.println("Bye!");
                        break;

                    case 1:
                        printFileContent(fileReader);
                        break;

                    case 2:
                        printMaxPrice(pricingService, scanIn);
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

    private void printFileContent(FileReader fileReader) {
        List<String> hotels = fileReader.readFile("/hotels.csv");

        System.out.println("Hotels loaded:");
        for (String hotel : hotels) {
            System.out.println("\t" + hotel);
        }
    }

    private void printMaxPrice(PricingService pricingService, Scanner scanIn) {
        try {
            System.out.println("Write in comma separated values the list of prices");

            String pricesInput = scanIn.nextLine();

            List<Integer> prices = getPricesList(pricesInput.split(","));
            Optional<Integer> maxPrice = pricingService.findMaxPrice(prices);

            if (maxPrice.isPresent()) {
                System.out.println(format("Max price found: %d", maxPrice.get()));
            } else{
                System.out.println("No max price found");
            }

        } catch (NumberFormatException nfe) {
            System.out.println("Invalid prices!");
        }
    }

    private List<Integer> getPricesList(String[] pricesStr) {
        List<Integer> prices = new ArrayList<>();

        for (int i = 0; i < pricesStr.length; i++) {
            prices.add(Integer.valueOf(pricesStr[i].trim()));
        }
        return prices;
    }

}
