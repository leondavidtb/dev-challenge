package services;

import com.example.challenge1.dtos.UserDTO;
import com.example.challenge1.dtos.UserResponseDTO;
import com.example.challenge1.repositories.UserRepository;
import com.example.challenge1.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void createUserTest() {
        UserDTO user = new UserDTO();
        user.setUserid("john@example.com");
        user.setPassword("password");
        user.setFullname("John Doe");
        user.setBirthdate(String.valueOf(LocalDate.now()));

        String expectedMessage = "User created successfully";

        UserResponseDTO response = userService.createUser(user);

        verify(userRepository, times(1)).save(any());

        assertNotNull(response);
        assertEquals(response.getMsg(), expectedMessage);
    }
}
