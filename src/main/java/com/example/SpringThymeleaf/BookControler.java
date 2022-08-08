package com.example.SpringThymeleaf;

import com.example.SpringThymeleaf.entity.Book;
import com.example.SpringThymeleaf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookControler {

    @Autowired
    BookService service;

@GetMapping("/")
    public String findAll(Model model) {
model.addAttribute("books", service.findallBooks());
return "all-books";
    }

    @GetMapping("/add")
    public  String lunchAddBookPage(Model model){
    model.addAttribute("book", new Book());
             return  "add-book";
    }
// adicionar
    @PostMapping("/addbook")
    public String CreateBooK(Book book){
service.addBook(book);
return "redirect:/";
    }

@GetMapping("/edit/{id}")
public String lunohEditPage( Model model,@PathVariable("id") int id ){
model.addAttribute("book", service.findBookById(id));
return "edit-book";
}
// edita
            @PostMapping("/updatebook")
              public String upadteBook(Book book){
                    service.updateBook(book);
                    return "redirect:/";
              }
// deletar

              @GetMapping("/delete/{id}")
              public String deleteBook(@PathVariable("id") int id){
                   service.deleteById(id);
                  return "redirect:/";
              }


// teste
          @GetMapping("/test")
                 public String test(){
                      Book st=new Book();
                 st.setId(1);
                 st.setAuthor("Rajankin");
                 st.setName("java11");
                 st.setNoOfPages(299);
                 st.setPublication("ptradhan");
                   service.addBook(st);
                   return  "index";
    }
}
