package com.adrian.audio_web.service;

import com.adrian.audio_web.dto.RequestForm;
import com.adrian.audio_web.entity.ClientRequest;
import com.adrian.audio_web.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository repository;

    public void save(RequestForm form) {
        ClientRequest request = new ClientRequest();
        request.setName(form.getName());
        request.setEmail(form.getEmail());
        request.setServiceType(form.getServiceType());
        request.setMessage(form.getMessage());

        repository.save(request);
    }
}