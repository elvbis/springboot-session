package com.session.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class SessionDataResponse {
	private String key;
	private String value;

}
