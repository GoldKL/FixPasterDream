package net.pasterdream.procedures;

import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.entity.Entity;

public class BlueprintGui0Pr0Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u7B2C" + (new java.text.DecimalFormat("#").format(new Object() {
			public int getScore(String score, Entity _ent) {
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective(score);
				if (_so != null)
					return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
				return 0;
			}
		}.getScore("blueprint_page", entity)) + "\u9875");
	}
}
