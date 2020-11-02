use db_example;

-- Create the table in the specified schema
CREATE TABLE IF NOT EXISTS `world`
(
    `name` varchar(16) NOT NULL, -- primary key column
    `continent` varchar(16) NOT NULL,
    `area` INT(16) NOT NULL,
    `population` INT(16) NOT NULL,
    `gdp` INT(16) NOT NULL,    
    PRIMARY KEY ( `name` )
);

-- Insert rows into table 'TableName'
INSERT INTO world
( -- columns to insert data into
 name,continent, area, population,gdp
)
VALUES
( -- first row: values for the columns in the list above
 'zaz', 'Asia', 652230,25500100,20343000
),
( -- second row: values for the columns in the list above
'bab' , 'Europe', 28748,2831741,12960000      
),
( -- second row: values for the columns in the list above
'gag' , 'Europe', 28748,283,12960000      
);
-- add more rows here

alter TABLE Word RENAME TO world;

-- Select rows from a Table or View 'TableOrViewName' in schema 'SchemaName'
SELECT 
    name,population,area  
FROM 
    world
WHERE 
    area > 3000000 OR population > 25000000;	/* add search conditions here */


SELECT 
    name,population,area
FROM
    world
WHERE 
    area > 3000000
UNION
SELECT 
    name,population,area
FROM
    world
WHERE 
    population > 25000000


