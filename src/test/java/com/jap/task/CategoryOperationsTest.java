package com.jap.task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CategoryOperationsTest {
	private CategoryOperations categoryOperations;

	@Before
	public void setUp() throws Exception {
		categoryOperations = new CategoryOperations();

	}
	@After
	public void tearDown() throws Exception {
		categoryOperations = null;
	}

	@Test
	public void addNewCategoryReturnTrue() {
		assertEquals(true,categoryOperations.addCategory("Meetings"));
	}


	@Test
	public void getCategoryThatIsPresentReturnCategory() {
		categoryOperations.addCategory("Meetings");
		assertNotNull(categoryOperations.findCategory("Meetings"));
	}

	@Test
	public void listAllCategories() {
		categoryOperations.addCategory("Meetings");
		categoryOperations.addCategory("Client Connect");
		List<Category> categories = categoryOperations.listAllCategories();
		assertEquals(2, categories.size());
	}
}
