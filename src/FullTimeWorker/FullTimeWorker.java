package FullTimeWorker;

import Worker.IWorker;
import Worker.Worker;

public class FullTimeWorker extends Worker implements IWorker {

    public FullTimeWorker(String name, String surname, int salary) {
        super(name, surname, salary);
    }

    @Override
    public void earnMoney() {
        super.setBalance(super.getSalary());
    }
}
