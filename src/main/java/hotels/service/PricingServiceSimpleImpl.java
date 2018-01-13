package hotels.service;

import java.util.List;
import java.util.Optional;

public class PricingServiceSimpleImpl implements PricingService {
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
