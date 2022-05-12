package PartTimeWorker;

import Worker.IWorker;
import Worker.Worker;

public class PartTimeWorker extends Worker implements IWorker {


    public PartTimeWorker(String name, String surname, int salary) {
        super(name, surname, salary);
    }

    @Override
    public void earnMoney() {
        super.setBalance(super.getSalary() / 3);
    }
}
