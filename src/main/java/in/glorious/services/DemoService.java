package in.glorious.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoService {
    private final RestTemplate restTemplate = new RestTemplate();
    // Run every 15 minutes
      @Scheduled(fixedRate = 300000) // 5 minutes in milliseconds
    public void callInternalApi() {
        String url = "https://gloriousserver.onrender.com/ok";
        try {
           restTemplate.getForObject(url, String.class);
           System.out.println("okkkk");
        } catch (Exception e) {

        }
    }

}
