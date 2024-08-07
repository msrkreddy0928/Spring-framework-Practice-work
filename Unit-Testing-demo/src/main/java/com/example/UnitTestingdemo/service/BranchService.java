package com.example.UnitTestingdemo.service;
import com.example.UnitTestingdemo.entity.Branch;
import com.example.UnitTestingdemo.repo.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
    @Autowired
    private BranchRepo branchRepo;
    public Long createBranch(Branch branch){
        branch = branchRepo.save(branch);
        return  branch.getId();
    }

    public Branch getById(Long id){
        return branchRepo.findById(id).get();
    }

}
