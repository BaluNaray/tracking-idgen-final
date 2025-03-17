package com.getrosoft.courier.tracking_idgen.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


/*
@Repository
public interface IdGenRepository extends CrudRepository<Void, Long> {

    @Query(value = "SELECT nextval('tracking_id_gen_seq')", nativeQuery = true)
    Long getNextTrackingNumber();
}


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

*/

@Repository
public class IdGenRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Long getNextTrackingNumber() {
        return (Long) entityManager.createNativeQuery("SELECT nextval('tracking_id_gen_seq')").getSingleResult();
    }
}
