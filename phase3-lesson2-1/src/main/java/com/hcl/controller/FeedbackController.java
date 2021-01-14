package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.Feedback;
import com.service.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService service;

	@GetMapping("/listfb")
	public List<Feedback> listfb() {
		// List<Employee> allemps = (List<Employee>) repo.findAll();
		List<Feedback> allfbs = (List<Feedback>) service.findAllFeedbacks();
		// return new ModelAndView("emps", "employees", allemps);
		return allfbs;
	}

	@GetMapping("/addfb")
	public ModelAndView addnewFb() {

		Feedback f1 = new Feedback();
		// return new ModelAndView("newemp", "form", e1); //model attribure<form:form
		// modelAttribute="form">
		return new ModelAndView("newfb", "form", f1);
	}

	@PostMapping("/addfb")
	public ModelAndView newFb(Feedback fb) {
		// repo.save(emp);
		service.saveFeedback(fb);
		// return new ModelAndView("redirect:/listemp");
		return new ModelAndView("redirect:/listfb");
	}

	@GetMapping("/checkid")
	public ModelAndView checkIdGet() {

		Feedback f1 = new Feedback();
		return new ModelAndView("checkidform", "form", f1); // model attribure<form:form modelAttribute="form">
	}

	@PostMapping("/checkid")
	public ModelAndView checkIdPost(@ModelAttribute("fb") Feedback fb) {
		try {
			// Employee e = repo.findById(emp.getId()).get();
			Feedback f = service.findFeedbackById(fb.getId()).get();
			return new ModelAndView("correctview", "correctfb", f);
		} catch (Exception e) {
			return new ModelAndView("wrong");
		}

		// return new ModelAndView("wrong");
	}

	@GetMapping("/editfb/{id}")
	public ModelAndView editFeedbackForm(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("editform");
		try {
			Feedback fb = service.findFeedbackById(id).get();
			mav.addObject("editfb", fb);

		} catch (Exception e) {
			return new ModelAndView("wrong");
		}
		return mav;
	}

	@PostMapping("/editfb/{id}")
	public ModelAndView editsaveFb(@ModelAttribute("fb") Feedback fb) {

		service.saveFeedback(fb);
		return new ModelAndView("redirect:/listfb");
	}

	@PostMapping("/wrong")
	public ModelAndView editsaveFb2(@ModelAttribute("fb") Feedback fb) {
		return new ModelAndView("redirect:/wrong");
	}

	@GetMapping("/deletefb/{id}")
	public ModelAndView deleteCustomerForm(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("deleteform");
		// Employee emp = repo.findById(id).get();
		try {
		Feedback fb = service.findFeedbackById(id).get();
		mav.addObject("deletefb", fb);
		} catch(Exception e) {
			return new ModelAndView("wrong");
		}
		return mav;
	}

	@PostMapping("/deletefb/delete")
	public ModelAndView deleteSaveEmp(@ModelAttribute("fb") Feedback fb) {

		// repo.delete(emp);
		service.deleteFeedback(fb);
		return new ModelAndView("redirect:/listfb");
	}

}
