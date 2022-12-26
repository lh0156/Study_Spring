package hello.itemservice.domain.item;

import java.util.List;

public interface IItemRepository {

    public void save();
    public Item findById(Long id);
    public List<Item> findAll();
    public void update(Long itemId, Item updateParam);
    public void delete(Long id);



}
