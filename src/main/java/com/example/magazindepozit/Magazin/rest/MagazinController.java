package com.example.magazindepozit.Magazin.rest;

import com.example.magazindepozit.Magazin.dtos.CreateMagazinRequest;
import com.example.magazindepozit.Magazin.dtos.CreateMagazinResponse;
import com.example.magazindepozit.Magazin.dtos.UpdateMagazinRequest;
import com.example.magazindepozit.Magazin.model.Magazin;
import com.example.magazindepozit.Magazin.service.MagazinService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/magazin")
@AllArgsConstructor
@Slf4j
public class MagazinController {

    private MagazinService magazinService;

    @GetMapping("/allMagazine")
    public ResponseEntity<List<Magazin>> getAllMagazine() {
        List<Magazin> magazine=magazinService.getAllMagazine();
        return new ResponseEntity<>(magazine, HttpStatus.OK);
    }

    @PostMapping("/createMagazin")
    public ResponseEntity<CreateMagazinResponse>addMagazin(@RequestBody CreateMagazinRequest createMagazinRequest){
        CreateMagazinResponse createMagazinResponse=magazinService.addMagazin(createMagazinRequest);
        return new ResponseEntity<>(createMagazinResponse,HttpStatus.CREATED);
    }

    @PutMapping("/updateMagazin")
    public ResponseEntity<Void> updateMagazin(@RequestBody UpdateMagazinRequest updateMagazinRequest){
        magazinService.updateMagazin(updateMagazinRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable long id){
        magazinService.deleteMagazin(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}