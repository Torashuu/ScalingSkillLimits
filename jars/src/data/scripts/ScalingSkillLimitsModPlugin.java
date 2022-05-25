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

    @Override
    public void onGameLoad(boolean newGame) {

        BaseSkillEffectDescription.OP_THRESHOLD = BaseSkillEffectDescription.OP_THRESHOLD * getLimitModifier();
        BaseSkillEffectDescription.OP_LOW_THRESHOLD = BaseSkillEffectDescription.OP_LOW_THRESHOLD * getLimitModifier();
        BaseSkillEffectDescription.OP_ALL_THRESHOLD = BaseSkillEffectDescription.OP_ALL_THRESHOLD * getLimitModifier();
        BaseSkillEffectDescription.FIGHTER_BAYS_THRESHOLD = BaseSkillEffectDescription.FIGHTER_BAYS_THRESHOLD * getLimitModifier();
        BaseSkillEffectDescription.PHASE_OP_THRESHOLD = BaseSkillEffectDescription.PHASE_OP_THRESHOLD * getLimitModifier();
        BaseSkillEffectDescription.AUTOMATED_POINTS_THRESHOLD = BaseSkillEffectDescription.AUTOMATED_POINTS_THRESHOLD * getLimitModifier();
        BulkTransport.CARGO_CAPACITY_THRESHOLD = BulkTransport.CARGO_CAPACITY_THRESHOLD * getLimitModifier();
        BulkTransport.FUEL_CAPACITY_THRESHOLD = BulkTransport.FUEL_CAPACITY_THRESHOLD * getLimitModifier();
        BulkTransport.PERSONNEL_CAPACITY_THRESHOLD = BulkTransport.PERSONNEL_CAPACITY_THRESHOLD * getLimitModifier();
        ContainmentProcedures.FUEL_USE_REDUCTION_MAX_FUEL = ContainmentProcedures.FUEL_USE_REDUCTION_MAX_FUEL* getLimitModifier();
        MakeshiftEquipment.SUPPLY_USE_REDUCTION_MAX_UNITS = MakeshiftEquipment.SUPPLY_USE_REDUCTION_MAX_UNITS* getLimitModifier();

        Global.getSector().getPlayerStats().getOfficerNumber().modifyMult("sclskl_scalingskilllimits", getLimitModifier());
    }
}
