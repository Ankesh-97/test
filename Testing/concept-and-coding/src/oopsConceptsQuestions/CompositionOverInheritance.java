package oopsConceptsQuestions;

public class CompositionOverInheritance {

    /*
    Composition allows you to modify the Job details (title, salary, department) without changing the Person class.
    Inheritance would tightly couple the Person class to the Job properties and make the design less flexible.
     */

    /*
    If you used inheritance, you would have to create multiple subclasses of Person for every different job
    type (e.g., SoftwareEngineerPerson, DoctorPerson, etc.), which leads to a rigid and bloated class hierarchy.
     */

}

enum JobRole{
    SOFTWARE_ENGINEER, MANAGER, DIRECTOR

}

class Person{
    private Job job;
    public Person(){
        this.job=new Job();
        job.setSalary(1000L);
    }
    public long getSalary(){
        return job.getSalary();
    }
}

class Job{
    private Long salary;
    private JobRole jobRole;
    public Long getSalary(){
        return salary;
    }
    public void setSalary(Long salary){
        this.salary=salary;
    }
}
