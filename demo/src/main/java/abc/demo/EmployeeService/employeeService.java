package abc.demo.EmployeeService;

import java.util.*;

import org.springframework.stereotype.Service;

import abc.demo.entity.*;

@Service

public class employeeService {
    List<Employee> list;

    public List<Employee> getEmployeeData() {
        return list;
    }

    public employeeService() {
        list = new ArrayList<>();
        list.add(new Employee(3107, "Srajan", 25000));
        list.add(new Employee(3108, "ABCD", 0));
        list.add(new Employee(300, "def", 1000));
    }

    /**
     * @param employeeId
     * @return
     */
    public Employee getEmployeeData(long employeeId) {
        Employee ans = null;
        for (int i = 0; i < list.size(); i++) {
            Employee e = list.get(i);
            if (e.getEmployeeId() == employeeId) {
                ans = e;
                break;
            }
        }
        return ans;
    }

    public void addEmployee(Employee e) {
        list.add(e);
    }

    public void updateEmployee(Long givenId, Employee e) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmployeeId() == givenId) {
                list.get(i).setEmployeeId(e.getEmployeeId());
                list.get(i).setName(e.getName());
                list.get(i).setSalary(e.getSalary());
            }
        }
    }

    public void deleteEmployee(long givenId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmployeeId() == givenId) {
                list.remove(i);
                break;
            }
        }
    }
}
