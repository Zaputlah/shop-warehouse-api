package com.reza.warehouse.service;

import com.reza.warehouse.model.Item;
import com.reza.warehouse.model.Variant;
import com.reza.warehouse.repository.ItemRepository;
import com.reza.warehouse.repository.VariantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VariantService {

    private final VariantRepository variantRepository;
    private final ItemRepository itemRepository;

    public List<Variant> getAllVariants() {
        return variantRepository.findAll();
    }

    public Optional<Variant> getVariantById(Long id) {
        return variantRepository.findById(id);
    }

    public Variant createVariant(Long itemId, Variant variant) {

        Item item = itemRepository.findById(itemId)
            .orElseThrow(() -> new RuntimeException("Item not found"));

        if (variantRepository.existsByNameAndItemId(variant.getName(), itemId)) {
            throw new RuntimeException("Variant name already exists for this item");
        }

        variant.setItem(item);

        return variantRepository.save(variant);
    }


    public Optional<Variant> updateVariant(Long id, Variant updatedVariant) {
        return variantRepository.findById(id).map(variant -> {
            variant.setName(updatedVariant.getName());
            variant.setPrice(updatedVariant.getPrice());
            return variantRepository.save(variant);
        });
    }

    public boolean deleteVariant(Long id) {
        return variantRepository.findById(id).map(variant -> {
            variantRepository.delete(variant);
            return true;
        }).orElse(false);
    }
}
