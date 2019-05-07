package com.asiainfo.readinglist.dao;

import com.asiainfo.readinglist.entiy.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReadingListMongoRepository extends MongoRepository<Book,Long> {
    List<Book> findByReader(String reader);
}
