package com.petclinic.services.mapservices;

import com.petclinic.model.Visit;
import com.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Map Implementation of Visit Service
 * 
 * @author Pranjal
 *
 */
@Service
@Profile({"default","map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService{

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {

        if(object.getPet() == null || object.getPet().getOwner() == null || object.getPet().getId() == null ){
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
