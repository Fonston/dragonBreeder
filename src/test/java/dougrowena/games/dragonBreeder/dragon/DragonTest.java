package dougrowena.games.dragonBreeder.dragon;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.TextFormat;
import dougrowena.games.dragonBreeder.genetics.genetypes.DragonGenome;
import dougrowena.games.dragonBreeder.genetics.genomegenerators.KomodyteGenerator;
import dougrowena.games.dragonBreeder.protobuf.DragonMessage;
import org.junit.Test;

/**
 * Created by HP DX2400 Custom on 27/12/2016.
 */
public class DragonTest {

    @Test
    public void testProtobufConversion() {

        KomodyteGenerator generator = new KomodyteGenerator();

        DragonGenome genome = generator.generate();

        Dragon testDragon = new Dragon(
                new DragonGenomeStats(genome),
                "testDragon",
                Gender.FEMALE,
                Age.ADULT
                );

        DragonMessage.Dragon protoDragon = Dragon.toProtobuf(testDragon);

        String dragonString = protoDragon.toString();

        DragonMessage.Dragon.Builder reconstructor =
                DragonMessage.Dragon.newBuilder();

        DragonMessage.Dragon reconstructedDragon = null;
        try {
            TextFormat.merge(dragonString, reconstructor);
            reconstructedDragon = reconstructor.build();
        } catch (Exception e) {
            assert false;
        }

        Dragon testDragon2 = Dragon.fromProtobuf(reconstructedDragon);

        String statisticsReport1 = testDragon.getGenome().reportGenomeStatistics();
        String statisticsReport2 = testDragon2.getGenome().reportGenomeStatistics();

        assert (statisticsReport1.equals(statisticsReport2)) : 100;
        assert (testDragon.gender == testDragon2.gender) : 101;
        assert (testDragon.age == testDragon2.age) : 102;
        assert (testDragon.name.equals(testDragon2.name)) : 103;

    }
}
