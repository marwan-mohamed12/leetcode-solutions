# Write your MySQL query statement below
SELECT r.contest_id , IFNULL( ROUND((COUNT(r.user_id) / (SELECT COUNT(user_id) from Users)) * 100, 2), 0) 
as percentage
FROM Register as r LEFT JOIN Users as u
ON r.user_id = u.user_id
GROUP BY r.contest_id
ORDER BY percentage DESC, r.contest_id ASC;