package 普通工厂模式;

public class HumanFactory {

    public Human createHuman(String gender){
        if(gender.equals("male")){
            return new Male();
        }else if(gender.equals("female")){
            return new Female();
        }else {
            System.out.println("input is worng");
        }
        return null;
    }

/*    public Male createMale(){
        return new Male();
    }
    public Female createFemale(){
        return new Female();
    }*/

    public static Male createMale(){
        return new Male();
    }

    public static Female createFemale(){
        return new Female();
    }
}
