package cn.cnnic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cnnic.entity.Person;
import cn.cnnic.repo.PersonRepo;

@Controller
@RequestMapping("/cap")
public class TestController {

	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private PersonRepo personRepo;
	/**
	 * 抓包管理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getName")
	public String getName() {
		
		Iterable<Person> personList = personRepo.findAll();
		for (Person person : personList) {
			System.out.println(person);
		}
		
		List<Person> list = mongoTemplate.findAll(Person.class);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("=--------------"+list.get(i));
		}
		
		Person p = new Person(3l,"Bob", 33);
		mongoTemplate.insert(p);
		
		return "am/cap/manage";
	}
	
}
