import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VäxtHotellMain {
    public static void main(String[] args) {

        //Create the guests
        Palmer laura = new Palmer("Laura", 5, Plant.PlantType.PALM);
        Palmer olof = new Palmer("Olof", 1, Plant.PlantType.PALM);
        Kaktusar igge = new Kaktusar("Igge", 0.2, Plant.PlantType.KAKTUS);
        MeateatingPlant meatloaf = new MeateatingPlant("Meatloaf", 0.7, Plant.PlantType.MEATEATER);

        //Add them to lists
        List<String> plantsNames = new ArrayList<>();
        plantsNames.add(laura.getName());
        plantsNames.add(olof.getName());
        plantsNames.add(igge.getName());
        plantsNames.add(meatloaf.getName());
        List<Plant> plants = new ArrayList<>();
        plants.add(laura);
        plants.add(olof);
        plants.add(igge);
        plants.add(meatloaf);


        //Variabels
        boolean nameMatch = false;                          //If users name matches a guest
        int matchSpot = 0;                                  // The spot where they match
        double amount = 0;                                  //Amount of liquid they need
        String userPlantname;                               //Holds the user input
        boolean exitProgram = false;                        //If user wants to exit
        Object[] buttonsTryAgain = {"Try Again", "Quit"};   //Buttons for exit box
        int tryAgainBox = 1;                                //If user wants to try again


        //Do while for the whole program, until the user presses exit
        do {
            //Ask user what plant is getting watered
            userPlantname = JOptionPane.showInputDialog(null, "Vilken växt ska vattnas?\nFyll i Namnet");

            //Will try to see if the user input matches a guest after lowercased and trim, Otherwise it will give error and user gets to try again
            try {
                userPlantname = userPlantname.toLowerCase().trim();
                for (int i = 0; i < plantsNames.size(); i++) {                      //Check if there is any names matching
                    if (userPlantname.equalsIgnoreCase(plantsNames.get(i))) {
                        //if user input matches 1 of the names
                        nameMatch = true;
                        matchSpot = i;
                        userPlantname = plants.get(matchSpot).getName();//Edits it to the version of the name added to the system.
                        System.out.println("match "+ matchSpot + userPlantname);
                    }


                }
                //If user presses cancel
            } catch (Exception e) {
                tryAgainBox = JOptionPane.showOptionDialog(null, "Vill du avsluta?", "Exit", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttonsTryAgain, null);
                //If user presses exit the program will close
                if (tryAgainBox == 0) {
                    exitProgram = false;
                } else if (tryAgainBox == 1 || tryAgainBox == 2) {
                    exitProgram = true;
                }
            }
            //Amount of liquid needed
            amount = plants.get(matchSpot).calculateWaterAmount(plants.get(matchSpot).plantType, plants.get(matchSpot).getHeight());


            //If the names match the result message will pop up, and asks user if they wish to try again or close.
            if (nameMatch) {
                //Info Message
                JOptionPane.showMessageDialog(null, plantsNames.get(matchSpot) + " ska ha " + amount + " Liter av " + plants.get(matchSpot).getLiquidType());
                tryAgainBox = JOptionPane.showOptionDialog(null, "Vill du kolla en till?", "Klart", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttonsTryAgain, null);
                if (tryAgainBox == 0) {
                    exitProgram = false;
                } else if (tryAgainBox == 1 || tryAgainBox == 2) {
                    exitProgram = true;
                }
            }

            //If the names dont match, user dont wish to exit and they havent pressed try again. they will get a message asking to try again
            if (!nameMatch && !exitProgram && tryAgainBox != 0) {
                JOptionPane.showMessageDialog(null, "Please enter a correct name\n '" + userPlantname + "' Was not a guest");
            }

            //If user wishes to try again this resets the values so it doesn't become a loop.
            nameMatch = false;
            tryAgainBox = 1;
        } while (!exitProgram);
    }
}
