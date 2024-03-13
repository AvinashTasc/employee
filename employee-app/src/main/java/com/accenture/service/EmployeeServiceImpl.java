package com.accenture.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.accenture.dao.EmployeeDao;
import com.accenture.entity.EmployeeEntity;
import com.accenture.model.EmployeeModel;

//@Component
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao empDao;
	
	
	@Override
	public int insertEmployee(EmployeeModel pm) {
		
		///convert model into entity
		//option 1 : manually convert model into entity
		//EmployeeEntity pe = new EmployeeEntity();
		//pe.setEmpId(pm.getEmpId());
		//pe.setEmpName(pm.getEmpName());
		//pe.setPrice(pm.getPrice());
		//pe.setQuantity(pm.getQuantity());
		
		//option 2: copy properties automatically
		EmployeeEntity pe = new EmployeeEntity();
		BeanUtils.copyProperties(pm, pe);
		
		EmployeeEntity addedEmployeeEntity = empDao.save(pe);
		if(addedEmployeeEntity == null) {
			//failed
			return -1;
		}else {
			//success
			return addedEmployeeEntity.getEmpId();
		}
	}


	@Override
	public List<EmployeeModel> printEmployees() {
		List<EmployeeEntity> allEmployeeEntities = empDao.findAll();
		//convert list of employeeentity to list of employeemodel
		
		List<EmployeeModel> allEmployeeModel = new ArrayList<EmployeeModel>();
		for(EmployeeEntity pe: allEmployeeEntities) {
			EmployeeModel pm = new EmployeeModel();
			BeanUtils.copyProperties(pe, pm);
			allEmployeeModel.add(pm);		
		}	
		return allEmployeeModel;
	}


	@Override
	public void removeEmployee(int empId) {
		empDao.delete(empId);
	}


	@Override
	public EmployeeModel getEmployeeById(int empId) {
		EmployeeEntity empEntity = empDao.findOne(empId);
		
		//convert employee entity into employee model
		EmployeeModel empModel = new EmployeeModel();
		BeanUtils.copyProperties(empEntity, empModel);
		return empModel;
	}


	@Override
	public int modifyEmployee(EmployeeModel pm) {
		EmployeeEntity pe = new EmployeeEntity();
		BeanUtils.copyProperties(pm, pe);
		
		EmployeeEntity updatedEmployeeEntity = empDao.save(pe);
		if(updatedEmployeeEntity == null) {
			//failed
			return -1;
		}else {
			//success
			return updatedEmployeeEntity.getEmpId();
		}
	}
	
	@Override
    public List<EmployeeModel> sortEmployeesBySalary() {
        List<EmployeeModel> allEmployees = printEmployees();
        allEmployees.sort(Comparator.comparingDouble(EmployeeModel::getSalary));
        return allEmployees;
    }

}












