package com.cg.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.bookstore.entities.UserClass;
import com.cg.bookstore.repository.ILoginRepository;
import com.cg.bookstore.service.ILoginService;


@SpringBootTest
public class UserModuleTests extends BookstoreApplicationTests{
	
	@Autowired
	ILoginRepository iLoginRepository;
	
	@Autowired
	ILoginService iLoginService;
		

	@Test
	void testGetAllUsers() {
		int count = iLoginRepository.userCount();
		List<UserClass> list = iLoginRepository.findAll();
		 assertEquals(count,list.size());	
	}
	
	

	
	@Test
	void  testValidateUsers() {
		Optional<UserClass> ol = iLoginRepository.findById(1);
		UserClass l = iLoginService.validateUser(ol.get().getUserId(), ol.get().getPassword());
		assertThat(ol.isPresent()).isEqualTo(!(l==null));
	}
	
	
	@Test
	void testRemoveUsers() {
		int count = iLoginRepository.userCount();
		Optional<UserClass> ol = iLoginRepository.findById(12);
		List<UserClass> list = iLoginService.removeUser(ol.get());
		assertThat(count-1).isEqualTo(list.size());
	}
	
	@Test
	void testAddUser() {
		int beforeCreating = iLoginRepository.userCount();
		UserClass userClass = new UserClass(4, "aneeket@gmail.com", "ani", "writer");
		iLoginRepository.save(userClass);
		int afterCreating = iLoginRepository.userCount();
		assertThat(afterCreating).isEqualTo(beforeCreating + 1);
	}

}

