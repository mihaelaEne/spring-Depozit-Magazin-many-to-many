package com.example.magazindepozit.Depozit.service;

import com.example.magazindepozit.Depozit.dtos.CreateDepozitRequest;
import com.example.magazindepozit.Depozit.dtos.CreateDepozitResponse;
import com.example.magazindepozit.Depozit.dtos.UpdateDepozitRequest;
import com.example.magazindepozit.Depozit.exceptions.DepozitDoesntExistException;
import com.example.magazindepozit.Depozit.exceptions.DepozitExistException;
import com.example.magazindepozit.Depozit.exceptions.NoUpdateException;
import com.example.magazindepozit.Depozit.model.Depozit;
import com.example.magazindepozit.Depozit.repository.DepozitRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DepozitService {

    private DepozitRepo depozitRepo;

    public DepozitService(DepozitRepo depozitRepo) {
        this.depozitRepo = depozitRepo;
    }

    public List<Depozit> getAllDepozite(){
        List<Depozit>all=depozitRepo.findAll();
        if(all.size()==0){
            throw new DepozitExistException();
        }
        return all;
    }


    @Transactional

    public CreateDepozitResponse addDepozit(CreateDepozitRequest createDepozitRequest){
        Optional<Depozit> depozitByNume=depozitRepo.findDepozitByNume(createDepozitRequest.getNume());

        if(depozitByNume.isPresent()){
            throw  new DepozitExistException();
        }

        Depozit depozit=Depozit.builder()
                .nume(createDepozitRequest.getNume())
                .adresa(createDepozitRequest.getAdresa())
                .build();


        Depozit depozit1=depozitRepo.saveAndFlush(depozit);

        return CreateDepozitResponse.builder().depozit(depozit1).build();
    }
    @Transactional
    public void deleteDepozit(long id){
        Optional<Depozit>depozit=depozitRepo.findById(id);

        if(depozit.isPresent()){
            depozitRepo.delete(depozit.get());
        }
        else{
            throw new DepozitDoesntExistException();
        }
    }
    @Transactional
    public void updateDepozit(UpdateDepozitRequest updateDepozitRequest){
        Optional<Depozit> depozitOptional= depozitRepo.findDepozitByNume(updateDepozitRequest.getNume());

        if(depozitOptional.isPresent()){
            Depozit depozit=depozitOptional.get();

            if(!updateDepozitRequest.getAdresa().equals("")){
                depozit.setAdresa(updateDepozitRequest.getAdresa());
            }

            depozitRepo.saveAndFlush(depozit);
        }


        else {
            throw new NoUpdateException();
        }
    }
}
