package com.example.demo.service;

import com.example.demo.domain.Part;

import java.util.List;

public interface PartService {
    public List<Part> findAll();
    public Part findById(int theId);
    public void save (Part thePart);
    public void deleteById(int theId);

    public List<Part> listAll(String keyword);
    public boolean validatePartInventory(Part thePart);
}
