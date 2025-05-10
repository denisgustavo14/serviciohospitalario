CREATE TABLE doctor (
                        id_doctor BIGINT PRIMARY KEY,
                        nombre VARCHAR(255),
                        ap_paterno VARCHAR(255),
                        ap_materno VARCHAR(255),
                        especialidad VARCHAR(255)
);

CREATE TABLE consultorio (
                             id_consultorio BIGINT PRIMARY KEY,
                             num_consultorio INT,
                             piso INT
);

CREATE TABLE paciente (
                          id_paciente BIGINT PRIMARY KEY,
                          nombre VARCHAR(255),
                          ap_paterno VARCHAR(255),
                          ap_materno VARCHAR(255)
);


INSERT INTO doctor (id_doctor, nombre, ap_paterno, ap_materno, especialidad) VALUES
(1, 'Denis', 'Garcia', 'Mendez', 'Neurlogia'),
(2, 'Laura', 'Consuelo', 'Tarango', 'Oncologia'),
(3, 'Daniel', 'Garcia', 'Mendez', 'Cardiologia');


INSERT INTO CONSULTORIO (id_consultorio, num_consultorio, piso) VALUES
(1, 105, 4),
(2, 509, 11),
(3, 97, 3);

INSERT INTO PACIENTE (id_paciente, nombre, ap_paterno, ap_materno) VALUES
(1, 'Harry', 'James', 'Potter'),
(2, 'Ron', 'Bilius', 'Weasley'),
(3, 'Hermione', 'Jean', 'Granger');