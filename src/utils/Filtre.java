package utils;

import org.bukkit.entity.Player;

public class Filtre
{
  public static RotationType RotationType;
  
  public static enum RotationType
  {
    ROTATION,  SPIRAL,  RADAR,  TORNADO;
  }
 
  
  public static void filtre(Player p, RotationType type, String particle, float radius, Boolean randomColor)
  {
    if (Maths.countdown_id.containsKey(p))
    {
      Maths.stopRotation(p);
      switch (type)
      {
      case RADAR: 
        Maths.rotationEffect(p, particle, radius, randomColor);
        break;
      case ROTATION: 
        Maths.spiraleEffect(p, particle, randomColor);
        break;
      case SPIRAL: 
        Maths.radarEffect(p, particle, randomColor);
        break;
      case TORNADO: 
        Maths.tornadoEffect(p, particle, randomColor);
      }
    }
    else
    {
      switch (type)
      {
      case RADAR: 
        Maths.rotationEffect(p, particle, radius, randomColor);
        break;
      case ROTATION: 
        Maths.spiraleEffect(p, particle, randomColor);
        break;
      case SPIRAL: 
        Maths.radarEffect(p, particle, randomColor);
        break;
      case TORNADO: 
        Maths.tornadoEffect(p, particle, randomColor);
      }
    }
  }
}
