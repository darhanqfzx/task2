package kz.bitlab.springboot.springbootdemo.controllers;

import kz.bitlab.springboot.springbootdemo.entities.Items;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private List<Items> items = new ArrayList<>();

    public HomeController() {
        items.add(new Items(1L, "Lenovo Legion 7", "RTX 5060 I5 14TH 1024SSD", 2500.0));
        items.add(new Items(2L, "Macbook M4", "M4 chip ", 1200.5));
        items.add(new Items(3L, "Airpods MAX", "take care of your ears", 350.0));
    }
    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("tovary", items);
        return "index";
    }
    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("item", new Items());
        return "add";
    }
    @PostMapping("/add")
    public String saveProduct(@ModelAttribute("item") Items item) {
        item.setId((long) (items.size() + 1)); 
        items.add(item);
        return "redirect:/";
    }
}
