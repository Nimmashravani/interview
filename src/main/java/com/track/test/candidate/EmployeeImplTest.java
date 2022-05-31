package com.track.test.candidate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.track.entity.Employee;
import com.track.repository.EmployeeRepository;
import com.track.serviceimpl.EmployeeServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeImplTest {
	@Autowired
	public EmployeeServiceImpl employeeServiceImpl;

	@MockBean
	private EmployeeRepository employeeRepo;

	@Test
	public void registerEmployee() {

		Employee employee = new Employee();

		employee.setUserId(3);
		employee.setName("shravani");
		employee.setGender("female");

		employee.setUserName("gunnu");
		employee.setPassword("1234");

		employee.setType("hr");
      employee.setLocation("siddipet");
      employee.setPanelMember(true);
		Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
		assertThat(employeeServiceImpl.registerEmployee(employee)).isEqualTo(employee);
	}

	/*@Test
	public void throwExceptionWhenUserIdNotFound() {
	    int id = anyInt();
	    when(employeeRepo.findById(id)).thenReturn(Optional.empty());
	    assertThatAnExceptionWasThrown(String.format("Quarter does not exist for id = %s!", id));
	}*/
	
	private void assertThatAnExceptionWasThrown(String format) {
		
	}

	@Test
	public void searchEmployee() {

		Employee employee = new Employee();

		employee.setUserId(3);
		employee.setName("shravani");
		employee.setGender("female");

		employee.setUserName("gunnu");
		employee.setPassword("1234");

		employee.setType("hr");
		employee.setLocation("siddipet");
		employee.setPanelMember(true);

		Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
		assertThat(employeeServiceImpl.searchEmployee(employee.getUserId())).isEqualTo(employee);

	}

	@Test
	public void deleteEmployee() {

		Employee employee = new Employee();

		employee.setUserId(3);
		employee.setName("shravani");
		employee.setGender("female");

		employee.setUserName("gunnu");
		employee.setPassword("1234");

		employee.setType("hr");

		employee.setLocation("siddipet");
		employee.setPanelMember(true);

		Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
		assertThat(employeeServiceImpl.deleteEmployee(employee.getUserId())).isEqualTo(employee);

	}

}