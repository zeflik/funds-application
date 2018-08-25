package pl.jozefniemiec.funds.dagger;

import dagger.Component;
import pl.jozefniemiec.funds.service.FundsManager;

@Component
public interface FundsManagerComponent {

    FundsManager getFundsManager();
}
