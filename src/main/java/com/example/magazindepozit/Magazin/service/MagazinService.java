package com.example.magazindepozit.Magazin.service;

import com.example.magazindepozit.Magazin.dtos.CreateMagazinRequest;
import com.example.magazindepozit.Magazin.dtos.CreateMagazinResponse;
import com.example.magazindepozit.Magazin.dtos.UpdateMagazinRequest;
import com.example.magazindepozit.Magazin.exceptions.MagazinDoesntExist;
import com.example.magazindepozit.Magazin.exceptions.MagazinExist;
import com.example.magazindepozit.Magazin.model.Magazin;
import com.example.magazindepozit.Magazin.repository.MagazinRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MagazinService {

    private MagazinRepo magazinRepo;

    public MagazinService(MagazinRepo magazinRepo) {
        this.magazinRepo = magazinRepo;
    }

    public List<Magazin> getAllMagazine(){
        List<Magazin>all=magazinRepo.findAll();
        if(all.size()==0){
            throw new MagazinExist();
        }
        return all;
    }

    @Transactional
    public CreateMagazinResponse addMagazin(CreateMagazinRequest createMagazinRequest){
        Optional<Magazin> magazinByNume=magazinRepo.findMagazinByNume(createMagazinRequest.getName());

        if(magazinByNume.isPresent()){
            throw new MagazinExist();
        }

       Magazin magazin=Magazin.builder()
                .name(createMagazinRequest.getName())
               .numaMall(createMagazinRequest.getNumeMall())
                .build();

        Magazin magazin1=magazinRepo.saveAndFlush(magazin);

        return CreateMagazinResponse.builder().magazin(magazin1).build();
    }


    @Transactional
    public void deleteMagazin(long id){
        Optional<Magazin>magazin=magazinRepo.findById(id);

        if(magazin.isPresent()){
            magazinRepo.delete(magazin.get());
        }
        else{
            throw new MagazinDoesntExist();
        }
    }


    @Transactional
    public void updateMagazin(UpdateMagazinRequest updateMagazinRequest) {
        Optional<Magazin> magazinOptional = magazinRepo.findMagazinByNume(updateMagazinRequest.getName());

        if (magazinOptional.isPresent()) {
            Magazin magazin = magazinOptional.get();

            if (!updateMagazinRequest.getNumeMall().equals("")) {
                magazin.setNumaMall(updateMagazinRequest.getNumeMall());
            }

            magazinRepo.saveAndFlush(magazin);
        }
    }




}
