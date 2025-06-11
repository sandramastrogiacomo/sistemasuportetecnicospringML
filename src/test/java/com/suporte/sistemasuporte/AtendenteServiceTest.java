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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
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
     @Test
    public void testDelete_Existente() {
        AtendenteModel atendenteModel = new AtendenteModel();
        atendenteModel.setId(1l);
        atendenteModel.setNome("Pedro Figueiredo");

        when(atendenteRepository.findById(1l)).thenReturn(Optional.of(atendenteModel));

        boolean resultado = atendenteService.delete(1l);

        assertTrue(resultado);

        verify(atendenteRepository, times(1)).deleteById(1l);
    }

    @Test
    public void testDelete_NaoExistente() {

        when(atendenteRepository.findById(1l)).thenReturn(Optional.empty());

        boolean resultado = atendenteService.delete(1l);

        assertFalse(resultado);

        verify(atendenteRepository, never()).deleteById(anyLong());
    }

    @Test
    public void testFindAll() {

        AtendenteModel atendenteModel1 = new AtendenteModel();
        atendenteModel1.setId(1l);
        atendenteModel1.setNome("Pedro Figueiredo");

        AtendenteModel atendenteModel2 = new AtendenteModel();
        atendenteModel2.setId(1l);
        atendenteModel2.setNome("Ana Machado");

        List<AtendenteModel> lista = List.of(atendenteModel1, atendenteModel2);
        Pageable pageable = PageRequest.of(0, 10);
        Page<AtendenteModel> pagina = new PageImpl<>(lista, pageable, lista.size());

        when(atendenteRepository.findAll(pageable)).thenReturn(pagina);
        Page<AtendenteModel> resultado = atendenteService.findAll(pageable);

        assertNotNull(resultado);
        assertEquals(2, resultado.getTotalElements());
        assertEquals ("Pedro Figueiredo", resultado.getContent().get(0).getNome());
        assertEquals ("Ana Machado", resultado.getContent().get(1).getNome());

        verify(atendenteRepository, times(1)).findAll(pageable);
    }
}
