package hotels.service.impl;

import hotels.service.PricingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PricingServiceSimpleImpl implements PricingService {
    @Override
    public List<Integer> convertToExchangeRate(List<Integer> prices, Float rate) {
        List<Integer> filteredPrices = new ArrayList<>();
        for (Integer price: prices) {
          filteredPrices.add(convertPrice(price, rate));
        }
        return filteredPrices;
    }

    private Integer convertPrice(Integer price, Float rate) {
        return Math.round(price * rate);
    }

    @Override
    public List<Integer> findPricesBelowThreshold(List<Integer> prices, Integer threshold) {
        List<Integer> filteredPrices = new ArrayList<>();
        for (Integer price: prices) {
            if (price < threshold) {
                filteredPrices.add(price);
            }
        }
        return filteredPrices;
    }

    @Override
    public Optional<Integer> findMaxPrice(List<Integer> prices) {
        if (prices == null || prices.isEmpty()) {
            return Optional.empty();
        }

        Integer maxFound = Integer.MIN_VALUE;
        for(Integer price: prices) {
            if (price > maxFound) {
                maxFound = price;
            }
        }
        return Optional.of(maxFound);
    }
}
