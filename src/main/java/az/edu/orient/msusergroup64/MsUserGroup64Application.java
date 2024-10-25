package az.edu.orient.msusergroup64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
public class MsUserGroup64Application {

    public static void main(String[] args) {
        SpringApplication.run(MsUserGroup64Application.class, args);
    }

}
