-- Implement your solution here
SELECT experience AS exp,
(SELECT DISTINCT GREATEST (sql, algo, bug_fixing)
FROM assessments WHERE sql = 100 OR algo = 100 OR bug_fixing = 100 ) AS max,
COUNT(experience) from assessments

GROUP BY experience
ORDER BY experience DESC;

--SELECT COUNT(*) from assessments
--WHERE GREATEST(sql, algo, bug_fixing) = 100

exp max count
5   2   3
3   0   1
1   1   1

1yr  100,null, 100

2yrs Null,50,100

3yrs Null,Null,100

4yrs null 50 100

5yrs 100 Null 100
5yrs null 50 Null
5yrs 100 100 100


