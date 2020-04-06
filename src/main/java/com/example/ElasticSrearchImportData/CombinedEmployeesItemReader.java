package com.example.ElasticSrearchImportData;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Objects;

/**
 * @author Valentin Zickner
 */
@Component
@JobScope
public class CombinedEmployeesItemReader implements ItemReader<Employee> {

    private FlatEmployeesItemReader flatEmployeesItemReader;
    private Employee lastEmployee;

    public CombinedEmployeesItemReader(@Qualifier("dataSource") DataSource dataSource) {
        this.flatEmployeesItemReader = new FlatEmployeesItemReader(dataSource);
    }

    @BeforeStep
    public void openExecutionContext(StepExecution stepExecution) {
        this.flatEmployeesItemReader.open(stepExecution.getExecutionContext());
    }

    @AfterStep
    public void closeExecutionContext() {
        this.flatEmployeesItemReader.close();
    }

    @Override
    public Employee read() throws Exception {
        lastEmployee = this.flatEmployeesItemReader.read();
        if (lastEmployee == null) {
            return null;
        }
        Employee employee = this.flatEmployeesItemReader.read();

        while (Objects.equals(lastEmployee, employee)) {
            employee = this.flatEmployeesItemReader.read();
        }

        return lastEmployee;
    }
}
