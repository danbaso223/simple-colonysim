import java.util.Random;
public class main {
    public static void main(String[] args){

        // Global Values
        String state = "gen";
        int food = 60;
        int colonist = 7;
        int drink = 60;
        int trees = 0;
        int plants = 0;
        int animals = 0;
        int raiders = 0;
        int days = 0;
        int army = 0;
        int nobles = 0;

            Random rand = new Random();
            state = "gen";
            while (state.equals("gen")) {
                trees = rand.nextInt(100);
                plants = rand.nextInt(100);
                animals = rand.nextInt(100);
                raiders = rand.nextInt(7);
                state = "sim";
            }
            while (state.equals("sim")) {

                days++; 

                // Repopulation
                int repopchance = rand.nextInt(5);
                if(repopchance==1&&colonist>2){
                    colonist = colonist+rand.nextInt(7);
                    System.out.println("!! - Colonist had children");
                }

                // Migrants
                int migrantchance = rand.nextInt(5);
                if(migrantchance==1&&food>60&&drink>60){
                    colonist = colonist+rand.nextInt(7);
                    System.out.println("!! - Migrants have arrived");
                }                

                // Army Growth
                int armychance = rand.nextInt(4);
                if (armychance==1&&colonist>5){
                    army++;
                }

                // Raids
                int raidchance = rand.nextInt(7);
                int raidwinchance = rand.nextInt(4);
                if (raidchance==1&&food>raiders&&colonist>0){
                   if (raidwinchance<=2){
                    raiders = 0;
                    raiders = rand.nextInt(7);
                    System.out.println("!! - Colony defeated raiders");
                   }else{
                    colonist = colonist - raiders;
                    raiders = rand.nextInt(7);
                    food = food - raiders;
                    System.out.println("!! - Colony was raided");
                   }
                   
                }

                // Plant Growth
                int growchance = rand.nextInt(6);
                if (growchance==1){
                    plants=plants+rand.nextInt(10);
                }

                // Animal Reproduction
                int animalchance = rand.nextInt(4);
                if (animalchance==1){
                    animals = animals+rand.nextInt(4);
                }
                
                //Drink and Eat
                if (food > 0) { food = food - 1; }
                if (drink > 0) { drink = drink - 1; }

                //Hunt and Make Food and Drink
                if (plants > 0){
                    plants = plants - 2;
                    drink = drink + 2;
                    food = food + 2;
                }
                if (animals > 0){
                    animals = animals - 1;
                    food = food + 2;
                }

                // Death
                /* 
                int popsustain = rand.nextInt(5);
                if (food <= 0||drink <= 0&&popsustain!=1) {
                    colonist = colonist - rand.nextInt(5);
                }
                */



                
                System.out.println("");
                System.out.println("## Day: "+days);
                System.out.println("Pop: "+colonist);
                System.out.println("Food: "+food);
                System.out.println("Drink: "+drink);
                //System.out.println(raiders);

                if (colonist <= 0){
                    System.out.println("This colony survived: "+days/365+" years or "+days+" days.");
                    days = 0;
                    break;
                }

                if(days==365) {break;}
                
            }

    }
}