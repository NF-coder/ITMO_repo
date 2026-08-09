package src.Character.CharacterMethods;

import src.Character.Actions.Exceptons.NegativeEnergyException;
import src.Locations.Location;

public class CharacterLocation {
    private Location location;

    // Location getter/setter
    public void setLocation(Location location){ this.location = location; }
    public Location getLocation(){ return this.location; }
}
