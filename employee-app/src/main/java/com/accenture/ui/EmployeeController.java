package com.accenture.ui;

import java.util.List;

import javax.jws.WebParam.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.model.EmployeeModel;
import com.accenture.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService ps;
	
	@RequestMapping(value = "/index.html")
	public String getIndexPage() {
		return "index";			// it will return /WEB-INF/myviews/index.jsp
	}
	
	@RequestMapping(value = "/showEmployeeForm.html")
	public ModelAndView showEmployeeForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("empModel", new EmployeeModel());
		mv.setViewName("add-employee");				// it will return /WEB-INF/myviews/add-employee.jsp
		return mv;
	}
	
	@RequestMapping(value = "/add-employee.html", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("empModel") EmployeeModel employee) {
		int addedId = ps.insertEmployee(employee);
		ModelAndView mv = new ModelAndView();		
		if(addedId == -1) {
			mv.addObject("msgForAdd", "could not add record in db");
			mv.setViewName("index");
			return mv;
		}else {
			mv.addObject("msgForAdd", "successfully added employee in db and id is : "+ addedId);
			mv.setViewName("redirect:getAllEmployees.html");
			return mv;
		}
	}
	
	@RequestMapping(value = "/getAllEmployees.html")
	public ModelAndView displayEmployees(){
		List<EmployeeModel> allEmployee = ps.printEmployees();
		ModelAndView mv = new ModelAndView();
		mv.addObject("listOfEmployees", allEmployee);
		mv.setViewName("all-employee");
		return mv;
	}
	
	@RequestMapping(value = "/deleteEmployee.html")
	public ModelAndView deleteEmployee(@RequestParam int empId ) {
		ps.removeEmployee(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("msgForDelete", "successfully deleted employee from db");
		mv.setViewName("redirect:getAllEmployees.html");
		return mv;
	}
	
	@RequestMapping(value = "/showEmployeeDetails.html")
	public ModelAndView showUpdateForm(@RequestParam int empId) {
		EmployeeModel employee = ps.getEmployeeById(empId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("update-employee");
		mv.addObject("emp", employee);
		
		return mv;
	}
	
	@RequestMapping(value = "/makeUpdate.html")
	public ModelAndView updateEmployee(@ModelAttribute("emp") EmployeeModel emp) {
		//here will make update operation
		int updatedEmpId = ps.modifyEmployee(emp);
		ModelAndView mv = new ModelAndView();		
		if(updatedEmpId == -1) {
			mv.addObject("msgForUpdate", "could not update record from db");
			mv.setViewName("index");
			return mv;
		}else {
			mv.addObject("msgForUpdate", "successfully updates employee from db and id is : "+ updatedEmpId);
			mv.setViewName("redirect:getAllEmployees.html");
			return mv;
		}
	}
	@RequestMapping(value = "/sortEmployeesBySalary.html")
    public ModelAndView sortEmployeesBySalary() {
        List<EmployeeModel> sortedEmployees = ps.sortEmployeesBySalary();
        ModelAndView mv = new ModelAndView();
        mv.addObject("listOfEmployees", sortedEmployees);
        mv.setViewName("sorted-employees-by-salary"); 
        return mv;
    }
}
