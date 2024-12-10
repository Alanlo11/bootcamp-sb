- SQL
  - DQL(Data Query Language)
    - SELECT - Alias(give a table / column a Temporary name)
    - WHERE
      - = , > , < ,>= , <= , <>
      - AND , OR , NOT
      - BETWEEN
      - LIKE
      - IN
      - ANY
      - ALL
      - EXISTS
    - ORDER BY
      - ASC
      - DESC
    - GROUP BY
      - HAVING
    - JOIN
      - LEFT JOIN
      - INNER JOIN 
      - RIGHT JOIN
      - FULL JOIN 
    - UNION , UNION ALL
    - Functions
      - AVG()
      - SUM()
      - COUNT()
      - MIN()
      - MAX()
    - Logics
      - IF : SELECT IF(500<1000 , "YES" , "NO")
      - CASE WHEN : 
        SELECT Name , Sex ,
          CASE 
            WHEN age >= 65 THEN 'Elderly'
            ELSE 'Not Elderly'
          END as Age Group
        FROM Peoples;
    - Window Function
      - OVER()
      - ROW_NUMBER()
      - RANK()
  - DML(Data Manipulation Language)
    - INSERT
    - UPDATE
    - DELETE
  - DDL(Data Definition Language)
    - CREATE
      - TABLE
      - DATABASE
      - SCHEMA
      - VIEW
    - ALTER
      - TABLE
        - ADD 
        - RENAME
        - MODIFY
        - DROP
        - ALTER COLUMN
    - DROP
      - TABLE
      - VIEW
      - DATABASE
      - INDEX
    - TRUNCATE
      - TABLE
  - DCL(Data Control Language)
    - GRANT
    - REVOKE 