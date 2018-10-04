package com.devcodes.train.repositorydao;

import com.devcodes.train.repositorydao.entities.Role;
import com.devcodes.train.repositorydao.entities.User;
import com.devcodes.train.repositorydao.entities.UserRole;
import com.devcodes.train.repositorydao.entities.UserRolePk;
import com.devcodes.train.repositorydao.nativesdao.IUserReportRepository;
import com.devcodes.train.repositorydao.repositories.RoleRepository;
import com.devcodes.train.repositorydao.repositories.UserRepository;
import com.devcodes.train.repositorydao.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class RepositoryDaoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RepositoryDaoApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private IUserReportRepository iUserReportRepository;

	@Override
	public void run(String ... args){

		Role role1 = new Role();
		role1.setRole("ADMIN");
		role1.setDescription("ESTE ES EL ROL DE ADMINISTRADOR");
		role1 = roleRepository.save(role1);

		Role role2 = new Role();
		role2.setRole("USER");
		role2.setDescription("ESTE ES EL ROL DE USUARIO");
		role2 = roleRepository.save(role2);

		User user = new User();
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCellphone("+573014214251");
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setEmail("manuelfp@gmail.com");
		user.setFirstName("MANUEL FERNANDO");
		user.setLastName("GARIZAO PABON");
		user.setPhone("0543760909");
		user.setUsername("manuelfp");
		user.setPassword("123456");//new BCryptPasswordEncoder().encode("123456"));
		user = userRepository.save(user);

		UserRole userRole = new UserRole(new UserRolePk(user.getId(), role1.getId()), user, role1, new Date());
		userRoleRepository.save(userRole);

		UserRole userRole1 = new UserRole(new UserRolePk(user.getId(), role2.getId()), user, role2, new Date());
		userRoleRepository.save(userRole1);

		user = userRepository.save(user);

		System.out.println(user);

		System.out.println("-----------------------------------------------------------------------------------------");
		iUserReportRepository.doUserReports().stream().forEach(r -> System.out.println(r));

		System.out.println("-----------------------------------------------------------------------------------------");
		iUserReportRepository.insertRole(new Role("OPERADOR", "ESTE ES EL ROL DE OPERADOR"));
	}
}
