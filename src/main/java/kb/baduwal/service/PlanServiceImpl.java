package kb.baduwal.service;

import kb.baduwal.bindings.PlanForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService{
    @Override
    public boolean createPlan(PlanForm planForm) {
        return false;
    }

    @Override
    public List<PlanForm> fetchPlans() {
        return List.of();
    }

    @Override
    public PlanForm getPlanById(Integer planId) {
        return null;
    }

    @Override
    public String changePlanStatus(Integer planId, String status) {
        return "";
    }
}
