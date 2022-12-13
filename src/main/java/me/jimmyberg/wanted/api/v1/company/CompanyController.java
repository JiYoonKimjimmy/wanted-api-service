package me.jimmyberg.wanted.api.v1.company;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.jimmyberg.wanted.api.v1.company.model.FindCompaniesRequest;
import me.jimmyberg.wanted.api.v1.company.model.FindCompaniesResponse;
import me.jimmyberg.wanted.api.v1.company.model.SaveCompanyRequest;
import me.jimmyberg.wanted.api.v1.company.model.SaveCompanyResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Company APIs")
@RequestMapping("/api/v1")
@RestController
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Operation(summary = "기업 정보 등록 API")
    @PostMapping("/company")
    public SaveCompanyResponse save(@RequestBody SaveCompanyRequest request) {
        return companyService.save(request);
    }

    @Operation(summary = "기업 목록 조회 API")
    @PostMapping("/companies")
    public FindCompaniesResponse findAll(@RequestBody FindCompaniesRequest request) {
        return companyService.findAll(request);
    }

}
