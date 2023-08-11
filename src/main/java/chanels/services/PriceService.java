package chanels.services;

import chanels.entities.Price;
import chanels.repositories.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> getAllPrice() {
        return priceRepository.findAll();
    }
}
