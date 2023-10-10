package com.session.demo.repository;

import java.util.List;


import com.session.demo.entity.SessionAttributeEntity;
import com.session.demo.entity.SessionAttributeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SessionAttributeRepository extends JpaRepository<SessionAttributeEntity, SessionAttributeId> {

	@Query("FROM SessionAttributeEntity sa WHERE sa.sessionId = :sessionId order by sa.attributeName")
	List<SessionAttributeEntity> findBySessionId(String sessionId);

	@Query("DELETE SessionAttributeEntity sa WHERE sa.sessionId = :sessionId")
	void deleteBySessionId(String sessionId);

}
