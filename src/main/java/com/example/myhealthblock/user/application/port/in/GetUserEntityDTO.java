package com.example.myhealthblock.user.application.port.in;

import com.example.myhealthblock.user.domain.dto.UserEntityDTO;

public interface GetUserEntityDTO {
    public UserEntityDTO getUserEntityDTO(String userId);
}
