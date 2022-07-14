DROP DATABASE IF EXISTS Student_Management_System;
CREATE DATABASE IF NOT EXISTS Student_Management_System;
USE  Student_Management_System;

DROP TABLE IF EXISTS Student;
CREATE TABLE IF NOT EXISTS Student(
                                      student_id VARCHAR(45),
                                      student_name VARCHAR(45),
                                      email TEXT,
                                      contact VARCHAR(20),
                                      address TEXT,
                                      nic VARCHAR(45),
                                      CONSTRAINT PRIMARY KEY (student_id)
);

DROP TABLE IF EXISTS Teacher;
CREATE TABLE IF NOT EXISTS Teacher(
                                      teacher_id VARCHAR(45),
                                      name VARCHAR(45),
                                      nic VARCHAR(45),
                                      contact VARCHAR(45),
                                      address TEXT,
                                      CONSTRAINT PRIMARY KEY (teacher_id)
);

DROP TABLE IF EXISTS Subject;
CREATE TABLE IF NOT EXISTS Subject(
                                      subject_id VARCHAR(45),
                                      subject_name VARCHAR(45),
                                      credit DOUBLE,
                                      teacher_id VARCHAR(45),
                                      CONSTRAINT PRIMARY KEY (subject_id),
                                      CONSTRAINT FOREIGN KEY (teacher_id) REFERENCES Teacher (teacher_id)
                                          ON DELETE CASCADE ON UPDATE CASCADE

);


DROP TABLE IF EXISTS Course;
CREATE TABLE IF NOT EXISTS Course(
                                     course_id VARCHAR(45),
                                     course_name VARCHAR(45),
                                     cost DOUBLE,
                                     duration VARCHAR(45),
                                     subject_id VARCHAR(45),
                                     CONSTRAINT PRIMARY KEY (course_id),
                                     CONSTRAINT FOREIGN KEY (subject_id) REFERENCES Subject (subject_id)
                                         ON DELETE CASCADE ON UPDATE CASCADE

);




DROP TABLE IF EXISTS Intake;
CREATE TABLE IF NOT EXISTS Intake(
                                     intake_id VARCHAR(45),
                                     start_date DATE,
                                     description VARCHAR(45),
                                     course_id VARCHAR(45),
                                     CONSTRAINT PRIMARY KEY (intake_id),
                                     CONSTRAINT FOREIGN KEY (course_id) REFERENCES Course (course_id)
                                         ON DELETE CASCADE ON UPDATE CASCADE

);



DROP TABLE IF EXISTS Registration;
CREATE TABLE IF NOT EXISTS Registration(
                                           registration_id VARCHAR(45),
                                           reg_date DATE,
                                           student_id VARCHAR(45),
                                           intake_id VARCHAR(45),
                                           CONSTRAINT PRIMARY KEY (registration_id),
                                           CONSTRAINT FOREIGN KEY (student_id) REFERENCES Student (student_id)
                                               ON DELETE CASCADE ON UPDATE CASCADE,
                                           CONSTRAINT FOREIGN KEY (intake_id) REFERENCES Intake (intake_id)
                                               ON DELETE CASCADE ON UPDATE CASCADE

);



DROP TABLE IF EXISTS Payment;
CREATE TABLE IF NOT EXISTS Payment(
                                      payment_id VARCHAR(45),
                                      date DATE,
                                      cost DOUBLE,
                                      registration_id VARCHAR(45),
                                      CONSTRAINT PRIMARY KEY (payment_id),
                                      CONSTRAINT FOREIGN KEY (registration_id) REFERENCES Registration (registration_id)
                                          ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Student VALUES ( 'S00-001','bhashana','majindrabhashana@gmail.com','0714589935','Kegalle','991852158V');
INSERT INTO Student VALUES ( 'S00-002','Nirmal','Nirmal@gmail','0702458625','kelaniya','981546547V');
INSERT INTO Student VALUES ( 'S00-003','gamini','gamini@gmail.com','0745896584','Kandy','990874567V');
INSERT INTO Student VALUES ( 'S00-004','upali','upali@gmail.com','0745858584','panadura','992586578V');
INSERT INTO Student VALUES ( 'S00-005','gota','gota@gmail.com','0745896857','polonnaruwa','998754465V');

INSERT INTO Teacher VALUES ('T00-001','deeoa','658957541','0713044885','Kegalle');
INSERT INTO Teacher VALUES ('T00-002','kumudini','658957542','0713044886','Colombo');
INSERT INTO Teacher VALUES ('T00-003','mala','658957543','0713044882','Dambulla');
INSERT INTO Teacher VALUES ('T00-004','geetha','658957544V','0713044883','Kadawatha');
INSERT INTO Teacher VALUES ('T00-005','saman','658957548V','0713044884','mulathiw');


INSERT INTO Subject VALUES ('SU-001','Prf',1000,'T00-001');
INSERT INTO Subject VALUES ('SU-002','Dbms',1500,'T00-002');
INSERT INTO Subject VALUES ('SU-003','OOP',2000,'T00-003');
INSERT INTO Subject VALUES ('SU-004','Layered Architecture',3000,'T00-004');
INSERT INTO Subject VALUES ('SU-005','Hibernate',4000,'T00-005');

INSERT INTO Course VALUES ('C00-001','GDSE',15000,'Three_years','SU-001');
INSERT INTO Course VALUES ('C00-002','CMJD',50000,'Three_years','SU-002');
INSERT INTO Course VALUES ('C00-003','Master',20000,'Three_years','SU-003');

INSERT INTO Intake VALUES ('IN-001','2022-06-10','Start','C00-001');
INSERT INTO Intake VALUES ('IN-002','2022-06-15','Start','C00-001');
INSERT INTO Intake VALUES ('IN-003','2022-06-20','Start','C00-002');
INSERT INTO Intake VALUES ('IN-004','2022-06-25','Start','C00-001');
INSERT INTO Intake VALUES ('IN-005','2022-07-10','Start','C00-003');

INSERT INTO Registration VALUES ('R00-001','2022-06-10','S00-001','IN-001');

INSERT INTO Payment VALUES ('P00-001','2022-06-15',5000,'R00-001');