package edu.doubler.test;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentTest {
	
	@Autowired
	private Properties user;
	
	@Resource(name="user")
	private Properties userProps;
	
	private String getValue(String key){
		return user.getProperty(key);
	}
	
	public void autowiredPrint(){
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		System.out.println("pasudo123Id : " + getValue("pasudo123.id"));
		System.out.println("pasudo123Pw : " + getValue("pasudo123.pw"));
		System.out.println("pasudo123Addr : " + getValue("pasudo123.address"));
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		System.out.println("doublerId : " + getValue("doubler.id"));
		System.out.println("doublerPw : " + getValue("doubler.pw"));
		System.out.println("doublerAddr : " + getValue("doubler.address"));
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
	
	public void ResourcePrint(){
		Set<Entry<Object, Object>> set = userProps.entrySet();
		Iterator<Entry<Object, Object>> it = set.iterator();
	
		while(it.hasNext()){
			Entry<Object, Object> entry = it.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
