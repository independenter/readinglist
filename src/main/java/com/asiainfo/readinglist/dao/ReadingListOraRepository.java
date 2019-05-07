package com.asiainfo.readinglist.dao;

import com.asiainfo.readinglist.entiy.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//只要定义了仓库接口，SpringBoot会在运行时自动实现
public interface ReadingListOraRepository extends JpaRepository<Book,Long> {
    //两个参数：仓库操作的领域对象类型，ID属性的类型
    List<Book> findByReader(String reader);
}
