package com.bhaskara.com.My_insure_application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyInsureApplicationTests {
	@Autowired
	private PolicyController Pc;
	
	@Autowired
	private PolicyRepository PRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testregisterpolicymethod() {
		Policy policy = PRepo.save(new Policy(101,"Krishna","Personal-Insurance","23-04-2020","22-04-2025"));
		assertThat(policy.getPolicyId()).isGreaterThan(0);
	}
	
	@Test
	public void testgetdetailsmethod( ) {
		Policy policy = PRepo.save(new Policy(101,"Krishna","Personal-Insurance","23-04-2020","22-04-2025"));
		Policy policyListById = PRepo.findById(policy.getPolicyId()).get();
		assertThat(policyListById).isNotNull();
	}
	
	@Test
	public void testgetalllistmethod() {
		Policy policy = new Policy(101,"Krishna","Personal-Insurance","23-04-2020","22-04-2025");
		Policy policy1 = new Policy(102,"Teja","Car-Insurance","23-04-2022","22-04-2027");
		Iterable<Policy> policyalllist = PRepo.findAll();
		assertThat(policyalllist).isNotNull();
		assertThat(policyalllist.iterator()).isNotEqualTo(2);
	}
	
	@Test
	public void testupdatemethod() {
		Policy policy = new Policy(101,"Krishna","Personal-Insurance","23-04-2020","22-04-2025");
		Policy savedPolicy = PRepo.findById(policy.getPolicyId()).get();
		savedPolicy.setValidFrom("23-06-2020");
		savedPolicy.setValidThru("23-06-2025");
		Policy updatedetails = PRepo.save(savedPolicy);
		assertThat(updatedetails.getValidFrom()).isEqualTo("23-06-2020");
		assertThat(updatedetails.getValidThru()).isEqualTo("23-06-2025");
		
	}
	
	@Test
	public void testdeletemethod() {
		Policy policy = new Policy(101,"Krishna","Personal-Insurance","23-04-2020","22-04-2025");
		PRepo.deleteById(policy.getPolicyId());
		Optional<Policy> optionalpolicy = PRepo.findById(policy.getPolicyId());
		assertThat(optionalpolicy).isEmpty();
	}
	
	
}
