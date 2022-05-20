package pl.wsb.programowaniejava.maciejgowin.przyklad;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BankAccount {

    private double balance;

    public void add(double value) {
        balance += value;
    }
}
