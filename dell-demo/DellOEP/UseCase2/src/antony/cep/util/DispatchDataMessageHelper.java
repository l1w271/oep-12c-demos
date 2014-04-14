package antony.cep.util;

import java.util.List;

import dsp.dell_services.ActivityDataType;
import dsp.dell_services.ServiceAttributeType;

public class DispatchDataMessageHelper {
	public DispatchDataMessageHelper() {
		super();
	}
	
	public String ServiceAttributeValue(ActivityDataType activity, String name) {
		for (ServiceAttributeType attr : activity.getServiceAttributes().getServiceAttributes())
			if (attr.getType().equals(name))
				return attr.getValue();
		return "";
	}
	
	public int ListSize(List list) {
		return list.size();
	}
        
    public static int getActualDays(String in) {
        int retval = 2;
        if (in.equalsIgnoreCase("Holiday")) {
            retval++;
        }
        return retval;
    }
}
