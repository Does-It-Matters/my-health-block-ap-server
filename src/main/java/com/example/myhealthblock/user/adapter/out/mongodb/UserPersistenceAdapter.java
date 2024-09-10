package com.example.myhealthblock.user.adapter.out.mongodb;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.user.domain.model.User;
import com.example.myhealthblock.user.application.port.out.UserOutputPort;
import lombok.RequiredArgsConstructor;

@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserOutputPort {

   private final UserRepository userRepository;

   @Override
   public boolean create(String id, String pw, String role) {
       UserDocument user = new UserDocument();
       user.setUserId(id);
       user.setPw(pw);
       user.setRole(role);
       userRepository.save(user);
       return true;
   }

   @Override
   public User getUser(String id) {
       UserDocument document = userRepository.findById(id).orElse(null);
       if (document == null) {
           return null;
       }
       return new User(document.getId(), document.getUserId(), document.getPw(), document.getRole());
   }

   @Override
   public boolean updatePw(String userId, String pw) {
       UserDocument document = userRepository.findByUserId(userId);
       if (document != null) {
           document.setPw(pw);
           userRepository.save(document);
           return true;
       }
       return false;
   }
}