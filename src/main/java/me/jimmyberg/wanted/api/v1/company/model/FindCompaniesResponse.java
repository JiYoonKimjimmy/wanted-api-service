package me.jimmyberg.wanted.api.v1.company.model;

import me.jimmyberg.wanted.common.model.PageableResponse;
import me.jimmyberg.wanted.entity.Company;
import org.springframework.data.domain.Page;

public class FindCompaniesResponse extends PageableResponse<Company> {

    public FindCompaniesResponse(Page<Company> pageable) {
        super(pageable);
    }

}
