package edu.doubler.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class LearningTest {
	
	@Autowired
	@Qualifier("learn")
	DataModelService service;
	
	@Test
	public void testReturnTrue(){
		service.isValid("asd");
	}
}
