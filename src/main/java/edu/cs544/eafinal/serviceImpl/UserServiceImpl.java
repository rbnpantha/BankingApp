package edu.cs544.eafinal.serviceImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import edu.cs544.eafinal.domain.Response;
import edu.cs544.eafinal.domain.User;
import edu.cs544.eafinal.rest.RestHttpHeader;
import edu.cs544.eafinal.service.UserService;

import org.codehaus.jackson.map.ObjectMapper;

public class UserServiceImpl implements UserService{
	@Autowired
	RestHttpHeader restHttpHeader;
	
	RestTemplate restTemplate = new RestTemplate();
	
	Response response;
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public User addUser(User user) {
		final String uri =
				"http://localhost:8080/BankingRest/users/add/";
				 RestTemplate restTemplate = new RestTemplate();
				 User result = restTemplate.postForObject( uri, user, User.class);
				 System.out.println(result);
				 return result;
	}

	@Override
	public void deleteUser(Long AccountId) {
		// TODO Auto-generated method stub
		final String uri =
				"http://localhost:8080/BankingRest/users/delete/" +AccountId;
				 Map<String, Long> params = new HashMap<String, Long>();
				 params.put("id", AccountId);
				 RestTemplate restTemplate = new RestTemplate();
				 restTemplate.delete ( uri, params );
				 System.out.println("Successfully Deleted user with AccountNo : " + AccountId );
	}

	@Override
	public List<User> getAll() {	
		ResponseEntity<List<User>> rateResponse =
		        restTemplate.exchange("http://localhost:8080/BankingRest/users/",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
		            });
		List<User> users = rateResponse.getBody();
		for(User user : users)
			System.out.println(" the list is as : "+user.getFirstName());
		
		return users;
		
			}

	@Override
	public User getUser(Long AccountId) {
		System.out.println("Inside service impl method!! " +AccountId);		
		String url = "http://localhost:8080/BankingRest/users/1";
		User user = restTemplate.getForObject(url, User.class, AccountId);
		System.out.println("Usr is : "+ user.toString());
		return user;
	}

	@Override
	public void updateUser(User user) {
		final String uri =
				"http://localhost:8080/BankingRest/users/delete/{id}";
				 Map<String, String> params = new HashMap<String, String>();
				 params.put("id", "2");
				 User updateUser = new User();
				 
				 RestTemplate restTemplate = new RestTemplate();
				 restTemplate.put ( uri, updateUser, params);
		
	}
}
