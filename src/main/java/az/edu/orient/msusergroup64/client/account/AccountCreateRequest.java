package az.edu.orient.msusergroup64.client.account;

import az.edu.orient.msusergroup64.enums.Currency;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountCreateRequest {
    private String name;
    private Currency currency;
    private BigDecimal balance;
    private Long userId;
}
