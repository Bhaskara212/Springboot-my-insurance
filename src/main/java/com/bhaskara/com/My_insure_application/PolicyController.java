package com.bhaskara.com.My_insure_application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {
	
	@Autowired
	  private PolicyRepository PRepo;
	
	  
	   @RequestMapping(value="/createpolicy",method=RequestMethod.GET)
	   public Policy createpolicy() {
		   Policy policy = new Policy(001,"Bhakara","Car-Insurance","23-02-2023","22-02-2028");
		   Policy savedPcy = PRepo.save(policy);
		   return savedPcy;
		   
	   }
	   
	   @RequestMapping(value="/registerpolicy",method=RequestMethod.POST)
	   public Policy registerpolicy(@RequestBody Policy policy) {
		   Policy savedPcy = PRepo.save(policy);
		   return savedPcy;
	   }
	   
	   @RequestMapping(value="/getdetails/{policyId}",method=RequestMethod.GET)
	   public Policy getdetails(@PathVariable(value="policyId")int policyId) {
		   return PRepo.findById(policyId).get();
	   }
	   
	   @RequestMapping(value={"/getalllist","/"},method=RequestMethod.GET)
	   public Iterable<Policy> getalllist(){
		   return PRepo.findAll();
		   
	   }
	   
	   @RequestMapping(value="/update/{policyId}",method=RequestMethod.PUT)
	   public ResponseEntity<Object> update(@RequestBody Policy policy,@PathVariable int policyId){
		   Optional<Policy> policyoptional =PRepo.findById(policyId);
		   if (policyoptional.isEmpty())
			   return ResponseEntity.notFound().build();
		   policy.setPolicyId(policyId);
		   PRepo.save(policy);
		   return ResponseEntity.noContent().build();
		   
	   }
	   
	   @RequestMapping(value="/delete/{policyId}",method=RequestMethod.DELETE)
	   public void delete(@PathVariable int policyId) {
		  PRepo.deleteById(policyId);
	   }
		

}
