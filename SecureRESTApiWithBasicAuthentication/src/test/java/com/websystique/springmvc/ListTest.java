/*package com.websystique.springmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.websystique.springmvc.model.User;

public class ListTest {
	
private  List<User> testUsers;
testUsers= populateDummyUsers();
	
	
private static final AtomicLong counter = new AtomicLong();
	
private static List<User> populateDummyUsers(){
	List<User> users = new ArrayList<User>();
	users.add(new User(counter.incrementAndGet(),"Sam",30));
	users.add(new User(counter.incrementAndGet(),"Tom",40));
	users.add(new User(counter.incrementAndGet(),"Jerome",45));
	users.add(new User(counter.incrementAndGet(),"Silvia",50));
	return users;
}

}
*/