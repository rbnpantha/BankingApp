package edu.cs544.eafinal.service;

import java.util.List;
import edu.cs544.eafinal.domain.User;

public interface UserService {
	public void addUser(User user);
	public void deleteUser(Long AccountId);
	public List<User> getAll();
	public User getUser(Long AccountId);
}
