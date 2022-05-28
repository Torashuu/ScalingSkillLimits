package data.scripts;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.impl.campaign.skills.BaseSkillEffectDescription;
import com.fs.starfarer.api.impl.campaign.skills.BulkTransport;
import com.fs.starfarer.api.impl.campaign.skills.ContainmentProcedures;
import com.fs.starfarer.api.impl.campaign.skills.MakeshiftEquipment;
import com.fs.starfarer.api.characters.MutableCharacterStatsAPI;

@SuppressWarnings("unused")
public class ScalingSkillLimitsModPlugin extends BaseModPlugin {

    private float getLimitModifier(){
        float value = 1.0f;
        float battleSize = Global.getSettings().getBattleSize();
        value = battleSize / 300;
        return value;
    }

    final private static float VANILLA_OP_THRESHOLD = 240;
    final private static float VANILLA_OP_LOW_THRESHOLD = 120;
    final private static float VANILLA_OP_ALL_LOW_THRESHOLD = 120;
    final private static float VANILLA_OP_ALL_THRESHOLD = 240;
    final private static float VANILLA_PHASE_OP_THRESHOLD = 40;
    final private static float VANILLA_MILITARIZED_OP_THRESHOLD = 5;
    final private static float VANILLA_AUTOMATED_POINTS_THRESHOLD = 120;

    final private static float VANILLA_FIGHTER_BAYS_THRESHOLD = 8;

    final private static float VANILLA_CARGO_CAPACITY_THRESHOLD = 120;
    final private static float VANILLA_FUEL_CAPACITY_THRESHOLD = 120;
    final private static float VANILLA_PERSONNEL_CAPACITY_THRESHOLD = 120;

    final private static float VANILLA_FUEL_USE_REDUCTION_MAX_FUEL = 120;
    final private static float VANILLA_SUPPLY_USE_REDUCTION_MAX_UNITS = 120;

    final private static int VANILLA_MAX_OFFICER_COUNT = 8;

    @Override
    public void onGameLoad(boolean newGame) {

        BaseSkillEffectDescription.OP_THRESHOLD = VANILLA_OP_THRESHOLD * getLimitModifier();
        BaseSkillEffectDescription.OP_LOW_THRESHOLD = VANILLA_OP_LOW_THRESHOLD * getLimitModifier();
        BaseSkillEffectDescription.OP_ALL_THRESHOLD = VANILLA_OP_ALL_THRESHOLD * getLimitModifier();
        BaseSkillEffectDescription.FIGHTER_BAYS_THRESHOLD = VANILLA_FIGHTER_BAYS_THRESHOLD * getLimitModifier();
        BaseSkillEffectDescription.PHASE_OP_THRESHOLD = VANILLA_PHASE_OP_THRESHOLD * getLimitModifier();
        BaseSkillEffectDescription.AUTOMATED_POINTS_THRESHOLD = VANILLA_AUTOMATED_POINTS_THRESHOLD * getLimitModifier();
        BulkTransport.CARGO_CAPACITY_THRESHOLD = VANILLA_CARGO_CAPACITY_THRESHOLD * getLimitModifier();
        BulkTransport.FUEL_CAPACITY_THRESHOLD = VANILLA_FUEL_CAPACITY_THRESHOLD * getLimitModifier();
        BulkTransport.PERSONNEL_CAPACITY_THRESHOLD = VANILLA_PERSONNEL_CAPACITY_THRESHOLD * getLimitModifier();
        ContainmentProcedures.FUEL_USE_REDUCTION_MAX_FUEL = VANILLA_FUEL_USE_REDUCTION_MAX_FUEL * getLimitModifier();
        MakeshiftEquipment.SUPPLY_USE_REDUCTION_MAX_UNITS = VANILLA_SUPPLY_USE_REDUCTION_MAX_UNITS * getLimitModifier();

//        Global.getSector().getPlayerStats().getOfficerNumber().modifyMult("sclskl_scalingskilllimits", getLimitModifier());
        Global.getSector().getPlayerStats().getOfficerNumber().setBaseValue(VANILLA_MAX_OFFICER_COUNT * getLimitModifier());
    }
}
