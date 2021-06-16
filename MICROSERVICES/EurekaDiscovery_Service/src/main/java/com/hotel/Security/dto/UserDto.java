package com.hotel.Security.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {

    private String username;
    private String token;
    private String role;
    
	public UserDto() {
	}

	public UserDto(String username, String token, String role) {
		super();
		this.username = username;
		this.token = token;
		this.role = role;
	}
    
}
