-- You can use this file to load seed data into the database using SQL statements
insert into Task (id, title, text, date, priority, done) values (0, 'First task', 'Do this homework for Ysoft', sysdate, 1, true); 
insert into Task (id, title, text, date, priority, done) values (1, 'Second task', 'Eat', sysdate, 3, false);
insert into Task (id, title, text, date, priority, done) values (3, 'Third task', 'Sleep', sysdate, 5, false);