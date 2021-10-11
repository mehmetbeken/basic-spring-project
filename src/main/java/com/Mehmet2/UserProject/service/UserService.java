package com.Mehmet2.UserProject.service;

import com.Mehmet2.UserProject.dto.UserDto;
import com.Mehmet2.UserProject.entity.User;
import com.Mehmet2.UserProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;



    public UserDto createUser(UserDto userDto) {
        User user=modelMapper.map(userDto,User.class);
        user.setCreatedBy("Admin");
        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    public List<UserDto> getUsers(){
        List<User> users=userRepository.findAll();
        List<UserDto> dtos=users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());

        return dtos;
    }

    public UserDto getUser(Long id){
       Optional<User> user= userRepository.findById(id);

       if (user.isPresent()){
           return modelMapper.map(user.get(),UserDto.class);
       }
       return null;
    }
    public UserDto updateUser(Long id,UserDto user){
        Optional<User> resultUser= userRepository.findById(id);

        if (resultUser.isPresent()){
            resultUser.get().setFirstName(user.getFirstName());
            resultUser.get().setLastName(user.getLastName());
            resultUser.get().setUpdatedAt(new Date());
            resultUser.get().setUpdatedBy("Admin");
            return modelMapper.map(userRepository.save(resultUser.get()),UserDto.class);
        }
        return null;
    }
}
