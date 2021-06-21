package com.hotel.Security;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.hotel.Security.entity.User;
import com.hotel.Security.enums.ClientType;
import com.hotel.Security.repository.UserRepository;

@SpringBootApplication

public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}
	@Bean
	public CommandLineRunner createAdmin(UserRepository userRepository,PasswordEncoder passwordEncoder){
		return args -> {
			Optional<User> optionalUser = userRepository.findByUsername("admin@admin.com");
			if(!optionalUser.isPresent()){
					saveAdmin(passwordEncoder,userRepository);
			}
		};
	}

	private void saveAdmin(PasswordEncoder passwordEncoder,UserRepository userRepository) {
		User admin = new User();
		admin.setUsername("admin@admin.com");
		admin.setPassword(passwordEncoder.encode("administrator"));
		admin.setRole(ClientType.Administrator.toString());
		userRepository.save(admin);
	}
}
