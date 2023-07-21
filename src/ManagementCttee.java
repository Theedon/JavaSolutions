package newPackage;

public class ManagementCttee {

    public ManagementCttee(){

    }
    public void addCteeMember(SeniorMember s){

    }
    public void addCteeMember(String name){

    }
}

abstract class Member{
    String name, address;
    public Member(String name, String address){

    }

    public abstract int getFee();
}

class StandardMember{
    int fee= 50;

    public StandardMember(String name, String address){

    }
    int getFee(){
        return fee;
    }
}

class SeniorMember{
    private int fee;
    public SeniorMember(String name, String address, int fee){
        this.fee=fee;
    }

    public int getFee(){
        return fee;
    }

}

class Society{
    private String name;
    int fee;
    public Society(String societyName){

    }
    public void addMember(String name, String address){

    }
    public void addSeniorMember(String name, String address, int fee){

    }
    public void addCtteeMember(SeniorMember member){

    }
    public int getFeeTotal(){
        return fee;
    }
}

