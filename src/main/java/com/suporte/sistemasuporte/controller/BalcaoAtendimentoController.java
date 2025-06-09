package com.suporte.sistemasuporte.controller;

import com.suporte.sistemasuporte.dto.BalcaoAtendimentoDTO;
import com.suporte.sistemasuporte.dto.BalcaoAtendimentoRespostaDTO;
import com.suporte.sistemasuporte.model.BalcaoAtendimento;
import com.suporte.sistemasuporte.service.BalcaoAtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/balcoes")
public class BalcaoAtendimentoController {

    @Autowired
    private BalcaoAtendimentoService balcaoAtendimentoService;

   @PostMapping
   public ResponseEntity<BalcaoAtendimentoRespostaDTO> criar(@RequestBody BalcaoAtendimentoDTO dto) {
       return ResponseEntity.status(HttpStatus.CREATED).body(balcaoAtendimentoService.criar(dto));
   }

   @GetMapping
    public ResponseEntity<List<BalcaoAtendimentoRespostaDTO>> listarTodos() {
       return ResponseEntity.ok(balcaoAtendimentoService.listarTodos());
   }

   @GetMapping ("/(id)")
    public ResponseEntity<BalcaoAtendimentoRespostaDTO> buscarPorId(@PathVariable Long id) {
       return ResponseEntity.ok(balcaoAtendimentoService.buscarPorId(id));
   }

   @PutMapping ("/{id}")
    public ResponseEntity<BalcaoAtendimentoRespostaDTO> atualizar(@PathVariable Long id, @RequestBody BalcaoAtendimentoDTO dto) {
       return ResponseEntity.ok(balcaoAtendimentoService.atualizar(id, dto));
   }

   @DeleteMapping ("/{id}")
    public ResponseEntity<BalcaoAtendimentoRespostaDTO> deletar(@PathVariable Long id) {
       balcaoAtendimentoService.deletar(id);
       return ResponseEntity.noContent().build();
   }
}