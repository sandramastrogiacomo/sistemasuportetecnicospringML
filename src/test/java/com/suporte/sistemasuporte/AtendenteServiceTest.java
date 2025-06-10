package com.suporte.sistemasuporte;

import com.suporte.sistemasuporte.dto.AtendenteDTO;
import com.suporte.sistemasuporte.model.AtendenteModel;
import com.suporte.sistemasuporte.repository.AtendenteRepository;
import com.suporte.sistemasuporte.service.AtendenteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AtendenteServiceTest {

   @InjectMocks
   private AtendenteService atendenteService;

   @Mock
   private AtendenteRepository atendenteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

    }
    @Test
    public void testSalvarAtendente() {
        AtendenteDTO atendenteDTO = new AtendenteDTO();
        atendenteDTO.setNome("Ana Soares");

        AtendenteModel atendenteModel = new AtendenteModel();
        atendenteModel.setId(1l);
        atendenteModel.setNome(atendenteDTO.getNome());

        when(atendenteRepository.save(any())).thenReturn(atendenteModel);

        AtendenteModel resultado = atendenteService.create(atendenteDTO);

        assertNotNull(resultado);
        assertEquals("Ana Soares", resultado.getNome());
        verify(atendenteRepository, times(1)).save(any());
    }
     @Test
    public void testBuscarPorId_Existente() {
        AtendenteModel atendenteModel = new AtendenteModel();
        atendenteModel.setId(1l);
        atendenteModel.setNome("Pedro Figueiredo");

        when(atendenteRepository.findById(1l)).thenReturn (Optional.of(atendenteModel));

        Optional<AtendenteModel> resultado = atendenteService.findById(1l);

        assertTrue(resultado.isPresent());
        assertEquals("Pedro Figueiredo", resultado.get().getNome());
     }

     @Test
    public void testBuscarPorId_NaoExistente() {
        when(atendenteRepository.findById(1l)).thenReturn(Optional.empty());

         Optional<AtendenteModel> resultado = atendenteService.findById(1l);
         assertFalse(resultado.isPresent());
     }
}
