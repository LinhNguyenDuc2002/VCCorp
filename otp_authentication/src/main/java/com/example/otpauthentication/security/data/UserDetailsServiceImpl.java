package com.example.otpauthentication.security.data;

import com.example.otpauthentication.entity.Employee;
import com.example.otpauthentication.entity.EmployeeRole;
import com.example.otpauthentication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("Username is not found");
                });

        List<EmployeeRole> employeeRoles = employee.getEmployeeRoleCollection().stream().toList();

        return new User(
                employee.getUsername(),
                employee.getPassword(),
                employee.getTblDepartmentid().getId(),
                employeeRoles.stream().map(EmployeeRole::getRole).toList()
        );
    }
}
