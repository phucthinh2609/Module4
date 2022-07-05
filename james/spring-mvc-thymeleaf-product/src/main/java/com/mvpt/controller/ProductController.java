package com.mvpt.controller;

import com.mvpt.model.Product;
import com.mvpt.service.IProductService;
import com.mvpt.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String showProductsListPage(Model model,
                                       @RequestParam(name = "search", defaultValue = "") String search) {
        List<Product> productList;

        if (search.isEmpty()){
            productList = productService.findAll();
        } else {
            productList = productService.findByName(search.trim());
        }
        model.addAttribute("products", productList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(Product product, RedirectAttributes redirect) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        redirect.addFlashAttribute("success", "Added product successful");
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String showDeletePage(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Deleted product successful");
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String showUpdatePage(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Updated product successful");
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    public String showViewPage(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, RedirectAttributes redirect) {

        return "redirect:/products";
    }

}
