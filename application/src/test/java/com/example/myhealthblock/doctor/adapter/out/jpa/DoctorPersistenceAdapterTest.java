//package com.example.myhealthblock.doctor.adapter.out.persistence;
//
//import com.example.myhealthblock.doctor.application.port.out.dto.DoctorProfileOutportResponse;
//import com.example.myhealthblock.doctor.domain.model.Doctor;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class DoctorPersistenceAdapterTest {
//
//    @InjectMocks
//    private DoctorPersistenceAdapter adapter;
//
//    @Mock
//    private DoctorRepository doctorRepository;
//
//    public DoctorPersistenceAdapterTest() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testCreateDoctor() {
//        Doctor doctor = new Doctor("id", "name", "field", "hospital", "introduction");
//
//        when(doctorRepository.save(any(DoctorEntity.class))).thenReturn(new DoctorEntity("id", "name", "field", "hospital", "introduction"));
//
//        boolean result = adapter.create(doctor.getId(), doctor.getName(), doctor.getField(), doctor.getHospital(), doctor.getIntroduction());
//
//        assertTrue(result);
//        verify(doctorRepository).save(any(DoctorEntity.class));
//    }
//
//    @Test
//    public void testGetDoctorProfile() {
//        DoctorEntity entity = new DoctorEntity("id", "name", "field", "hospital", "introduction");
//        when(doctorRepository.findByUserId("id")).thenReturn(entity);
//
//        DoctorProfileOutportResponse profileDTO = adapter.getDoctorProfile("id");
//
//        assertEquals("name", profileDTO.getName());
//        assertEquals("field", profileDTO.getField());
//        assertEquals("hospital", profileDTO.getHospital());
//        assertEquals("introduction", profileDTO.getIntroduction());
//    }
//}
