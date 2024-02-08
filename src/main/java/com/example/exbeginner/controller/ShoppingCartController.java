package com.example.exbeginner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exbeginner.model.Item;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({"/product", "/product/"})
public class ShoppingCartController {
    @Autowired 
    private ServletContext application;
    @Autowired
    private HttpSession session;

    @GetMapping({"", "/"})
    public String index(Model model) {
        /**
         * applicationスコープに商品情報を格納する
         */

        List<Item> products = new ArrayList<>();

        Item notebook = new Item();
        notebook.setName("手帳ノート");
        notebook.setPrice(1000);
        products.add(notebook);

        Item stationerySet = new Item();
        stationerySet.setName("文房具セット");
        stationerySet.setPrice(1500);
        products.add(stationerySet);

        Item file = new Item();
        file.setName("ファイル");
        file.setPrice(2000);
        products.add(file);

        if(application.getAttribute("products") == null){
            application.setAttribute("products", products);
        }

        /**
         * sessionスコープに空のリストを格納する
         */
        LinkedList<Item> initialCart = new LinkedList<>();
        // initialCart.add(notebook);
        // initialCart.add(stationerySet);
        // initialCart.add(file);


        if(session.getAttribute("cartItems") == null) {
            session.setAttribute("cartItems", initialCart);
        }

        /**
         * requestスコープに合計金額を格納する
         */
        Integer totalPrice = 0;
        LinkedList<Item> sessionCartItems = (LinkedList<Item>) session.getAttribute("cartItems");
        for(Item carItem : sessionCartItems) {
            totalPrice += carItem.getPrice();
        }
        model.addAttribute("totalPrice", totalPrice);

        return "item-and-cart";
    }

    @PostMapping("/inCart")
    public String inCart(Integer index) {
        System.out.println(index);
        List<Item> products = (List<Item>) application.getAttribute("products");
        Item addItem = products.get(index);

        LinkedList<Item> inCart = (LinkedList<Item>) session.getAttribute("cartItems");
        inCart.add(addItem);
        System.out.println(inCart);

        return "redirect:/product";
    }
}
