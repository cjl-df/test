use db_example;

create TABLE IF NOT EXISTS `salary`(
    `id` INT(16) UNSIGNED UNIQUE not null,
    `name` varchar(16),
    `sex` varchar(1),
    `salary` int(16),
    primary key(id)
);

INSERT INTO salary (
    `id`,
    `name`,
    `sex`,
    `salary`
)
VALUES
(4,'li','f',2333),
(5,'li1','m',2333),
(6,'li2','f',2333);

select * from salary;

UPDATE salary
SET
    sex = CASE sex
        WHEN 'm' THEN 'f'
        ELSE 'm'
    END;

select * from salary;