package dougrowena.games.dragonBreeder.genetics.genomegenerators;

import dougrowena.games.dragonBreeder.dragon.DragonGenomeStats;
import dougrowena.games.dragonBreeder.genetics.genetypes.DragonGenome;
import org.junit.Test;

/**
 * Created by HP DX2400 Custom on 21/08/2016.
 */
public class KomodyteGeneratorTest {

    @Test
    public void testGenerate() {

        DragonGenome komodyteGenome = new KomodyteGenerator().generate();

        DragonGenomeStats statistics = new DragonGenomeStats(komodyteGenome);

        String s = statistics.reportGenomeStatistics();

        System.out.println();
        System.out.println(s);
    }

}