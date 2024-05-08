package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    public void punchIn_setsClockedInToTrue_punchOutSetsClockedInToFalse()
    {
        // arrange
        Employee employee = new Employee("salfahdn", "Fahd", "Tech", 40.00);

        //actions
        employee.punchIn(02.5);

        // assert
        assertTrue(employee.isClockedIn());

        //action
        employee.punchOut(10.5);

        //assert
        assertFalse(employee.isClockedIn());
    }

    @Test
    public void punchOut_ShouldCalculate_TimeWorkedCorrectly()
    {
        //arrange
        Employee employee = new Employee("salfahdn", "Fahd", "Tech", 40.00);
        double expectedTimeWorked = 8.0;

        //actions
        employee.punchIn(2.5);
        employee.punchOut(10.5);

        //Assert
        double actualTimeWorked = employee.getHoursWorked();
        assertEquals(expectedTimeWorked, actualTimeWorked);
    }

}