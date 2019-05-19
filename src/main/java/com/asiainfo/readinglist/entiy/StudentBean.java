package com.asiainfo.readinglist.entiy;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class StudentBean {

	@NonNull
	private String name;
	
	private int age;
}

class Main {
	public static void main(String[] args) {
		StudentBean studentBean = StudentBean.of("zhangsan").setAge(22);
		System.out.println(studentBean.getAge());
		System.out.println(studentBean.getName());
	}
}