package com.example.aula02.controller;

import com.example.aula02.dto.VeiculoDto;
import com.example.aula02.model.Veiculo;
import com.example.aula02.repository.VeiculoRepository;
import com.example.aula02.service.IVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired //injecao de dependencia - injecao por atributo
    private IVeiculoService service;

    @GetMapping("/{placa}")
    public ResponseEntity<VeiculoDto> getVeiculo(@PathVariable String placa){
        return  ResponseEntity.ok().body(service.getVeiculo(placa));


    }
    @GetMapping("/all")
    public ResponseEntity<List<VeiculoDto>> getAllVeiculo(){
        List<VeiculoDto> lista = service.getAllVeiculo();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/allOrder")
    public ResponseEntity<List<VeiculoDto>> getAllOrderByValor(){
        List<VeiculoDto> lista = service.getAllOrderByValor();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/bymodel/{modelo}")
    public ResponseEntity<List<VeiculoDto>> getByModelo(@PathVariable String modelo){
        List<VeiculoDto> lista = service.getByModelo(modelo);
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void saveVeiculo(@RequestBody Veiculo veiculo){
        service.saveVeiculo(veiculo);
    }
}
