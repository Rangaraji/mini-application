import java.util.*;
class ATM{
    private static Scanner sc;
    //static String[] user = {"Ranga","raj"};
    //static int[] balance = {50000,10000};
    static int p = 1234;
    static int balance=50000;
    static int[] amount = {0,0,0,0};
    static int[] wit = {0,0,0,0};
    static int[] dep = {0,0,0,0};
    static int[] amount1 = {100,200,500,2000};
    static int l = 0;
    static int tot = 0;
    static int wi = 0;
    static int giv = 0;
    static int count = 0;
    static int in = 0;
    static int abcd = 0;
   //Home page
   static void login(){
       sc = new Scanner(System.in);
       System.out.print("\033[H\033[2J");
       System.out.println("ATM machine");
       System.out.println("1. Admin login");
       System.out.println("2. User login");
       System.out.println("3. Exit");
       System.out.print("Enter the choice :");
       int a = sc.nextInt();
       switch (a) {
           case 1:
           System.out.print("\033[H\033[2J");
           System.out.print("Enter your name :");
           String user = sc.next();
           System.out.print("Enter your pin :");
           int pin = sc.nextInt();
           if(user.equals("admin") && pin == 4321){
               System.out.println("Logged successfully...!");
               admin();
           }
           else{
               System.out.print("Invalid user");
           }
            break;
            
            case 2:
            System.out.print("\033[H\033[2J");
            System.out.print("Enter your name ");
            String user1 = sc.next();
            System.out.print("Enter your pin ");
            int pin1 = sc.nextInt();
            if(user1.equals("Ranga") && pin1 == p){
                my();
            }
            else{
                System.out.println("Invalid user");
            }
            break;

            case 3:
            System.exit(0);
            break;
            
            default:
            System.out.println("Invalid input");
            break;
       } 
   }
    //admin login
    static void admin(){
        System.out.println("Hello Rangaraj");
        System.out.println("Admin Login");
        System.out.println("1. view money :");
        System.out.println("2. Load money:");
        System.out.println("3. Exit :");
        System.out.println("4. back :");
        System.out.print("Enter the choice :");
        int c = sc.nextInt();
        switch(c){
        case 1:
        System.out.print("\033[H\033[2J");
        viewmoney();
        case 2:
        System.out.print("\033[H\033[2J");
        loadmoney();
        case 3:
        System.exit(0);
        case 4:
        login();
        }
    }
    //view money
   static void viewmoney(){
       System.out.print("\033[H\033[2J");
       for(int i=0;i<4;i++){
       System.out.println("Enter the amount "+amount1[i]+" = "+amount[i]);
    }
   System.out.println("The total amount "+l);
   System.out.println("Press enter to back");
       sc.nextLine();
       String g = sc.nextLine();
       if (g.equals(""))
           admin();
}
     //load money
   static void loadmoney(){
    for(int i=0;i<4;i++){
        System.out.print("Enter the amount "+amount1[i]+" = ");
        amount[i] += sc.nextInt();
        l = (l+amount[i]*amount1[i]);
    }
    System.out.println("The total amount "+l);
    System.out.println("Press enter to back");
        sc.nextLine();
        String g1 = sc.nextLine();
        if (g1.equals(""))
            admin();
}
   //my money 
   static void my(){
       System.out.println("Welcome Ranga");
       System.out.println("1. withdraw :");
       System.out.println("2. view balance :");
       System.out.println("3. Deposit money");
       System.out.println("4. Pin change");
       System.out.println("5. Ministatement");
       System.out.println("6. Exit");
       System.out.println("7. Back");
       System.out.print("Enter the choice :");
       int b = sc.nextInt();
       switch(b){
           case 1:
           withdraw();
           case 2:
           viewbalance();
           case 3:
           deposite();
           case 4:
           pinchange();
           case 5:
           ministatement();
           case 6:
           System.exit(0);
           case 7:
           login();
       }
   }
   //withdraw
   static void withdraw(){
    System.out.print("\033[H\033[2J");
    System.out.print("Enter the amount = ");
    giv = sc.nextInt();
    if(wi>=giv  && giv%100==0){
    balance -=giv;
    wi =wi-giv;
    reminder( giv);
    count++;
    System.out.println("Current balance is"+balance);
    sc.nextLine();
    System.out.println("Press enter to next !!!");
    String gh = sc.nextLine();
    if(gh.equals("")){
        my();
    }
}
else{
    System.out.println("Invalid amount");
    sc.nextLine();
    System.out.println("Press enter to next !!!");
    String gh = sc.nextLine();
    if(gh.equals("")){
        my();
    }
}

}
//reminder
static void reminder(int giv){
    if(giv/2000!=0){
    wit[3] = giv/2000;
    giv = giv%2000;
    amount[3] = amount[3]-wit[3];
    }
    else if(giv/500!=0){
    wit[2] = giv/500;
    giv = giv%500;
    amount[2] = amount[2]-wit[2];
    }
    else if(giv/200!=0){
    wit[1] = giv/200;
    giv = giv%200;
    amount[1] = amount[1]-wit[1];
    }
    else if(giv/100!=0){
    wit[0] = giv/100;
    giv = giv%100;
    amount[0] = amount[0]-wit[0];
    }
}
   //view balance
   static void viewbalance(){
       System.out.println("your balance is :"+balance);
       System.out.println("Press Enter to back!");
        sc.nextLine();
        String gh = sc.nextLine();
        if(gh.equals("")){
        my();
    }
}
   //Deposite
   static void deposite(){
    System.out.println("Enter the amount in 100 200 500 1000");
    for (int i = 0; i < 4; i++) {
       
        System.out.print("Enter the amount " + amount1[i] + " = ");
        amount[i] += sc.nextInt();
        abcd += amount[i]*amount1[i];
        count++;
    }
        depos(abcd);
    System.out.println(" Total amount deposit : "+abcd);
    System.out.println("Press enter to back");
    sc.nextLine();
    String g = sc.nextLine();
    if (g.equals(""))
        my();
}

//reminder depos
static void depos(int abcd){
    if(abcd/2000!=0){
    dep[3] = abcd/2000;
    abcd = abcd%2000;
    amount[3] = amount[3]+dep[3];
    }
    else if(abcd/500!=0){
    dep[2] = abcd/500;
    abcd = abcd%500;
    amount[2] = amount[2]+dep[2];
    }
    else if(abcd/200!=0){
    dep[1] = abcd/200;
    abcd = abcd%200;
    amount[1] = amount[1]+dep[1];
    }
    else if(abcd/100!=0){
    dep[0] = abcd/100;
    abcd = abcd%100;
    amount[0] = amount[0]+dep[0];
    }
}
    //pinchange
    static void pinchange(){
        System.out.print("\033[H\033[2J");
        System.out.print("Enter the old pin : ");
        int pass = sc.nextInt();
        if(pass==p){
            System.out.print("Enter the new pin : ");
            int ac = sc.nextInt();
            p=ac;
            System.out.println("Your pin has changed sucessfully!!!");
            sc.nextLine();
            System.out.println("Press enter to next !!!");
            String gh = sc.nextLine();
            if(gh.equals("")){
                my();
            }
        }
        else{
            System.out.println("Invalid password !");
            sc.nextLine();
            System.out.println("Press enter to next !!!");
            String gh = sc.nextLine();
            if(gh.equals("")){
                my();
            }
        }
    }
    //ministatement
    static void ministatement(){
        for(int i=1;i<=count;i++){
            Date ab = java.util.Calendar.getInstance().getTime();
            System.out.println(ab+" "+giv+" "+balance);
            System.out.println("Press enter to back");
        sc.nextLine();
        String g = sc.nextLine();
        if (g.equals(""))
        my();
        }
    }
   public static void main(String[] args){
       sc = new Scanner(System.in);
       login();
   }
}