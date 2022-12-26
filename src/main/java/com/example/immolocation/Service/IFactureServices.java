package com.example.immolocation.Service;

import com.example.immolocation.Model.Facture;

import java.util.List;

public interface IFactureServices {
    public List<Facture> Factures(Long id);
}
