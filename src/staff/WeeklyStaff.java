package staff;

public class WeeklyStaff extends MonthlyStaff implements Staff {

    private int workWeeks;

    public int getWorkWeeks() {
        return workWeeks;
    }

    public WeeklyStaff(int workDays, int premium, int workWeeks) {
        super((workDays < 0) ? 0 : workDays, (premium < 0) ? 0 : premium); //проверка и заполнение родительского конструктора
        if (workWeeks > 4 || workWeeks < 2) this.workWeeks = 0; //проверка на корректность данных
        else this.workWeeks = workWeeks;
    }

    @Override
    public int calculateSalary(int salary) {
        if (salary < 0) salary = 0;
        printYearSalary(salary);
        return workWeeks * salary;
    }

    private void printYearSalary(int salary) {
        if (salary < 0) salary = 0;
        System.out.println(workWeeks * salary * 26);
    }
}
