# Write your MySQL query statement below

SELECT e.name, b.bonus
FROM Employee as e LEFT JOIN Bonus as b
on e.empId = b.empId
where b.bonus < 1000 OR b.bonus IS NULL;