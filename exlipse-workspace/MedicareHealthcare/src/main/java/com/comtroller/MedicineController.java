package com.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Medicine;
import com.service.MedicineService;

@RestController
public class MedicineController {
	
	@Autowired
	MedicineService medicineService;
	
	@PostMapping("/addMed")
	public Medicine addMedicine(@RequestBody Medicine medicine) {
		return medicineService.addMedicine(medicine);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/findById/{id}")
	public Medicine findMedicineById(@PathVariable ("id") long id) {
		return medicineService.findMedicineById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/findByName/{name}")
	public Medicine findMedicineByName(@PathVariable ("name") String name){
		return medicineService.findMedicineByName(name);	
	}
	
	@GetMapping("/findByBrand/{brand}")
	public List<Medicine> findMedicineByBrand(@PathVariable ("brand") String brand) {
		return medicineService.findMedicineByBrand(brand);
	}
	
	@GetMapping("/findByCategory/{category}")
	public Medicine findMedicineByCategory(@PathVariable ("category") String category) {
		return medicineService.findMedicineByCategory(category);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/findAll")
	public List<Medicine> findAllMedicine(){
		return medicineService.findAllMedicine();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update/{id}")
	public Medicine updateMedicineById(@PathVariable ("id") long id, @RequestBody Medicine medicine) {
		return medicineService.updateMedicineById(id, medicine);
	}
	
	@DeleteMapping("/deleteMedicine/{id}")
	public String removeMedicine(@PathVariable ("id") long id) {
		return medicineService.removeMedicine(id);
	}

}
