def batchfilter = message.getInvocationProperty('batchfilter');

def batchmatched = true;

if (batchfilter != null && payload.batch != batchfilter)
	batchmatched = false;
	
message.setInvocationProperty('batchmatched', batchmatched);

return payload;