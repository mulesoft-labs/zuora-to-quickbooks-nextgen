if (payload.accountingCode != null) {
	def itemcodes = payload.accountingCode.split(':');
	
	int itemtreesize = itemcodes.size();
	int idx = itemtreesize - 1;
	int pidx = idx - 1;
	
	message.setInvocationProperty('qbitemname', itemcodes[idx]);
	message.setInvocationProperty('zqbitemname', 'z' + itemcodes[idx]);
	message.setInvocationProperty('itemtreesize', itemtreesize);
	
	if (itemtreesize > 1) {
		message.setInvocationProperty('qbparentitem', itemcodes[pidx]);
	}
}
else {
	message.setInvocationProperty('qbitemname', payload.chargeName);
	message.setInvocationProperty('zqbitemname', 'z' + payload.chargeName);
	message.setInvocationProperty('itemtreesize', 1);
}

return payload;