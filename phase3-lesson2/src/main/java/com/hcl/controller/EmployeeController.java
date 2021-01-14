package com.hcl.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.Employee;
import com.service.EmployeeService;


//@RestController
@RestController
//@SessionAttributes("first")
public class EmployeeController {
	
	
//	@Autowired
//	private EmpRepository repo;//all crud operations;

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/listemp")
	public List<Employee> listEmp() {
		//List<Employee> allemps = (List<Employee>) repo.findAll();
		List<Employee> allemps = (List<Employee>) service.findAllEmployees();
		//return new ModelAndView("emps", "employees", allemps);
		return allemps;
		
	}
	
	@PostMapping("/addemp")
	public ModelAndView newEmp(Employee emp) {
		//repo.save(emp);
		service.saveEmployee(emp);
		return new ModelAndView("redirect:/listemp");
	}
	
	@GetMapping("/addemp")
	public ModelAndView addnewEmp() {
		
		Employee e1 = new Employee();
		return new ModelAndView("newemp", "form", e1);  //model attribure<form:form modelAttribute="form">
	}
	@PostMapping("/checkid")
	public ModelAndView checkIdPost(@ModelAttribute("emp") Employee emp) {
		try {
			//Employee e = repo.findById(emp.getId()).get();
			Employee e = service.findEmployeeById(emp.getId()).get();
			return new ModelAndView("correctview","correctemp", e);
		} catch(Exception e) {
			return new ModelAndView("wrong");
		}
		
		//return new ModelAndView("wrong");
	}
	
	@GetMapping("/checkid")
	public ModelAndView checkIdGet() {
		
		Employee e1 = new Employee();
		return new ModelAndView("checkidform", "form", e1);  //model attribure<form:form modelAttribute="form">
	}

	
	@GetMapping("/editemp/{id}")
    public ModelAndView editCustomerForm(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("editform");
        System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        try {
        //Employee emp =  repo.findById(id).get();
        Employee emp = service.findEmployeeById(id).get();
        System.out.println("afterrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        System.out.println("emp is: ==============" + emp);
        //if( emp == null ) {
        	//return new ModelAndView("wrong", "employees", emp);
        //}else {
        	mav.addObject("editemp", emp);
        //}
        
        } catch(Exception e) {
            System.out.println("catchhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");

        	return new ModelAndView("wrong");
        }
        return mav;
    }

    @PostMapping("/editemp/{id}")
    public ModelAndView editsaveEmp(@ModelAttribute("emp") Employee emp) {
//        if(emp == null) {
//        	System.out.println("hereeeeee");
//        	return ("redirect:/wrong");
//        }
    	
        //repo.save(emp);
    	service.saveEmployee(emp);
        return new ModelAndView("redirect:/listemp");
       }
    
    @PostMapping("/wrong")
    public String editsaveEmp2(@ModelAttribute("emp") Employee emp) {
    	return ("redirect:/wrong");
    }
    
	
    
    @GetMapping("/deleteemp/{id}")
    public ModelAndView deleteCustomerForm(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("deleteform");
        //Employee emp =  repo.findById(id).get();
        Employee emp = service.findEmployeeById(id).get();
        mav.addObject("deleteemp", emp);
    
        return mav;
    }

    @PostMapping("/deleteemp/delete")
    public ModelAndView deleteSaveEmp(@ModelAttribute("emp") Employee emp) {
        
        //repo.delete(emp);
    	service.deleteEmployee(emp);
        return new ModelAndView("redirect:/listemp");
       }
	
	

	
}
