SELECT MAX(salary) as SecondHighestSalary
FROM Employee as emp1
WHERE salary < (SELECT max(salary) FROM Employee as emp2)