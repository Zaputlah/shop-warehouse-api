package com.reza.warehouse.service;

import com.reza.warehouse.model.Item;
import com.reza.warehouse.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Item not found with id " + id));
    }

    public Item createItem(Item item) {

        // CEK NAMA SUDAH ADA
        if (itemRepository.existsByName(item.getName())) {
            throw new RuntimeException("Item name already exists: " + item.getName());
        }

        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item item) {
        Item existing = getItemById(id);

        // CEK JIKA NAMA BERUBAH
        if (!existing.getName().equals(item.getName())) {
            // CEK NAMA SUDAH ADA DI DB
            if (itemRepository.existsByName(item.getName())) {
                throw new RuntimeException("Item name already exists: " + item.getName());
            }
        }

        existing.setName(item.getName());
        existing.setDescription(item.getDescription());
        return itemRepository.save(existing);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
