package bazy.dziala.bazydziala.service;


import bazy.dziala.bazydziala.model.ElectoralRegister;
import bazy.dziala.bazydziala.repository.ElectoralRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectoralRegisterService {

    private final ElectoralRegisterRepository electoralRegisterRepository;

    @Autowired
    public ElectoralRegisterService(ElectoralRegisterRepository electoralRegisterRepository) {
        this.electoralRegisterRepository = electoralRegisterRepository;
    }

    public List<ElectoralRegister> getAll(){
        return electoralRegisterRepository.findAll();
    }

    public ElectoralRegister getById(Long id){
        Optional<ElectoralRegister> foundRegister = electoralRegisterRepository.findById(id);
        return foundRegister.orElseThrow();
    }

    public ElectoralRegister updateRegister(ElectoralRegister electoralRegister){
        return electoralRegisterRepository.saveAndFlush(electoralRegister);
    }

    public ElectoralRegister createRegister(ElectoralRegister electoralRegister){
        return electoralRegisterRepository.saveAndFlush(electoralRegister);
    }

    public String deleteElectoralRegister(Long id){
        ElectoralRegister registerToDelete = getById(id);
        electoralRegisterRepository.delete(registerToDelete);
        return "Data with id: " + id + " deleted!";
    }
}
