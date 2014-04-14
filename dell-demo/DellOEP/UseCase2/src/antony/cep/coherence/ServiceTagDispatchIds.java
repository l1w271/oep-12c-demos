package antony.cep.coherence;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class ServiceTagDispatchIds implements Serializable {
	String serviceTag;
	List<String> dispatchIds;
	
	public ServiceTagDispatchIds() {
		dispatchIds = new ArrayList<String>();
	}

	public ServiceTagDispatchIds(String tag) {
		this();
		serviceTag = tag;
	}

	public String getServiceTag() {
		return serviceTag;
	}

	public void setServiceTag(String serviceTag) {
		this.serviceTag = serviceTag;
	}

	public List<String> getDispatchIds() {
		return dispatchIds;
	}

	public void setDispatchIds(List<String> dispatchIds) {
		this.dispatchIds = dispatchIds;
	}
}
