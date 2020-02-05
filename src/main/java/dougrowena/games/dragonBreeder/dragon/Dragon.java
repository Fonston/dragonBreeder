package dougrowena.games.dragonBreeder.dragon;

import dougrowena.games.dragonBreeder.genetics.genetypes.*;
import dougrowena.games.dragonBreeder.genetics.phenotype.BaseColourPhenotype;
import dougrowena.games.dragonBreeder.genetics.phenotype.FeathersPhenotype;
import dougrowena.games.dragonBreeder.genetics.phenotype.StripeColourPhenotype;
import dougrowena.games.dragonBreeder.genetics.phenotype.WingsPhenotype;
import dougrowena.games.dragonBreeder.protobuf.AgeEnum;
import dougrowena.games.dragonBreeder.protobuf.DragonGenomeMessage;
import dougrowena.games.dragonBreeder.protobuf.DragonMessage;
import dougrowena.games.dragonBreeder.protobuf.GenderEnum;

import java.util.HashSet;
import java.util.Vector;

/**
 * Created by HP DX2400 Custom on 20/08/2016.
 */
public class Dragon {

    private static HashSet<Dragon> REGISTERED_DRAGONS
            = new HashSet<Dragon>();


    public DragonGenomeStats getGenome() {
        return genome;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Age getAge() {
        return age;
    }

    protected DragonGenomeStats genome;

    protected String name;
    protected Gender gender;
    protected Age age;

    public DragonGenome getGenes() {
        return genes;
    }

    protected DragonGenome genes;


    public Dragon(final DragonGenomeStats genome,
                  final String name,
                  final Gender gender,
                  final Age age) {

        assert (genome != null) : 1;
        assert (name != null) : 2;
        assert (!name.equals("")) : 3;
        assert (gender != null) : 4;
        assert (age != null) : 5;

        this.genome = genome;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.genes = genome.genome;

    }

    /**
     * Get perived colour
     * @return
     */
    public BaseColourPhenotype getColour() {

        return BaseColourPhenotype.getPhenotypicalGene(
                genes.getSequenceAGene(DragonGenome.BODY_COLOUR_1_INDEX),
                genes.getSequenceBGene(DragonGenome.BODY_COLOUR_1_INDEX)
        );

    }

    public StripeColourPhenotype getPatternColour() {

        return StripeColourPhenotype.getPhenotypicalGene(
                genes.getSequenceAGene(DragonGenome.PATTERN_COLOUR_1_INDEX),
                genes.getSequenceBGene(DragonGenome.PATTERN_COLOUR_1_INDEX)
        );

    }

    /**
     * Get derived pattern
     * @return
     */
    public PatternGene getPattern() {

        return PatternGene.getPhenotypicalGene(
                genes.getSequenceAGene(DragonGenome.PATTERN_INDEX),
                genes.getSequenceBGene(DragonGenome.PATTERN_INDEX)
                );
    }

    /**
     * Get derived bodyPlan
     * @return
     */
    public BodyPlanGene getBodyPlan() {
        return BodyPlanGene.getPhenotypicalGene(
                genes.getSequenceAGene(DragonGenome.BODY_PLAN_INDEX),
                genes.getSequenceBGene(DragonGenome.BODY_PLAN_INDEX)
        );
    }

    /**
     * get derived feathers
     * @return
     */
    public FeathersPhenotype getFeathers() {
        return  FeathersPhenotype.getFeathersPhenotype(
                genes.getGeneSequenceA().get(DragonGenome.FEATHERS_INDEX),
                genes.getGeneSequenceB().get(DragonGenome.FEATHERS_INDEX));
    }

    /**
     * Get derived wings
     * @return
     */
    public WingsPhenotype getWings() {
        return  WingsPhenotype.getWingsPhenotype(
                genes.getGeneSequenceA().get(DragonGenome.WINGS_INDEX),
                genes.getGeneSequenceB().get(DragonGenome.WINGS_INDEX));

    }

    public String toString() {
        return name;
    }

    public static Vector<Dragon> getMaleDragons() {
        Vector<Dragon> maleDragons = new Vector<Dragon>();

        for (Dragon dragon : REGISTERED_DRAGONS) {
            if (dragon.gender == Gender.MALE ){
                maleDragons.add(dragon);
            }
        }

        return maleDragons;
    }

    public static Vector<Dragon> getFemaleDragons() {
        Vector<Dragon> femaleDragons = new Vector<Dragon>();

        for (Dragon dragon : REGISTERED_DRAGONS) {
            if (dragon.gender == Gender.FEMALE) {
                femaleDragons.add(dragon);
            }
        }

        return  femaleDragons;
    }

    public static void registerDragon(Dragon dragon) {
        REGISTERED_DRAGONS.add(dragon);
    }

    public static void clearDragons() {
        REGISTERED_DRAGONS.clear();
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public static DragonMessage.Dragon toProtobuf(final Dragon dragon) {

        if (dragon == null) {
            return null;
        }

        DragonGenomeMessage.DragonGenome dragonGenome =
                DragonGenome.toProtobuf(dragon.genome.getGenome());
        AgeEnum.Age age = null;
        if (dragon.getAge() == Age.HATCHLING) {
            age = AgeEnum.Age.HATCHLING;
        } else if (dragon.getAge() == Age.ADOLESCENT) {
            age = AgeEnum.Age.ADOLESCENT;
        } else if (dragon.getAge() == Age.ADULT) {
            age = AgeEnum.Age.ADULT;
        }

        GenderEnum.Gender gender;
        if (dragon.getGender() == Gender.MALE ) {
            gender = GenderEnum.Gender.MALE;
        } else {
            gender = GenderEnum.Gender.FEMALE;
        }

        String name = dragon.getName();

        DragonMessage.Dragon.Builder dragonBuilder =
                DragonMessage.Dragon.newBuilder();

        dragonBuilder.setDragonGenome(dragonGenome);
        dragonBuilder.setAge(age);
        dragonBuilder.setGender(gender);
        dragonBuilder.setName(name);

        return dragonBuilder.build();
    }

    public static Dragon fromProtobuf(final DragonMessage.Dragon dragon) {

        if (dragon == null) {
            return null;
        }

        GenderEnum.Gender protoGender = dragon.getGender();
        AgeEnum.Age protoAge = dragon.getAge();

        Gender gender;
        if (protoGender == GenderEnum.Gender.FEMALE) {
            gender = Gender.FEMALE;
        } else {
            gender = Gender.MALE;
        }

        Age age = null;
        if (protoAge == AgeEnum.Age.HATCHLING) {
            age = Age.HATCHLING;
        } else if (protoAge == AgeEnum.Age.ADOLESCENT) {
            age = Age.ADOLESCENT;
        } else if (protoAge == AgeEnum.Age.ADULT) {
            age = Age.ADULT;
        }

        String name = dragon.getName();
        DragonGenome genome = DragonGenome.fromProtobuf(dragon.getDragonGenome());
        DragonGenomeStats stats = new DragonGenomeStats(genome);

        return new Dragon(stats, name, gender, age);
    }

    public String reportString() {

        String report = "";

        report += "name:\t" +getName() + "\n";
        report += "gender:\t" + getGender() + "\n";
        report += "age:\t" + getAge() + "\n";
        report += "bodyPlan:\t" + getBodyPlan() + "\n";
        report += "colour:\t" + getColour() + "\n";
        report += "pattern:\t" + getPattern() + "\n";
        report += "patternColour:\t" + getPatternColour() + "\n";
        report += "feathers:\t" + getFeathers() + "\n";
        report += "wings:\t" + getWings() + "\n";

        report += "genomeStats: \n" +
                getGenome().reportGenomeStatistics();

        return report;
    }
}
