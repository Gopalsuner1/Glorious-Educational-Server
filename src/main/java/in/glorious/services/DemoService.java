package in.glorious.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${url}")
    private String url;
    // Run every 15 minutes
      @Scheduled(fixedRate = 300000) // 5 minutes in milliseconds
    public void callInternalApi() {
        try {
           restTemplate.getForObject(url, String.class);
        } catch (Exception e) {

        }
    }

}
