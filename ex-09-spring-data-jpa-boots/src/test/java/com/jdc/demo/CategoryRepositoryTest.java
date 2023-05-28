package com.jdc.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.demo.repo.CategoryRepo;

@SpringBootTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepo repo;
	
	@ParameterizedTest
	@CsvSource({
		"Foods,1",
		"Drinks,2",
		"Accessories,6"
	})
	void test_find_one_by_name_found(String name, int id) {
		
		var result = repo.findOneByName(name);
		
		assertNotNull(result);
		assertEquals(name, result.getName());
		assertEquals(id, result.getId());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
			"foods", "Drinks ", "Accessorie", ""
	})
	void test_find_one_by_name_not_found(String name) {
		var result = repo.findOneByName(name);
		assertNull(result);
	}
}
