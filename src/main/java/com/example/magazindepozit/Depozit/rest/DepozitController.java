package com.example.magazindepozit.Depozit.rest;

import com.example.magazindepozit.Depozit.dtos.CreateDepozitRequest;
import com.example.magazindepozit.Depozit.dtos.CreateDepozitResponse;
import com.example.magazindepozit.Depozit.dtos.UpdateDepozitRequest;
import com.example.magazindepozit.Depozit.model.Depozit;
import com.example.magazindepozit.Depozit.service.DepozitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/depozit")
@AllArgsConstructor
@Slf4j
public class DepozitController {

    private DepozitService depozitService;


    @GetMapping("/allDepozite")
    public ResponseEntity<List<Depozit>> getAllDepozite() {
        List<Depozit> depozite=depozitService.getAllDepozite();
        return new ResponseEntity<>(depozite, HttpStatus.OK);
    }

    @PostMapping("/createDepozit")
    public ResponseEntity<CreateDepozitResponse>addDepozit(@RequestBody CreateDepozitRequest createDepozitRequest){
        CreateDepozitResponse createClientResponse=depozitService.addDepozit(createDepozitRequest);
        return new ResponseEntity<>(createClientResponse,HttpStatus.CREATED);
    }

    @PutMapping("/updateDepozit")
    public ResponseEntity<Void> updateDepozit(@RequestBody UpdateDepozitRequest updateDepozitRequest){
        depozitService.updateDepozit(updateDepozitRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable long id){
        depozitService.deleteDepozit(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }






}


