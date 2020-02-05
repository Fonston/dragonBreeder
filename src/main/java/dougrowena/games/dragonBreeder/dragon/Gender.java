package dougrowena.games.dragonBreeder.dragon;

/**
 * Created by HP DX2400 Custom on 23/08/2016.
 */
public class Gender {

    public static Gender MALE = new Gender();
    public static Gender FEMALE = new Gender();

    private Gender() {}

    public static boolean canMate(final Gender gender1,
                                  final Gender gender2) {

        if (gender1 == null || gender2 == null) {
            return false;
        }

        if (gender1 != MALE && gender2 != FEMALE) {
            return false;
        }

        if (gender2 != MALE && gender2 != FEMALE) {
            return false;
        }

        // Now that any null or non-binary genders have been eliminated from
        // the comparison the only thing to do is check that they are different
        // genders
        return gender1 != gender2;
    }

    public String toString() {
        if (this == MALE) {
            return "MALE";
        }
        return "FEMALE";
    }

}
