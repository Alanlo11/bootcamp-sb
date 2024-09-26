package com.bootcamp.demo.demo_sb_calculator.controller.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_calculator.controller.BookOperation;
import com.bootcamp.demo.demo_sb_calculator.model.Bag;
import com.bootcamp.demo.demo_sb_calculator.model.Book;
import com.bootcamp.demo.demo_sb_calculator.model.Bag.Color;

@Controller
// @Controller annotation -> Before server start completed -> new BookController()
// the created object -> Spring Context (not the heap memory, it is separated memory location)
// All these kind of objects, we call it "Bean"
// This bean MUST be created before server start completed.
// Implication: If the bean fail to create, server start fails. 
// If bean not exists, server start fail, no API services.

@ResponseBody
public class BookController implements BookOperation{
  // 只有行為，冇狀態
  // 佢只係用黎call method，唔需要有狀態
  // private int x; <- 冇呢d

  public Book getBook(int id, double price) {
    System.out.println("getbook");
    return new Book(id, price,null);
  }

  public Book getBook2(int id, double price) {
    System.out.println("getbook2");
    return new Book(id, price,null);
  }

  public List<Book> getBooks() {
    System.out.println("getbooks");
    return List.of(new Book(1, 10.3,null), new Book(2, 99.9,null));
  }

  public Set<Book> getBooks2() {
    System.out.println("getbooks2");
    return Set.of(new Book(1, 10.3,null), new Book(2, 99.9,null));
  }

  // instance method
  public Map<String, List<Book>> getBookmap() {
    System.out.println("getbookmap");
    Map<String, List<Book>> bookmap = new HashMap<>();
    bookmap.put("John", List.of(new Book(1, 10.3,null),new Book(2,12.3,null)));
    bookmap.put("Peter", List.of(new Book(2, 99.9,null)));
    return bookmap;
  }

  public Book[] getBookArray() {
    System.out.println("getbookarray");
    return new Book[] {new Book(1, 10.3,null), new Book(2, 99.9,null)};
  }

  public Bag getBag() {
    return Bag.builder().books((List.of(new Book(1, 10.3,List.of("abc","def")), new Book(2, 99.9,List.of("ijk")))))
    .color(Color.RED)
    .build();
  }

}