package antony.cep.coherence;

import java.util.List;


import com.tangosol.util.InvocableMap.Entry;
import com.tangosol.util.processor.AbstractProcessor;

public class AddServiceTagEntryProcessor extends AbstractProcessor {
	private String dispatchId;

	public AddServiceTagEntryProcessor(String dispatchId) {
		super();
		this.dispatchId = dispatchId;
	}

	@Override
	public Object process(Entry entry) {
		String key = (String)entry.getKey();
		ServiceTagDispatchIds st;
		if (entry.isPresent())
			st = (ServiceTagDispatchIds)entry.getValue();
		else
			st = new ServiceTagDispatchIds(key);
		List<String> dispatchIds = st.getDispatchIds(); 
		if (!dispatchIds.contains(dispatchId))
			dispatchIds.add(dispatchId);
		// System.out.println(System.currentTimeMillis()+" Tag:"+key+" dispatchId:"+dispatchId+" DispatchIdCount:"+dispatchIds.size());
		entry.setValue(st);
		return dispatchIds.size();
	}

	@Override
	public int hashCode() {
		return dispatchId == null ? 0 : dispatchId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddServiceTagEntryProcessor other = (AddServiceTagEntryProcessor) obj;
		if (dispatchId == null) {
			if (other.dispatchId != null)
				return false;
		} else if (!dispatchId.equals(other.dispatchId))
			return false;
		return true;
	}

}
