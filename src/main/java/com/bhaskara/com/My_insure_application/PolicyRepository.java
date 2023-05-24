package com.bhaskara.com.My_insure_application;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends CrudRepository<Policy,Integer>{

}
