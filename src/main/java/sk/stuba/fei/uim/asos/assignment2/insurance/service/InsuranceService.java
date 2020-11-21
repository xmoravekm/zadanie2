package sk.stuba.fei.uim.asos.assignment2.insurance.service;

import sk.stuba.fei.uim.asos.assignment2.ws.Insurance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class InsuranceService implements IInsuranceContractService<Insurance> {

    private final AtomicLong idCounter;
    private final Map<Long, Insurance> insuranceMap;

    public InsuranceService() {
        this.insuranceMap = new HashMap<>();
        idCounter = new AtomicLong(0);
    }

    @Override
    public Insurance create(Insurance contract) {
        contract.setId(this.idCounter.incrementAndGet());
        insuranceMap.put(contract.getId(), contract);
        return  contract;
    }

    @Override
    public Insurance update(Insurance contract) {
        if(!insuranceMap.containsKey(contract.getId())){
            throw new IllegalArgumentException("Contract has not been found");
        }
        return insuranceMap.put(contract.getId(), contract);
    }

    @Override
    public List<Insurance> getAll() {
        return new ArrayList<>(insuranceMap.values());
    }

    @Override
    public List<Insurance> getByUserId(Long userId) {
        List<Insurance> list = new ArrayList<>();
        for(Map.Entry<Long, Insurance> entry : insuranceMap.entrySet()){
            if(entry.getValue().getIdPerson() == userId){
                list.add(entry.getValue());
            }
        }
        return  list;
    }
}
