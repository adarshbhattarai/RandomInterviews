package gcodejam.RoundTwo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/**
 * @author adarshbhattarai on 2020-04-27
 * @project untitled
 */
public class PlayersShuffle {

    public static void main(String[] args) {

        List<String> players = new ArrayList<>(Arrays.asList("Saugat",
                "Nishant" ,
                "Nimesh " ,
                "Gaurav" ,
                "Ram" ,
                "Prajil" ,
                "Bharat" ,
                "Ananda" ,
                "Adarsh" ,
                "Aditya" ,
                "Roshan" ,
                "Govinda" ,
                "Prabin" ,
                "Amrit" ,
                "Pranudeep" ,
                "Sandip" ,
                "Binay" ,
                "Anup"));
        List<List<String>> groups = new ArrayList<>();
        int MAX_ALLOWED=4;
        int teamsGroup=0;

        for (;!players.isEmpty();){

            int random = new Random().nextInt(players.size());
            String player = players.get(random);
            players.remove(player);
            if(groups.size()== teamsGroup)
            groups.add(new ArrayList<>());
            groups.get(teamsGroup).add(player);

            if(groups.get(teamsGroup).size()==MAX_ALLOWED){
                teamsGroup++;
                if(teamsGroup>1)
                MAX_ALLOWED++;
            }
        }

        String[] groupsTitle={"A","B","C","D"};
        for(int i=0;i<4;i++){
            System.out.print("GROUP "+ groupsTitle[i]);
            System.out.println(" --> "+ groups.get(i));
        }

    }
}