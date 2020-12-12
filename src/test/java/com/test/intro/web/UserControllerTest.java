package com.test.intro.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.intro.domain.PhonesDTO;
import com.test.intro.domain.UserDTO;
import com.test.intro.service.UserService;
import com.test.intro.utils.Urls;

/**
 * The Class UserControllerTest.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService userService;

	/**
	 * Sign up.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void signUp() throws Exception {

		Mockito.when(userService.registerUser(Mockito.any(UserDTO.class)))
				.thenReturn(new ResponseEntity<>(null, HttpStatus.CREATED));
		UserDTO dto = this.defaultUser();
		
		this.mvc.perform(post(Urls.USERS.concat(Urls.REGISTER)).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(dto))).andExpect(status().is(201));

	}

	private UserDTO defaultUser() {
		List<PhonesDTO> phonesDTO = new ArrayList<>();
		phonesDTO.add(new PhonesDTO(null, null, "1234567", "45", "56", null));

		return new UserDTO(null, null, null, "John Doe", "john.doe@gmail.com", "Hunter22", null, null, phonesDTO);
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
