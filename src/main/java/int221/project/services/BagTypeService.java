package int221.project.services;

import int221.project.models.BagType;
import int221.project.repositories.BagTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BagTypeService {
    @Autowired
    BagTypeRepository bagTypeRepository;

    //GET
    public List<BagType> getAllBagType(){
        return bagTypeRepository.findAll();
    }
}
