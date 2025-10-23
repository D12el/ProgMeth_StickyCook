package logic.entity.ability;

import logic.entity.Slime;

//The ability added to the entity that can be picked up.
public interface Pickable {
    void pick(Slime user);
}
