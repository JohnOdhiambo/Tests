SELECT task_name,SUM(grade)/3 as average_grade
 from survey
  --where average_grade >= 3
GROUP BY task_name
HAVING COUNT(task_name) >= 3