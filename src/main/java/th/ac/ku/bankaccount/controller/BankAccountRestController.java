package th.ac.ku.bankaccount.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.bankaccount.data.BankAccountRepository;
import th.ac.ku.bankaccount.model.BankAccount;

import java.util.List;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountRestController {

    @Autowired
    private BankAccountRepository repository;

    @GetMapping("/customer/{customerId}")
    public List<BankAccount> getAllCustomerId(@PathVariable int customerId){
        return repository.findByCustomerId(customerId);
    }


    @GetMapping
    public List<BankAccount> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount getOne(@PathVariable int id){
        return repository.findById(id).get();
    }

    @PostMapping
    public BankAccount create(@RequestBody BankAccount bankAccount){
        BankAccount record = repository.save(bankAccount);
        return record;
    }

    @PutMapping("/{id}")
    public BankAccount update(@PathVariable int id,
                              @RequestBody BankAccount requestBody){
        BankAccount record = repository.findById(id).get();
        record.setBalance(requestBody.getBalance());
        repository.save(record);
        return record;

    }

    @DeleteMapping("/{id}")
    public BankAccount delete(@PathVariable int id){
        BankAccount record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }
}
