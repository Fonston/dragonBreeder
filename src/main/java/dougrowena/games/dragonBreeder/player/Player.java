package dougrowena.games.dragonBreeder.player;

import dougrowena.games.dragonBreeder.dragon.Dragon;
import dougrowena.games.dragonBreeder.dragon.Gender;
import dougrowena.games.dragonBreeder.protobuf.DragonMessage;
import dougrowena.games.dragonBreeder.protobuf.PlayerMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HP DX2400 Custom on 05/09/2016.
 */
public class Player {

    private String name;
    private HashSet<Dragon> dragons;

    public Player(final String name) {

        assert (name != null) : 1;

        this.name = name;

        dragons = new HashSet<Dragon>();
    }

    public String getName() {
        return name;
    }

    public void addDragon(final Dragon dragon) {
        dragons.add(dragon);
    }

    public void clearDragons() {
        dragons.clear();
    }

    public void removeDragon(final Dragon dragon) {
        dragons.remove(dragon);
    }

    public Set<Dragon> getAllDragons() {
        HashSet<Dragon> tmpSet = new HashSet<Dragon>(dragons);
        return tmpSet;
    }

    public Set<Dragon> getMaleDragons() {
        HashSet<Dragon> maleDragons = new HashSet<Dragon>();

        for (Dragon dragon : dragons) {
            if (dragon.getGender() == Gender.MALE) {
                maleDragons.add(dragon);
            }
        }

        return maleDragons;
    }

    public Set<Dragon> getFemaleDragons() {
        HashSet<Dragon> femaleDragons = new HashSet<Dragon>();

        for (Dragon dragon : dragons) {
            if (dragon.getGender() == Gender.FEMALE ){
                femaleDragons.add(dragon);
            }
        }

        return femaleDragons;
    }

    /**
     *
     * @param player
     * @return
     */
    public static PlayerMessage.Player toProtobuf(final Player player) {

        if (player == null) {
            return null;
        }

        PlayerMessage.Player.Builder builder =
                PlayerMessage.Player.newBuilder();
        builder.setName(player.getName());

        for (Dragon dragon : player.getAllDragons()) {
            builder.addDragon(Dragon.toProtobuf(dragon));
        }

        return builder.build();

    }

    /**
     *
     * @param player
     * @return
     */
    public static Player fromProtobuf(final PlayerMessage.Player player) {

        if (player == null) {
            return null;
        }

        Player tmpPlayer = new Player(player.getName());

        List<DragonMessage.Dragon> dragons = player.getDragonList();
        for (DragonMessage.Dragon dragon : dragons) {
            Dragon tmpDragon = Dragon.fromProtobuf(dragon);

            tmpPlayer.addDragon(tmpDragon);
        }

        return tmpPlayer;
    }

}
