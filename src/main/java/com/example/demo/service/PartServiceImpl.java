package com.example.demo.service;

import com.example.demo.domain.Part;
import com.example.demo.repositories.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartServiceImpl implements PartService{
    private PartRepository partRepository;

    @Autowired
    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<Part> findAll() {
        return (List<Part>) partRepository.findAll();
    }
    public List<Part> listAll(String keyword){
        if(keyword !=null){
            return partRepository.search(keyword);
        }
        return (List<Part>) partRepository.findAll();
    }
    @Override
    public Part findById(int theId) {
        Long theIdl=(long)theId;
        Optional<Part> result = partRepository.findById(theIdl);

        Part thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            throw new RuntimeException("Did not find part id - " + theId);
        }

        return thePart;
    }

    @Override
    public void save(Part thePart) {
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
