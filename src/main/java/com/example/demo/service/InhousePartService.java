package com.example.demo.service;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;

import java.util.List;

public interface InhousePartService {
    public List<InhousePart> findAll();
    public InhousePart findById(int theId);
    public void save (InhousePart thePart);
    public void deleteById(int theId);
    public boolean validatePartInventory(Part thePart);
}
