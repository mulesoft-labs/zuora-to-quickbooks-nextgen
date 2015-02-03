String itemid = null;

if (payload.size() > 0) {

	def itemparent = message.getInvocationProperty('qbparentitem');
	
	if (itemparent == null)
		itemparent = '';
	
	if (payload.size() == 1) {
		itemid = payload.get(0).id.value;
	}
	else {
		for (int i=0; i < payload.size(); i++) {
			def item = payload.get(i);
			def checkparent = item.itemParentName;
			if (checkparent != null && checkparent != '' && checkparent == itemparent) {
				itemid = item.id.value;
				break;
			} 
			else if (itemparent == '' && (checkparent == null || checkparent == '')) {
				itemid = item.id.value;
				break;			
			}
		}
	}
	
}

return [itemid:itemid];