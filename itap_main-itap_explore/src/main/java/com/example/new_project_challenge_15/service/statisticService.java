package com.example.new_project_challenge_15.service;

import com.example.new_project_challenge_15.repository.LogRepo;
import com.example.new_project_challenge_15.repository.RoleRepository;
import org.springframework.stereotype.Service;

import com.example.new_project_challenge_15.models.log;

import com.example.new_project_challenge_15.entity.DTO.statisticModel;
import com.example.new_project_challenge_15.models.User;
import com.example.new_project_challenge_15.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class statisticService {
    @Autowired

    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    LogRepo logRepo;

//    public void userBan(Long id){
//        User user = userRepository.findById(id);
//        if(user != null){
//            if(user.isActive()) {
//                user.setActive(false);
//            }else{
//                user.setActive(true);
//            }
//        }
//        userRepository.save(user);
//    }
//    public void userSetAdministrator(Long id){
//        User user = userRepository.findById(id);
//        Set<Role> roles = new HashSet<>();
//        Role userRole = roleRepository.findByName(ERole.VIP)
//                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//        if(user.getRoles().contains("VIP")){
//            user.getRoles().remove("VIP");
//        }else{
//            roles.add(userRole);
//            user.setRoles(roles);
//        }
//        userRepository.save(user);
//    }
    public List<User> get3users1(){
        return userRepository.get3users1();
    }
    public List<User> get3users2(){
        return userRepository.get3users2();
    }

    public statisticModel getByUsername(String username) {
        User user = userRepository.findByUsernameTwo(username);
        statisticModel stat = new statisticModel();
        try {
//            log lastLog = logRepo.findLastDate(username);
            stat.setDate(logRepo.findLastDate(username));
        } catch (Exception e) {
            System.out.println(e);
        }
        List<log> logs = logRepo.findByUsername(username);
        stat.setAllRequsetNum(logRepo.findNumberOfRequests(username));
        stat.setLogs(logs);
        stat.setUser(user);
        stat.setRole(userRepository.getRoleById(username));
        stat.setTodayRequsetNum(logRepo.findTodayRequestNum(username));
        return stat;
    }

    public statisticModel general() {
        statisticModel stat = new statisticModel();
        stat.setAllRequsetNum(userRepository.getUserNum());
        stat.setTodayRequsetNum(logRepo.Number());
        return stat;
    }
}
