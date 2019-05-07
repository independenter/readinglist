package com.asiainfo.readinglist;

import com.asiainfo.readinglist.dao.ReaderRepository;
import com.asiainfo.readinglist.dao.ReadingListOraRepository;
import com.asiainfo.readinglist.entiy.Book;
import com.asiainfo.readinglist.entiy.Reader;
import com.asiainfo.readinglist.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadinglistApplicationTests {

	@Autowired //必须添加自动装配
	private ReadingListOraRepository readingListOraRepository;
	@Autowired
	private ReaderRepository readerRepository;


	@Test
	public void contextLoads() {
//		List<Book> readingList = readingListOraRepository.findAll();
//		readingList.forEach(n->{
//			System.out.println(n);
//		});
//		List<Reader> readers = readerRepository.findAll();
//		readers.forEach(n->{
//			System.out.println(n);
//		});
		System.out.println(readerRepository.findOne("root"));
	}

}
