package hotels.service;


import java.util.List;
import java.util.Optional;

public interface PricingService {
    List<Integer> findPricesBelowThreshold(List<Integer> prices, Integer threshold);
    Optional<Integer> findMaxPrice(List<Integer> prices);
}
