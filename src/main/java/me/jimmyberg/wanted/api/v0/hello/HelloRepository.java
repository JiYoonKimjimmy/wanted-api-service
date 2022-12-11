package me.jimmyberg.wanted.api.v0.hello;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<Hello, Long>, HelloQRepository {
}
