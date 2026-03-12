package com.upiiz.doctores;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final DoctorRepository repository;

    public DataLoader(DoctorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            repository.save(new Doctor("Ana García López", "Cardiología", "4921234567", "ana.garcia@hospital.com"));
            repository.save(new Doctor("Carlos Martínez Ruiz", "Neurología", "4927654321", "carlos.martinez@hospital.com"));
            repository.save(new Doctor("María Rodríguez Pérez", "Pediatría", "4921112233", "maria.rodriguez@hospital.com"));
            repository.save(new Doctor("José Hernández Torres", "Ortopedia", "4924445566", "jose.hernandez@hospital.com"));
            repository.save(new Doctor("Laura Sánchez Díaz", "Dermatología", "4927778899", "laura.sanchez@hospital.com"));
            repository.save(new Doctor("Miguel Flores Morales", "Oftalmología", "4923334455", "miguel.flores@hospital.com"));
            repository.save(new Doctor("Patricia López Vega", "Ginecología", "4926667788", "patricia.lopez@hospital.com"));
            repository.save(new Doctor("Roberto Ramírez Cruz", "Psiquiatría", "4929990011", "roberto.ramirez@hospital.com"));
            repository.save(new Doctor("Sofía Jiménez Reyes", "Oncología", "4922223344", "sofia.jimenez@hospital.com"));
            repository.save(new Doctor("Fernando Castro Núñez", "Urología", "4925556677", "fernando.castro@hospital.com"));
        }
    }
}