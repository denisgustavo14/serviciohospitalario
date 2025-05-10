# serviciohospitalario


requests:

curl --location 'localhost:8080/api/v1/hospital/crearCita' \
--header 'Content-Type: application/json' \
--data '{
  "idDoctor": 1,
  "idConsultorio": 1,
  "idPaciente": 3,
  "horario": "2025-05-10T15:00:00"
}'


curl --location 'localhost:8080/api/v1/hospital/citasPorDocYFecha/2/fecha/2025-05-10'
