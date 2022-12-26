package com.example.immolocation.Service;

import com.example.immolocation.Dao.FactureRepository;
import com.example.immolocation.Model.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureServiceImpl implements IFactureServices{
    @Autowired
    FactureRepository factureRepository;

    @Override
    public List<Facture> Factures(Long id) {
        List<Facture> factures=factureRepository.findFactureByLocataire_Id(id);
        if(factures.isEmpty()){
            return null;
        }else{
            return factures;
        }

    }
}
