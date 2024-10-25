package az.edu.orient.msusergroup64.client.account;

import az.edu.orient.msusergroup64.enums.Currency;
import az.edu.orient.msusergroup64.enums.Status;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountResponse {
    private Long id;
    private String name;
    private Currency currency;
    private BigDecimal balance;
    private String iban;
    private Status status;
    private Long userId;

}
