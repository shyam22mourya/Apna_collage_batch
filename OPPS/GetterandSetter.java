package OPPS;

public class GetterandSetter {
     public static void main (String []args){
              Employe  em =new Employe()  ; 
               em.name = "shyam"; 
               em.setSalary(500000);
               em.setid(56);
               System.out.println(em.getid());
               System.out.println(em.getsalary());

     }
}
 class  Employe{
       String name  ; 
     private  int Salary ; 
     private int id ;    
          
       int getsalary   (){
         return this.Salary ; 
       }

       int getid   (){
        return this.id;  
      }

       void setSalary(  int Salary){
            this.Salary=Salary ;  
       }
        void setid ( int id){
             this.id = id; 
        }
 }
