package br.com.senai.repositories;

import br.com.senai.models.Brand;
import br.com.senai.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Long> {
}
