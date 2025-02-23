package tokyo.dto;

import java.math.BigDecimal;

public class ContaDto {
    private BigDecimal saldo;

    public ContaDto() {
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
