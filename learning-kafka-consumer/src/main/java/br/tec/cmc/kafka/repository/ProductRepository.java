package br.tec.cmc.kafka.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.tec.cmc.kafka.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
    
    @Transactional
    public void save(Product prod) {
        persist(prod);
    }
}
