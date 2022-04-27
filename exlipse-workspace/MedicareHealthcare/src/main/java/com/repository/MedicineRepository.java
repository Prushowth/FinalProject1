package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long>{
	
	public Medicine getByName(String name);
	public Medicine getByBrand(String brand);
	public Medicine getByCategory(String category);
}
