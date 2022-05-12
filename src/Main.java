import FullTimeWorker.FullTimeWorker;
import PartTimeWorker.PartTimeWorker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //!!!!!!!!!!!!!!!!Salary is not what worker will get on balance!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        FullTimeWorker fullTimeWorker1 = new FullTimeWorker("Tomas", "Topson", 100000);
        FullTimeWorker fullTimeWorker2 = new FullTimeWorker("Eduard", "Godson", 70000);
        FullTimeWorker fullTimeWorker3 = new FullTimeWorker("Roman", "Flopson", 130000);
        FullTimeWorker fullTimeWorker4 = new FullTimeWorker("Andrey", "Kolchan", 50000);
        FullTimeWorker fullTimeWorker5 = new FullTimeWorker("Vladimir", "Potter", 65000);


        PartTimeWorker partTimeWorker1 = new PartTimeWorker("Kadro", "Molfarov", 150000);
        PartTimeWorker partTimeWorker2 = new PartTimeWorker("Mykyta", "Kolivanov", 310000);
        PartTimeWorker partTimeWorker3 = new PartTimeWorker("Alexey", "Holograf", 80000);
        PartTimeWorker partTimeWorker4 = new PartTimeWorker("Alexander", "Chernen", 170000);
        PartTimeWorker partTimeWorker5 = new PartTimeWorker("African", "Rolexov", 90000);

        List<FullTimeWorker> fl = new ArrayList<>();
        List<PartTimeWorker> pl = new ArrayList<>();

        fl.add(fullTimeWorker1);
        fl.add(fullTimeWorker2);
        fl.add(fullTimeWorker3);
        fl.add(fullTimeWorker4);
        fl.add(fullTimeWorker5);

        pl.add(partTimeWorker1);
        pl.add(partTimeWorker2);
        pl.add(partTimeWorker3);
        pl.add(partTimeWorker4);
        pl.add(partTimeWorker5);

        earn(fl, pl);

        System.out.println("Total salary = " +  calculateTotalSalary(fl, pl));
        findHighestSalary(fl,pl);
        findLowestSalary(fl,pl);
        System.out.println("Average salary = " + averageSalary(fl,pl));
    }

    public static long calculateTotalSalary(List<FullTimeWorker> fl, List<PartTimeWorker> pl) {
        int totalSal = 0;
        for (FullTimeWorker e : fl) {
            totalSal += e.getBalance();
        }

        for (PartTimeWorker e : pl) {
            totalSal += e.getBalance();
        }


        return totalSal;
    }

    public static void earn(List<FullTimeWorker> fl, List<PartTimeWorker> pl) {
        for (FullTimeWorker e : fl) {
            e.earnMoney();
        }

        for (PartTimeWorker e : pl) {
            e.earnMoney();
        }
    }

    public static void findHighestSalary(List<FullTimeWorker> fl, List<PartTimeWorker> pl) {
        FullTimeWorker fHighestSalaryWorker;
        PartTimeWorker pHighestSalaryWorker;

//        for (FullTimeWorker e : fl) {
//           if(e.getBalance() > fHighestSalaryWorker.getBalance())
//               fHighestSalaryWorker = e;
//        }
//
//        for (PartTimeWorker e : pl) {
//            if(e.getBalance() > pHighestSalaryWorker.getBalance())
//                pHighestSalaryWorker = e;
//        }

        sortCompar(fl,pl);
        fHighestSalaryWorker = fl.get(fl.size() - 1);
        pHighestSalaryWorker = pl.get(pl.size() - 1);

        if(fHighestSalaryWorker.getBalance() > pHighestSalaryWorker.getBalance())
            System.out.println("Worker with highest salary:\n" + fHighestSalaryWorker.toString());
        else if (fHighestSalaryWorker.getBalance() < pHighestSalaryWorker.getBalance())
            System.out.println("Worker with highest salary:\n" + pHighestSalaryWorker.toString());
        else
            System.out.println("Workers with highest salary:\n"
                    + pHighestSalaryWorker.toString() + "\n" + fHighestSalaryWorker.toString());

    }

    public static void findLowestSalary(List<FullTimeWorker> fl, List<PartTimeWorker> pl){
        FullTimeWorker fLowestSalaryWorker;
        PartTimeWorker pLowestSalaryWorker;

//        for (FullTimeWorker e : fl) {
//            if(e.getBalance() < fLowestSalaryWorker.getBalance())
//                fLowestSalaryWorker = e;
//        }
//
//        for (PartTimeWorker e : pl) {
//            if(e.getBalance() < pLowestSalaryWorker.getBalance())
//                pLowestSalaryWorker = e;
//        }
        sortCompar(fl,pl);
        fLowestSalaryWorker = fl.get(0);
        pLowestSalaryWorker = pl.get(0);
        if(fLowestSalaryWorker.getBalance() < pLowestSalaryWorker.getBalance())
            System.out.println("Worker with lowest salary:\n" + fLowestSalaryWorker.toString());
        else if (fLowestSalaryWorker.getBalance() > pLowestSalaryWorker.getBalance())
            System.out.println("Worker with lowest salary:\n" + pLowestSalaryWorker.toString());
        else
            System.out.println("Workers with lowest salary:\n"
                    + pLowestSalaryWorker.toString() + "\n" + fLowestSalaryWorker.toString());
    }

    public static int averageSalary(List<FullTimeWorker> fl, List<PartTimeWorker> pl){
        int average = 0;
        for (FullTimeWorker e : fl) {
            average += e.getBalance();
        }

        for (PartTimeWorker e : pl) {
            average += e.getBalance();
        }
        average = average / (fl.size() + pl.size());
        return average;

    }

    public static void sortCompar(List<FullTimeWorker> fl, List<PartTimeWorker> pl){
        fl.sort(new SalaryComparator());
        pl.sort(new SalaryComparator());
    }

}