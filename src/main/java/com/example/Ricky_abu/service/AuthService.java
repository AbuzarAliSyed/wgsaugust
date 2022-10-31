package com.example.Ricky_abu.service;

//import com.example.demo.dto.RegisterRequest;
import com.example.Ricky_abu.dto.RegisterRequest;
import com.example.Ricky_abu.model.User;
import com.example.Ricky_abu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public void signup(RegisterRequest registerRequest) {
        User user=new User();
        user.setUserName(registerRequest.getUsername());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        userRepository.save(user);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
