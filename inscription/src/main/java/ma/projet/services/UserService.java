package ma.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.dao.IDao;
import ma.projet.entities.User;
import ma.projet.repository.UserRepository;

@Service
public class UserService implements IDao<User> {
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public User create(User o) {
		return userRepository.save(o);
	}

	@Override
	public boolean delete(User o) {
		try {
			userRepository.delete(o);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
		
	}

	@Override
	public User update(User o) {
		// TODO Auto-generated method stub
		return userRepository.save(o);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}
	
	

}
