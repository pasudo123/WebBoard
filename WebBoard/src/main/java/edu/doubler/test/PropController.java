package edu.doubler.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropController {
	
	@Value("#{user['pasudo123.id']}")
	String pasudo123Id;
	
	@Value("#{user['pasudo123.pw']}")
	String pasudo123Pw;
	
	@Value("#{user['pasudo123.address']}")
	String pasudo123Addr;
	
	@Value("#{user['doubler.id']}")
	String doublerId;
	
	@Value("#{user['doubler.pw']}")
	String doublerPw;
	
	@Value("#{user['doubler.address']}")
	String doublerAddr;
	
	@Autowired
	ComponentTest componentTest;
	
	@RequestMapping("/props")
	public String printProps(){
		
//		displayOnConsole();
//		componentTest.autowiredPrint();
		componentTest.ResourcePrint();
		
		return "testView/prop.jsp";
	}
	
	private void displayOnConsole(){
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		System.out.println("pasudo123Id : " + pasudo123Id);
		System.out.println("pasudo123Pw : " + pasudo123Pw);
		System.out.println("pasudo123Addr : " + pasudo123Addr);
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		System.out.println("doublerId : " + doublerId);
		System.out.println("doublerPw : " + doublerPw);
		System.out.println("doublerAddr : " + doublerAddr);
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
}
