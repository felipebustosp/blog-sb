package com.felipe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.felipe.persistence.User;

@SpringBootTest
public class UserServiceTest {
    

    @Autowired
    private UserService service  ;

    @Test
    @DisplayName("Test initial record loading")
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords(){
        List<User> users = service.list();
        User user = users.get(0);
        assertEquals(user.getUser_id(), 1);
    }

}
