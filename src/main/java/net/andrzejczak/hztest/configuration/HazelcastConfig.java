package net.andrzejczak.hztest.configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static net.andrzejczak.hztest.service.CacheService.CACHE_MAP;

@Configuration
class HazelcastConfig {

    @Bean
    @Profile("!dev")
    HazelcastInstance myHazelcastInstance() {
        ClientConfig config = new ClientConfig();
        config.getNetworkConfig().addAddress("hazelcast-sample");

        HazelcastInstance instance = HazelcastClient.newHazelcastClient(config);

        instance.getConfig().addMapConfig(new MapConfig(CACHE_MAP).setTimeToLiveSeconds(120));
        return instance;
    }

    @Bean
    @Profile("dev")
    HazelcastInstance myHazelcastInstanceLocal() {
        return Hazelcast.newHazelcastInstance();
    }
}
