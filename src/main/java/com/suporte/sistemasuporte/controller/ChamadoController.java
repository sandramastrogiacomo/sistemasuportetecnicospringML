package com.suporte.sistemasuporte.controller;

import com.suporte.sistemasuporte.dto.ChamadoDTO;
import com.suporte.sistemasuporte.dto.ChamadoRespostaDTO;
import com.suporte.sistemasuporte.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @PostMapping
    public ResponseEntity<ChamadoRespostaDTO> criarChamado(@RequestBody ChamadoDTO chamadoDTO){
        ChamadoRespostaDTO chamadoRespostaDTO = chamadoService.criarChamado(chamadoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(chamadoRespostaDTO);
    }

    @GetMapping
    public ResponseEntity<List<ChamadoRespostaDTO>> listarTodosChamados(){
        List<ChamadoRespostaDTO> chamados = chamadoService.listarTodos();
        List<ChamadoRespostaDTO> chamadoRespostaDTOs = chamados.stream().map(ChamadoRespostaDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(chamadoRespostaDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoRespostaDTO>buscarPorId(@PathVariable Long id){
        ChamadoRespostaDTO chamadoRespostaDTO = chamadoService.buscarChamadoPorId(id);
        return ResponseEntity.ok(chamadoRespostaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoRespostaDTO> atualizarChamado(@PathVariable Long id,
                                                               @RequestBody ChamadoDTO chamadoDTO){
        ChamadoRespostaDTO atualizado = chamadoService.atualizar(id, chamadoDTO);
            return ResponseEntity.ok(atualizado);
        }
        
     @DeleteMapping ("/{id}")
     public ResponseEntity<Void> deletarChamado(@PathVariable Long id){
            chamadoService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        
     @GetMapping("/relatorio/abertos")
     public ResponseEntity<List<ChamadoRespostaDTO>> listarChamadosAbertos() {
        List<ChamadoRespostaDTO> lista = chamadoService.listarChamadosPorEstadoChamado("ABERTO")
                .stream().map(ChamadoRespostaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
     }

     @GetMapping("/relatorio/em-atendimento")
    public ResponseEntity<List<ChamadoRespostaDTO>> listarChamadosEmAtendimento() {
        List<ChamadoRespostaDTO> lista = chamadoService.listarChamadosPorEstadoChamado("EM_ATENDIMENTO")
                .stream().map(ChamadoRespostaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
     }
     @GetMapping("/relatorio/finalizado")
    public ResponseEntity<List<ChamadoRespostaDTO>> listarChamadosFinalizado() {
        List<ChamadoRespostaDTO> lista = chamadoService.listarChamadosPorEstadoChamado("FINALIZADO")
                .stream().map(ChamadoRespostaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
     }

        }

