package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item();
        item.setItemName("좋은 아이템");
        item.setPrice(20000);
        item.setQuantity(30);

        //when
        Item saveItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(saveItem.getId());
        assertThat(saveItem).isEqualTo(findItem);
    }

    @Test
    void findAll() {

        //given
        Item item = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 20);

        itemRepository.save(item);
        itemRepository.save(item2);

        //when
        List<Item> all = itemRepository.findAll();

        //then
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(item, item2);

    }

    @Test
    void updateItem() {

        //given
        Item item = new Item("item1", 10000, 10);
        Item saveItem = itemRepository.save(item);
        Long saveItemId = saveItem.getId();

        //when
        Item updateParam = new Item("item2", 20000, 20);
        itemRepository.update(saveItemId, updateParam);

        //then
        Item isUpdateId = itemRepository.findById(saveItemId);
        assertThat(isUpdateId.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(isUpdateId.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(isUpdateId.getQuantity()).isEqualTo(updateParam.getQuantity());

    }

}
