package me.jimmyberg.wanted.api.v1.company;

import me.jimmyberg.wanted.api.v1.company.model.FindCompaniesRequest;
import me.jimmyberg.wanted.api.v1.company.model.FindCompaniesResponse;
import me.jimmyberg.wanted.api.v1.company.model.SaveCompanyRequest;
import me.jimmyberg.wanted.api.v1.company.model.SaveCompanyResponse;
import me.jimmyberg.wanted.entity.Company;
import me.jimmyberg.wanted.repository.company.CompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * Company 정보 저장
     */
    public SaveCompanyResponse save(SaveCompanyRequest request) {
        Company entity = companyRepository.save(Company.of(request));
        return SaveCompanyResponse.of(entity.getId());
    }

    /**
     * Company 정보 조회 by id
     */
    public Optional<Company> findById(long id) {
        return companyRepository.findById(id);
    }

    /**
     * Company 목록 조회
     */
    public FindCompaniesResponse findAll(FindCompaniesRequest request) {
        Page<Company> pageable = companyRepository.findAll(request.pageRequest());
        return new FindCompaniesResponse(pageable);
    }

}
