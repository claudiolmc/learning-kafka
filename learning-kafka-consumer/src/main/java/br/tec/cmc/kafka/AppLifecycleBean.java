package br.tec.cmc.kafka;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import br.tec.cmc.kafka.consumer.ProductConsumer;
import br.tec.cmc.kafka.repository.ProductRepository;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class AppLifecycleBean {

    private static final Logger logger = Logger.getLogger("ListenerBean");

    @Inject
    private ProductRepository repo;

    void onStart(@Observes StartupEvent ev) {               
        logger.info(">>> APP STARTING...");
        ProductConsumer consumer = new ProductConsumer(repo);
        consumer.start();
    }

    void onStop(@Observes ShutdownEvent ev) {               
        logger.info("The application is stopping...");
    }

}