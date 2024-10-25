package az.edu.orient.msusergroup64.client.account;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-account", url = "${client.account}/accounts")
public interface AccountClient {

    @PostMapping
    AccountResponse createAccount(@RequestBody AccountCreateRequest createRequest);
}
