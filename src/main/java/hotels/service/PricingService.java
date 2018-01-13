package hotels.service;


import java.util.List;
import java.util.Optional;

public interface PricingService {
    Optional<Integer> findMaxPrice(List<Integer> prices);
}
