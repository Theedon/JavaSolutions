package newPackage;
import java.util.Date;

public class Student {

    String studentNo;
    String studentName;
    Date dateOfBirth;
    int tariffPoints;
    static int noOfStudents;

    public void setStudentNo(String studentNo){
        this.studentNo= studentNo;
    }

    public void setStudentName(String studentName){
        this.studentName= studentName;
    }

    public void setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }

    public void setTariffPoints(int tariffPoints){
        this.tariffPoints= tariffPoints;
    }

    public String getStudentNo(){
        return studentNo;
    }

    public String getStudentName(){
        return studentName;
    }

    public Date getDateOfBirth(){
        return dateOfBirth;
    }

    public int getTariffPoints(){
        return tariffPoints;
    }

    public Student(){
        studentNo= "not known";
        studentName= "not known";
        dateOfBirth= new Date(2018, 1,1);
        tariffPoints= 20;
        noOfStudents++;
    }

    public Student(String studentNo, String studentName,
                   Date dateOfBirth, int tariffPoints){
        this.studentNo= studentNo;
        this.studentName= studentName;
        this.dateOfBirth= dateOfBirth;
        this.tariffPoints= tariffPoints;
    }


}
