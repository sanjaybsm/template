package com.sanjay.template.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection="User")
public class User {

	@Id
	private String id;

	public String firstName;
	public String lastName;
	public String email;
	public String password;


}
