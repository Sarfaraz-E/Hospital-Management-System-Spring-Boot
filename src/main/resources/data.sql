INSERT INTO Patient (name, gender, birth_date, email, blood_group,created_at)
VALUES
    ('Sarfaraz Essa', 'MALE', '1990-05-10', 'sarfarazessa@example.com', 'O_POSITIVE', NOW()),
    ('Alishba', 'FEMALE', '1995-08-20', 'alishba@example.com', 'A_POSITIVE', NOW()),
    ('Bisharat', 'MALE', '1988-03-15', 'bisharat@example.com', 'A_POSITIVE', NOW()),
    ('humera', 'FEMALE', '1992-12-01', 'humera@example.com', 'AB_POSITIVE', NOW()),
    ('Kabir ', 'MALE', '1993-07-11', 'kabir@example.com', 'O_POSITIVE', NOW());


INSERT INTO Doctor (name, specialization , email)
VALUES
    ('Dr- Amir Essa', 'Cardiology' , ' amiressa@gmail.com'),
    ('Dr- Adil Essa', 'Dernatoology' , ' adilessa@gmail.com'),
    ('Dr- Arslan Essa', 'Orthopedics' , ' arslanessa@gmail.com');

INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
  ('2025-07-01 10:30:00', 'General Checkup', 1, 2),
  ('2025-07-02 11:00:00', 'Skin Rash', 2, 2),
  ('2025-07-03 09:45:00', 'Knee Pain', 3, 3),
  ('2025-07-04 14:00:00', 'Follow-up Visit', 1, 1),
  ('2025-07-05 16:15:00', 'Consultation', 1, 4),
  ('2025-07-06 08:30:00', 'Allergy Treatment', 2, 5);
