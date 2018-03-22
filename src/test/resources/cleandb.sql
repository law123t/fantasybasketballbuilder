DELETE FROM test_basketball.user_team;
DELETE FROM test_basketball.user_roles;
DELETE FROM test_basketball.users;
DELETE FROM test_basketball.center;
DELETE FROM test_basketball.point_guard;
DELETE FROM test_basketball.power_forward;
DELETE FROM test_basketball.small_forward;
DELETE FROM test_basketball.shooting_guard;
USE test_basketball;
INSERT INTO `point_guard` VALUES (1,'Russel','Westbrook',2558,840,864,132,31,438),(1,'Stephen','Curry',1999,524,353,142,17,239);
INSERT INTO 'shooting_guard' VALUES(1,'James','Harden',2356,907,659,121,38,464),(1,'DeMar','DeRozan',2020,290,386,78,13,180);
INSERT INTO 'small_forward' VALUES (1,'Lebron','James',1954,646,639,92,44,303),(1,'Kawhi','Leonard',1376,260,430,133,55,154);
INSERT INTO 'power_forward' VALUES (1,'Anthony','Davis',2099,157,884,94,167,181);
INSERT INTO 'center' VALUES (1,'Karl','Anthony Towns',805,220,1007,56,103,212);
INSERT INTO `users` VALUES (1,'admin','admin','John','Smith','smith@john.com'), (2,'admin2','admin2','Tim','Jim','Jim@Tim.com'), (3,'User','User','Beth','Seth','seth@beth.com');
INSERT INTO `user_roles` VALUES (1,'administrator', 1),(2,'administrator', 2),(3,'user', 3);
INSERT INTO `user_team` VALUES (1,'Team One',1,2,3,4,5,1);

