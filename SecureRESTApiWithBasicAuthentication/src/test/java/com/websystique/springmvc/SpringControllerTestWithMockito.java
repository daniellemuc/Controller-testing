package com.websystique.springmvc;

import static org.mockito.Mockito.times;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import  org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.*;
import com.websystique.springmvc.controller.UsersRestController;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class SpringControllerTestWithMockito{
	
	
	private MockMvc mockMvc;
	
	@Mock
    private UserService userService;
	
	@InjectMocks
	private UsersRestController usersRestController;
	
	@Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(usersRestController).build();
    }
	

	@Test
    public void test_get_all_success1() throws Exception {
        List<User> testUsersList = new ArrayList<User>();
        testUsersList.add(new User(1,"Sam",30));
        testUsersList.add(new User(2,"Tom",40));
        testUsersList.add(new User(3,"Jerome",45));
        testUsersList.add(new User(4,"Silvia",50));

        when(userService.findAllUsers()).thenReturn(testUsersList);

        mockMvc.perform(get("/user/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Sam")))
                .andExpect(jsonPath("$[0].age", is(30)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Tom")))
                .andExpect(jsonPath("$[1].age", is(40)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].name", is("Jerome")))
                .andExpect(jsonPath("$[2].age", is(45)))	
                .andExpect(jsonPath("$[3].id", is(4)))
                .andExpect(jsonPath("$[3].name", is("Silvia")))
                .andExpect(jsonPath("$[3].age", is(50)));
        ((UserService) verify(userService, times(1))).findAllUsers();
        verifyNoMoreInteractions(userService);
	}

        @Test
        public void test_get_all_success2() throws Exception {
            List<User> testUsersList = new ArrayList<User>();
            when(userService.findAllUsers()).thenReturn(testUsersList);

            mockMvc.perform(get("/user/"))
                    .andExpect(status().isNoContent());
            ((UserService) verify(userService, times(1))).findAllUsers();
            verifyNoMoreInteractions(userService);     
    }
        
        @Test
        public void test_get_all_fail1() throws Exception {
            List<User> testUsersList = new ArrayList<User>();
            testUsersList.add(new User(1,"Sam",30));
            testUsersList.add(new User(2,"Tom",40));
            testUsersList.add(new User(3,"Jerome",45));
            testUsersList.add(new User(4,"Adi",50));

            when(userService.findAllUsers()).thenReturn(testUsersList);

            mockMvc.perform(get("/user/"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(jsonPath("$", hasSize(4)))
                    .andExpect(jsonPath("$[0].id", is(1)))
                    .andExpect(jsonPath("$[0].name", is("Sam")))
                    .andExpect(jsonPath("$[0].age", is(30)))
                    .andExpect(jsonPath("$[1].id", is(2)))
                    .andExpect(jsonPath("$[1].name", is("Tom")))
                    .andExpect(jsonPath("$[1].age", is(40)))
                    .andExpect(jsonPath("$[2].id", is(3)))
                    .andExpect(jsonPath("$[2].name", is("Jerome")))
                    .andExpect(jsonPath("$[2].age", is(45)))	
                    .andExpect(jsonPath("$[3].id", is(4)))
                    .andExpect(jsonPath("$[3].name", is("Silvia")))
                    .andExpect(jsonPath("$[3].age", is(50)));
            ((UserService) verify(userService, times(1))).findAllUsers();
            verifyNoMoreInteractions(userService);
        }

        @Test
        public void test_get_all_fail2() throws Exception {
            List<User> testUsersList = new ArrayList<User>();
            when(userService.findAllUsers()).thenReturn(testUsersList);

            mockMvc.perform(get("/user/"))
                    .andExpect(status().isOk());
            ((UserService) verify(userService, times(1))).findAllUsers();
            verifyNoMoreInteractions(userService);     
    }
	
}




