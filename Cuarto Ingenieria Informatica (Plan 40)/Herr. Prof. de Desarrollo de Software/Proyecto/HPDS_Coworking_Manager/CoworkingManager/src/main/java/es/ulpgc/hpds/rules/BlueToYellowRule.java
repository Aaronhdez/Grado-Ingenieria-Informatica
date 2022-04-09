package es.ulpgc.hpds.rules;

import es.ulpgc.hpds.conditions.CleanCondition;
import es.ulpgc.hpds.conditions.OnUseCondition;
import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.persistence.Condition;
import es.ulpgc.hpds.persistence.Rule;

import java.util.ArrayList;

public class BlueToYellowRule implements Rule {
    private final ArrayList<Condition> conditionsToEvaluate;

    public BlueToYellowRule(ArrayList<Sensor> sensors) {
        this.conditionsToEvaluate = new ArrayList<>();
        conditionsToEvaluate.add(new OnUseCondition(sensors));
        conditionsToEvaluate.add(new CleanCondition(sensors));
    }

    @Override
    public boolean check() {
        return !this.conditionsToEvaluate.get(0).evaluate() && this.conditionsToEvaluate.get(1).evaluate();
    }
}
