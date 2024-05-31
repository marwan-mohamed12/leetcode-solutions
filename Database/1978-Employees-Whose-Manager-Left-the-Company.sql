# Write your MySQL query statement below
SELECT employee_id 
from Employees 
WHERE salary < 30000 
AND manager_id NOT IN (select employee_id from Employees)
ORDER BY employee_id;