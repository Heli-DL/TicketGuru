package OP1RKS.TicketGuru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import OP1RKS.TicketGuru.domain.AppUser;
import OP1RKS.TicketGuru.domain.AppUserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
public class UserRestController {

	@Autowired
	private AppUserRepository urepo;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
	
	// REST AppUser
	// REST List all AppUsers
	@GetMapping("/users")
	public Iterable<AppUser> getAppUsers() {
		return urepo.findAll();
	};
	
	// REST Add
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public AppUser newAppUser (@Valid @RequestBody AppUser newAppUser, BindingResult result) throws MethodArgumentNotValidException {
		if(result.hasErrors()) {
			throw new MethodArgumentNotValidException(null, result);
		} 
		String password = newAppUser.getPassword();
		newAppUser.setPassword(passwordEncoder.encode(password));
		return urepo.save(newAppUser);
	};
	
	// REST Update
	@PutMapping("/users/{id}")
    public AppUser editAppUser (@Valid @RequestBody AppUser editAppUser, @PathVariable Long id, BindingResult result) throws MethodArgumentNotValidException {
		Optional<AppUser> appUser = urepo.findById(id);
		if (appUser.isPresent()) {
			if(result.hasErrors()) {
				throw new MethodArgumentNotValidException(null, result);
			} 
			AppUser existingAppUser = appUser.get();
			String password = editAppUser.getPassword();
		        
			existingAppUser.setFirstname(editAppUser.getFirstname());
			existingAppUser.setLastname(editAppUser.getLastname());
		    existingAppUser.setEmail(editAppUser.getEmail());
		    existingAppUser.setPassword(passwordEncoder.encode(password));
		    existingAppUser.setDeleted(editAppUser.getDeleted());
		    existingAppUser.setUserrole(editAppUser.getUserrole());
		        
		    return urepo.save(existingAppUser);   
		} else {
			throw new EntityNotFoundException("User not found with id: " + id);
		}
	};
	
	// REST Find by id
	@GetMapping("/users/{id}")
	public AppUser editAppUser(@PathVariable Long id) {
		Optional<AppUser> appUser = urepo.findById(id);
		if (appUser.isPresent()) {
			return appUser.get();
		} else {
			throw new EntityNotFoundException("User not found with id " + id);
		}
	};
	
	// REST Delete
	@DeleteMapping("/users/{id}")
	public void deleteAppUser(@PathVariable Long id) {
		if (!urepo.existsById(id)) {
			throw new EntityNotFoundException("User not found with id " + id);
		}
		urepo.deleteById(id);
	};
}
