package cn.cnnic.mongoTest;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import cn.cnnic.entity.Address;
import cn.cnnic.entity.Person;
import cn.cnnic.repo.AddressRepo;
import cn.cnnic.repo.PersonRepo;

public class Application {
	
	private static final Log logger = LogFactory.getLog(Application.class);
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("spring-config.xml").getPath());
		PersonRepo personRepo = context.getBean(PersonRepo.class);
		AddressRepo addressRepo = context.getBean(AddressRepo.class);

		Person personAchilles = new Person();
		personAchilles.setPersonId(1l);
		personAchilles.setName("Achilles");
		personRepo.save(personAchilles);
		Person personHektor = new Person();
		personHektor.setPersonId(2l);
		personHektor.setName("Hektor");

		Address address = new Address(1, "221b Baker Street", "London NW1","London", 12345l);
		List<Address> addresses = personHektor.getAddresses();
		addresses.add(address);
		personAchilles.setAddresses(addresses);

		//addressRepo.save(address);
		//personRepo.save(personHektor);
		logger.debug("==================================");

		Iterable<Person> personList = personRepo.findAll();
		System.out.println("Person List : ");
		for (Person person : personList) {
			System.out.println(person);
		}

		System.out.println("Person with Id 1 is "
				+ personRepo.searchByName("Hektor"));

		context.close();

	}
}
