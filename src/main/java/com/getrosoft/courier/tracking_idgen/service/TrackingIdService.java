package com.getrosoft.courier.tracking_idgen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.getrosoft.courier.tracking_idgen.repository.IdGenRepository;
import com.getrosoft.courier.tracking_idgen.utils.NumberBaseConverter;

@Service
public class TrackingIdService {

	private final IdGenRepository idGenRepository;

    @Autowired
    public TrackingIdService(IdGenRepository idGenRepository) {
        this.idGenRepository = idGenRepository;
    }
	
    @Transactional
	public String generateTrackingNumber() {
		// TODO Auto-generated method stub
		return 	NumberBaseConverter.base10toBase36(
					idGenRepository.getNextTrackingNumber());
	}
}
