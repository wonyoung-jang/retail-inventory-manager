package com.example.demo.service;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.repositories.InhousePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InhousePartServiceImpl implements InhousePartService {
    private InhousePartRepository partRepository;

    @Autowired
    public InhousePartServiceImpl(InhousePartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<InhousePart> findAll() {
        return (List<InhousePart>) partRepository.findAll();
    }

    @Override
    public InhousePart findById(int theId) {
        Long theIdl=(long)theId;
        Optional<InhousePart> result = partRepository.findById(theIdl);

        InhousePart thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            return null;
        }

        return thePart;
    }

    @Override
    public void save(InhousePart thePart) {
        partRepository.save(thePart);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        partRepository.deleteById(theIdl);
    }
    
    @Override
    public boolean validatePartInventory(Part thePart) {
        int inventoryLevel = thePart.getInv();
        int minInventory = thePart.getMinimumInventory();
        int maxInventory = thePart.getMaximumInventory();

        boolean isValid = inventoryLevel >= minInventory && inventoryLevel <= maxInventory;

        return isValid;
    }
}
