package com.example.ElasticSrearchImportData;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Valentin Zickner
 */
public class FlatEmployeesItemReader extends JdbcCursorItemReader<Employee> {

    public FlatEmployeesItemReader(DataSource dataSource) {
        this.setSql("select * from employees");
        this.setRowMapper(new EmployeeRowMapper());
        this.setDataSource(dataSource);
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            Employee employee = new Employee();
            employee.setEmpNo(resultSet.getInt("emp_no"));
            employee.setBirthDate(resultSet.getDate("birth_date"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setHireDate(resultSet.getDate("hire_date"));
            return employee;
        }
    }
}
