
class Coach {
    String coachNumber;
    String coachType;
    int totalBerthAllowed;
    Coach next;

    Coach(String coachNumber, String coachType, int totalBerthAllowed){
        this.coachNumber = coachNumber;
        this.coachType = coachType;
        this.totalBerthAllowed = totalBerthAllowed;
        this.next = null;
    }

    void coachDetails(Coach coachObj){
        System.out.println("-------");
        System.out.print("Coach Number" + coachObj.coachNumber);
        System.out.print("Coach Type" + coachObj.coachType);
        System.out.print("Coach Type" + coachObj.totalBerthAllowed);
    }
}

class Train {
    Coach head = null;
    Coach createTrainCoach(String coachNumber, String coachType,int totalBerthAllowed){
        return new Coach(coachNumber, coachType,totalBerthAllowed);
    }

    void addCoachToLast(Coach coachObj){
        if(head == null){
            /* train not yet constructed */
            head = coachObj;
        }
        else {
            Coach current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = coachObj;
        }
    }

    void addCoachToFirst(Coach coachObj){
        coachObj.next = head;
        head = coachObj;
    }

    void addCoachAtPos(Coach coachObj, String coachNumber){
        Coach current = head;
        Coach save = null;
        while(current.next != null){
            if(current.coachNumber == coachNumber) {
                save = current.next;
                break;
            }
            else {
                current = current.next;
            }
        }
        coachObj.next = save;
        current.next = coachObj;
    }

    void trainDetails(){
        Coach current = head;
        while(current != null){
            current.coachDetails(current);
            current = current.next;
        }
    }
}

public class SinglyLinkedList{

    public static void main(String[] args) {
        Train trainObj = new  Train();
        /* Train construction started*/
        trainObj.addCoachToFirst(trainObj.createTrainCoach("A5", "coach", 40));
        trainObj.addCoachToFirst(trainObj.createTrainCoach("A4", "coach", 20));
        trainObj.addCoachToFirst(trainObj.createTrainCoach("A3", "coach", 10));
        trainObj.addCoachToFirst(trainObj.createTrainCoach("A2", "coach", 10));
        trainObj.addCoachToFirst(trainObj.createTrainCoach("A1", "coach", 34));
        trainObj.addCoachToLast(trainObj.createTrainCoach("A6", "coach", 8));
        trainObj.addCoachToLast(trainObj.createTrainCoach("A7", "coach",8));
        trainObj.addCoachToLast(trainObj.createTrainCoach("A9", "coach",8));
        trainObj.addCoachToLast(trainObj.createTrainCoach("A11", "coach",9));
        trainObj.addCoachToLast(trainObj.createTrainCoach("A12", "coach",10));
        trainObj.addCoachAtPos(trainObj.createTrainCoach("A8", "coach",11), "A7");
        trainObj.addCoachAtPos(trainObj.createTrainCoach("A10", "coach",12), "A9");
        trainObj.addCoachAtPos(trainObj.createTrainCoach("A13", "coach",13), "A12");
        trainObj.trainDetails();
    }
    
}