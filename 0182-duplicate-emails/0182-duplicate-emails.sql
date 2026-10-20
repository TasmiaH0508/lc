-- Write your PostgreSQL query statement below
SELECT email
FROM Person
GROUP BY email
HAVING COUNT(email) >= 2;