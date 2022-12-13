package me.jimmyberg.wanted.api.v1.company;

import me.jimmyberg.wanted.entity.Company;
import me.jimmyberg.wanted.repository.company.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * Company 정보 조회 by id
     */
    public Optional<Company> findById(long id) {
        return companyRepository.findById(id);
    }

}
