package com.example.myhealthblock.user.adapter.out.database.mongodb;

import com.example.myhealthblock.user.application.port.out.UserOutputPort;
import com.example.myhealthblock.user.domain.model.User;

import lombok.RequiredArgsConstructor;

//@LogExecutionTime(logTarget = LogTarget.ADAPTER)
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
       UserDocument userDocument = userRepository.findById(id).orElse(null);
       if (userDocument == null) {
           return null;
       }
       return new User(userDocument.getId(), userDocument.getUserId(), userDocument.getPw(), userDocument.getRole());
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

    // private UserDTO getUserDTO(UserDocument u) {
    //     return new UserDTO(u.getId(), u.getUserId(), u.getPw(), u.getRole());
    // }
}