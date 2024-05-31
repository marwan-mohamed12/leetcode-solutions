# Write your MySQL query statement below
SELECT e1.name
FROM Employee as e1 join Employee as e2
ON e1.id = e2.managerId
GROUP BY e2.managerID
HAVING count(e2.managerId) >= 5;