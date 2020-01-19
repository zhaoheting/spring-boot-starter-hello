package com.hello.controllers;

import com.hello.entities.Book;
import com.hello.repositories.ReadingListRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {

    private ReadingListRepository readingListRepository;

    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(value = "/getReaderBooks/{readerName}", method = RequestMethod.GET)
    public String getReaderBooks(@PathVariable String readerName, Model model) {
        List<Book> readerBooks = readingListRepository.findByReader(readerName);
        if (CollectionUtils.isEmpty(readerBooks)) {
            model.addAttribute("books", readerBooks);
        }
        return "ReadingList";
    }

    @RequestMapping(value = "/addToBooks/{readerName}", method = RequestMethod.POST)
    public String addToReaderBooks(@PathVariable String readerName,Book book) {
        book.setReader(readerName);
        readingListRepository.save(book);
        return "redirect:/getReaderBooks/{readerName}";
    }
}
