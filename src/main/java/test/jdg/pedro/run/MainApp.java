package test.jdg.pedro.run;

import org.infinispan.client.hotrod.RemoteCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MainApp {

	private static final Logger log = LoggerFactory.getLogger(MainApp.class);
	private  RemoteCacheManager cacheManager;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MainApp.class);
	}
	
	@Autowired
	@Bean
	public CommandLineRunner demo(RemoteCacheManager cacheManager) {
		return (args) -> {

			log.info("Getting the cache, hopefully!");
			log.info("------------------------------");
			this.cacheManager = cacheManager;
			log.info("CacheManager adquired!");
			log.info("------------------------------");
			log.info("Adding testKey to the MyCache cache");
			log.info("------------------------------");
			cacheManager.getCache("MyCache").put("testKey", "testValue");
			log.info("Value testKey added successfully or so I think");
			log.info("------------------------------");
			log.info("Getting the value for testKey");
			log.info((String) cacheManager.getCache("MyCache").get("testKey"));
			log.info("------------------------------");
		};
	}

}
