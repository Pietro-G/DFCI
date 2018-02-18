
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class AntigenFabric {

    public class Antigen
    {
        public String EntrzID1;
        public class CorrelatedAntigen
        {
            public String FID;
            public double Probability;
        }
        public ArrayList<CorrelatedAntigen> EntrzID2;

    }

    public void parseData()
    {
        ArrayList<Antigen> antigenArrayList = new ArrayList<>();
        File antigenFile = new File("Antigen_processing_and_presentation.dat");
        try (Scanner Input = new Scanner(antigenFile)) {
            while (Input.hasNext())
            {
                String[] data = Input.nextLine().split(" ");
                for(int i = 0; i < antigenArrayList.size(); ++i)
                {
                    if(!data.equals(antigenArrayList.get(i).EntrzID1)) {
                        ArrayList<Antigen.CorrelatedAntigen> correlatedAntigenArrayList = new ArrayList<>();

                        Antigen.CorrelatedAntigen correlatedAntigen = new Antigen().new CorrelatedAntigen();
                        correlatedAntigen.FID = data[1];
                        correlatedAntigen.Probability = Double.parseDouble(data[2]);
                        correlatedAntigenArrayList.add(correlatedAntigen);

                        Antigen mainAntigen = new Antigen();
                        mainAntigen.EntrzID1 = data[0];
                        mainAntigen.EntrzID2 = correlatedAntigenArrayList;

                        antigenArrayList.add(mainAntigen);
                    }

                    else{
                        ArrayList<Antigen.CorrelatedAntigen> correlatedAntigenArrayList = new ArrayList<>();
                        Antigen.CorrelatedAntigen correlatedAntigen = new Antigen().new CorrelatedAntigen();
                        correlatedAntigen.FID = data[1];
                        correlatedAntigen.Probability = Double.parseDouble(data[2]);
                        correlatedAntigenArrayList.add(i, correlatedAntigen);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Antigen_processing_and_presentation.dat not found");
        }
    }
}
