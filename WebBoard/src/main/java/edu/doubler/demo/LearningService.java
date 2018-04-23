package edu.doubler.demo;

import org.springframework.stereotype.Service;

@Service("learn")
public class LearningService implements DataModelService{

	@Override
	public boolean isValid(String input) {
		return true;
	}
	
}
