package com.asiainfo.readinglist.dao;

import com.asiainfo.readinglist.entiy.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader,String> {
    public Reader findOne(String username);
}
