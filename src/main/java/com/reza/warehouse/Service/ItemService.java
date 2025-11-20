package com.reza.warehouse.Service;

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
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item item) {
        Item existing = getItemById(id);
        existing.setName(item.getName());
        existing.setDescription(item.getDescription());
        return itemRepository.save(existing);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
