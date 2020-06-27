package com.jfsfeb.springmvcass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jfsfeb.springmvcass.dto.EmployeeInfoBean;
import com.jfsfeb.springmvcass.services.EmployeeServices;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeServices employeeService;

	@GetMapping("/searchEmployeeForm")
	public String dispalySearchEmployeeForm() {

		return "searchEmployee";
	}

	@GetMapping("/searchEmp")
	public String searchEmployee(@RequestParam(name = "id") int empIdVal, ModelMap modelMap) {
		EmployeeInfoBean bean = employeeService.getEmployeeByid(empIdVal);
		if (bean != null) {
			modelMap.addAttribute("empInfo", bean);
		} else {
			modelMap.addAttribute("errmsg", "Employee Details not found");

		}
		return "searchEmployee";
	}

	@GetMapping("addEmployeeForm")
	public String displayAddEmployee() {

		return "addEmployee";
	}

	@PostMapping("/addEmp")
	public String addEmployee(EmployeeInfoBean bean, ModelMap modelMap) {

		boolean isAdded = employeeService.addEmployee(bean);

		if (isAdded) {
			modelMap.addAttribute("msg", "Employee Added succesfully");

		} else {
			modelMap.addAttribute("errMsg", "Unable to Add Employee Details");
		}
		return "addEmployee";
	}

	@GetMapping("/updateEmployeeForm")
	public String dispalyUpadteEmployee() {

		return "updateEmployee";
	}

	@GetMapping("/updateEmp")
	public String updateEmployee(EmployeeInfoBean bean, ModelMap modelMap) {

		boolean updated = employeeService.updateEmployee(bean);
		if (updated) {
			modelMap.addAttribute("msg", "EmployeeDetails Updated");
		} else {
			modelMap.addAttribute("errMsg", "EmployeeDetails not Updated");
		}
		return "updateEmployee";
	}

	@GetMapping("/deleteEmployeeForm")
	public String dispalyDeleteEmployee() {

		return "deleteEmployee";
	}

	@GetMapping("/deleteEmp")
	public String deleteEmployee(int id, ModelMap modelMap) {

		boolean updated = employeeService.deleteEmployee(id);
		if (updated) {
			modelMap.addAttribute("msg", "EmployeeDetails deleted");
		} else {
			modelMap.addAttribute("errMsg", "EmployeeDetails not deleted");
		}
		return "deleteEmployee";

	}

	@GetMapping("/getAllEmployees")
	public String dispalyAllEmployee() {

		return "allEmployeeDetails";
	}

	@GetMapping("/allEmp")
	public String allEmployee(EmployeeInfoBean bean, ModelMap modelMap) {

		List<EmployeeInfoBean> bean1 = employeeService.getAllEmployees();

		if (bean1 != null && !bean1.isEmpty()) {
			modelMap.addAttribute("msg", bean1);
		} else {
			modelMap.addAttribute("errMsg", "EmployeeDetails not deleted");
		}
		return "allEmployeeDetails";

	}

	@GetMapping("/pathVar/{city}")
	public String getPathVariable(@PathVariable(name = "city") String cityName, ModelMap modelMap) {
		modelMap.addAttribute("cityName", cityName);
		return "pathVariable";
	}

	@GetMapping("/redirect")
	public String redirectReq() {
		return "redirect:http://www.youtube.com";
	}

	@GetMapping("/forward")
	public String forwardReq() {
		return "forward:/searchEmployeeForm";
	}

}