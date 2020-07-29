package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
}
