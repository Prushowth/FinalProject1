package com.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Medicine;
import com.repository.MedicineRepository;
import com.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService{
	
	@Autowired
	MedicineRepository medRepo;
	
	public Medicine addMedicine(Medicine medicine) {
		return medRepo.save(medicine);
	}
	
	public Medicine findMedicineById(long id) {
		return medRepo.getById(id);
		}
	
	public Medicine findMedicineByName(String name) {
		return medRepo.getByName(name);
	}
	
	public List<Medicine> findMedicineByBrand(String brand) {
		List<Medicine> med1 =  medRepo.findAll();
		List<Medicine> newMed = new ArrayList<>();
		for(int i = 0; i<med1.size();i++) {
			Medicine m1 = med1.get(i);
			if(m1.getBrand().equals(brand)) {
				System.out.println(m1);
				newMed.add(m1);
			}
		}
		return newMed;
	}
	
	public Medicine findMedicineByCategory(String category) {
		return medRepo.getByCategory(category);
	}
	
	public List<Medicine> findAllMedicine(){
		return medRepo.findAll();
	}
	
	public Medicine updateMedicineById(long id, Medicine medicine) {
		Optional<Medicine> op = medRepo.findById(id);
		Medicine med = op.get();
		med.setName(medicine.getName());
		med.setBrand(medicine.getBrand());
		med.setAvailableQuantity(medicine.getAvailableQuantity());
		med.setUnitPrice(medicine.getUnitPrice());
		med.setCategory(medicine.getCategory());
		return medRepo.save(med);
	}
	
	public String removeMedicine(long id) {
		medRepo.deleteById(id);
		return "The Medicine was removed successfully";
		
	}

}
