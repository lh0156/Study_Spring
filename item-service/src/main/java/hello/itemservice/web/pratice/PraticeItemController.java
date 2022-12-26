package hello.itemservice.web.pratice;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/pratice")
@RequiredArgsConstructor
public class PraticeItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/itemList")
    public String items(Model model) {

        List<Item> itemList = itemRepository.findAll();
        model.addAttribute("itemList", itemList);
        return "pratice/itemList";

    }

    @GetMapping("/item/{itemId}")
    public String item(Model model, @PathVariable Long itemId) {

        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "pratice/item";

    }

    @GetMapping("/item/add")
    public String addForm() {
        return "pratice/addForm";
    }

    @PostMapping("/item/add")
    public String add(Item item, RedirectAttributes redirectAttributes, Model model) {
        itemRepository.save(item);

        model.addAttribute("item", item);

        redirectAttributes.addAttribute("itemId", item.getId());
        redirectAttributes.addAttribute("status", "true");

        return "redirect:/pratice/item/{itemId}";

    }

    @GetMapping("/item/{itemId}/delete")
    public String delete(Model model, @PathVariable Long itemId) {

        itemRepository.delete(itemId);
        List<Item> itemList = itemRepository.findAll();

        model.addAttribute("itemList", itemList);

        return "redirect:/pratice/itemList";

    }

    @GetMapping("/item/{itemId}/edit")
    public String editForm(Model model, @PathVariable Long itemId) {

        Item findItem = itemRepository.findById(itemId);
        model.addAttribute("item", findItem);

        return "pratice/editForm";

    }

    @PostMapping("/item/{itemId}/edit")
    public String edit(@PathVariable Long itemId, Item item) {

        itemRepository.update(itemId, item);

        return "redirect:/pratice/itemList";

    }

}
