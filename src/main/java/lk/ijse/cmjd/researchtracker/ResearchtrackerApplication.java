package lk.ijse.cmjd.researchtracker;

import lk.ijse.cmjd.researchtracker.user.User;
import lk.ijse.cmjd.researchtracker.user.UserRepository;
import lk.ijse.cmjd.researchtracker.project.Project;
import lk.ijse.cmjd.researchtracker.project.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ResearchtrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResearchtrackerApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository,
	                               PasswordEncoder passwordEncoder,
	                               ProjectRepository projectRepository) {
		return args -> {
// 1. Create a default Admin user if the database table doesn't have it
			if (userRepository.findByEmail("admin@test.com").isEmpty()) {
				User admin = new User();
				admin.setEmail("admin@test.com");
				admin.setPassword(passwordEncoder.encode("password123"));
				admin.setRole("ADMIN");
				userRepository.save(admin);
				System.out.println("Test admin user created successfully!");
			}

// 2. Create a default mock project using your exact entity setters
			if (projectRepository.count() == 0) {
				Project sampleProject = new Project();
				sampleProject.setTitle("AI Research Tracker System");
				sampleProject.setSummary("Developing a robust full-stack portal for monitoring academic milestones.");
				sampleProject.setStatus("ACTIVE");

				projectRepository.save(sampleProject);
				System.out.println("Sample research project initialized successfully!");
			}
		};
	}
}

