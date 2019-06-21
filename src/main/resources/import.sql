INSERT INTO MEMBERS (memberid, firstname, lastname) VALUES (1, 'Owen', 'Miller');
INSERT INTO MEMBERS (memberid, firstname, lastname) VALUES (2, 'Karishma', 'Patel');
INSERT INTO MEMBERS (memberid, firstname, lastname) VALUES (3, 'Jack', 'Flanagen');
INSERT INTO MEMBERS (memberid, firstname, lastname) VALUES (4, 'Matt', 'Hunt');
INSERT INTO MEMBERS (memberid, firstname, lastname) VALUES (5, 'Chester', 'Gardner');

INSERT INTO INSTRUCTORS (instructorid, firstname, lastname) VALUES (1,'Josh','Brooks');
INSERT INTO INSTRUCTORS (instructorid, firstname, lastname) VALUES (2,'Marc','Parington');
INSERT INTO INSTRUCTORS (instructorid, firstname, lastname) VALUES (3, 'Rich', 'Harris');
INSERT INTO INSTRUCTORS (instructorid, firstname, lastname) VALUES (4,'Harry','Buck');

INSERT INTO CLASSES (classid, classname, instructors_instructorid) VALUES (1, 'HIIT', 2);
INSERT INTO CLASSES (classid, classname, instructors_instructorid) VALUES (2, 'Zumba', 1);
INSERT INTO CLASSES (classid, classname, instructors_instructorid) VALUES (3, 'Insanity', 3);
INSERT INTO CLASSES (classid, classname, instructors_instructorid) VALUES (4, 'Balletfit', 2);