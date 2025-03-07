package br.edu.umfg.prog.tres.api.demo.controllers;

import br.edu.umfg.prog.tres.api.demo.entities.Cliente;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private ArrayList<Cliente> lista = new ArrayList<Cliente>();

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> post(
            @RequestBody Cliente cliente){
        this.lista.add(cliente);

        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Cliente>> get(){
        return ResponseEntity.ok(this.lista);
    }

    //api.minhaempresa.com/clinte/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(
            @PathVariable(value = "id") UUID id){
        for(Cliente cliente : this.lista){
            if (cliente.getId().equals(id)){
                return ResponseEntity.ok(cliente);
            }
        }

        return ResponseEntity.badRequest().body(null);
    }
}
