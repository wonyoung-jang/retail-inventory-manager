package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (partRepository.count() == 0 && productRepository.count() == 0) {
            OutsourcedPart guitarStrings = new OutsourcedPart("Guitar Strings", 10.0, 0, "StringMaster", 0, 2, 1);
            OutsourcedPart pianoHammers = new OutsourcedPart("Piano Hammers", 20.0, 0, "PianoCraft", 0, 2, 2);
            OutsourcedPart drumHeads = new OutsourcedPart("Drum Heads", 30.0, 0, "DrumCircle", 0, 2, 3);
            OutsourcedPart trumpetValves = new OutsourcedPart("Trumpet Valves", 40.0, 0, "BrassTech", 0, 2, 4);
            OutsourcedPart violinBows = new OutsourcedPart("Violin Bows", 50.0, 0, "ViolinArt", 0, 2, 5);

            outsourcedPartRepository.save(guitarStrings);
            outsourcedPartRepository.save(pianoHammers);
            outsourcedPartRepository.save(drumHeads);
            outsourcedPartRepository.save(trumpetValves);
            outsourcedPartRepository.save(violinBows);

            Product acousticGuitar = new Product("Acoustic Guitar", 100.0, 0);
            Product uprightPiano = new Product("Upright Piano", 200.0, 0);
            Product drumSet = new Product("Drum Set", 300.0, 0);
            Product trumpet = new Product("Trumpet", 400.0, 0);
            Product violin = new Product("Violin", 500.0, 0);

            productRepository.save(acousticGuitar);
            productRepository.save(uprightPiano);
            productRepository.save(drumSet);
            productRepository.save(trumpet);
            productRepository.save(violin);
        } else {
            System.out.println("Sample inventory already exists. Skipping bootstrap data load.");
        }
        
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());
    }
}
