package com.examen.servicioHospitalario.service;

import com.examen.servicioHospitalario.dto.CitaRequest;
import com.examen.servicioHospitalario.dto.CitaResponse;
import com.examen.servicioHospitalario.exception.HospitalException;
import com.examen.servicioHospitalario.model.Cita;
import com.examen.servicioHospitalario.model.Consultorio;
import com.examen.servicioHospitalario.model.Doctor;
import com.examen.servicioHospitalario.model.Paciente;
import com.examen.servicioHospitalario.repository.ConsultorioRepository;
import com.examen.servicioHospitalario.repository.DoctorRespository;
import com.examen.servicioHospitalario.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class Hospitalmpl implements IHospital{

    private final ICita icita;

    private final DoctorRespository doctorRespository;

    private final ConsultorioRepository consultorioRepository;

    private final PacienteRepository pacienteRepository;


    @Override
    public CitaResponse crearCita(CitaRequest citaRequest) {

        Doctor doctor = doctorRespository.findById(citaRequest.getIdDoctor())
                .orElseThrow(()-> new HospitalException(
                        HttpStatus.NOT_FOUND,
                        "D001",
                        "Doctor no encontrado",
                        "Doctor con id " + citaRequest.getIdDoctor()));

          Consultorio consultorio = consultorioRepository.findById(citaRequest.getIdConsultorio())
                  .orElseThrow(()-> new HospitalException(
                          HttpStatus.NOT_FOUND,
                          "C001",
                          "Consultorio no encontrado",
                          "Consultorio con id " + citaRequest.getIdConsultorio()));
          Paciente paciente = pacienteRepository.findById(citaRequest.getIdPaciente())
                  .orElseThrow(()-> new HospitalException(
                          HttpStatus.NOT_FOUND,
                          "P001",
                          "Paciente no encontrado",
                          "Paciente con id " + citaRequest.getIdPaciente()));

        LocalDateTime horario = citaRequest.getHorario();
        LocalDate fecha = horario.toLocalDate();

        Cita cita = crearCita(consultorio, doctor, paciente, horario, fecha);

        return construyeResponse(cita);
    }


    public Cita crearCita(Consultorio consultorio, Doctor doctor,  Paciente paciente, LocalDateTime horario, LocalDate fecha) {
        if (icita.existeCitaConsultorioHorario(consultorio.getIdConsultorio(), horario)) {
            throw new HospitalException(HttpStatus.CONFLICT, "C002", "Consultorio ocupado", "ya hay una cita en este consultorio");
        }

        if (icita.existeCitaDoctorHorario(doctor.getIdDoctor(), horario)) {
            throw new HospitalException(HttpStatus.CONFLICT, "D002", "Doctor ocupado", "el doctor ya tiene una cita en este horario");
        }

        if (!icita.citasPacienteEntre(paciente.getIdPaciente(), horario.minusHours(2), horario.plusHours(2)).isEmpty()) {
            throw new HospitalException(HttpStatus.CONFLICT, "P002", "Paciente ocupado", "el paciente ya tiene una cita en este horario");
        }

        if (icita.contarCitasDoctorEnDia(doctor.getIdDoctor(), fecha) >= 8) {
            throw new HospitalException(HttpStatus.CONFLICT, "D003", "Doctor ocupado", "el doctor ya tiene 8 citas en este dia");
        }

        Cita cita = new Cita();
        cita.setDoctor(doctor);
        cita.setConsultorio(consultorio);
        cita.setPaciente(paciente);
        cita.setHorario(horario);

        return icita.guardar(cita);
    }

    public CitaResponse construyeResponse(Cita cita) {
        CitaResponse citaResponse = new CitaResponse();
        citaResponse.setIdCita(cita.getIdCita());
        citaResponse.setDoctor(cita.getDoctor());
        citaResponse.setPaciente(cita.getPaciente());
        citaResponse.setConsultorio(cita.getConsultorio());
        citaResponse.setHoraConsulta(cita.getHorario());
        return citaResponse;
    }
}
