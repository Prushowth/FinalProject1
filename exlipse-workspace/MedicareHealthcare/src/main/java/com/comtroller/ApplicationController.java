package com.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Medicine;
import com.service.MedicineService;

@RestController
@RequestMapping("/api")
public class ApplicationController {
	
	@Autowired
	MedicineService medicineService;
	
	@GetMapping("/index")
	public String indexpage(Model model ) {
		List<Medicine> med = medicineService.findAllMedicine();
		model.addAttribute("medicineList", med);
		return "index";
	}
	
	@PostMapping()
	public ResponseEntity<?> addUserCartItem(){
		return null;
		
	}

}
