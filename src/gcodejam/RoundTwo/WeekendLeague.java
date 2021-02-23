package gcodejam.RoundTwo;


import java.util.*;

/**
 * @author adarshbhattarai on 2020-04-27
 * @project untitled
 */
public class WeekendLeague {

    public static void main(String[] args) {

        List < String > winners =
                new ArrayList (Arrays.asList ("Gaurav", "Nishant", "Nimesh", "Prabin"));
        List < String > runnerUps =
                new ArrayList (Arrays.asList ("Amrit", "Anup", "Saugat", "Roshan"));


        Map<String,String> m = new HashMap();
        int i=0;
        for(String s : winners) m.put(s,runnerUps.get(i++));

        Queue<String> freeRunnerUps = new LinkedList();
        List<String[]> players = new ArrayList();
        for(;winners.size()>0;){
            int random = new Random().nextInt(winners.size());
            String winner = winners.get(random);
            String runnerUp = m.get(winner);
            winners.remove(winner);
            if(runnerUps.contains(runnerUp)){
                runnerUps.remove(runnerUp);
                freeRunnerUps.add(runnerUp);
            }
            if(runnerUps.size()>0){
                int nextRandom = new Random().nextInt(runnerUps.size());
                players.add(new String[]{winner,runnerUps.get(nextRandom)});
                runnerUps.remove(runnerUps.get(nextRandom));
            }else{
                players.add(new String[]{winner,freeRunnerUps.poll()});
            }

        }
        for(String[] game: players){

            System.out.println(game[0]+" plays " + game[1]);
        }

    }


}
