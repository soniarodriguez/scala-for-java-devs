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
            printOptions();

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
                        printPriceInOtherCurrency(pricingService, scanIn);
                        break;

                    case 3:
                        printPricesBelowThreshold(pricingService, scanIn);
                        break;

                    case 4:
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



    private void printOptions() {
        System.out.println("\nSelect an action: ");
        System.out.println("\t1. Read hotels source file.");
        System.out.println("\t2. Convert prices to a different currency.");
        System.out.println("\t3. Find prices below a maximum threshold.");
        System.out.println("\t4. Get max price of a list.");
        System.out.println("\t0. To exit.");
    }

    private void printFileContent(FileReader fileReader) {
        List<String> hotels = fileReader.readFile("/hotels.csv");

        System.out.println("Hotels loaded:");
        for (String hotel : hotels) {
            System.out.println("\t" + hotel);
        }
    }

    private void printPriceInOtherCurrency(PricingService pricingService, Scanner scanIn) {
        try {
            System.out.println("Write in comma separated values the list of prices");
            String pricesInput = scanIn.nextLine();

            Float rateInput = inputForExchangeRate(scanIn);

            List<Integer> prices = getPricesList(pricesInput.split(","));
            List<Integer> otherCurrencyPrices = pricingService.convertToExchangeRate(prices, rateInput);

            System.out.println("Prices in that currency:");
            printPricesList(otherCurrencyPrices);

        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number");
        }
    }

    private Float inputForExchangeRate(Scanner scanIn) {
        System.out.println("Write the exchange rate of the currency");
        String rateInput = scanIn.nextLine();

        return Float.valueOf(rateInput);
    }

    private void printPricesBelowThreshold(PricingService pricingService, Scanner scanIn) {
        try {
            System.out.println("Write in comma separated values the list of prices");
            String pricesInput = scanIn.nextLine();

            int threshold = inputForThreshold(scanIn);

            List<Integer> prices = getPricesList(pricesInput.split(","));
            List<Integer> otherCurrencyPrices = pricingService.findPricesBelowThreshold(prices, threshold);

            System.out.println(format("Prices below %d", threshold));
            printPricesList(otherCurrencyPrices);

        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number");
        }
    }

    private Integer inputForThreshold(Scanner scanIn) {
        System.out.println("Write the maximum price you want to filter for");
        String thresholdInput = scanIn.nextLine();

        return Integer.valueOf(thresholdInput);
    }

    private void printPricesList(List<Integer> prices) {
        StringBuffer pricesToPrint = new StringBuffer();
        for(Integer price: prices) {
            pricesToPrint.append(price).append(",");
        }
        pricesToPrint.deleteCharAt(pricesToPrint.length() - 1);
        System.out.println(pricesToPrint);
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
