package ma.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.dao.IDao;
import ma.projet.entities.Role;
import ma.projet.repository.RoleRepository;

@Service
public class RoleService implements IDao<Role>{
	
	@Autowired
	private RoleRepository Role1Repository;

	@Override
	public Role create(Role o) {
		return Role1Repository.save(o);
	}

	@Override
	public boolean delete(Role o) {
		try {
			Role1Repository.delete(o);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public Role update(Role o) {
		return Role1Repository.save(o);
	}

	@Override
	public List<Role> findAll() {
		return Role1Repository.findAll();
	}

	@Override
	public Role findById(Long id) {
		return Role1Repository.findById(id).orElse(null);
	}
	

}