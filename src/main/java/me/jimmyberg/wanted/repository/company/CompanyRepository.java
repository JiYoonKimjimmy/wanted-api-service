package me.jimmyberg.wanted.repository.company;

import me.jimmyberg.wanted.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
