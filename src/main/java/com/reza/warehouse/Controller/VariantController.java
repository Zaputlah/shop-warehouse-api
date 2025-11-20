package com.reza.warehouse.controller;

import com.reza.warehouse.model.Variant;
import com.reza.warehouse.service.VariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/variants")
@RequiredArgsConstructor
public class VariantController {

    private final VariantService variantService;

    @GetMapping
    public List<Variant> getAllVariants() {
        return variantService.getAllVariants();
    }

    @PostMapping("/{itemId}")
    public Variant createVariant(@PathVariable Long itemId, @RequestBody Variant variant) {
        return variantService.createVariant(itemId, variant);
    }

    @PutMapping("/{variantId}")
    public Optional<Variant> updateVariant(@PathVariable Long variantId, @RequestBody Variant variant) {
        return variantService.updateVariant(variantId, variant);
    }

    @DeleteMapping("/{variantId}")
    public void deleteVariant(@PathVariable Long variantId) {
        variantService.deleteVariant(variantId);
    }

}
