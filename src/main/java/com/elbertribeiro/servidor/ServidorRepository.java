package com.elbertribeiro.servidor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Long> {
}
