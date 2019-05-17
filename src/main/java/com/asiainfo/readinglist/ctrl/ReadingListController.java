package com.asiainfo.readinglist.ctrl;

import com.asiainfo.readinglist.entiy.Book;
import com.asiainfo.readinglist.dao.ReadingListOraRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * http://www.yixiubb.com:8000/rl/readinglist
 * @EnableAutoConfiguration(exclude = { //禁用登录
org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
 */
@Slf4j
@Controller
@RequestMapping("/rl")
@ConfigurationProperties(prefix="amazon")
public class ReadingListController {

    private String associateId;
    private ReadingListOraRepository readingListRepository;

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }

    public String getAssociateId() {
        return associateId;
    }

    @Autowired
    public ReadingListController(
            ReadingListOraRepository readingListOraRepository) {
        this.readingListRepository = readingListOraRepository;
    }
//    private ReadingListMongoRepository readingListRepository;
//    @Autowired
//    public ReadingListController(
//            ReadingListMongoRepository readingListMongoRepository) {
//        this.readingListRepository = readingListMongoRepository;
//    }

//    @RequestMapping("/")
//    public String showIndex(){
//        return "readingList";
//    }

    @RequestMapping(value="/{reader}", method= RequestMethod.GET)
    public String readersBooks(
            @PathVariable("reader") String reader,
            Model model) {
        List<Book> readingList =
                readingListRepository.findByReader(reader);
        logger.warn("findByReader:"+reader+"|"+readingList);
        if (readingList != null) {
            model.addAttribute("books", readingList);
//            for(Book book:readingList){
//                System.out.println("book = " + book);
//            }
        }else{
            throw new RuntimeException("测试Eorror页面");
        }

        model.addAttribute("reader", reader);
        model.addAttribute("amazonID", associateId);
        return "readingList";
    }

    @RequestMapping(value="/{reader}", method=RequestMethod.POST)
    public String addToReadingList(
            @PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        logger.warn("addToReadingList:"+reader+"|"+reader);
        if(book.getAuthor()!="" && book.getAuthor()!=null){
            readingListRepository.save(book);
        }
        return "redirect:/{reader}";
    }

    @GetMapping(value = "get")
    @ResponseBody
    public Book getBook(){
        Book book = new Book();
        book.setId(1L);
        book.setIsbn("15501951002");
        book.setTitle("发生那地方");
        return book;
    }
}
