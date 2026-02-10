package com.adrian.audio_web.repository;

import com.adrian.audio_web.entity.ClientRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<ClientRequest, Long> {
}
