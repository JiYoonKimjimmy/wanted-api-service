package me.jimmyberg.wanted.api.v1.company;

import me.jimmyberg.wanted.api.v1.company.model.FindCompaniesRequest;
import me.jimmyberg.wanted.api.v1.company.model.FindCompaniesResponse;
import me.jimmyberg.wanted.api.v1.company.model.SaveCompanyRequest;
import me.jimmyberg.wanted.api.v1.company.model.SaveCompanyResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/company")
    public SaveCompanyResponse save(@RequestBody SaveCompanyRequest request) {
        return companyService.save(request);
    }

    @PostMapping("/companies")
    public FindCompaniesResponse findAll(@RequestBody FindCompaniesRequest request) {
        return companyService.findAll(request);
    }

}
