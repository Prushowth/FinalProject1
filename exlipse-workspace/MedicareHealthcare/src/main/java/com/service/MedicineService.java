package com.service;

import java.util.List;

import com.entity.Medicine;

public interface MedicineService {
	
	public Medicine addMedicine(Medicine medicine);
	
	public Medicine findMedicineById(long id);
	
	public Medicine findMedicineByName(String name);
	
	public List<Medicine> findMedicineByBrand(String brand);
	
	public Medicine findMedicineByCategory(String category);
	
	public List<Medicine> findAllMedicine();
	
	public Medicine updateMedicineById(long id, Medicine medicine) ;
	
	public String removeMedicine(long id);

}
