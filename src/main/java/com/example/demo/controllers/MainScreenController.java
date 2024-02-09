package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MainScreenController {
    private PartService partService;
    private ProductService productService;

    public MainScreenController(PartService partService,ProductService productService){
        this.partService=partService;
        this.productService=productService;
    }
    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword){
        List<Part> partList=partService.listAll(partkeyword);
        theModel.addAttribute("parts",partList);
        theModel.addAttribute("partkeyword",partkeyword);
        List<Product> productList=productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword",productkeyword);
        return "mainscreen";
    }

    @GetMapping("/about")
    public String showAbout(){
        return "about";
    }

    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productId") Long productId, RedirectAttributes redirectAttributes) {
        boolean success = productService.buyProduct(productId);
        String message = success ? "Purchase successful!" : "Purchase failed: Product out of stock.";
        redirectAttributes.addFlashAttribute("purchaseMessage", message);
        return "redirect:/mainscreen";
    }
}
