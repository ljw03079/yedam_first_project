insert into patient(patient_id, patient_name, patient_gender, patient_resident_number, patient_age, employee_num)
values (1, '홍길동', '남', '001225-345678', 20, 1);
delete from patient;

rollback;

commit;

insert into chart (disease, doctor_charts, employee_num, patient_id)
values ('nacolapsy','기면증',1,1);

select * from employee;
select * from patient;

ALTER TABLE treatment
ADD FOREIGN KEY (patient_id)
REFERENCES patient (patient_id)
ON DELETE CASCADE;

SELECT * FROM PATIENT
JOIN CHART ON PATIENT.PATIENT_ID = CHART.PATIENT_ID
WHERE patient.PATIENT_ID = 1;

SELECT EMPLOYEE.EMPLOYEE_NAME FROM EMPLOYEE
	JOIN PATIENT ON EMPLOYEE.EMPLOYEE_NUM = PATIENT.EMPLOYEE_NUM
	WHERE PATIENT.PATIENT_ID = 1;