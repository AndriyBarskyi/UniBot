package com.example.unibot;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.unibot.service.DepartmentService;
import com.example.unibot.service.UniversityService;

@Component
public class AppRunner implements CommandLineRunner {
    public static final String SHOW_HEAD_OF_DEP = "Who is head of department";
    public static final String SHOW_AVERAGE_SALARY =
        "Show the average salary for the department";
    public static final String SHOW_EMPLOYEE_COUNT =
        "Show count of employee for";
    public static final String GLOBAL_SEARCH_BY = "Global search by";
    private static final String HELP = "List of available commands:\n"
        + "Who is head of department {department_name}\n"
        + "Show {department_name} statistics\n"
        + "Show the average salary for the department {department_name}\n"
        + "Show count of employee for {department_name}\n"
        + "Global search by {template}\n"
        + "    or enter \"q\" to quit";
    private static final String DEFAULT_MESSAGE =
        "Incorrect input! Type in \"Help\" to see the instructions.";
    private final DepartmentService departmentService;
    private final UniversityService universityService;

    @Autowired
    public AppRunner(DepartmentService departmentService,
        UniversityService universityService) {
        this.departmentService = departmentService;
        this.universityService = universityService;
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

        String data;
        System.out.println(HELP);
        while (!(data = reader.readLine()).equalsIgnoreCase("q")) {
            String firstPart = data.lastIndexOf(" ") > 1 ?
                data.substring(0, data.lastIndexOf(" ")) : "";
            String lastWord = data.lastIndexOf(" ") > 1 ?
                data.substring(data.lastIndexOf(" ") + 1) : "";

            if (data.startsWith("Show ") && data.endsWith(" statistics")) {
                System.out.println(departmentService.getDepartmentStatistics(
                    data.substring(data.indexOf(" "), data.lastIndexOf(" "))
                        .trim()));
            } else if (firstPart.equalsIgnoreCase(SHOW_HEAD_OF_DEP)) {
                System.out.println("Head of " + lastWord + " is "
                    + departmentService.getHeadOfDepartment(
                    lastWord));
            } else if (firstPart.equalsIgnoreCase(SHOW_AVERAGE_SALARY)) {
                System.out.println("The average salary of " + lastWord + " is "
                    + departmentService.getAvgSalary(lastWord));
            } else if (firstPart.equalsIgnoreCase(SHOW_EMPLOYEE_COUNT)) {
                System.out.println(
                    departmentService.getEmployeesCount(lastWord));
            } else if (firstPart.equalsIgnoreCase(GLOBAL_SEARCH_BY)) {
                System.out.println(universityService.globalSearchBy(lastWord));
            } else if (data.equalsIgnoreCase("help")) {
                System.out.println(HELP);
            } else {
                System.out.println(DEFAULT_MESSAGE);
            }
        }
    }
}
