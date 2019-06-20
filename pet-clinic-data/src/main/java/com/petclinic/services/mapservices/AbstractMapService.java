package com.petclinic.services.mapservices;

import com.petclinic.model.BaseEntity;

import java.util.*;

/**
 * Map Implementation of BaseEntity
 * 
 * @author Pranjal
 *
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){

        if(object !=  null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }else{
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));

    }

    private Long getNextId(){

        Long nextValue = null;

        try{
            nextValue =Collections.max(map.keySet()) +1;
        }catch (NoSuchElementException ex){
            nextValue = 1L;
        }

        return nextValue;
    }
}
