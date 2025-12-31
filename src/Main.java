import java.util.ArrayList;
import java.util.Scanner;
public class Main{
        public static void main(String[] args) {
                Scanner in=new Scanner(System.in);
                ArrayList<Entity>entities=new ArrayList<>();
                while(true) {
                        System.out.println("Welcome to University Management System");
                        System.out.println("Write down what service you need.");
                        System.out.println("1-add professor \n" +
                                "2-add university \n" +
                                "3-showing everything \n" +
                                "4-compare object(if you have at least 2 or more data points in one university or professor's field)\n" +
                                "5-quit");
                        System.out.printf("Choose your number:");
                        int a = in.nextInt();
                        in.nextLine();
                        if (a == 1) {
                                System.out.println("1.Name professor");
                                String name=in.nextLine();
                                System.out.println("2.Enter the age");
                                int age=in.nextInt();
                                in.nextLine();
                                System.out.println("3.Enter the department");
                                String dep=in.nextLine();
                                System.out.println("4.Enter the experience years");
                                int exp=in.nextInt();
                                in.nextLine();
                                System.out.println("5.Enter the knowledge");
                                String knwl=in.nextLine();
                                System.out.println("6.Enter your personal qualities (you can leave it blank)");
                                String prq=in.nextLine();
                                entities.add(new Professor(name,age,dep,exp,knwl,prq));
                                System.out.println("Added Professor!");
                        }else if(a==2){
                                System.out.println("1.Name of University:");
                                String name=in.nextLine();
                                System.out.println("2.Location of University: ");
                                String loc=in.nextLine();
                                System.out.println("3.Enter Education Direction:");
                                String edud=in.nextLine();
                                System.out.println("4.Enter the creation year:");
                                int year=in.nextInt();
                                in.nextLine();
                                System.out.println("5.Enter the course:");
                                String cour=in.nextLine();
                                entities.add(new University(name,loc,edud,year,cour));
                                System.out.println("Added the University!");
                        }else if(a==3){
                                System.out.println("What list do you need?"+"\n");
                                System.out.println("1-University " +
                                        "2-Professors " +
                                        "3-Anything ");
                                System.out.println("Choose the number:");
                                int s=in.nextInt();
                                in.nextLine();
                                if(s==1){
                                        for(Entity i:entities){
                                                if(i instanceof University) i.showInfo();
                                        }
                                }
                                if(s==2){
                                        for(Entity i: entities){
                                                if(i instanceof Professor) i.showInfo();
                                        }
                                }
                                if(s==3){
                                        for(Entity i:entities){
                                                System.out.println(i.toString());
                                        }
                                }else{
                                        System.out.println("Incorrect number! Returning to main menu. \n");
                                }
                        }else if(a==4){
                                int profcount=0;
                                int univercount=0;
                                for(Entity i:entities){
                                        if(i instanceof Professor) profcount++;
                                        else if(i instanceof University)univercount++;
                                }
                                if(profcount<2){
                                        System.out.println("No compare with professors");
                                        continue;
                                }
                                if(univercount<2){
                                        System.out.println("NO compare with universities");
                                        continue;
                                }
                                        System.out.println("Compare options:");
                                        System.out.println("1 - Most experienced professor");
                                        System.out.println("2 - Youngest university");
                                        System.out.print("Choose the number: ");
                                        int option = in.nextInt();
                                        in.nextLine();
                                        if(option==1){
                                                Professor mostexprn=null;
                                                int maxexp=-1;
                                                for(Entity e :entities){
                                                        if(e instanceof Professor pro){
                                                                if(pro.getExperience()>maxexp){
                                                                        maxexp=pro.getExperience();
                                                                        mostexprn=pro;
                                                                }
                                                        }
                                                }
                                                System.out.println("The most Expirence Professor:"+mostexprn.getName()+maxexp+"years experience.");
                                        } else if (option==2) {
                                                University younguniver=null;
                                                int minage=9999;
                                                for(Entity e: entities){
                                                        if(e instanceof University uni){ int age=uni.getYear();
                                                                if(minage>age){
                                                                        minage=age;
                                                                        younguniver=uni;
                                                                }
                                                        }
                                                }
                                                System.out.println("Youngest University its a:"+ younguniver.getName()+minage+"years.");
                                        }
                                }
                        if(a==5){
                                System.out.println("Program terminated");
                                break;
                        }
                }

        }
}