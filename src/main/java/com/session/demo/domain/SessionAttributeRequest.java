package com.session.demo.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionAttributeRequest {

	private String key;
	private String value;
}
