import Worker.Worker;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Worker> {
    public int compare(Worker w1, Worker w2){
        return Integer.compare(w1.getBalance(), w2.getBalance());
    }
}
